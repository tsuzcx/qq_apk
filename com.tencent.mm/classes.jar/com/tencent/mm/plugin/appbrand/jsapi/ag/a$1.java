package com.tencent.mm.plugin.appbrand.jsapi.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.sdk.platformtools.Log;

final class a$1
  extends h.c
{
  a$1(a parama) {}
  
  public final void a(h.d paramd)
  {
    AppMethodBeat.i(215765);
    super.a(paramd);
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onPause, type: ".concat(String.valueOf(paramd)));
    this.mIR.c(paramd);
    AppMethodBeat.o(215765);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(215763);
    super.onCreate();
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onCreate");
    a.a(this.mIR);
    AppMethodBeat.o(215763);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(215766);
    super.onDestroy();
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onDestroy");
    this.mIR.bLX();
    AppMethodBeat.o(215766);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(215764);
    super.onResume();
    Log.i("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onResume");
    a.b(this.mIR);
    AppMethodBeat.o(215764);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.a.1
 * JD-Core Version:    0.7.0.1
 */