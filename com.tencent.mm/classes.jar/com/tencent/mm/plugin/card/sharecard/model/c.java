package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.akm;
import com.tencent.mm.protocal.c.akn;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  public String inn;
  
  public c(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new akm();
    locala.ecI = new akn();
    locala.uri = "/cgi-bin/micromsg-bin/getsharecard";
    locala.ecG = 904;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((akm)this.dmK.ecE.ecN).bZc = paramString;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(904), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (akn)this.dmK.ecF.ecN;
      y.v("MicroMsg.NetSceneGetShareCard", "json:" + paramq.inn);
      this.inn = paramq.inn;
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 904;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.c
 * JD-Core Version:    0.7.0.1
 */