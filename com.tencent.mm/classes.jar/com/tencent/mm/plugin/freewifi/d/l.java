package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.protocal.c.bqq;
import com.tencent.mm.protocal.c.bqr;

public final class l
  extends c
{
  public l(String paramString1, int paramInt, String paramString2)
  {
    aUp();
    bqq localbqq = (bqq)this.dmK.ecE.ecN;
    localbqq.appId = paramString1;
    localbqq.ksD = paramInt;
    localbqq.bJY = paramString2;
  }
  
  protected final void aUp()
  {
    b.a locala = new b.a();
    locala.ecH = new bqq();
    locala.ecI = new bqr();
    locala.uri = "/cgi-bin/mmo2o-bin/setpcloginuserInfo";
    locala.ecG = 1761;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
  }
  
  public final int getType()
  {
    return 1761;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.l
 * JD-Core Version:    0.7.0.1
 */