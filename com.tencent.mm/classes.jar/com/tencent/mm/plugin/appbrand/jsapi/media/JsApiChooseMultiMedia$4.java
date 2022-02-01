package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.support.v4.app.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import org.json.JSONObject;

final class JsApiChooseMultiMedia$4
  implements a.a
{
  JsApiChooseMultiMedia$4(JsApiChooseMultiMedia paramJsApiChooseMultiMedia, c paramc, JSONObject paramJSONObject, int paramInt) {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(46496);
    if (paramInt != 113)
    {
      AppMethodBeat.o(46496);
      return;
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
    {
      this.jXo.a(this.cgw, this.ccE, this.ccB);
      AppMethodBeat.o(46496);
      return;
    }
    this.cgw.h(this.ccB, this.jXo.e("fail:system permission denied", null));
    AppMethodBeat.o(46496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia.4
 * JD-Core Version:    0.7.0.1
 */