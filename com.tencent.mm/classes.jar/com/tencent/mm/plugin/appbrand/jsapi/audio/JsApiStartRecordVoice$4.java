package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.support.v4.app.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.q;
import org.json.JSONObject;

final class JsApiStartRecordVoice$4
  implements a.a
{
  JsApiStartRecordVoice$4(JsApiStartRecordVoice paramJsApiStartRecordVoice, q paramq, JSONObject paramJSONObject, int paramInt) {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(45976);
    if (paramInt != 116)
    {
      AppMethodBeat.o(45976);
      return;
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
    {
      this.jCs.a(this.ccA, this.ccE, this.ccB);
      AppMethodBeat.o(45976);
      return;
    }
    this.ccA.h(this.ccB, this.jCs.e("fail:system permission denied", null));
    AppMethodBeat.o(45976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice.4
 * JD-Core Version:    0.7.0.1
 */