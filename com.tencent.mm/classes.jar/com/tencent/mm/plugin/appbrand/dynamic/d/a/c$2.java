package com.tencent.mm.plugin.appbrand.dynamic.d.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.dynamic.h.d;
import com.tencent.mm.z.b.b;
import com.tencent.mm.z.b.b.a;
import com.tencent.mm.z.c.a;
import org.json.JSONObject;

final class c$2
  implements Runnable
{
  c$2(c paramc, String paramString1, boolean paramBoolean, String paramString2, b.a parama, String paramString3, b paramb, a parama1) {}
  
  public final void run()
  {
    AppMethodBeat.i(10870);
    com.tencent.mm.plugin.appbrand.collector.c.l(this.hpi, "parse_json_start", this.hpj);
    JSONObject localJSONObject = this.hph.Bi(this.val$data);
    if (localJSONObject == null)
    {
      this.hoD.aj(this.hph.U(this.hpk, "fail:invalid data"));
      AppMethodBeat.o(10870);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("rawJsapiData", this.val$data);
    com.tencent.mm.plugin.appbrand.collector.c.l(this.hpi, "parse_json_end", this.hpj);
    d.a(this.hpi, this.val$data, localJSONObject);
    this.hpl.a(this.hpm, localJSONObject, localBundle, this.hoD);
    AppMethodBeat.o(10870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.a.c.2
 * JD-Core Version:    0.7.0.1
 */