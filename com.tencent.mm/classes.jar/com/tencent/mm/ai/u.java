package com.tencent.mm.ai;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.asn;
import com.tencent.mm.protocal.c.aso;
import com.tencent.mm.sdk.platformtools.y;

public final class u
  extends m
  implements k
{
  public b dmK;
  private f dmL;
  public String egK;
  
  public u(String paramString1, String paramString2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new asn();
    ((b.a)localObject).ecI = new aso();
    ((b.a)localObject).uri = "/cgi-bin/mmkf-bin/kfgetbindlist";
    ((b.a)localObject).ecG = 674;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (asn)this.dmK.ecE.ecN;
    ((asn)localObject).toq = paramString1;
    ((asn)localObject).tor = paramString2;
    this.egK = paramString1;
  }
  
  public final aso Mt()
  {
    if ((this.dmK != null) && (this.dmK.ecF.ecN != null)) {
      return (aso)this.dmK.ecF.ecN;
    }
    return null;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    y.i("MicroMsg.NetSceneKFGetBindList", "do scene");
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneKFGetBindList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 674;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ai.u
 * JD-Core Version:    0.7.0.1
 */