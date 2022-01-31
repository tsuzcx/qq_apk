package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bnt;
import com.tencent.mm.protocal.c.bnu;
import com.tencent.mm.sdk.platformtools.y;

public final class u
  extends m
  implements k
{
  b dmK = null;
  private f dmL = null;
  
  public u(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new bnt();
    locala.ecI = new bnu();
    locala.uri = "/cgi-bin/micromsg-bin/searchharddevice";
    locala.ecG = 540;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((bnt)this.dmK.ecE.ecN).tGB = paramString;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.exdevice.NetSceneSearchHardDevice", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 540;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.u
 * JD-Core Version:    0.7.0.1
 */