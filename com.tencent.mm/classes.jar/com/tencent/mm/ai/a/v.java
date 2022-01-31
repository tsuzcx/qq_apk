package com.tencent.mm.ai.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bii;
import com.tencent.mm.protocal.c.bij;
import com.tencent.mm.sdk.platformtools.y;

public final class v
  extends m
  implements k
{
  public b dmK;
  private f dmL;
  
  public v(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bii();
    ((b.a)localObject).ecI = new bij();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/qymsgstatenotify";
    ((b.a)localObject).ecG = 1361;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bii)this.dmK.ecE.ecN;
    ((bii)localObject).sCO = paramString1;
    ((bii)localObject).sCI = paramString2;
    ((bii)localObject).time_stamp = paramInt;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    y.i("MicroMsg.NetSceneQyMsgStateNotify", "do scene");
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneQyMsgStateNotify", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1361;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ai.a.v
 * JD-Core Version:    0.7.0.1
 */