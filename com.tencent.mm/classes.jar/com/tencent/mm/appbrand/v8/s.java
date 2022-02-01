package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.JavaCallback;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Context;
import com.eclipsesource.mmv8.V8Function;
import com.eclipsesource.mmv8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class s
  extends o
{
  private WeakReference<m> fje = null;
  
  protected final void a(final m paramm, V8Object paramV8Object)
  {
    AppMethodBeat.i(262451);
    if (paramm != null) {}
    for (int i = paramm.hashCode();; i = 0)
    {
      Log.i("MicroMsg.V8DirectApiSharedBufferLock", "hy: trigger setup worker %d", new Object[] { Integer.valueOf(i) });
      this.fje = new WeakReference(paramm);
      paramV8Object.registerJavaMethod(new JavaCallback()
      {
        public final Object invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
        {
          AppMethodBeat.i(262179);
          if ((paramAnonymousV8Array.length() < 2) || (paramAnonymousV8Array.getType(0) != 1) || (paramAnonymousV8Array.getType(1) != 7))
          {
            Log.w("MicroMsg.V8DirectApiSharedBufferLock", "hy: v8 params error");
            AppMethodBeat.o(262179);
            return Integer.valueOf(-1);
          }
          int i = paramAnonymousV8Array.getInteger(0);
          paramAnonymousV8Object = (V8Function)paramAnonymousV8Array.getObject(1);
          i = s.b.a(s.b.acp(), i, paramAnonymousV8Object, paramm);
          AppMethodBeat.o(262179);
          return Integer.valueOf(i);
        }
      }, "lockSharedNativeBuffer");
      paramV8Object.registerJavaMethod(new JavaCallback()
      {
        public final Object invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
        {
          AppMethodBeat.i(262301);
          if ((paramAnonymousV8Array.length() < 2) || (paramAnonymousV8Array.getType(0) != 1) || (paramAnonymousV8Array.getType(1) != 1))
          {
            Log.w("MicroMsg.V8DirectApiSharedBufferLock", "hy: v8 params error");
            AppMethodBeat.o(262301);
            return null;
          }
          int i = paramAnonymousV8Array.getInteger(0);
          int j = paramAnonymousV8Array.getInteger(1);
          s.b.a(s.b.acp(), i, j);
          AppMethodBeat.o(262301);
          return null;
        }
      }, "unlockSharedNativeBuffer");
      AppMethodBeat.o(262451);
      return;
    }
  }
  
  final void cleanup()
  {
    AppMethodBeat.i(262452);
    if (this.fje != null) {
      b.a(b.acp(), (m)this.fje.get());
    }
    AppMethodBeat.o(262452);
  }
  
  static final class a
  {
    volatile m fjg;
    volatile V8Function fjh;
    volatile int kh;
    
    public a(int paramInt, m paramm, V8Function paramV8Function)
    {
      this.kh = paramInt;
      this.fjg = paramm;
      this.fjh = paramV8Function;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(262325);
      String str = "LockItem{itemId=" + this.kh + '}';
      AppMethodBeat.o(262325);
      return str;
    }
  }
  
  static class b
  {
    private static b fjj;
    private final ConcurrentHashMap<Integer, ConcurrentLinkedQueue<s.a>> fji;
    private AtomicInteger fjk;
    
    static
    {
      AppMethodBeat.i(262730);
      if (!s.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        fjj = null;
        AppMethodBeat.o(262730);
        return;
      }
    }
    
    private b()
    {
      AppMethodBeat.i(262708);
      this.fjk = new AtomicInteger(0);
      this.fji = new ConcurrentHashMap(100);
      AppMethodBeat.o(262708);
    }
    
    private int a(int paramInt, V8Function paramV8Function, m paramm)
    {
      boolean bool = true;
      AppMethodBeat.i(262711);
      ConcurrentLinkedQueue localConcurrentLinkedQueue;
      synchronized (this.fji)
      {
        if (!this.fji.containsKey(Integer.valueOf(paramInt))) {
          break label162;
        }
        localConcurrentLinkedQueue = (ConcurrentLinkedQueue)this.fji.get(Integer.valueOf(paramInt));
        if ((!$assertionsDisabled) && (localConcurrentLinkedQueue == null))
        {
          paramV8Function = new AssertionError();
          AppMethodBeat.o(262711);
          throw paramV8Function;
        }
      }
      bool = localConcurrentLinkedQueue.isEmpty();
      for (;;)
      {
        paramInt = this.fjk.getAndIncrement();
        paramV8Function = new s.a(paramInt, paramm, paramV8Function);
        localConcurrentLinkedQueue.offer(paramV8Function);
        if (bool) {
          a(paramV8Function.fjg, paramV8Function.fjh);
        }
        Log.v("MicroMsg.V8DirectApiSharedBufferLock", "hy: request lock %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(262711);
        return paramInt;
        label162:
        localConcurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.fji.put(Integer.valueOf(paramInt), localConcurrentLinkedQueue);
      }
    }
    
    private void a(final m paramm, final V8Function paramV8Function)
    {
      AppMethodBeat.i(262713);
      paramm.fiy.q(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(262436);
          if (!paramV8Function.isReleased())
          {
            Log.d("MicroMsg.V8DirectApiSharedBufferLock", "hy: trigger task call");
            paramV8Function.call(paramm.acm().getGlobalObject(), null);
            paramV8Function.release();
            AppMethodBeat.o(262436);
            return;
          }
          Log.w("MicroMsg.V8DirectApiSharedBufferLock", "hy: called a released task");
          AppMethodBeat.o(262436);
        }
      });
      AppMethodBeat.o(262713);
    }
    
    private static b aco()
    {
      AppMethodBeat.i(262706);
      if (fjj == null) {}
      try
      {
        if (fjj == null) {
          fjj = new b();
        }
        b localb = fjj;
        AppMethodBeat.o(262706);
        return localb;
      }
      finally
      {
        AppMethodBeat.o(262706);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.s
 * JD-Core Version:    0.7.0.1
 */