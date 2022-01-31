package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.protocal.c.p;
import com.tencent.mm.protocal.c.q;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends com.tencent.mm.ah.a<q>
{
  public a(String paramString1, long paramLong, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    p localp = new p();
    localp.srq = paramString1;
    localp.srJ = paramLong;
    localp.scene = paramInt;
    localp.srr = paramString2;
    localp.srL = paramString3;
    localp.nzq = paramString4;
    paramString1 = new b.a();
    paramString1.ecH = localp;
    paramString1.ecI = new q();
    paramString1.ecG = 1344;
    paramString1.uri = "/cgi-bin/mmpay-bin/newaapaysucc";
    paramString1.ecJ = 0;
    paramString1.ecK = 0;
    this.dmK = paramString1.Kt();
    y.i("MicroMsg.CgiAAPaySucc", "CgiAAPaySucc, bill_no: %s, pay_amount: %s, scene: %s, groupid: %s, out_trade_no: %s, trans_id: %s", new Object[] { localp.srq, Long.valueOf(localp.srJ), Integer.valueOf(localp.scene), localp.srr, localp.srL, localp.nzq });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.a.a
 * JD-Core Version:    0.7.0.1
 */