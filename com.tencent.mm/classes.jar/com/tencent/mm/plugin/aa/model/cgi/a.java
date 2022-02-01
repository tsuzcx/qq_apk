package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.s;
import com.tencent.mm.protocal.protobuf.t;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends c<t>
{
  public a(String paramString1, long paramLong, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(63370);
    s locals = new s();
    locals.KBs = paramString1;
    locals.KBK = paramLong;
    locals.scene = paramInt;
    locals.KBt = paramString2;
    locals.KBM = paramString3;
    locals.CpP = paramString4;
    paramString1 = new d.a();
    paramString1.iLN = locals;
    paramString1.iLO = new t();
    paramString1.funcId = 1344;
    paramString1.uri = "/cgi-bin/mmpay-bin/newaapaysucc";
    paramString1.iLP = 0;
    paramString1.respCmdId = 0;
    c(paramString1.aXF());
    Log.i("MicroMsg.CgiAAPaySucc", "CgiAAPaySucc, bill_no: %s, pay_amount: %s, scene: %s, groupid: %s, out_trade_no: %s, trans_id: %s", new Object[] { locals.KBs, Long.valueOf(locals.KBK), Integer.valueOf(locals.scene), locals.KBt, locals.KBM, locals.CpP });
    AppMethodBeat.o(63370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.a
 * JD-Core Version:    0.7.0.1
 */