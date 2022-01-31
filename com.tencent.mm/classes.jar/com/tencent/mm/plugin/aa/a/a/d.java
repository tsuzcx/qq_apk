package com.tencent.mm.plugin.aa.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.b;
import com.tencent.mm.protocal.protobuf.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
  extends a<c>
{
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(40643);
    b.a locala = new b.a();
    b localb = new b();
    localb.wjW = paramString1;
    localb.wjX = paramString2;
    locala.fsX = localb;
    locala.fsY = new c();
    locala.uri = "/cgi-bin/mmpay-bin/newaaclosenotify";
    locala.funcId = 1672;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ab.i("MicroMsg.CgiCloseAAUrgeNotify", "CgiCloseAAUrgeNotify, billNo: %s, chatroom: %s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(40643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.a.d
 * JD-Core Version:    0.7.0.1
 */