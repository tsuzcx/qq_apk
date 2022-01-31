package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.chr;
import com.tencent.mm.protocal.c.chs;
import com.tencent.mm.sdk.platformtools.y;

public final class j
  extends m
  implements k
{
  private b dmK = null;
  private f dmL = null;
  public chr lrH = null;
  public chs lrI = null;
  
  public j(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new chr();
    locala.ecI = new chs();
    locala.ecG = 277;
    locala.uri = "/cgi-bin/micromsg-bin/wcopurchasepackage";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.lrH = ((chr)this.dmK.ecE.ecN);
    this.lrH.syc = paramString;
    y.i("MicroMsg.NetSceneIPCallPurchasePackage", "NetSceneIPCallPurchasePackage ProductID:%s", new Object[] { this.lrH.syc });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneIPCallPurchasePackage", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.lrI = ((chs)((b)paramq).ecF.ecN);
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 277;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.d.j
 * JD-Core Version:    0.7.0.1
 */