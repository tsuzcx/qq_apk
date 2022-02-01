package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.b;
import com.tencent.mm.protocal.protobuf.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.z;

public final class d
  extends z<c>
{
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63374);
    c.a locala = new c.a();
    b localb = new b();
    localb.YzL = paramString1;
    localb.YzM = paramString2;
    locala.otE = localb;
    locala.otF = new c();
    locala.uri = "/cgi-bin/mmpay-bin/newaaclosenotify";
    locala.funcId = 1672;
    locala.otG = 0;
    locala.respCmdId = 0;
    c(locala.bEF());
    Log.i("MicroMsg.CgiCloseAAUrgeNotify", "CgiCloseAAUrgeNotify, billNo: %s, chatroom: %s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(63374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.d
 * JD-Core Version:    0.7.0.1
 */