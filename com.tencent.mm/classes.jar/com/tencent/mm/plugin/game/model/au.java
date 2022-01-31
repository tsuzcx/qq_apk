package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.at;
import com.tencent.mm.sdk.platformtools.y;

public final class au
  extends m
  implements k
{
  private f dmL;
  private final b jvQ;
  
  public au(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new at();
    ((b.a)localObject).ecI = new com.tencent.mm.plugin.game.d.au();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/gamereport";
    ((b.a)localObject).ecG = 1223;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.jvQ = ((b.a)localObject).Kt();
    localObject = (at)this.jvQ.ecE.ecN;
    ((at)localObject).kRX = paramString1;
    ((at)localObject).kTS = paramInt1;
    ((at)localObject).kTT = paramInt2;
    ((at)localObject).kTU = paramString2;
    ((at)localObject).kTV = paramString3;
    ((at)localObject).kTR = ((int)(System.currentTimeMillis() / 1000L));
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.jvQ, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetGameIndex", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1223;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.au
 * JD-Core Version:    0.7.0.1
 */