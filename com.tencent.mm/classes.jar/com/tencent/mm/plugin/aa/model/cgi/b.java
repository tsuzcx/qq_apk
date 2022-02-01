package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.s;
import com.tencent.mm.protocal.protobuf.t;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
  extends a<t>
{
  public b(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(63371);
    b.a locala = new b.a();
    s locals = new s();
    locals.FIe = paramString1;
    locals.FIf = paramString2;
    locals.scene = paramInt;
    locala.hQF = locals;
    locala.hQG = new t();
    locala.uri = "/cgi-bin/mmpay-bin/newaapayurge";
    locala.funcId = 1644;
    locala.hQH = 0;
    locala.respCmdId = 0;
    c(locala.aDS());
    ae.i("MicroMsg.CgiAAPayUrge", "CgiAAPayUrge, billNo: %s, chatroom: %s, scene: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(63371);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.b
 * JD-Core Version:    0.7.0.1
 */