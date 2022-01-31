package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.support.v4.app.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import org.json.JSONObject;

final class d$1
  implements a.a
{
  d$1(d paramd, c paramc, JSONObject paramJSONObject, int paramInt) {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramInt != 48) {
      return;
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
    {
      this.gqc.a(this.ggH, this.gbZ, this.dIS);
      return;
    }
    this.ggH.C(this.dIS, this.gqc.h("fail:system permission denied", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.d.1
 * JD-Core Version:    0.7.0.1
 */