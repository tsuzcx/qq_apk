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
  private WeakReference<m> cQk = null;
  
  protected final void a(final m paramm, V8Object paramV8Object)
  {
    AppMethodBeat.i(193502);
    if (paramm != null) {}
    for (int i = paramm.hashCode();; i = 0)
    {
      ad.i("MicroMsg.V8DirectApiSharedBufferLock", "hy: trigger setup worker %d", new Object[] { Integer.valueOf(i) });
      this.cQk = new WeakReference(paramm);
      paramV8Object.registerJavaMethod(new JavaCallback()
      {
        public final Object invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
        {
          AppMethodBeat.i(193489);
          if ((paramAnonymousV8Array.length() < 2) || (paramAnonymousV8Array.getType(0) != 1) || (paramAnonymousV8Array.getType(1) != 7))
          {
            ad.w("MicroMsg.V8DirectApiSharedBufferLock", "hy: v8 params error");
            AppMethodBeat.o(193489);
            return Integer.valueOf(-1);
          }
          int i = paramAnonymousV8Array.getInteger(0);
          paramAnonymousV8Object = (V8Function)paramAnonymousV8Array.getObject(1);
          i = s.b.a(s.b.LW(), i, paramAnonymousV8Object, paramm);
          AppMethodBeat.o(193489);
          return Integer.valueOf(i);
        }
      }, "lockSharedNativeBuffer");
      paramV8Object.registerJavaMethod(new JavaCallback()
      {
        public final Object invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
        {
          AppMethodBeat.i(193490);
          if ((paramAnonymousV8Array.length() < 2) || (paramAnonymousV8Array.getType(0) != 1) || (paramAnonymousV8Array.getType(1) != 1))
          {
            ad.w("MicroMsg.V8DirectApiSharedBufferLock", "hy: v8 params error");
            AppMethodBeat.o(193490);
            return null;
          }
          int i = paramAnonymousV8Array.getInteger(0);
          int j = paramAnonymousV8Array.getInteger(1);
          s.b.a(s.b.LW(), i, j);
          AppMethodBeat.o(193490);
          return null;
        }
      }, "unlockSharedNativeBuffer");
      AppMethodBeat.o(193502);
      return;
    }
  }
  
  final void cleanup()
  {
    AppMethodBeat.i(193503);
    if (this.cQk != null) {
      b.a(b.LW(), (m)this.cQk.get());
    }
    AppMethodBeat.o(193503);
  }
  
  static final class a
  {
    volatile int abb;
    volatile m cQm;
    volatile V8Function cQn;
    
    public a(int paramInt, m paramm, V8Function paramV8Function)
    {
      this.abb = paramInt;
      this.cQm = paramm;
      this.cQn = paramV8Function;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(193491);
      String str = "LockItem{itemId=" + this.abb + '}';
      AppMethodBeat.o(193491);
      return str;
    }
  }
  
  static class b
  {
    private static b cQp;
    private final ConcurrentHashMap<Integer, ConcurrentLinkedQueue<s.a>> cQo;
    private AtomicInteger cQq;
    
    static
    {
      AppMethodBeat.i(193501);
      if (!s.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        cQp = null;
        AppMethodBeat.o(193501);
        return;
      }
    }
    
    private b()
    {
      AppMethodBeat.i(193494);
      this.cQq = new AtomicInteger(0);
      this.cQo = new ConcurrentHashMap(100);
      AppMethodBeat.o(193494);
    }
    
    private static b LV()
    {
      AppMethodBeat.i(193493);
      if (cQp == null) {}
      try
      {
        if (cQp == null) {
          cQp = new b();
        }
        b localb = cQp;
        AppMethodBeat.o(193493);
        return localb;
      }
      finally
      {
        AppMethodBeat.o(193493);
      }
    }
    
    private int a(int paramInt, V8Function paramV8Function, m paramm)
    {
      boolean bool = true;
      AppMethodBeat.i(193495);
      ConcurrentLinkedQueue localConcurrentLinkedQueue;
      synchronized (this.cQo)
      {
        if (!this.cQo.containsKey(Integer.valueOf(paramInt))) {
          break label162;
        }
        localConcurrentLinkedQueue = (ConcurrentLinkedQueue)this.cQo.get(Integer.valueOf(paramInt));
        if ((!$assertionsDisabled) && (localConcurrentLinkedQueue == null))
        {
          paramV8Function = new AssertionError();
          AppMethodBeat.o(193495);
          throw paramV8Function;
        }
      }
      bool = localConcurrentLinkedQueue.isEmpty();
      for (;;)
      {
        paramInt = this.cQq.getAndIncrement();
        paramV8Function = new s.a(paramInt, paramm, paramV8Function);
        localConcurrentLinkedQueue.offer(paramV8Function);
        if (bool) {
          a(paramV8Function.cQm, paramV8Function.cQn);
        }
        ad.v("MicroMsg.V8DirectApiSharedBufferLock", "hy: request lock %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(193495);
        return paramInt;
        label162:
        localConcurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.cQo.put(Integer.valueOf(paramInt), localConcurrentLinkedQueue);
      }
    }
    
    private void a(final m paramm, final V8Function paramV8Function)
    {
      AppMethodBeat.i(193496);
      paramm.cPC.q(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(193492);
          if (!paramV8Function.isReleased())
          {
            ad.d("MicroMsg.V8DirectApiSharedBufferLock", "hy: trigger task call");
            paramV8Function.call(paramm.LT().getGlobalObject(), null);
            paramV8Function.release();
            AppMethodBeat.o(193492);
            return;
          }
          ad.w("MicroMsg.V8DirectApiSharedBufferLock", "hy: called a released task");
          AppMethodBeat.o(193492);
        }
      });
      AppMethodBeat.o(193496);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.s
 * JD-Core Version:    0.7.0.1
 */