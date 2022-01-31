package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.acy;
import com.tencent.mm.protocal.c.acz;
import com.tencent.mm.sdk.platformtools.y;

public final class o
  extends m
  implements k
{
  b dmK = null;
  private f dmL = null;
  
  public o()
  {
    b.a locala = new b.a();
    locala.ecH = new acy();
    locala.ecI = new acz();
    locala.uri = "/cgi-bin/micromsg-bin/getboundharddevices";
    locala.ecG = 539;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((acy)this.dmK.ecE.ecN).hQQ = 1;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.exdevice.NetSceneGetBoundHardDevices", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 539;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.o
 * JD-Core Version:    0.7.0.1
 */