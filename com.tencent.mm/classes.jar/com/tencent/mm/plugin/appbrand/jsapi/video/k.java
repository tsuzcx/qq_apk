package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.j;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
  implements j
{
  public final int d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(234643);
    Log.d("WxPlayer/".concat(String.valueOf(paramString1)), paramString2);
    AppMethodBeat.o(234643);
    return 1;
  }
  
  public final int e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(234646);
    Log.e("WxPlayer/".concat(String.valueOf(paramString1)), paramString2);
    AppMethodBeat.o(234646);
    return 1;
  }
  
  public final int i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(234644);
    Log.i("WxPlayer/".concat(String.valueOf(paramString1)), paramString2);
    AppMethodBeat.o(234644);
    return 1;
  }
  
  public final int v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(234642);
    Log.v("WxPlayer/".concat(String.valueOf(paramString1)), paramString2);
    AppMethodBeat.o(234642);
    return 1;
  }
  
  public final int w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(234645);
    Log.w("WxPlayer/".concat(String.valueOf(paramString1)), paramString2);
    AppMethodBeat.o(234645);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.k
 * JD-Core Version:    0.7.0.1
 */