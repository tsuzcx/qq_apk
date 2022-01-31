package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.c.agr;
import com.tencent.mm.protocal.c.ags;

public final class g
  extends c
{
  public g(String paramString1, String paramString2, String paramString3)
  {
    aUp();
    agr localagr = (agr)this.dmK.ecE.ecN;
    localagr.koB = paramString1;
    localagr.koC = paramString2;
    localagr.koD = paramString3;
    localagr.ssK = m.aTF();
  }
  
  protected final void aUp()
  {
    b.a locala = new b.a();
    locala.ecH = new agr();
    locala.ecI = new ags();
    locala.uri = "/cgi-bin/mmo2o-bin/getprotocol31schemaurl";
    locala.ecG = 1746;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
  }
  
  public final String aUz()
  {
    return ((ags)this.dmK.ecF.ecN).tem;
  }
  
  public final int getType()
  {
    return 1746;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.g
 * JD-Core Version:    0.7.0.1
 */