package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class s
  extends o
{
  private WeakReference<m> dqx = null;
  
  protected final void a(final m paramm, V8Object paramV8Object)
  {
    AppMethodBeat.i(216905);
    if (paramm != null) {}
    for (int i = paramm.hashCode();; i = 0)
    {
      Log.i("MicroMsg.V8DirectApiSharedBufferLock", "hy: trigger setup worker %d", new Object[] { Integer.valueOf(i) });
      this.dqx = new WeakReference(paramm);
      paramV8Object.registerJavaMethod(new JavaCallback()
      {
        public final Object invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
        {
          AppMethodBeat.i(216892);
          if ((paramAnonymousV8Array.length() < 2) || (paramAnonymousV8Array.getType(0) != 1) || (paramAnonymousV8Array.getType(1) != 7))
          {
            Log.w("MicroMsg.V8DirectApiSharedBufferLock", "hy: v8 params error");
            AppMethodBeat.o(216892);
            return Integer.valueOf(-1);
          }
          int i = paramAnonymousV8Array.getInteger(0);
          paramAnonymousV8Object = (V8Function)paramAnonymousV8Array.getObject(1);
          i = s.b.a(s.b.XM(), i, paramAnonymousV8Object, paramm);
          AppMethodBeat.o(216892);
          return Integer.valueOf(i);
        }
      }, "lockSharedNativeBuffer");
      paramV8Object.registerJavaMethod(new JavaCallback()
      {
        public final Object invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
        {
          AppMethodBeat.i(216893);
          if ((paramAnonymousV8Array.length() < 2) || (paramAnonymousV8Array.getType(0) != 1) || (paramAnonymousV8Array.getType(1) != 1))
          {
            Log.w("MicroMsg.V8DirectApiSharedBufferLock", "hy: v8 params error");
            AppMethodBeat.o(216893);
            return null;
          }
          int i = paramAnonymousV8Array.getInteger(0);
          int j = paramAnonymousV8Array.getInteger(1);
          s.b.a(s.b.XM(), i, j);
          AppMethodBeat.o(216893);
          return null;
        }
      }, "unlockSharedNativeBuffer");
      AppMethodBeat.o(216905);
      return;
    }
  }
  
  final void cleanup()
  {
    AppMethodBeat.i(216906);
    if (this.dqx != null) {
      b.a(b.XM(), (m)this.dqx.get());
    }
    AppMethodBeat.o(216906);
  }
  
  static final class a
  {
    volatile int aea;
    volatile V8Function dqA;
    volatile m dqz;
    
    public a(int paramInt, m paramm, V8Function paramV8Function)
    {
      this.aea = paramInt;
      this.dqz = paramm;
      this.dqA = paramV8Function;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(216894);
      String str = "LockItem{itemId=" + this.aea + '}';
      AppMethodBeat.o(216894);
      return str;
    }
  }
  
  static class b
  {
    private static b dqC;
    private final ConcurrentHashMap<Integer, ConcurrentLinkedQueue<s.a>> dqB;
    private AtomicInteger dqD;
    
    static
    {
      AppMethodBeat.i(216904);
      if (!s.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        dqC = null;
        AppMethodBeat.o(216904);
        return;
      }
    }
    
    private b()
    {
      AppMethodBeat.i(216897);
      this.dqD = new AtomicInteger(0);
      this.dqB = new ConcurrentHashMap(100);
      AppMethodBeat.o(216897);
    }
    
    private static b XL()
    {
      AppMethodBeat.i(216896);
      if (dqC == null) {}
      try
      {
        if (dqC == null) {
          dqC = new b();
        }
        b localb = dqC;
        AppMethodBeat.o(216896);
        return localb;
      }
      finally
      {
        AppMethodBeat.o(216896);
      }
    }
    
    private int a(int paramInt, V8Function paramV8Function, m paramm)
    {
      boolean bool = true;
      AppMethodBeat.i(216898);
      ConcurrentLinkedQueue localConcurrentLinkedQueue;
      synchronized (this.dqB)
      {
        if (!this.dqB.containsKey(Integer.valueOf(paramInt))) {
          break label162;
        }
        localConcurrentLinkedQueue = (ConcurrentLinkedQueue)this.dqB.get(Integer.valueOf(paramInt));
        if ((!$assertionsDisabled) && (localConcurrentLinkedQueue == null))
        {
          paramV8Function = new AssertionError();
          AppMethodBeat.o(216898);
          throw paramV8Function;
        }
      }
      bool = localConcurrentLinkedQueue.isEmpty();
      for (;;)
      {
        paramInt = this.dqD.getAndIncrement();
        paramV8Function = new s.a(paramInt, paramm, paramV8Function);
        localConcurrentLinkedQueue.offer(paramV8Function);
        if (bool) {
          a(paramV8Function.dqz, paramV8Function.dqA);
        }
        Log.v("MicroMsg.V8DirectApiSharedBufferLock", "hy: request lock %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(216898);
        return paramInt;
        label162:
        localConcurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.dqB.put(Integer.valueOf(paramInt), localConcurrentLinkedQueue);
      }
    }
    
    private void a(final m paramm, final V8Function paramV8Function)
    {
      AppMethodBeat.i(216899);
      paramm.dpQ.r(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(216895);
          if (!paramV8Function.isReleased())
          {
            Log.d("MicroMsg.V8DirectApiSharedBufferLock", "hy: trigger task call");
            paramV8Function.call(paramm.XJ().getGlobalObject(), null);
            paramV8Function.release();
            AppMethodBeat.o(216895);
            return;
          }
          Log.w("MicroMsg.V8DirectApiSharedBufferLock", "hy: called a released task");
          AppMethodBeat.o(216895);
        }
      });
      AppMethodBeat.o(216899);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.s
 * JD-Core Version:    0.7.0.1
 */