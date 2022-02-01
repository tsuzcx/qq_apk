package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class s
  extends o
{
  private WeakReference<m> cYV = null;
  
  protected final void a(final m paramm, V8Object paramV8Object)
  {
    AppMethodBeat.i(198703);
    if (paramm != null) {}
    for (int i = paramm.hashCode();; i = 0)
    {
      ad.i("MicroMsg.V8DirectApiSharedBufferLock", "hy: trigger setup worker %d", new Object[] { Integer.valueOf(i) });
      this.cYV = new WeakReference(paramm);
      paramV8Object.registerJavaMethod(new JavaCallback()
      {
        public final Object invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
        {
          AppMethodBeat.i(198690);
          if ((paramAnonymousV8Array.length() < 2) || (paramAnonymousV8Array.getType(0) != 1) || (paramAnonymousV8Array.getType(1) != 7))
          {
            ad.w("MicroMsg.V8DirectApiSharedBufferLock", "hy: v8 params error");
            AppMethodBeat.o(198690);
            return Integer.valueOf(-1);
          }
          int i = paramAnonymousV8Array.getInteger(0);
          paramAnonymousV8Object = (V8Function)paramAnonymousV8Array.getObject(1);
          i = s.b.a(s.b.ND(), i, paramAnonymousV8Object, paramm);
          AppMethodBeat.o(198690);
          return Integer.valueOf(i);
        }
      }, "lockSharedNativeBuffer");
      paramV8Object.registerJavaMethod(new JavaCallback()
      {
        public final Object invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
        {
          AppMethodBeat.i(198691);
          if ((paramAnonymousV8Array.length() < 2) || (paramAnonymousV8Array.getType(0) != 1) || (paramAnonymousV8Array.getType(1) != 1))
          {
            ad.w("MicroMsg.V8DirectApiSharedBufferLock", "hy: v8 params error");
            AppMethodBeat.o(198691);
            return null;
          }
          int i = paramAnonymousV8Array.getInteger(0);
          int j = paramAnonymousV8Array.getInteger(1);
          s.b.a(s.b.ND(), i, j);
          AppMethodBeat.o(198691);
          return null;
        }
      }, "unlockSharedNativeBuffer");
      AppMethodBeat.o(198703);
      return;
    }
  }
  
  final void cleanup()
  {
    AppMethodBeat.i(198704);
    if (this.cYV != null) {
      b.a(b.ND(), (m)this.cYV.get());
    }
    AppMethodBeat.o(198704);
  }
  
  static final class a
  {
    volatile int adN;
    volatile m cYX;
    volatile V8Function cYY;
    
    public a(int paramInt, m paramm, V8Function paramV8Function)
    {
      this.adN = paramInt;
      this.cYX = paramm;
      this.cYY = paramV8Function;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(198692);
      String str = "LockItem{itemId=" + this.adN + '}';
      AppMethodBeat.o(198692);
      return str;
    }
  }
  
  static class b
  {
    private static b cZa;
    private final ConcurrentHashMap<Integer, ConcurrentLinkedQueue<s.a>> cYZ;
    private AtomicInteger cZb;
    
    static
    {
      AppMethodBeat.i(198702);
      if (!s.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        cZa = null;
        AppMethodBeat.o(198702);
        return;
      }
    }
    
    private b()
    {
      AppMethodBeat.i(198695);
      this.cZb = new AtomicInteger(0);
      this.cYZ = new ConcurrentHashMap(100);
      AppMethodBeat.o(198695);
    }
    
    private static b NC()
    {
      AppMethodBeat.i(198694);
      if (cZa == null) {}
      try
      {
        if (cZa == null) {
          cZa = new b();
        }
        b localb = cZa;
        AppMethodBeat.o(198694);
        return localb;
      }
      finally
      {
        AppMethodBeat.o(198694);
      }
    }
    
    private int a(int paramInt, V8Function paramV8Function, m paramm)
    {
      boolean bool = true;
      AppMethodBeat.i(198696);
      ConcurrentLinkedQueue localConcurrentLinkedQueue;
      synchronized (this.cYZ)
      {
        if (!this.cYZ.containsKey(Integer.valueOf(paramInt))) {
          break label162;
        }
        localConcurrentLinkedQueue = (ConcurrentLinkedQueue)this.cYZ.get(Integer.valueOf(paramInt));
        if ((!$assertionsDisabled) && (localConcurrentLinkedQueue == null))
        {
          paramV8Function = new AssertionError();
          AppMethodBeat.o(198696);
          throw paramV8Function;
        }
      }
      bool = localConcurrentLinkedQueue.isEmpty();
      for (;;)
      {
        paramInt = this.cZb.getAndIncrement();
        paramV8Function = new s.a(paramInt, paramm, paramV8Function);
        localConcurrentLinkedQueue.offer(paramV8Function);
        if (bool) {
          a(paramV8Function.cYX, paramV8Function.cYY);
        }
        ad.v("MicroMsg.V8DirectApiSharedBufferLock", "hy: request lock %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(198696);
        return paramInt;
        label162:
        localConcurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.cYZ.put(Integer.valueOf(paramInt), localConcurrentLinkedQueue);
      }
    }
    
    private void a(final m paramm, final V8Function paramV8Function)
    {
      AppMethodBeat.i(198697);
      paramm.cYn.r(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(198693);
          if (!paramV8Function.isReleased())
          {
            ad.d("MicroMsg.V8DirectApiSharedBufferLock", "hy: trigger task call");
            paramV8Function.call(paramm.NA().getGlobalObject(), null);
            paramV8Function.release();
            AppMethodBeat.o(198693);
            return;
          }
          ad.w("MicroMsg.V8DirectApiSharedBufferLock", "hy: called a released task");
          AppMethodBeat.o(198693);
        }
      });
      AppMethodBeat.o(198697);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.s
 * JD-Core Version:    0.7.0.1
 */