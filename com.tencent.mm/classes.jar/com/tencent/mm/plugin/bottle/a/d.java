package com.tencent.mm.plugin.bottle.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.acw;
import com.tencent.mm.protocal.c.acx;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  
  public d()
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new acw();
    ((b.a)localObject).ecI = new acx();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getbottlecount";
    ((b.a)localObject).ecG = 152;
    ((b.a)localObject).ecJ = 49;
    ((b.a)localObject).ecK = 1000000049;
    ((b.a)localObject).ecL = false;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (acw)this.dmK.ecE.ecN;
    ((acw)localObject).hPY = com.tencent.mm.model.q.Gj();
    ((acw)localObject).tbx = ((int)bk.UX());
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    paramq = (acx)this.dmK.ecF.ecN;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      c.og(paramq.tbz);
      c.of(paramq.tby);
    }
    for (;;)
    {
      y.d("MicroMsg.NetSceneGetBottleCount", "onGYNetEnd type:" + paramInt2 + " code:" + paramInt3 + " ret:" + paramq.sze + " pickCnt:" + paramq.tbz + " throwCnt:" + paramq.tby);
      this.dmL.onSceneEnd(0, paramq.sze, paramString, this);
      return;
      if ((paramq.sze == -2002) || (paramq.sze == -56))
      {
        c.og(0);
        c.of(0);
      }
    }
  }
  
  public final int getType()
  {
    return 152;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.a.d
 * JD-Core Version:    0.7.0.1
 */