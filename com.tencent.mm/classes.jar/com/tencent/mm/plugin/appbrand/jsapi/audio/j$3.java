package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.support.v4.app.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

final class j$3
  implements a.a
{
  j$3(j paramj, q paramq, JSONObject paramJSONObject, int paramInt) {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(45934);
    if (paramInt != 116)
    {
      AppMethodBeat.o(45934);
      return;
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
    {
      ad.i("MicroMsg.Record.JsApiOperateRecorder", "PERMISSION_GRANTED, do invoke again");
      this.jBT.a(this.ccA, this.ccE, this.ccB);
      AppMethodBeat.o(45934);
      return;
    }
    ad.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, SYS_PERM_DENIED");
    this.ccA.h(this.ccB, this.jBT.e("fail:system permission denied", null));
    AppMethodBeat.o(45934);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.j.3
 * JD-Core Version:    0.7.0.1
 */