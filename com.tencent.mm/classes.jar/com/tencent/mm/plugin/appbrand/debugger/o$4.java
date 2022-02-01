package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.n;
import com.tencent.mm.g.a.n.a;
import com.tencent.mm.protocal.protobuf.evo;
import com.tencent.mm.sdk.event.IListener;
import org.json.JSONObject;

final class o$4
  extends IListener<n>
{
  o$4(o paramo)
  {
    AppMethodBeat.i(160993);
    this.__eventId = n.class.getName().hashCode();
    AppMethodBeat.o(160993);
  }
  
  private boolean a(n paramn)
  {
    AppMethodBeat.i(147023);
    if ((paramn == null) || (paramn.dCn == null) || (paramn.dCn.dCq == null))
    {
      AppMethodBeat.o(147023);
      return true;
    }
    evo localevo = new evo();
    localevo.dCo = paramn.dCn.dCo;
    localevo.dCp = paramn.dCn.dCp;
    localevo.Ntq = paramn.dCn.dCq.toString();
    localevo.timestamp = System.currentTimeMillis();
    paramn = v.a(localevo, o.d(this.liz), "networkDebugAPI");
    this.liz.a(paramn);
    AppMethodBeat.o(147023);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.o.4
 * JD-Core Version:    0.7.0.1
 */