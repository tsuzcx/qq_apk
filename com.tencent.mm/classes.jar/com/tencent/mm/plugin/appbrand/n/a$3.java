package com.tencent.mm.plugin.appbrand.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.n.b.b.a;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

final class a$3
  implements b.a
{
  public final void a(i parami, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(132324);
    try
    {
      paramJSONObject.put("notSupport", a.aIy().contains(ag.cE(parami.mAppId)));
      paramJSONObject.put("switchWebsocket", ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVA, 0));
      paramJSONObject.put("switchFs", ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVB, 0));
      AppMethodBeat.o(132324);
      return;
    }
    catch (JSONException parami)
    {
      AppMethodBeat.o(132324);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.a.3
 * JD-Core Version:    0.7.0.1
 */