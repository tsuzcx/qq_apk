package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ah.a;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.protocal.c.anl;
import com.tencent.mm.protocal.c.anm;

class y
  extends a<anm>
{
  y(int paramInt1, int paramInt2, int paramInt3)
  {
    this(4, 0, paramInt1, paramInt2, paramInt3);
  }
  
  y(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    b.a locala = new b.a();
    anl localanl = new anl();
    localanl.aQw = paramInt1;
    localanl.tjD = paramInt2;
    localanl.condition = paramInt3;
    localanl.tjB = paramInt4;
    localanl.tjC = paramInt5;
    locala.ecH = localanl;
    locala.ecI = new anm();
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxausagerecord";
    locala.ecG = 1148;
    this.dmK = locala.Kt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.y
 * JD-Core Version:    0.7.0.1
 */