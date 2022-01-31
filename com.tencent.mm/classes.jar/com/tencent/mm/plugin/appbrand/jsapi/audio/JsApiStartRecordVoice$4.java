package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.support.v4.app.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;
import org.json.JSONObject;

final class JsApiStartRecordVoice$4
  implements a.a
{
  JsApiStartRecordVoice$4(JsApiStartRecordVoice paramJsApiStartRecordVoice, r paramr, JSONObject paramJSONObject, int paramInt) {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(130787);
    if (paramInt != 116)
    {
      AppMethodBeat.o(130787);
      return;
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
    {
      this.hCO.a(this.bAW, this.bBa, this.bAX);
      AppMethodBeat.o(130787);
      return;
    }
    this.bAW.h(this.bAX, this.hCO.j("fail:system permission denied", null));
    AppMethodBeat.o(130787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice.4
 * JD-Core Version:    0.7.0.1
 */