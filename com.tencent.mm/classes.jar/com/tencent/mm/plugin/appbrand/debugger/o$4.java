package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.m;
import com.tencent.mm.g.a.m.a;
import com.tencent.mm.protocal.protobuf.dzq;
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
    if ((paramm == null) || (paramm.djZ == null) || (paramm.djZ.dkc == null))
    {
      AppMethodBeat.o(147023);
      return true;
    }
    dzq localdzq = new dzq();
    localdzq.dka = paramm.djZ.dka;
    localdzq.dkb = paramm.djZ.dkb;
    localdzq.HML = paramm.djZ.dkc.toString();
    localdzq.timestamp = System.currentTimeMillis();
    paramm = v.a(localdzq, this.kbz.coY, "networkDebugAPI");
    this.kbz.a(paramm);
    AppMethodBeat.o(147023);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.o.4
 * JD-Core Version:    0.7.0.1
 */