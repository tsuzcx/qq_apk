package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.support.v4.app.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

final class JsApiChooseMedia$3
  implements a.a
{
  JsApiChooseMedia$3(JsApiChooseMedia paramJsApiChooseMedia, c paramc, JSONObject paramJSONObject, int paramInt) {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(131156);
    if (paramInt != 120)
    {
      ab.e("MicroMsg.JsApiChooseMedia", "requestAudioPermission requestCode is not for choose media");
      AppMethodBeat.o(131156);
      return;
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
    {
      ab.i("MicroMsg.JsApiChooseMedia", "requestAudioPermission permission is grant for choose media");
      this.hQU.a(this.hxW, this.bBa, this.bAX);
      AppMethodBeat.o(131156);
      return;
    }
    ab.e("MicroMsg.JsApiChooseMedia", "requestAudioPermission sys perm denied for choose media");
    this.hxW.h(this.bAX, this.hQU.j("fail:system permission denied", null));
    AppMethodBeat.o(131156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.3
 * JD-Core Version:    0.7.0.1
 */