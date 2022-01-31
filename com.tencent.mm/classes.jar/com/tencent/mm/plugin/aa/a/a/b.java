package com.tencent.mm.plugin.aa.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.r;
import com.tencent.mm.protocal.protobuf.s;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
  extends a<s>
{
  public b(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(40640);
    b.a locala = new b.a();
    r localr = new r();
    localr.wjW = paramString1;
    localr.wjX = paramString2;
    localr.scene = paramInt;
    locala.fsX = localr;
    locala.fsY = new s();
    locala.uri = "/cgi-bin/mmpay-bin/newaapayurge";
    locala.funcId = 1644;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ab.i("MicroMsg.CgiAAPayUrge", "CgiAAPayUrge, billNo: %s, chatroom: %s, scene: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(40640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.a.b
 * JD-Core Version:    0.7.0.1
 */