package com.tencent.mm.plugin.game.commlib;

import android.os.Build.VERSION;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.a.a.a;
import com.tencent.mm.plugin.game.d.aw;
import com.tencent.mm.plugin.game.d.ax;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  extends m
  implements k
{
  private f dmL;
  private final com.tencent.mm.ah.b jvQ;
  
  public c()
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new aw();
    ((b.a)localObject).ecI = new ax();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/getgamecenterglobalsetting";
    ((b.a)localObject).ecG = 1311;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.jvQ = ((b.a)localObject).Kt();
    aw localaw = (aw)this.jvQ.ecE.ecN;
    localaw.kUa = x.cqJ();
    String str = a.a.aYi().aYa();
    localObject = str;
    if (bk.bl(str)) {
      localObject = bk.fS(ae.getContext());
    }
    localaw.ffq = ((String)localObject);
    localaw.kUb = com.tencent.mm.sdk.platformtools.e.bvj;
    localaw.kUc = new d();
    localaw.kUc.kRV = Build.VERSION.SDK_INT;
    localaw.kUc.kRW = com.b.a.a.b.X(ae.getContext());
    y.i("MicroMsg.NetSceneGetGameGlobalConfig", "lang=%s, country=%s, releaseChannel=%s, osVersion = %d, deviceLevel = %d", new Object[] { localaw.kUa, localaw.ffq, Integer.valueOf(localaw.kUb), Integer.valueOf(localaw.kUc.kRV), Integer.valueOf(localaw.kUc.kRW) });
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.jvQ, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetGameGlobalConfig", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramq = (ax)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    if (paramq == null)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    a.a(paramq);
    com.tencent.mm.plugin.game.commlib.c.a.aYt();
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1311;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.c
 * JD-Core Version:    0.7.0.1
 */