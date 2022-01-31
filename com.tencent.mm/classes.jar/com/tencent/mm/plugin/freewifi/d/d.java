package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.protocal.c.pa;
import com.tencent.mm.protocal.c.pb;

public final class d
  extends c
{
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong, String paramString6, String paramString7)
  {
    aUp();
    pa localpa = (pa)this.dmK.ecE.ecN;
    localpa.sMD = paramString1;
    localpa.sME = paramString2;
    localpa.sMF = paramString3;
    localpa.sMG = paramString4;
    localpa.sMH = paramString5;
    localpa.sMI = paramLong;
    localpa.sMJ = paramString6;
    localpa.sMK = paramString7;
  }
  
  protected final void aUp()
  {
    b.a locala = new b.a();
    locala.ecH = new pa();
    locala.ecI = new pb();
    locala.uri = "/cgi-bin/mmo2o-bin/checkifcallup";
    locala.ecG = 1155;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
  }
  
  public final pb aUx()
  {
    return (pb)this.dmK.ecF.ecN;
  }
  
  public final int getType()
  {
    return 1155;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.d
 * JD-Core Version:    0.7.0.1
 */