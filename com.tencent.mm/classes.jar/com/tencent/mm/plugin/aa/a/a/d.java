package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ah.a;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.protocal.c.b;
import com.tencent.mm.protocal.c.c;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  extends a<c>
{
  public d(String paramString1, String paramString2)
  {
    b.a locala = new b.a();
    b localb = new b();
    localb.srq = paramString1;
    localb.srr = paramString2;
    locala.ecH = localb;
    locala.ecI = new c();
    locala.uri = "/cgi-bin/mmpay-bin/newaaclosenotify";
    locala.ecG = 1672;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    y.i("MicroMsg.CgiCloseAAUrgeNotify", "CgiCloseAAUrgeNotify, billNo: %s, chatroom: %s", new Object[] { paramString1, paramString2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.a.d
 * JD-Core Version:    0.7.0.1
 */