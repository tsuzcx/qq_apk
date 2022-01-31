package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.b.a;
import com.tencent.mm.plugin.appbrand.t.b.a.a;
import com.tencent.mm.plugin.appbrand.t.b.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class JsApiChooseMultiMedia$1
  implements a.b
{
  JsApiChooseMultiMedia$1(JsApiChooseMultiMedia paramJsApiChooseMultiMedia, Context paramContext) {}
  
  public final void a(int paramInt, String paramString, a.a parama)
  {
    AppMethodBeat.i(131217);
    if (paramInt == 0)
    {
      paramInt = (int)(parama.latitude * 1000000.0D);
      int i = (int)(parama.longitude * 1000000.0D);
      paramString = new StringBuilder();
      paramString.append(paramInt);
      paramString.append(",");
      paramString.append(i);
      this.hRs.getSharedPreferences(ah.dsP() + "_locCache", 0).edit().putString("locStr", paramString.toString()).apply();
      ab.d("MicroMsg.JsApiChooseMultiMedia", "onLocationChange latitude %f, longitude: %f, locStr: %s.", new Object[] { Double.valueOf(parama.latitude), Double.valueOf(parama.longitude), paramString });
      ((a)e.q(a.class)).c("wgs84", this, null);
      AppMethodBeat.o(131217);
      return;
    }
    ab.e("MicroMsg.JsApiChooseMultiMedia", "onLocationChange error, errCode: %d.", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(131217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia.1
 * JD-Core Version:    0.7.0.1
 */