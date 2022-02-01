package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.s;
import com.tencent.mm.protocal.protobuf.t;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends a<t>
{
  public b(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(63371);
    b.a locala = new b.a();
    s locals = new s();
    locals.FpG = paramString1;
    locals.FpH = paramString2;
    locals.scene = paramInt;
    locala.hNM = locals;
    locala.hNN = new t();
    locala.uri = "/cgi-bin/mmpay-bin/newaapayurge";
    locala.funcId = 1644;
    locala.hNO = 0;
    locala.respCmdId = 0;
    c(locala.aDC());
    ad.i("MicroMsg.CgiAAPayUrge", "CgiAAPayUrge, billNo: %s, chatroom: %s, scene: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(63371);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.b
 * JD-Core Version:    0.7.0.1
 */