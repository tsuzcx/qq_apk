package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.apo;
import com.tencent.mm.protocal.c.byu;
import com.tencent.mm.protocal.c.byv;
import com.tencent.mm.sdk.platformtools.y;

public final class n
  extends m
  implements k
{
  public String bwK = null;
  b dmK = null;
  private f dmL = null;
  public int jvW = 0;
  
  public n(apo paramapo, String paramString1, String paramString2, int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new byu();
    ((b.a)localObject).ecI = new byv();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/hardware/transfermsgtodevice";
    ((b.a)localObject).ecG = 1717;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (byu)this.dmK.ecE.ecN;
    ((byu)localObject).syI = paramString1;
    ((byu)localObject).sPn = paramString2;
    ((byu)localObject).tOS = paramapo;
    ((byu)localObject).tOT = paramInt;
    this.bwK = paramString2;
    this.jvW = paramInt;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.exdevice.NetSceneGetAppMsgInfo", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1717;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.n
 * JD-Core Version:    0.7.0.1
 */