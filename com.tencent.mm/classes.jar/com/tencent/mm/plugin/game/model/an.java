package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.ay;
import com.tencent.mm.plugin.game.d.az;
import com.tencent.mm.sdk.platformtools.y;

public final class an
  extends m
  implements k
{
  private f dmL;
  public final b jvQ;
  
  public an(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ay();
    ((b.a)localObject).ecI = new az();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/newgetgamedetail";
    ((b.a)localObject).ecG = 1217;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.jvQ = ((b.a)localObject).Kt();
    localObject = (ay)this.jvQ.ecE.ecN;
    ((ay)localObject).kUa = paramString1;
    ((ay)localObject).kRX = paramString2;
    ((ay)localObject).kUm = paramBoolean;
    ((ay)localObject).kUo = true;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.jvQ, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetGameDetailNew", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1217;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.an
 * JD-Core Version:    0.7.0.1
 */