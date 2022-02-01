package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.MultiContextNodeJS;
import com.eclipsesource.v8.MultiContextV8;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8.JavaTaskScheduler;
import com.eclipsesource.v8.V8Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public final class h
  extends a
{
  private MultiContextNodeJS cMF;
  public volatile m cMG;
  private i cMH;
  
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
  
  final MultiContextV8 LD()
  {
    AppMethodBeat.i(144023);
    try
    {
      this.cMF = MultiContextNodeJS.createMultiContextNodeJS(1, this.cMh, this.cMi, this.cMj);
      this.cMF.getRuntime().getV8().setNativeJavaCallback(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(200808);
          h.a(h.this).LN();
          AppMethodBeat.o(200808);
        }
      });
      this.cMF.getRuntime().getV8().setJavaTaskScheduler(new V8.JavaTaskScheduler()
      {
        public final void Schedule(Runnable paramAnonymousRunnable)
        {
          AppMethodBeat.i(200809);
          h.a(h.this).u(paramAnonymousRunnable);
          AppMethodBeat.o(200809);
        }
      });
      this.cMi = null;
      MultiContextV8 localMultiContextV8 = this.cMF.getRuntime();
      AppMethodBeat.o(144023);
      return localMultiContextV8;
    }
    finally
    {
      AppMethodBeat.o(144023);
    }
  }
  
  final c LE()
  {
    AppMethodBeat.i(144024);
    this.cMH = i.a(new i.a()
    {
      public final boolean LL()
      {
        AppMethodBeat.i(200810);
        boolean bool = h.b(h.this).handleMessage();
        AppMethodBeat.o(200810);
        return bool;
      }
      
      public final void closeUVLoop()
      {
        AppMethodBeat.i(200812);
        if (h.b(h.this) != null) {
          h.b(h.this).closeUVLoop();
        }
        AppMethodBeat.o(200812);
      }
      
      public final void wakeUpUVLoop()
      {
        AppMethodBeat.i(200811);
        if (h.b(h.this) != null) {
          h.b(h.this).wakeUpUVLoop();
        }
        AppMethodBeat.o(200811);
      }
    }, this.cMo.cMy);
    i locali = this.cMH;
    AppMethodBeat.o(144024);
    return locali;
  }
  
  final void LF()
  {
    AppMethodBeat.i(144025);
    ac.i("MicroMsg.NodeJSRuntime", "cleanUpRuntimeWhenThreadEnd");
    try
    {
      this.cMF.release();
      ac.i("MicroMsg.NodeJSRuntime", "cleanUpRuntimeWhenThreadEnd done");
      AppMethodBeat.o(144025);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.NodeJSRuntime", "cleanUpWhenThreadEnd exp = %s", new Object[] { localException });
      AppMethodBeat.o(144025);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.h
 * JD-Core Version:    0.7.0.1
 */