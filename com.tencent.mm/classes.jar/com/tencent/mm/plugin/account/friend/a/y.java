package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.px;

public final class y
  extends m
  implements k
{
  public static int fgp = 1;
  public static int fgq = 2;
  public static int fgr = 3;
  public static int fgs = 4;
  private b dmK;
  private f dmL;
  
  public y(int paramInt)
  {
    b.a locala = new b.a();
    locala.ecH = new pw();
    locala.ecI = new px();
    locala.uri = "/cgi-bin/micromsg-bin/checkunbind";
    locala.ecG = 254;
    locala.ecJ = 131;
    locala.ecK = 1000000131;
    this.dmK = locala.Kt();
    ((pw)this.dmK.ecE.ecN).sNG = paramInt;
  }
  
  public final String WX()
  {
    try
    {
      String str = ((px)this.dmK.ecF.ecN).sNH;
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneCheckUnBind", "getRandomPasswd() " + str);
      return str;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.NetSceneCheckUnBind", localException, "", new Object[0]);
    }
    return null;
  }
  
  public final px WY()
  {
    return (px)this.dmK.ecF.ecN;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 254;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.y
 * JD-Core Version:    0.7.0.1
 */