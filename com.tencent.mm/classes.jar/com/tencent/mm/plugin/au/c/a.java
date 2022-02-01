package com.tencent.mm.plugin.au.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.a.ag;
import com.tencent.mm.protocal.protobuf.a.x;
import com.tencent.mm.protocal.protobuf.a.y;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vibrate/model/GetProcessRingBackVibrateCgi;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/ringtone/ProcessRingBackResponse;", "ringBackInfo", "Lcom/tencent/mm/protocal/protobuf/ringtone/SimpleRingBack;", "(Lcom/tencent/mm/protocal/protobuf/ringtone/SimpleRingBack;)V", "plugin-vibrate_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends b<y>
{
  public a(ag paramag)
  {
    AppMethodBeat.i(260693);
    x localx = new x();
    localx.acjq = 1;
    localx.acjp = paramag;
    paramag = new c.a();
    paramag.otE = ((com.tencent.mm.bx.a)localx);
    paramag.otF = ((com.tencent.mm.bx.a)new y());
    paramag.otG = 0;
    paramag.respCmdId = 0;
    paramag.uri = "/cgi-bin/micromsg-bin/processringback";
    paramag.funcId = 6918;
    c(paramag.bEF());
    AppMethodBeat.o(260693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.au.c.a
 * JD-Core Version:    0.7.0.1
 */