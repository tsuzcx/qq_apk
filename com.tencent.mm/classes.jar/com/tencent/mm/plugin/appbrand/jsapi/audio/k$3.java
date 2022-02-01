package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.support.v4.app.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

final class k$3
  implements a.a
{
  k$3(k paramk, r paramr, JSONObject paramJSONObject, int paramInt) {}
  
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
      ae.i("MicroMsg.Record.JsApiOperateRecorder", "PERMISSION_GRANTED, do invoke again");
      this.kAd.a(this.cjR, this.cjV, this.cjS);
      AppMethodBeat.o(45934);
      return;
    }
    ae.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, SYS_PERM_DENIED");
    this.cjR.h(this.cjS, this.kAd.e("fail:system permission denied", null));
    AppMethodBeat.o(45934);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.k.3
 * JD-Core Version:    0.7.0.1
 */