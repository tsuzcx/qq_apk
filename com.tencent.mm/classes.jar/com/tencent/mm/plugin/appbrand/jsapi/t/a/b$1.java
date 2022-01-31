package com.tencent.mm.plugin.appbrand.jsapi.t.a;

import com.tencent.luggage.g.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

final class b$1
  implements e.d
{
  b$1(b paramb, c paramc, JSONObject paramJSONObject, int paramInt) {}
  
  public final void n(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(145926);
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
    {
      ab.i("MicroMsg.BaseRecordJsApi", "PERMISSION_GRANTED, do invoke again");
      this.ifq.a(this.hKB, this.bBa, this.bAX);
      AppMethodBeat.o(145926);
      return;
    }
    ab.e("MicroMsg.BaseRecordJsApi", "operateRecorder, SYS_PERM_DENIED");
    this.hKB.h(this.bAX, this.ifq.j("fail:system permission denied", null));
    AppMethodBeat.o(145926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.a.b.1
 * JD-Core Version:    0.7.0.1
 */