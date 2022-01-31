package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bzw;
import com.tencent.mm.protocal.c.bzx;

public final class y
  extends m
  implements k
{
  private String bJp;
  private String bwK;
  public String cMT;
  private b dmK;
  private f dmL;
  private int jwb;
  
  public y(String paramString1, String paramString2, String paramString3)
  {
    this.cMT = paramString3;
    this.bwK = paramString1;
    this.bJp = paramString2;
    this.jwb = 0;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    paramf = new b.a();
    paramf.ecH = new bzw();
    paramf.ecI = new bzx();
    paramf.uri = "/cgi-bin/mmoc-bin/hardware/updatemydeviceattr";
    paramf.ecG = 1263;
    paramf.ecJ = 0;
    paramf.ecK = 0;
    this.dmK = paramf.Kt();
    paramf = (bzw)this.dmK.ecE.ecN;
    paramf.cMT = this.cMT;
    paramf.mLc = this.bwK;
    paramf.devicetype = this.bJp;
    paramf.tPB = this.jwb;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1263;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.y
 * JD-Core Version:    0.7.0.1
 */