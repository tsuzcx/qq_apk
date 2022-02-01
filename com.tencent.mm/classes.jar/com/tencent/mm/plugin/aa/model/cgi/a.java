package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.t;
import com.tencent.mm.protocal.protobuf.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.z;

public final class a
  extends z<u>
{
  public a(String paramString1, long paramLong, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(63370);
    t localt = new t();
    localt.YzL = paramString1;
    localt.YAe = paramLong;
    localt.scene = paramInt;
    localt.YzM = paramString2;
    localt.YAg = paramString3;
    localt.Oks = paramString4;
    paramString1 = new c.a();
    paramString1.otE = localt;
    paramString1.otF = new u();
    paramString1.funcId = 1344;
    paramString1.uri = "/cgi-bin/mmpay-bin/newaapaysucc";
    paramString1.otG = 0;
    paramString1.respCmdId = 0;
    c(paramString1.bEF());
    Log.i("MicroMsg.CgiAAPaySucc", "CgiAAPaySucc, bill_no: %s, pay_amount: %s, scene: %s, groupid: %s, out_trade_no: %s, trans_id: %s", new Object[] { localt.YzL, Long.valueOf(localt.YAe), Integer.valueOf(localt.scene), localt.YzM, localt.YAg, localt.Oks });
    AppMethodBeat.o(63370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.a
 * JD-Core Version:    0.7.0.1
 */