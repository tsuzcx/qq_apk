package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.MultiContextNodeJS;
import com.eclipsesource.v8.MultiContextV8;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8.JavaTaskScheduler;
import com.eclipsesource.v8.V8Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public final class h
  extends a
{
  private MultiContextNodeJS cYT;
  private volatile m cYU;
  private i cYV;
  
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
  
  final MultiContextV8 Ng()
  {
    AppMethodBeat.i(144023);
    try
    {
      this.cYT = MultiContextNodeJS.createMultiContextNodeJS(1, this.cYs, this.cYt, this.cYv);
      this.cYT.getRuntime().getV8().setNativeJavaCallback(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194161);
          h.a(h.this).Nr();
          AppMethodBeat.o(194161);
        }
      });
      this.cYT.getRuntime().getV8().setJavaTaskScheduler(new V8.JavaTaskScheduler()
      {
        public final void Schedule(Runnable paramAnonymousRunnable)
        {
          AppMethodBeat.i(194162);
          h.a(h.this).c(paramAnonymousRunnable, false);
          AppMethodBeat.o(194162);
        }
      });
      this.cYt = null;
      MultiContextV8 localMultiContextV8 = this.cYT.getRuntime();
      AppMethodBeat.o(144023);
      return localMultiContextV8;
    }
    finally
    {
      AppMethodBeat.o(144023);
    }
  }
  
  final c Nh()
  {
    AppMethodBeat.i(144024);
    this.cYV = i.a(new i.a()
    {
      public final boolean Np()
      {
        AppMethodBeat.i(194163);
        boolean bool = h.b(h.this).handleMessage();
        AppMethodBeat.o(194163);
        return bool;
      }
      
      public final void closeUVLoop()
      {
        AppMethodBeat.i(194165);
        if (h.b(h.this) != null) {
          h.b(h.this).closeUVLoop();
        }
        AppMethodBeat.o(194165);
      }
      
      public final void wakeUpUVLoop()
      {
        AppMethodBeat.i(194164);
        if (h.b(h.this) != null) {
          h.b(h.this).wakeUpUVLoop();
        }
        AppMethodBeat.o(194164);
      }
    }, this.cYA.cYL);
    i locali = this.cYV;
    AppMethodBeat.o(144024);
    return locali;
  }
  
  final void Ni()
  {
    AppMethodBeat.i(144025);
    ae.i("MicroMsg.NodeJSRuntime", "cleanUpRuntimeWhenThreadEnd");
    try
    {
      this.cYT.release();
      ae.i("MicroMsg.NodeJSRuntime", "cleanUpRuntimeWhenThreadEnd done");
      AppMethodBeat.o(144025);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.NodeJSRuntime", "cleanUpWhenThreadEnd exp = %s", new Object[] { localException });
      AppMethodBeat.o(144025);
    }
  }
  
  public final m No()
  {
    AppMethodBeat.i(194167);
    if (this.cYU == null) {
      this.cYU = new m(this, Nj(), new m.a()
      {
        public final V8Context Nm()
        {
          AppMethodBeat.i(194166);
          if (h.b(h.this) == null)
          {
            localObject = new IllegalStateException("getMainContext mNodeJS not ready!");
            AppMethodBeat.o(194166);
            throw ((Throwable)localObject);
          }
          ae.i("MicroMsg.NodeJSRuntime", "getMainContext %s", new Object[] { Integer.valueOf(h.b(h.this).getMainContext().hashCode()) });
          Object localObject = h.b(h.this).getMainContext();
          AppMethodBeat.o(194166);
          return localObject;
        }
      });
    }
    m localm = this.cYU;
    AppMethodBeat.o(194167);
    return localm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.h
 * JD-Core Version:    0.7.0.1
 */