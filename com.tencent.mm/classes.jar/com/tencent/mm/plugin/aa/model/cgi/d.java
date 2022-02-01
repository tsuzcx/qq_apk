package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends com.tencent.mm.ak.c<com.tencent.mm.protocal.protobuf.c>
{
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63374);
    d.a locala = new d.a();
    b localb = new b();
    localb.KBs = paramString1;
    localb.KBt = paramString2;
    locala.iLN = localb;
    locala.iLO = new com.tencent.mm.protocal.protobuf.c();
    locala.uri = "/cgi-bin/mmpay-bin/newaaclosenotify";
    locala.funcId = 1672;
    locala.iLP = 0;
    locala.respCmdId = 0;
    c(locala.aXF());
    Log.i("MicroMsg.CgiCloseAAUrgeNotify", "CgiCloseAAUrgeNotify, billNo: %s, chatroom: %s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(63374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.d
 * JD-Core Version:    0.7.0.1
 */