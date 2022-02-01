package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.q;
import com.tencent.mm.protocal.protobuf.r;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  extends c<r>
{
  public a(String paramString1, long paramLong, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(63370);
    q localq = new q();
    localq.DKA = paramString1;
    localq.DKR = paramLong;
    localq.scene = paramInt;
    localq.DKB = paramString2;
    localq.DKS = paramString3;
    localq.wLA = paramString4;
    paramString1 = new b.a();
    paramString1.hvt = localq;
    paramString1.hvu = new r();
    paramString1.funcId = 1344;
    paramString1.uri = "/cgi-bin/mmpay-bin/newaapaysucc";
    paramString1.reqCmdId = 0;
    paramString1.respCmdId = 0;
    this.rr = paramString1.aAz();
    ac.i("MicroMsg.CgiAAPaySucc", "CgiAAPaySucc, bill_no: %s, pay_amount: %s, scene: %s, groupid: %s, out_trade_no: %s, trans_id: %s", new Object[] { localq.DKA, Long.valueOf(localq.DKR), Integer.valueOf(localq.scene), localq.DKB, localq.DKS, localq.wLA });
    AppMethodBeat.o(63370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.a
 * JD-Core Version:    0.7.0.1
 */