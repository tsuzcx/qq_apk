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
  private MultiContextNodeJS cPk;
  public volatile m cPl;
  private i cPm;
  
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
  
  final MultiContextV8 LF()
  {
    AppMethodBeat.i(144023);
    try
    {
      this.cPk = MultiContextNodeJS.createMultiContextNodeJS(1, this.cOM, this.cON, this.cOO);
      this.cPk.getRuntime().getV8().setNativeJavaCallback(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(193482);
          h.a(h.this).LP();
          AppMethodBeat.o(193482);
        }
      });
      this.cPk.getRuntime().getV8().setJavaTaskScheduler(new V8.JavaTaskScheduler()
      {
        public final void Schedule(Runnable paramAnonymousRunnable)
        {
          AppMethodBeat.i(193483);
          h.a(h.this).t(paramAnonymousRunnable);
          AppMethodBeat.o(193483);
        }
      });
      this.cON = null;
      MultiContextV8 localMultiContextV8 = this.cPk.getRuntime();
      AppMethodBeat.o(144023);
      return localMultiContextV8;
    }
    finally
    {
      AppMethodBeat.o(144023);
    }
  }
  
  final c LG()
  {
    AppMethodBeat.i(144024);
    this.cPm = i.a(new i.a()
    {
      public final boolean LN()
      {
        AppMethodBeat.i(193484);
        boolean bool = h.b(h.this).handleMessage();
        AppMethodBeat.o(193484);
        return bool;
      }
      
      public final void closeUVLoop()
      {
        AppMethodBeat.i(193486);
        if (h.b(h.this) != null) {
          h.b(h.this).closeUVLoop();
        }
        AppMethodBeat.o(193486);
      }
      
      public final void wakeUpUVLoop()
      {
        AppMethodBeat.i(193485);
        if (h.b(h.this) != null) {
          h.b(h.this).wakeUpUVLoop();
        }
        AppMethodBeat.o(193485);
      }
    }, this.cOT.cPd);
    i locali = this.cPm;
    AppMethodBeat.o(144024);
    return locali;
  }
  
  final void LH()
  {
    AppMethodBeat.i(144025);
    ad.i("MicroMsg.NodeJSRuntime", "cleanUpRuntimeWhenThreadEnd");
    try
    {
      this.cPk.release();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.h
 * JD-Core Version:    0.7.0.1
 */