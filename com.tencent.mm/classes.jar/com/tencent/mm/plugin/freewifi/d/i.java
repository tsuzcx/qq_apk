package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.protocal.c.aiy;
import com.tencent.mm.protocal.c.aiz;

public final class i
  extends c
{
  public i(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    aUp();
    aiy localaiy = (aiy)this.dmK.ecE.ecN;
    localaiy.bHI = paramString1;
    localaiy.koB = paramString2;
    localaiy.koC = paramString3;
    localaiy.koD = paramString4;
    localaiy.bJY = paramString5;
    localaiy.sst = paramString6;
  }
  
  public final String aUA()
  {
    return ((aiz)this.dmK.ecF.ecN).kpJ;
  }
  
  public final String aUB()
  {
    return ((aiz)this.dmK.ecF.ecN).kpK;
  }
  
  protected final void aUp()
  {
    b.a locala = new b.a();
    locala.ecH = new aiy();
    locala.ecI = new aiz();
    locala.uri = "/cgi-bin/mmo2o-bin/getportalapinfo";
    locala.ecG = 1709;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
  }
  
  public final int getType()
  {
    return 1709;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.i
 * JD-Core Version:    0.7.0.1
 */