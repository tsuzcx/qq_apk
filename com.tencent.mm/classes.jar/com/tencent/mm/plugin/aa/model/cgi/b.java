package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.s;
import com.tencent.mm.protocal.protobuf.t;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
  extends c<t>
{
  public b(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(63371);
    b.a locala = new b.a();
    s locals = new s();
    locals.DKA = paramString1;
    locals.DKB = paramString2;
    locals.scene = paramInt;
    locala.hvt = locals;
    locala.hvu = new t();
    locala.uri = "/cgi-bin/mmpay-bin/newaapayurge";
    locala.funcId = 1644;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ac.i("MicroMsg.CgiAAPayUrge", "CgiAAPayUrge, billNo: %s, chatroom: %s, scene: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(63371);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.b
 * JD-Core Version:    0.7.0.1
 */