package com.tencent.mm.ai.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.protocal.c.rx;
import com.tencent.mm.protocal.c.zp;
import com.tencent.mm.sdk.platformtools.y;

public final class n
  extends m
  implements k
{
  Object data;
  public b dmK;
  private f dmL;
  
  public n(String paramString, zp paramzp, Object paramObject)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new rw();
    ((b.a)localObject).ecI = new rx();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/createbizchatinfo";
    ((b.a)localObject).ecG = 1355;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (rw)this.dmK.ecE.ecN;
    ((rw)localObject).sCO = paramString;
    ((rw)localObject).sPX = paramzp;
    this.data = paramObject;
  }
  
  public final rx MT()
  {
    if ((this.dmK != null) && (this.dmK.ecF.ecN != null)) {
      return (rx)this.dmK.ecF.ecN;
    }
    return null;
  }
  
  public final rw MU()
  {
    if ((this.dmK != null) && (this.dmK.ecE.ecN != null)) {
      return (rw)this.dmK.ecE.ecN;
    }
    return null;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    y.i("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "do scene");
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1355;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ai.a.n
 * JD-Core Version:    0.7.0.1
 */