package com.tencent.mm.plugin.ext.voicecontrol;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.dy;
import com.tencent.mm.protocal.c.dz;
import com.tencent.mm.protocal.c.ea;
import com.tencent.mm.protocal.c.ee;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends m
  implements k
{
  public int CD;
  public String appId;
  public int bMC;
  com.tencent.mm.ah.b dmK;
  private f dmL;
  public int ebK;
  public int ebL;
  public int jLF;
  public com.tencent.mm.bv.b jLG;
  public String jLH;
  public ee jLI;
  public dy jLJ;
  int jLK = 5000;
  long jLL = 0L;
  
  public a(int paramInt1, String paramString1, int paramInt2, String paramString2, ee paramee)
  {
    this.bMC = 1;
    this.appId = paramString1;
    this.jLF = paramInt1;
    this.CD = 1;
    this.ebK = paramInt2;
    this.jLI = paramee;
    this.jLJ = null;
    this.jLH = paramString2;
    if (paramee != null) {}
    for (;;)
    {
      y.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, totalLen=%s, controlType=%s, %s, %s", new Object[] { Integer.valueOf(1), paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(1), Boolean.valueOf(bool), Boolean.valueOf(false) });
      return;
      bool = false;
    }
  }
  
  public a(int paramInt, String paramString, dy paramdy, long paramLong)
  {
    this.bMC = 2;
    this.appId = paramString;
    this.jLF = paramInt;
    this.CD = 1;
    this.jLI = null;
    this.jLJ = paramdy;
    this.jLL = paramLong;
    y.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, controlType=%s, %s, %s", new Object[] { Integer.valueOf(2), paramString, Integer.valueOf(paramInt), Integer.valueOf(1), Boolean.valueOf(false), Boolean.valueOf(true) });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    paramf = new b.a();
    paramf.ecG = 985;
    paramf.uri = "/cgi-bin/micromsg-bin/appvoicecontrol";
    paramf.ecH = new dz();
    paramf.ecI = new ea();
    paramf.ecJ = 0;
    paramf.ecK = 0;
    this.dmK = paramf.Kt();
    paramf = (dz)this.dmK.ecE.ecN;
    paramf.ssq = this.bMC;
    paramf.euK = this.appId;
    paramf.sxB = this.jLF;
    paramf.sxC = this.CD;
    paramf.sxD = this.jLI;
    paramf.sxE = this.jLJ;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramq != null)) {
      y.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] onGYNetEnd netId %d , errType %d, errCode %d, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    }
    while (this.dmL != null)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      y.e("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] onGYNetEnd netId %d , errType %d, errCode %d, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    }
    y.e("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] callback null");
  }
  
  public final int getType()
  {
    return 985;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.voicecontrol.a
 * JD-Core Version:    0.7.0.1
 */