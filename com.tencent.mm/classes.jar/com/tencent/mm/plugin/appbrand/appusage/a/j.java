package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.cvh;
import com.tencent.mm.protocal.protobuf.cvi;
import com.tencent.mm.protocal.protobuf.za;
import com.tencent.mm.protocal.protobuf.ze;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public class j
  extends a<cvi>
{
  public j(long paramLong, LinkedList<aht> paramLinkedList, LinkedList<za> paramLinkedList1, int paramInt1, int paramInt2, int paramInt3, ze paramze)
  {
    AppMethodBeat.i(44689);
    ae.i("MicroMsg.Recommend.CgiReportRecommendWxa", "sessionId:%d, action_scene:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1) });
    b.a locala = new b.a();
    cvh localcvh = new cvh();
    localcvh.cbe = paramLong;
    localcvh.HFJ = paramLinkedList;
    localcvh.HFM = paramLinkedList1;
    localcvh.HFK = paramInt1;
    localcvh.HFL = paramInt2;
    localcvh.HFN = paramInt3;
    localcvh.GWq = paramze;
    locala.hQF = localcvh;
    locala.hQG = new cvi();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/reportrecommendwxa";
    locala.funcId = 2564;
    c(locala.aDS());
    AppMethodBeat.o(44689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.j
 * JD-Core Version:    0.7.0.1
 */