package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.ahj;
import com.tencent.mm.protocal.protobuf.cun;
import com.tencent.mm.protocal.protobuf.cuo;
import com.tencent.mm.protocal.protobuf.yx;
import com.tencent.mm.protocal.protobuf.zb;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public class j
  extends a<cuo>
{
  public j(long paramLong, LinkedList<ahj> paramLinkedList, LinkedList<yx> paramLinkedList1, int paramInt1, int paramInt2, int paramInt3, zb paramzb)
  {
    AppMethodBeat.i(44689);
    ad.i("MicroMsg.Recommend.CgiReportRecommendWxa", "sessionId:%d, action_scene:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1) });
    b.a locala = new b.a();
    cun localcun = new cun();
    localcun.cbe = paramLong;
    localcun.Hmj = paramLinkedList;
    localcun.Hmm = paramLinkedList1;
    localcun.Hmk = paramInt1;
    localcun.Hml = paramInt2;
    localcun.Hmn = paramInt3;
    localcun.GCQ = paramzb;
    locala.hNM = localcun;
    locala.hNN = new cuo();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/reportrecommendwxa";
    locala.funcId = 2564;
    c(locala.aDC());
    AppMethodBeat.o(44689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.j
 * JD-Core Version:    0.7.0.1
 */