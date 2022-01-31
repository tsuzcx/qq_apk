package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.support.v4.app.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import org.json.JSONObject;

final class b$2
  implements a.a
{
  b$2(b paramb, c paramc, JSONObject paramJSONObject, int paramInt) {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramInt != 48) {
      return;
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
    {
      this.gpI.a(this.ggH, this.gbZ, this.dIS);
      return;
    }
    this.ggH.C(this.dIS, this.gpI.h("permission_denied", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.b.2
 * JD-Core Version:    0.7.0.1
 */