package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ah.a;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.protocal.c.w;
import com.tencent.mm.protocal.c.x;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  extends a<x>
{
  public c(int paramInt1, int paramInt2, int paramInt3)
  {
    b.a locala = new b.a();
    w localw = new w();
    localw.limit = paramInt1;
    localw.offset = paramInt2;
    localw.type = paramInt3;
    locala.ecH = localw;
    locala.ecI = new x();
    locala.uri = "/cgi-bin/mmpay-bin/newaaquerylist";
    locala.ecG = 1676;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    y.i("MicroMsg.CgiAAQueryList", "CgiAAQueryList, limit: %s, offset: %s, type: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
  }
  
  public c(int paramInt1, int paramInt2, int paramInt3, String paramString1, int paramInt4, int paramInt5, String paramString2)
  {
    b.a locala = new b.a();
    w localw = new w();
    localw.limit = paramInt1;
    localw.offset = paramInt2;
    localw.type = paramInt3;
    localw.sse = paramString1;
    localw.ssf = paramInt4;
    localw.ssg = paramInt5;
    localw.ssh = paramString2;
    locala.ecH = localw;
    locala.ecI = new x();
    locala.uri = "/cgi-bin/mmpay-bin/newaaquerylist";
    locala.ecG = 1676;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    y.i("MicroMsg.CgiAAQueryList", "CgiAAQueryList, limit: %s, offset: %s, type: %s, bill_id: %s, trans_id: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString1, paramString2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.a.c
 * JD-Core Version:    0.7.0.1
 */