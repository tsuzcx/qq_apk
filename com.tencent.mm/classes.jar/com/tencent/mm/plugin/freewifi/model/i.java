package com.tencent.mm.plugin.freewifi.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.platformtools.y;

public final class i
  extends m
  implements k
{
  private String bOL;
  private final b dmK;
  private f dmL;
  
  private i()
  {
    b.a locala = new b.a();
    locala.ecH = new bw();
    locala.ecI = new bx();
    locala.uri = "/cgi-bin/mmo2o-bin/addcontact";
    locala.ecG = 1703;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
  }
  
  public i(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this();
    this.bOL = paramString1;
    bw localbw = (bw)this.dmK.ecE.ecN;
    localbw.svu = paramString1;
    localbw.kSC = paramString2;
    localbw.sss = paramInt;
    localbw.sst = paramString3;
    y.i("MicroMsg.FreeWifi.NetSceneAddContact", "appid = %s", new Object[] { paramString1 });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.FreeWifi.NetSceneAddContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, appid = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.bOL });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1703;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.i
 * JD-Core Version:    0.7.0.1
 */