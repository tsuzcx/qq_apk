package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.protocal.protobuf.t;
import com.tencent.mm.protocal.protobuf.u;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends c<u>
{
  public a(String paramString1, long paramLong, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(63370);
    t localt = new t();
    localt.RDi = paramString1;
    localt.RDB = paramLong;
    localt.scene = paramInt;
    localt.RDj = paramString2;
    localt.RDD = paramString3;
    localt.Ine = paramString4;
    paramString1 = new d.a();
    paramString1.lBU = localt;
    paramString1.lBV = new u();
    paramString1.funcId = 1344;
    paramString1.uri = "/cgi-bin/mmpay-bin/newaapaysucc";
    paramString1.lBW = 0;
    paramString1.respCmdId = 0;
    c(paramString1.bgN());
    Log.i("MicroMsg.CgiAAPaySucc", "CgiAAPaySucc, bill_no: %s, pay_amount: %s, scene: %s, groupid: %s, out_trade_no: %s, trans_id: %s", new Object[] { localt.RDi, Long.valueOf(localt.RDB), Integer.valueOf(localt.scene), localt.RDj, localt.RDD, localt.Ine });
    AppMethodBeat.o(63370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.a
 * JD-Core Version:    0.7.0.1
 */