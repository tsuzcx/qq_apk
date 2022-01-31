package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.support.v4.app.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.o;
import org.json.JSONObject;

final class JsApiStartRecordVoice$4
  implements a.a
{
  JsApiStartRecordVoice$4(JsApiStartRecordVoice paramJsApiStartRecordVoice, o paramo, JSONObject paramJSONObject, int paramInt) {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramInt != 116) {
      return;
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
    {
      this.gjv.a(this.gcp, this.gbZ, this.dIS);
      return;
    }
    this.gcp.C(this.dIS, this.gjv.h("fail:system permission denied", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice.4
 * JD-Core Version:    0.7.0.1
 */