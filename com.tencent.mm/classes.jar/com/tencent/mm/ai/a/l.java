package com.tencent.mm.ai.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.it;
import com.tencent.mm.protocal.c.iu;
import com.tencent.mm.sdk.platformtools.y;

public final class l
  extends m
  implements k
{
  private Object data;
  public b dmK;
  private f dmL;
  
  public l(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new it();
    ((b.a)localObject).ecI = new iu();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/bizchatsearchcontact";
    ((b.a)localObject).ecG = 1364;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (it)this.dmK.ecE.ecN;
    ((it)localObject).sCO = paramString1;
    ((it)localObject).bGm = paramString2;
    ((it)localObject).offset = paramInt;
    this.data = null;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    y.i("MicroMsg.NetSceneBizChatSearchContact", "do scene");
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneBizChatSearchContact", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1364;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ai.a.l
 * JD-Core Version:    0.7.0.1
 */