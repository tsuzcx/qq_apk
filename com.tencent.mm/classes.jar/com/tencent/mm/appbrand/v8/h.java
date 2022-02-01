package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.MultiContextNodeJS;
import com.eclipsesource.mmv8.MultiContextV8;
import com.eclipsesource.mmv8.V8;
import com.eclipsesource.mmv8.V8.JavaTaskScheduler;
import com.eclipsesource.mmv8.V8Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
  extends a
{
  private MultiContextNodeJS fif;
  private volatile m fig;
  private i fih;
  
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
  
  final MultiContextV8 abU()
  {
    AppMethodBeat.i(144023);
    try
    {
      this.fif = MultiContextNodeJS.createMultiContextNodeJS(1, this.fhD, this.fhE, this.fhG);
      this.fif.getRuntime().getV8().setNativeJavaCallback(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(262200);
          h.a(h.this).acg();
          AppMethodBeat.o(262200);
        }
      });
      this.fif.getRuntime().getV8().setJavaTaskScheduler(new V8.JavaTaskScheduler()
      {
        public final void Schedule(Runnable paramAnonymousRunnable)
        {
          AppMethodBeat.i(262835);
          h.a(h.this).t(paramAnonymousRunnable);
          AppMethodBeat.o(262835);
        }
      });
      this.fhE = null;
      MultiContextV8 localMultiContextV8 = this.fif.getRuntime();
      AppMethodBeat.o(144023);
      return localMultiContextV8;
    }
    finally
    {
      AppMethodBeat.o(144023);
    }
  }
  
  final c abV()
  {
    AppMethodBeat.i(144024);
    this.fih = i.a(new i.a()
    {
      public final boolean ace()
      {
        AppMethodBeat.i(262439);
        boolean bool = h.b(h.this).handleMessage();
        AppMethodBeat.o(262439);
        return bool;
      }
      
      public final void closeUVLoop()
      {
        AppMethodBeat.i(262441);
        if (h.b(h.this) != null) {
          h.b(h.this).closeUVLoop();
        }
        AppMethodBeat.o(262441);
      }
      
      public final void wakeUpUVLoop()
      {
        AppMethodBeat.i(262440);
        if (h.b(h.this) != null) {
          h.b(h.this).wakeUpUVLoop();
        }
        AppMethodBeat.o(262440);
      }
    }, abT().fhV);
    i locali = this.fih;
    AppMethodBeat.o(144024);
    return locali;
  }
  
  final void abW()
  {
    AppMethodBeat.i(144025);
    Log.i("MicroMsg.NodeJSRuntime", "cleanUpRuntimeWhenThreadEnd");
    try
    {
      this.fif.release();
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
  
  public final m acd()
  {
    AppMethodBeat.i(262412);
    if (this.fig == null) {
      this.fig = new m(this, abX(), new m.a()
      {
        public final V8Context aca()
        {
          AppMethodBeat.i(262197);
          if (h.b(h.this) == null)
          {
            localObject = new IllegalStateException("getMainContext mNodeJS not ready!");
            AppMethodBeat.o(262197);
            throw ((Throwable)localObject);
          }
          Log.i("MicroMsg.NodeJSRuntime", "getMainContext %s", new Object[] { Integer.valueOf(h.b(h.this).getMainContext().hashCode()) });
          Object localObject = h.b(h.this).getMainContext();
          AppMethodBeat.o(262197);
          return localObject;
        }
      });
    }
    m localm = this.fig;
    AppMethodBeat.o(262412);
    return localm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.h
 * JD-Core Version:    0.7.0.1
 */