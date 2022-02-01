package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.m;
import com.tencent.mm.g.a.m.a;
import com.tencent.mm.protocal.protobuf.ebh;
import com.tencent.mm.sdk.b.c;
import org.json.JSONObject;

final class o$4
  extends c<m>
{
  o$4(o paramo)
  {
    AppMethodBeat.i(160993);
    this.__eventId = m.class.getName().hashCode();
    AppMethodBeat.o(160993);
  }
  
  private boolean a(m paramm)
  {
    AppMethodBeat.i(147023);
    if ((paramm == null) || (paramm.dlb == null) || (paramm.dlb.dle == null))
    {
      AppMethodBeat.o(147023);
      return true;
    }
    ebh localebh = new ebh();
    localebh.dlc = paramm.dlb.dlc;
    localebh.dld = paramm.dlb.dld;
    localebh.IgS = paramm.dlb.dle.toString();
    localebh.timestamp = System.currentTimeMillis();
    paramm = v.a(localebh, this.keQ.cpc, "networkDebugAPI");
    this.keQ.a(paramm);
    AppMethodBeat.o(147023);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.o.4
 * JD-Core Version:    0.7.0.1
 */