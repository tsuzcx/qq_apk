package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ah.a;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.protocal.c.r;
import com.tencent.mm.protocal.c.s;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends a<s>
{
  public b(String paramString1, String paramString2, int paramInt)
  {
    b.a locala = new b.a();
    r localr = new r();
    localr.srq = paramString1;
    localr.srr = paramString2;
    localr.scene = paramInt;
    locala.ecH = localr;
    locala.ecI = new s();
    locala.uri = "/cgi-bin/mmpay-bin/newaapayurge";
    locala.ecG = 1644;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    y.i("MicroMsg.CgiAAPayUrge", "CgiAAPayUrge, billNo: %s, chatroom: %s, scene: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.a.b
 * JD-Core Version:    0.7.0.1
 */