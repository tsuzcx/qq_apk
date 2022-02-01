package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.q;
import com.tencent.mm.protocal.protobuf.r;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends com.tencent.mm.ak.a<r>
{
  public a(String paramString1, long paramLong, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(63370);
    q localq = new q();
    localq.FIe = paramString1;
    localq.FIv = paramLong;
    localq.scene = paramInt;
    localq.FIf = paramString2;
    localq.FIw = paramString3;
    localq.yoZ = paramString4;
    paramString1 = new b.a();
    paramString1.hQF = localq;
    paramString1.hQG = new r();
    paramString1.funcId = 1344;
    paramString1.uri = "/cgi-bin/mmpay-bin/newaapaysucc";
    paramString1.hQH = 0;
    paramString1.respCmdId = 0;
    c(paramString1.aDS());
    ae.i("MicroMsg.CgiAAPaySucc", "CgiAAPaySucc, bill_no: %s, pay_amount: %s, scene: %s, groupid: %s, out_trade_no: %s, trans_id: %s", new Object[] { localq.FIe, Long.valueOf(localq.FIv), Integer.valueOf(localq.scene), localq.FIf, localq.FIw, localq.yoZ });
    AppMethodBeat.o(63370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.a
 * JD-Core Version:    0.7.0.1
 */