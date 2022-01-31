package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.mm.ah.a;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.protocal.c.bld;
import com.tencent.mm.protocal.c.ble;
import com.tencent.mm.protocal.c.qm;
import com.tencent.mm.protocal.c.qn;
import com.tencent.mm.protocal.c.wh;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public class f
  extends a<ble>
{
  public f(long paramLong, LinkedList<wh> paramLinkedList, qm paramqm, int paramInt1, int paramInt2, qn paramqn)
  {
    y.i("MicroMsg.CgiReportRecommendWxa", "sessionId:%d, action_scene:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1) });
    b.a locala = new b.a();
    bld localbld = new bld();
    localbld.bah = paramLong;
    localbld.tEF = paramLinkedList;
    localbld.tEG = paramqm;
    localbld.tEH = paramInt1;
    localbld.tEI = paramInt2;
    localbld.tgB = paramqn;
    locala.ecH = localbld;
    locala.ecI = new ble();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/reportrecommendwxa";
    locala.ecG = 2564;
    this.dmK = locala.Kt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.f
 * JD-Core Version:    0.7.0.1
 */