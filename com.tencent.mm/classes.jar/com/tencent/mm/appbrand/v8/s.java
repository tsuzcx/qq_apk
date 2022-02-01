package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class s
  extends o
{
  private WeakReference<m> cNF = null;
  
  protected final void a(final m paramm, V8Object paramV8Object)
  {
    AppMethodBeat.i(200828);
    if (paramm != null) {}
    for (int i = paramm.hashCode();; i = 0)
    {
      ac.i("MicroMsg.V8DirectApiSharedBufferLock", "hy: trigger setup worker %d", new Object[] { Integer.valueOf(i) });
      this.cNF = new WeakReference(paramm);
      paramV8Object.registerJavaMethod(new JavaCallback()
      {
        public final Object invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
        {
          AppMethodBeat.i(200815);
          if ((paramAnonymousV8Array.length() < 2) || (paramAnonymousV8Array.getType(0) != 1) || (paramAnonymousV8Array.getType(1) != 7))
          {
            ac.w("MicroMsg.V8DirectApiSharedBufferLock", "hy: v8 params error");
            AppMethodBeat.o(200815);
            return Integer.valueOf(-1);
          }
          int i = paramAnonymousV8Array.getInteger(0);
          paramAnonymousV8Object = (V8Function)paramAnonymousV8Array.getObject(1);
          i = s.b.a(s.b.LU(), i, paramAnonymousV8Object, paramm);
          AppMethodBeat.o(200815);
          return Integer.valueOf(i);
        }
      }, "lockSharedNativeBuffer");
      paramV8Object.registerJavaMethod(new JavaCallback()
      {
        public final Object invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
        {
          AppMethodBeat.i(200816);
          if ((paramAnonymousV8Array.length() < 2) || (paramAnonymousV8Array.getType(0) != 1) || (paramAnonymousV8Array.getType(1) != 1))
          {
            ac.w("MicroMsg.V8DirectApiSharedBufferLock", "hy: v8 params error");
            AppMethodBeat.o(200816);
            return null;
          }
          int i = paramAnonymousV8Array.getInteger(0);
          int j = paramAnonymousV8Array.getInteger(1);
          s.b.a(s.b.LU(), i, j);
          AppMethodBeat.o(200816);
          return null;
        }
      }, "unlockSharedNativeBuffer");
      AppMethodBeat.o(200828);
      return;
    }
  }
  
  final void cleanup()
  {
    AppMethodBeat.i(200829);
    if (this.cNF != null) {
      b.a(b.LU(), (m)this.cNF.get());
    }
    AppMethodBeat.o(200829);
  }
  
  static final class a
  {
    volatile int abW;
    volatile m cNH;
    volatile V8Function cNI;
    
    public a(int paramInt, m paramm, V8Function paramV8Function)
    {
      this.abW = paramInt;
      this.cNH = paramm;
      this.cNI = paramV8Function;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(200817);
      String str = "LockItem{itemId=" + this.abW + '}';
      AppMethodBeat.o(200817);
      return str;
    }
  }
  
  static class b
  {
    private static b cNK;
    private final ConcurrentHashMap<Integer, ConcurrentLinkedQueue<s.a>> cNJ;
    private AtomicInteger cNL;
    
    static
    {
      AppMethodBeat.i(200827);
      if (!s.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        cNK = null;
        AppMethodBeat.o(200827);
        return;
      }
    }
    
    private b()
    {
      AppMethodBeat.i(200820);
      this.cNL = new AtomicInteger(0);
      this.cNJ = new ConcurrentHashMap(100);
      AppMethodBeat.o(200820);
    }
    
    private static b LT()
    {
      AppMethodBeat.i(200819);
      if (cNK == null) {}
      try
      {
        if (cNK == null) {
          cNK = new b();
        }
        b localb = cNK;
        AppMethodBeat.o(200819);
        return localb;
      }
      finally
      {
        AppMethodBeat.o(200819);
      }
    }
    
    private int a(int paramInt, V8Function paramV8Function, m paramm)
    {
      boolean bool = true;
      AppMethodBeat.i(200821);
      ConcurrentLinkedQueue localConcurrentLinkedQueue;
      synchronized (this.cNJ)
      {
        if (!this.cNJ.containsKey(Integer.valueOf(paramInt))) {
          break label162;
        }
        localConcurrentLinkedQueue = (ConcurrentLinkedQueue)this.cNJ.get(Integer.valueOf(paramInt));
        if ((!$assertionsDisabled) && (localConcurrentLinkedQueue == null))
        {
          paramV8Function = new AssertionError();
          AppMethodBeat.o(200821);
          throw paramV8Function;
        }
      }
      bool = localConcurrentLinkedQueue.isEmpty();
      for (;;)
      {
        paramInt = this.cNL.getAndIncrement();
        paramV8Function = new s.a(paramInt, paramm, paramV8Function);
        localConcurrentLinkedQueue.offer(paramV8Function);
        if (bool) {
          a(paramV8Function.cNH, paramV8Function.cNI);
        }
        ac.v("MicroMsg.V8DirectApiSharedBufferLock", "hy: request lock %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(200821);
        return paramInt;
        label162:
        localConcurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.cNJ.put(Integer.valueOf(paramInt), localConcurrentLinkedQueue);
      }
    }
    
    private void a(final m paramm, final V8Function paramV8Function)
    {
      AppMethodBeat.i(200822);
      paramm.cMX.r(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(200818);
          if (!paramV8Function.isReleased())
          {
            ac.d("MicroMsg.V8DirectApiSharedBufferLock", "hy: trigger task call");
            paramV8Function.call(paramm.LR().getGlobalObject(), null);
            paramV8Function.release();
            AppMethodBeat.o(200818);
            return;
          }
          ac.w("MicroMsg.V8DirectApiSharedBufferLock", "hy: called a released task");
          AppMethodBeat.o(200818);
        }
      });
      AppMethodBeat.o(200822);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.s
 * JD-Core Version:    0.7.0.1
 */