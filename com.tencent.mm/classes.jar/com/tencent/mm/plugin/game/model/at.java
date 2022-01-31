package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aok;
import com.tencent.mm.protocal.c.aol;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;

public final class at
  extends m
  implements k
{
  private String appId;
  private f dmL;
  final b jvQ;
  
  public at(String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new aok();
    ((b.a)localObject).ecI = new aol();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/gethvgamemenu";
    ((b.a)localObject).ecG = 1369;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.appId = paramString;
    this.jvQ = ((b.a)localObject).Kt();
    localObject = (aok)this.jvQ.ecE.ecN;
    ((aok)localObject).kUa = x.cqJ();
    ((aok)localObject).ffq = bk.fS(ae.getContext());
    ((aok)localObject).euK = paramString;
    y.i("MicroMsg.NetSceneHVGameGetMenu", "lang=%s, country=%s, appid=%s", new Object[] { ((aok)localObject).kUa, ((aok)localObject).ffq, ((aok)localObject).euK });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.jvQ, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneHVGameGetMenu", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if ((aol)((b)paramq).ecF.ecN == null)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1369;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.at
 * JD-Core Version:    0.7.0.1
 */