package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.support.v4.app.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import org.json.JSONObject;

final class JsApiChooseVideo$3
  implements a.a
{
  JsApiChooseVideo$3(JsApiChooseVideo paramJsApiChooseVideo, c paramc, JSONObject paramJSONObject, int paramInt) {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(131271);
    if (paramInt != 115)
    {
      AppMethodBeat.o(131271);
      return;
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
    {
      this.hRF.a(this.hxW, this.bBa, this.bAX);
      AppMethodBeat.o(131271);
      return;
    }
    this.hxW.h(this.bAX, this.hRF.j("fail:system permission denied", null));
    AppMethodBeat.o(131271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.3
 * JD-Core Version:    0.7.0.1
 */