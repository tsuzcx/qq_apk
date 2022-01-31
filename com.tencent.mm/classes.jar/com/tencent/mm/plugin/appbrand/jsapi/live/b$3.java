package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.app.Activity;
import android.support.v4.app.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import org.json.JSONObject;

final class b$3
  implements a.a
{
  b$3(b paramb, Activity paramActivity, c paramc, JSONObject paramJSONObject, int paramInt) {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(96089);
    ab.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback requestCode:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 117)
    {
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        al.p(new b.3.1(this), 50L);
        AppMethodBeat.o(96089);
        return;
      }
      ab.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback not grant");
      this.hza.h(this.bAX, this.hNJ.j("fail:system permission denied", null));
      AppMethodBeat.o(96089);
      return;
    }
    if (paramInt == 118)
    {
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        al.p(new b.3.2(this), 50L);
        AppMethodBeat.o(96089);
        return;
      }
      ab.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback not grant");
      this.hza.h(this.bAX, this.hNJ.j("fail:system permission denied", null));
    }
    AppMethodBeat.o(96089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.b.3
 * JD-Core Version:    0.7.0.1
 */