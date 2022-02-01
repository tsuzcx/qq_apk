package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class s
  extends o
{
  private WeakReference<m> cZT = null;
  
  protected final void a(final m paramm, V8Object paramV8Object)
  {
    AppMethodBeat.i(194185);
    if (paramm != null) {}
    for (int i = paramm.hashCode();; i = 0)
    {
      ae.i("MicroMsg.V8DirectApiSharedBufferLock", "hy: trigger setup worker %d", new Object[] { Integer.valueOf(i) });
      this.cZT = new WeakReference(paramm);
      paramV8Object.registerJavaMethod(new JavaCallback()
      {
        public final Object invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
        {
          AppMethodBeat.i(194172);
          if ((paramAnonymousV8Array.length() < 2) || (paramAnonymousV8Array.getType(0) != 1) || (paramAnonymousV8Array.getType(1) != 7))
          {
            ae.w("MicroMsg.V8DirectApiSharedBufferLock", "hy: v8 params error");
            AppMethodBeat.o(194172);
            return Integer.valueOf(-1);
          }
          int i = paramAnonymousV8Array.getInteger(0);
          paramAnonymousV8Object = (V8Function)paramAnonymousV8Array.getObject(1);
          i = s.b.a(s.b.NB(), i, paramAnonymousV8Object, paramm);
          AppMethodBeat.o(194172);
          return Integer.valueOf(i);
        }
      }, "lockSharedNativeBuffer");
      paramV8Object.registerJavaMethod(new JavaCallback()
      {
        public final Object invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
        {
          AppMethodBeat.i(194173);
          if ((paramAnonymousV8Array.length() < 2) || (paramAnonymousV8Array.getType(0) != 1) || (paramAnonymousV8Array.getType(1) != 1))
          {
            ae.w("MicroMsg.V8DirectApiSharedBufferLock", "hy: v8 params error");
            AppMethodBeat.o(194173);
            return null;
          }
          int i = paramAnonymousV8Array.getInteger(0);
          int j = paramAnonymousV8Array.getInteger(1);
          s.b.a(s.b.NB(), i, j);
          AppMethodBeat.o(194173);
          return null;
        }
      }, "unlockSharedNativeBuffer");
      AppMethodBeat.o(194185);
      return;
    }
  }
  
  final void cleanup()
  {
    AppMethodBeat.i(194186);
    if (this.cZT != null) {
      b.a(b.NB(), (m)this.cZT.get());
    }
    AppMethodBeat.o(194186);
  }
  
  static final class a
  {
    volatile int adN;
    volatile m cZV;
    volatile V8Function cZW;
    
    public a(int paramInt, m paramm, V8Function paramV8Function)
    {
      this.adN = paramInt;
      this.cZV = paramm;
      this.cZW = paramV8Function;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(194174);
      String str = "LockItem{itemId=" + this.adN + '}';
      AppMethodBeat.o(194174);
      return str;
    }
  }
  
  static class b
  {
    private static b cZY;
    private final ConcurrentHashMap<Integer, ConcurrentLinkedQueue<s.a>> cZX;
    private AtomicInteger cZZ;
    
    static
    {
      AppMethodBeat.i(194184);
      if (!s.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        cZY = null;
        AppMethodBeat.o(194184);
        return;
      }
    }
    
    private b()
    {
      AppMethodBeat.i(194177);
      this.cZZ = new AtomicInteger(0);
      this.cZX = new ConcurrentHashMap(100);
      AppMethodBeat.o(194177);
    }
    
    private static b NA()
    {
      AppMethodBeat.i(194176);
      if (cZY == null) {}
      try
      {
        if (cZY == null) {
          cZY = new b();
        }
        b localb = cZY;
        AppMethodBeat.o(194176);
        return localb;
      }
      finally
      {
        AppMethodBeat.o(194176);
      }
    }
    
    private int a(int paramInt, V8Function paramV8Function, m paramm)
    {
      boolean bool = true;
      AppMethodBeat.i(194178);
      ConcurrentLinkedQueue localConcurrentLinkedQueue;
      synchronized (this.cZX)
      {
        if (!this.cZX.containsKey(Integer.valueOf(paramInt))) {
          break label162;
        }
        localConcurrentLinkedQueue = (ConcurrentLinkedQueue)this.cZX.get(Integer.valueOf(paramInt));
        if ((!$assertionsDisabled) && (localConcurrentLinkedQueue == null))
        {
          paramV8Function = new AssertionError();
          AppMethodBeat.o(194178);
          throw paramV8Function;
        }
      }
      bool = localConcurrentLinkedQueue.isEmpty();
      for (;;)
      {
        paramInt = this.cZZ.getAndIncrement();
        paramV8Function = new s.a(paramInt, paramm, paramV8Function);
        localConcurrentLinkedQueue.offer(paramV8Function);
        if (bool) {
          a(paramV8Function.cZV, paramV8Function.cZW);
        }
        ae.v("MicroMsg.V8DirectApiSharedBufferLock", "hy: request lock %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(194178);
        return paramInt;
        label162:
        localConcurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.cZX.put(Integer.valueOf(paramInt), localConcurrentLinkedQueue);
      }
    }
    
    private void a(final m paramm, final V8Function paramV8Function)
    {
      AppMethodBeat.i(194179);
      paramm.cZl.r(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194175);
          if (!paramV8Function.isReleased())
          {
            ae.d("MicroMsg.V8DirectApiSharedBufferLock", "hy: trigger task call");
            paramV8Function.call(paramm.Ny().getGlobalObject(), null);
            paramV8Function.release();
            AppMethodBeat.o(194175);
            return;
          }
          ae.w("MicroMsg.V8DirectApiSharedBufferLock", "hy: called a released task");
          AppMethodBeat.o(194175);
        }
      });
      AppMethodBeat.o(194179);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.s
 * JD-Core Version:    0.7.0.1
 */