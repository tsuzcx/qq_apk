package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.dd;
import com.tencent.mm.plugin.game.d.de;
import com.tencent.mm.sdk.platformtools.y;

public final class aw
  extends m
  implements k
{
  private f dmL;
  public final b jvQ;
  
  public aw(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new dd();
    ((b.a)localObject).ecI = new de();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/newsubscribenewgame";
    ((b.a)localObject).ecG = 1219;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.jvQ = ((b.a)localObject).Kt();
    localObject = (dd)this.jvQ.ecE.ecN;
    ((dd)localObject).kRX = paramString1;
    ((dd)localObject).kUa = paramString2;
    ((dd)localObject).kRU = paramString3;
    ((dd)localObject).kSk = paramBoolean;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.jvQ, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGameSubscription", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1219;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.aw
 * JD-Core Version:    0.7.0.1
 */