package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.MultiContextNodeJS;
import com.eclipsesource.v8.MultiContextV8;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8.JavaTaskScheduler;
import com.eclipsesource.v8.V8Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class h
  extends a
{
  private MultiContextNodeJS cXV;
  private volatile m cXW;
  private i cXX;
  
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
  
  final MultiContextV8 Nl()
  {
    AppMethodBeat.i(144023);
    try
    {
      this.cXV = MultiContextNodeJS.createMultiContextNodeJS(1, this.cXv, this.cXw, this.cXy);
      this.cXV.getRuntime().getV8().setNativeJavaCallback(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(198680);
          h.a(h.this).Nw();
          AppMethodBeat.o(198680);
        }
      });
      this.cXV.getRuntime().getV8().setJavaTaskScheduler(new V8.JavaTaskScheduler()
      {
        public final void Schedule(Runnable paramAnonymousRunnable)
        {
          AppMethodBeat.i(198681);
          h.a(h.this).u(paramAnonymousRunnable);
          AppMethodBeat.o(198681);
        }
      });
      this.cXw = null;
      MultiContextV8 localMultiContextV8 = this.cXV.getRuntime();
      AppMethodBeat.o(144023);
      return localMultiContextV8;
    }
    finally
    {
      AppMethodBeat.o(144023);
    }
  }
  
  final c Nm()
  {
    AppMethodBeat.i(144024);
    this.cXX = i.a(new i.a()
    {
      public final boolean Nu()
      {
        AppMethodBeat.i(198682);
        boolean bool = h.b(h.this).handleMessage();
        AppMethodBeat.o(198682);
        return bool;
      }
      
      public final void closeUVLoop()
      {
        AppMethodBeat.i(198684);
        if (h.b(h.this) != null) {
          h.b(h.this).closeUVLoop();
        }
        AppMethodBeat.o(198684);
      }
      
      public final void wakeUpUVLoop()
      {
        AppMethodBeat.i(198683);
        if (h.b(h.this) != null) {
          h.b(h.this).wakeUpUVLoop();
        }
        AppMethodBeat.o(198683);
      }
    }, this.cXD.cXN);
    i locali = this.cXX;
    AppMethodBeat.o(144024);
    return locali;
  }
  
  final void Nn()
  {
    AppMethodBeat.i(144025);
    ad.i("MicroMsg.NodeJSRuntime", "cleanUpRuntimeWhenThreadEnd");
    try
    {
      this.cXV.release();
      ad.i("MicroMsg.NodeJSRuntime", "cleanUpRuntimeWhenThreadEnd done");
      AppMethodBeat.o(144025);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.NodeJSRuntime", "cleanUpWhenThreadEnd exp = %s", new Object[] { localException });
      AppMethodBeat.o(144025);
    }
  }
  
  public final m Nt()
  {
    AppMethodBeat.i(198686);
    if (this.cXW == null) {
      this.cXW = new m(this, No(), new m.a()
      {
        public final V8Context Nr()
        {
          AppMethodBeat.i(198685);
          if (h.b(h.this) == null)
          {
            localObject = new IllegalStateException("getMainContext mNodeJS not ready!");
            AppMethodBeat.o(198685);
            throw ((Throwable)localObject);
          }
          ad.i("MicroMsg.NodeJSRuntime", "getMainContext %s", new Object[] { Integer.valueOf(h.b(h.this).getMainContext().hashCode()) });
          Object localObject = h.b(h.this).getMainContext();
          AppMethodBeat.o(198685);
          return localObject;
        }
      });
    }
    m localm = this.cXW;
    AppMethodBeat.o(198686);
    return localm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.h
 * JD-Core Version:    0.7.0.1
 */