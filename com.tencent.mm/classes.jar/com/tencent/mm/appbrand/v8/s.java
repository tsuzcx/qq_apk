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
  private WeakReference<m> hnr = null;
  
  protected final void b(final m paramm, V8Object paramV8Object)
  {
    AppMethodBeat.i(238640);
    if (paramm != null) {}
    for (int i = paramm.hashCode();; i = 0)
    {
      Log.i("MicroMsg.V8DirectApiSharedBufferLock", "hy: trigger setup worker %d", new Object[] { Integer.valueOf(i) });
      this.hnr = new WeakReference(paramm);
      paramV8Object.registerJavaMethod(new JavaCallback()
      {
        public final Object invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
        {
          AppMethodBeat.i(238566);
          if ((paramAnonymousV8Array.length() < 2) || (paramAnonymousV8Array.getType(0) != 1) || (paramAnonymousV8Array.getType(1) != 7))
          {
            Log.w("MicroMsg.V8DirectApiSharedBufferLock", "hy: v8 params error");
            AppMethodBeat.o(238566);
            return Integer.valueOf(-1);
          }
          int i = paramAnonymousV8Array.getInteger(0);
          paramAnonymousV8Object = (V8Function)paramAnonymousV8Array.getObject(1);
          i = s.b.a(s.b.aEp(), i, paramAnonymousV8Object, paramm);
          AppMethodBeat.o(238566);
          return Integer.valueOf(i);
        }
      }, "lockSharedNativeBuffer");
      paramV8Object.registerJavaMethod(new JavaCallback()
      {
        public final Object invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
        {
          AppMethodBeat.i(238558);
          if ((paramAnonymousV8Array.length() < 2) || (paramAnonymousV8Array.getType(0) != 1) || (paramAnonymousV8Array.getType(1) != 1))
          {
            Log.w("MicroMsg.V8DirectApiSharedBufferLock", "hy: v8 params error");
            AppMethodBeat.o(238558);
            return null;
          }
          int i = paramAnonymousV8Array.getInteger(0);
          int j = paramAnonymousV8Array.getInteger(1);
          s.b.a(s.b.aEp(), i, j);
          AppMethodBeat.o(238558);
          return null;
        }
      }, "unlockSharedNativeBuffer");
      AppMethodBeat.o(238640);
      return;
    }
  }
  
  final void cleanup()
  {
    AppMethodBeat.i(238645);
    if (this.hnr != null) {
      b.a(b.aEp(), (m)this.hnr.get());
    }
    AppMethodBeat.o(238645);
  }
  
  static final class a
  {
    volatile m hnt;
    volatile V8Function hnu;
    volatile int ld;
    
    public a(int paramInt, m paramm, V8Function paramV8Function)
    {
      this.ld = paramInt;
      this.hnt = paramm;
      this.hnu = paramV8Function;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(238657);
      String str = "LockItem{itemId=" + this.ld + '}';
      AppMethodBeat.o(238657);
      return str;
    }
  }
  
  static class b
  {
    private static b hnw;
    private final ConcurrentHashMap<Integer, ConcurrentLinkedQueue<s.a>> hnv;
    private AtomicInteger hnx;
    
    static
    {
      AppMethodBeat.i(238734);
      if (!s.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        hnw = null;
        AppMethodBeat.o(238734);
        return;
      }
    }
    
    private b()
    {
      AppMethodBeat.i(238666);
      this.hnx = new AtomicInteger(0);
      this.hnv = new ConcurrentHashMap(100);
      AppMethodBeat.o(238666);
    }
    
    private int a(int paramInt, V8Function paramV8Function, m paramm)
    {
      boolean bool = true;
      AppMethodBeat.i(238674);
      ConcurrentLinkedQueue localConcurrentLinkedQueue;
      synchronized (this.hnv)
      {
        if (!this.hnv.containsKey(Integer.valueOf(paramInt))) {
          break label162;
        }
        localConcurrentLinkedQueue = (ConcurrentLinkedQueue)this.hnv.get(Integer.valueOf(paramInt));
        if ((!$assertionsDisabled) && (localConcurrentLinkedQueue == null))
        {
          paramV8Function = new AssertionError();
          AppMethodBeat.o(238674);
          throw paramV8Function;
        }
      }
      bool = localConcurrentLinkedQueue.isEmpty();
      for (;;)
      {
        paramInt = this.hnx.getAndIncrement();
        paramV8Function = new s.a(paramInt, paramm, paramV8Function);
        localConcurrentLinkedQueue.offer(paramV8Function);
        if (bool) {
          a(paramV8Function.hnt, paramV8Function.hnu);
        }
        Log.v("MicroMsg.V8DirectApiSharedBufferLock", "hy: request lock %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(238674);
        return paramInt;
        label162:
        localConcurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.hnv.put(Integer.valueOf(paramInt), localConcurrentLinkedQueue);
      }
    }
    
    private void a(final m paramm, final V8Function paramV8Function)
    {
      AppMethodBeat.i(238680);
      paramm.hmL.u(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(238661);
          if (!paramV8Function.isReleased())
          {
            Log.d("MicroMsg.V8DirectApiSharedBufferLock", "hy: trigger task call");
            paramV8Function.call(paramm.aEm().getGlobalObject(), null);
            paramV8Function.release();
            AppMethodBeat.o(238661);
            return;
          }
          Log.w("MicroMsg.V8DirectApiSharedBufferLock", "hy: called a released task");
          AppMethodBeat.o(238661);
        }
      });
      AppMethodBeat.o(238680);
    }
    
    private static b aEo()
    {
      AppMethodBeat.i(238660);
      if (hnw == null) {}
      try
      {
        if (hnw == null) {
          hnw = new b();
        }
        b localb = hnw;
        AppMethodBeat.o(238660);
        return localb;
      }
      finally
      {
        AppMethodBeat.o(238660);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.s
 * JD-Core Version:    0.7.0.1
 */