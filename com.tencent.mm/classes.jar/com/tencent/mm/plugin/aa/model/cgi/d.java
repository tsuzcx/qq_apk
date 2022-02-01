package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.b;
import com.tencent.mm.protocal.protobuf.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
  extends a<c>
{
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63374);
    b.a locala = new b.a();
    b localb = new b();
    localb.FpG = paramString1;
    localb.FpH = paramString2;
    locala.hNM = localb;
    locala.hNN = new c();
    locala.uri = "/cgi-bin/mmpay-bin/newaaclosenotify";
    locala.funcId = 1672;
    locala.hNO = 0;
    locala.respCmdId = 0;
    c(locala.aDC());
    ad.i("MicroMsg.CgiCloseAAUrgeNotify", "CgiCloseAAUrgeNotify, billNo: %s, chatroom: %s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(63374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.d
 * JD-Core Version:    0.7.0.1
 */