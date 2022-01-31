package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.support.v4.app.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import org.json.JSONObject;

final class g$1
  implements a.a
{
  g$1(g paramg, c paramc, JSONObject paramJSONObject, int paramInt) {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(126272);
    if (paramInt != 48)
    {
      AppMethodBeat.o(126272);
      return;
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
    {
      this.hKU.a(this.hxW, this.bBa, this.bAX);
      AppMethodBeat.o(126272);
      return;
    }
    this.hxW.h(this.bAX, this.hKU.j("fail:system permission denied", null));
    AppMethodBeat.o(126272);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.g.1
 * JD-Core Version:    0.7.0.1
 */