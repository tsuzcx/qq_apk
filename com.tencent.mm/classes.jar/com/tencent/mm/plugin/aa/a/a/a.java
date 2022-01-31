package com.tencent.mm.plugin.aa.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.p;
import com.tencent.mm.protocal.protobuf.q;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  extends com.tencent.mm.ai.a<q>
{
  public a(String paramString1, long paramLong, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(40639);
    p localp = new p();
    localp.wjW = paramString1;
    localp.wkp = paramLong;
    localp.scene = paramInt;
    localp.wjX = paramString2;
    localp.wkr = paramString3;
    localp.qkt = paramString4;
    paramString1 = new b.a();
    paramString1.fsX = localp;
    paramString1.fsY = new q();
    paramString1.funcId = 1344;
    paramString1.uri = "/cgi-bin/mmpay-bin/newaapaysucc";
    paramString1.reqCmdId = 0;
    paramString1.respCmdId = 0;
    this.rr = paramString1.ado();
    ab.i("MicroMsg.CgiAAPaySucc", "CgiAAPaySucc, bill_no: %s, pay_amount: %s, scene: %s, groupid: %s, out_trade_no: %s, trans_id: %s", new Object[] { localp.wjW, Long.valueOf(localp.wkp), Integer.valueOf(localp.scene), localp.wjX, localp.wkr, localp.qkt });
    AppMethodBeat.o(40639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.a.a
 * JD-Core Version:    0.7.0.1
 */