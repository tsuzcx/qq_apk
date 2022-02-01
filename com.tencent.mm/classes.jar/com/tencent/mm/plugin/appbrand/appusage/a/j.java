package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.protocal.protobuf.aau;
import com.tencent.mm.protocal.protobuf.aaz;
import com.tencent.mm.protocal.protobuf.ali;
import com.tencent.mm.protocal.protobuf.dxs;
import com.tencent.mm.protocal.protobuf.dxt;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public class j
  extends c<dxt>
{
  public j(long paramLong, LinkedList<ali> paramLinkedList, LinkedList<aau> paramLinkedList1, int paramInt1, int paramInt2, int paramInt3, aaz paramaaz)
  {
    AppMethodBeat.i(44689);
    Log.i("MicroMsg.Recommend.CgiReportRecommendWxa", "sessionId:%d, action_scene:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1) });
    d.a locala = new d.a();
    dxs localdxs = new dxs();
    localdxs.Tkj = paramLong;
    localdxs.Uda = paramLinkedList;
    localdxs.Udd = paramLinkedList1;
    localdxs.Udb = paramInt1;
    localdxs.Udc = paramInt2;
    localdxs.SRZ = paramInt3;
    localdxs.Tkk = paramaaz;
    locala.lBU = localdxs;
    locala.lBV = new dxt();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/reportrecommendwxa";
    locala.funcId = 2564;
    c(locala.bgN());
    AppMethodBeat.o(44689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.j
 * JD-Core Version:    0.7.0.1
 */