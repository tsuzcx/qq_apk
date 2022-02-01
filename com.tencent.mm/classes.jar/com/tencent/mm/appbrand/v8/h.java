package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.MultiContextNodeJS;
import com.eclipsesource.v8.MultiContextV8;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8.JavaTaskScheduler;
import com.eclipsesource.v8.V8Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
  extends a
{
  private i dpA;
  private MultiContextNodeJS dpy;
  private volatile m dpz;
  
  static
  {
    AppMethodBeat.i(144026);
    MultiContextNodeJS.setGetTmpFileDirectoryDelegate(new h.1());
    AppMethodBeat.o(144026);
  }
  
  private h(IJSRuntime.Config paramConfig)
  {
    super(paramConfig);
  }
  
  static h e(IJSRuntime.Config paramConfig)
  {
    AppMethodBeat.i(144022);
    paramConfig = new h(paramConfig);
    AppMethodBeat.o(144022);
    return paramConfig;
  }
  
  public final m XA()
  {
    AppMethodBeat.i(216887);
    if (this.dpz == null) {
      this.dpz = new m(this, Xv(), new m.a()
      {
        public final V8Context Xy()
        {
          AppMethodBeat.i(216886);
          if (h.b(h.this) == null)
          {
            localObject = new IllegalStateException("getMainContext mNodeJS not ready!");
            AppMethodBeat.o(216886);
            throw ((Throwable)localObject);
          }
          Log.i("MicroMsg.NodeJSRuntime", "getMainContext %s", new Object[] { Integer.valueOf(h.b(h.this).getMainContext().hashCode()) });
          Object localObject = h.b(h.this).getMainContext();
          AppMethodBeat.o(216886);
          return localObject;
        }
      });
    }
    m localm = this.dpz;
    AppMethodBeat.o(216887);
    return localm;
  }
  
  final MultiContextV8 Xs()
  {
    AppMethodBeat.i(144023);
    try
    {
      this.dpy = MultiContextNodeJS.createMultiContextNodeJS(1, this.doX, this.doY, this.dpa);
      this.dpy.getRuntime().getV8().setNativeJavaCallback(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(216881);
          h.a(h.this).XD();
          AppMethodBeat.o(216881);
        }
      });
      this.dpy.getRuntime().getV8().setJavaTaskScheduler(new V8.JavaTaskScheduler()
      {
        public final void Schedule(Runnable paramAnonymousRunnable)
        {
          AppMethodBeat.i(216882);
          h.a(h.this).u(paramAnonymousRunnable);
          AppMethodBeat.o(216882);
        }
      });
      this.doY = null;
      MultiContextV8 localMultiContextV8 = this.dpy.getRuntime();
      AppMethodBeat.o(144023);
      return localMultiContextV8;
    }
    finally
    {
      AppMethodBeat.o(144023);
    }
  }
  
  final c Xt()
  {
    AppMethodBeat.i(144024);
    this.dpA = i.a(new i.a()
    {
      public final boolean XB()
      {
        AppMethodBeat.i(216883);
        boolean bool = h.b(h.this).handleMessage();
        AppMethodBeat.o(216883);
        return bool;
      }
      
      public final void closeUVLoop()
      {
        AppMethodBeat.i(216885);
        if (h.b(h.this) != null) {
          h.b(h.this).closeUVLoop();
        }
        AppMethodBeat.o(216885);
      }
      
      public final void wakeUpUVLoop()
      {
        AppMethodBeat.i(216884);
        if (h.b(h.this) != null) {
          h.b(h.this).wakeUpUVLoop();
        }
        AppMethodBeat.o(216884);
      }
    }, this.dpf.dpp);
    i locali = this.dpA;
    AppMethodBeat.o(144024);
    return locali;
  }
  
  final void Xu()
  {
    AppMethodBeat.i(144025);
    Log.i("MicroMsg.NodeJSRuntime", "cleanUpRuntimeWhenThreadEnd");
    try
    {
      this.dpy.release();
      Log.i("MicroMsg.NodeJSRuntime", "cleanUpRuntimeWhenThreadEnd done");
      AppMethodBeat.o(144025);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.NodeJSRuntime", "cleanUpWhenThreadEnd exp = %s", new Object[] { localException });
      AppMethodBeat.o(144025);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.h
 * JD-Core Version:    0.7.0.1
 */