package com.tencent.mm.plugin.appbrand.jsapi.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.sdk.platformtools.ae;

final class a$1
  extends h.c
{
  a$1(a parama) {}
  
  public final void a(h.d paramd)
  {
    AppMethodBeat.i(220551);
    super.a(paramd);
    ae.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onPause, type: ".concat(String.valueOf(paramd)));
    this.lBt.c(paramd);
    AppMethodBeat.o(220551);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(220549);
    super.onCreate();
    ae.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onCreate");
    a.a(this.lBt);
    AppMethodBeat.o(220549);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(220552);
    super.onDestroy();
    ae.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onDestroy");
    this.lBt.bqp();
    AppMethodBeat.o(220552);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(220550);
    super.onResume();
    ae.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onResume");
    a.b(this.lBt);
    AppMethodBeat.o(220550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.a.1
 * JD-Core Version:    0.7.0.1
 */