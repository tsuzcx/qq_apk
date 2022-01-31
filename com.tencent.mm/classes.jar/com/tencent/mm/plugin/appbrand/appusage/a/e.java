package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.mm.ah.a;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.protocal.c.ajs;
import com.tencent.mm.protocal.c.ajt;
import com.tencent.mm.protocal.c.mk;
import com.tencent.mm.protocal.c.qn;
import com.tencent.mm.sdk.platformtools.y;

public class e
  extends a<ajt>
{
  public e(int paramInt1, int paramInt2, mk parammk, long paramLong, qn paramqn)
  {
    y.i("MicroMsg.CgiGetRecommendWxa", "pageNum:%d, filterType:%d, sessionId:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
    b.a locala = new b.a();
    ajs localajs = new ajs();
    localajs.tgz = paramInt1;
    localajs.bgZ = paramInt2;
    localajs.tgA = parammk;
    localajs.bah = paramLong;
    localajs.tgB = paramqn;
    locala.ecH = localajs;
    locala.ecI = new ajt();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getrecommendwxa";
    locala.ecG = 2778;
    this.dmK = locala.Kt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.e
 * JD-Core Version:    0.7.0.1
 */