package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.c.tg;
import com.tencent.mm.protocal.c.th;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends m
  implements com.tencent.mm.network.k
{
  private String bZc = "";
  private final b dmK;
  private f dmL;
  public int ino;
  
  public a(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new tg();
    locala.ecI = new th();
    locala.uri = "/cgi-bin/mmbiz-bin/card/delsharecard";
    locala.ecG = 1163;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((tg)this.dmK.ecE.ecN).bZc = paramString;
    this.bZc = paramString;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneDelShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(1163), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (th)this.dmK.ecF.ecN;
      y.i("MicroMsg.NetSceneDelShareCard", "ret_code:" + paramq.ino);
      this.ino = paramq.ino;
      if (this.ino == 0) {
        am.aAA().yx(this.bZc);
      }
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1163;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.a
 * JD-Core Version:    0.7.0.1
 */