package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.aeb;
import com.tencent.mm.protocal.protobuf.ckb;
import com.tencent.mm.protocal.protobuf.ckc;
import com.tencent.mm.protocal.protobuf.wn;
import com.tencent.mm.protocal.protobuf.wq;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public class j
  extends c<ckc>
{
  public j(long paramLong, LinkedList<aeb> paramLinkedList, LinkedList<wn> paramLinkedList1, int paramInt1, int paramInt2, int paramInt3, wq paramwq)
  {
    AppMethodBeat.i(44689);
    ad.i("MicroMsg.Recommend.CgiReportRecommendWxa", "sessionId:%d, action_scene:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1) });
    b.a locala = new b.a();
    ckb localckb = new ckb();
    localckb.bTj = paramLong;
    localckb.EeU = paramLinkedList;
    localckb.EeX = paramLinkedList1;
    localckb.EeV = paramInt1;
    localckb.EeW = paramInt2;
    localckb.EeY = paramInt3;
    localckb.Dya = paramwq;
    locala.gUU = localckb;
    locala.gUV = new ckc();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/reportrecommendwxa";
    locala.funcId = 2564;
    this.rr = locala.atI();
    AppMethodBeat.o(44689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.j
 * JD-Core Version:    0.7.0.1
 */