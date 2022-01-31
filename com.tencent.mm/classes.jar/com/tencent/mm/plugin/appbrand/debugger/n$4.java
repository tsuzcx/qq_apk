package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.m;
import com.tencent.mm.g.a.m.a;
import com.tencent.mm.protocal.protobuf.cue;
import com.tencent.mm.sdk.b.c;
import org.json.JSONObject;

final class n$4
  extends c<m>
{
  n$4(n paramn)
  {
    AppMethodBeat.i(101837);
    this.__eventId = m.class.getName().hashCode();
    AppMethodBeat.o(101837);
  }
  
  private boolean a(m paramm)
  {
    AppMethodBeat.i(101838);
    if ((paramm == null) || (paramm.cmz == null) || (paramm.cmz.cmC == null))
    {
      AppMethodBeat.o(101838);
      return true;
    }
    cue localcue = new cue();
    localcue.cmA = paramm.cmz.cmA;
    localcue.cmB = paramm.cmz.cmB;
    localcue.ycW = paramm.cmz.cmC.toString();
    localcue.timestamp = System.currentTimeMillis();
    paramm = t.a(localcue, this.hlT.bER, "networkDebugAPI");
    this.hlT.a(paramm);
    AppMethodBeat.o(101838);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.n.4
 * JD-Core Version:    0.7.0.1
 */