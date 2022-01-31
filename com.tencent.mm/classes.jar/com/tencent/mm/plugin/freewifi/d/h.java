package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.protocal.c.aiu;
import com.tencent.mm.protocal.c.aiv;
import com.tencent.mm.protocal.c.zo;

public final class h
  extends c
{
  public h(String paramString1, int paramInt, String paramString2)
  {
    aUp();
    aiu localaiu = (aiu)this.dmK.ecE.ecN;
    localaiu.appId = paramString1;
    localaiu.ksD = paramInt;
    localaiu.bJY = paramString2;
  }
  
  protected final void aUp()
  {
    b.a locala = new b.a();
    locala.ecH = new aiu();
    locala.ecI = new aiv();
    locala.uri = "/cgi-bin/mmo2o-bin/getpcfrontpage";
    locala.ecG = 1760;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
  }
  
  public final zo aUt()
  {
    aiv localaiv = (aiv)this.dmK.ecF.ecN;
    if (localaiv != null) {
      return localaiv.ssE;
    }
    return null;
  }
  
  public final int getType()
  {
    return 1760;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.h
 * JD-Core Version:    0.7.0.1
 */