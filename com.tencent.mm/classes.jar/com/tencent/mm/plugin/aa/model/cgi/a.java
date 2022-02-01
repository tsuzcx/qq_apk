package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.q;
import com.tencent.mm.protocal.protobuf.r;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends com.tencent.mm.al.a<r>
{
  public a(String paramString1, long paramLong, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(63370);
    q localq = new q();
    localq.FpG = paramString1;
    localq.FpX = paramLong;
    localq.scene = paramInt;
    localq.FpH = paramString2;
    localq.FpY = paramString3;
    localq.xZh = paramString4;
    paramString1 = new b.a();
    paramString1.hNM = localq;
    paramString1.hNN = new r();
    paramString1.funcId = 1344;
    paramString1.uri = "/cgi-bin/mmpay-bin/newaapaysucc";
    paramString1.hNO = 0;
    paramString1.respCmdId = 0;
    c(paramString1.aDC());
    ad.i("MicroMsg.CgiAAPaySucc", "CgiAAPaySucc, bill_no: %s, pay_amount: %s, scene: %s, groupid: %s, out_trade_no: %s, trans_id: %s", new Object[] { localq.FpG, Long.valueOf(localq.FpX), Integer.valueOf(localq.scene), localq.FpH, localq.FpY, localq.xZh });
    AppMethodBeat.o(63370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.a
 * JD-Core Version:    0.7.0.1
 */