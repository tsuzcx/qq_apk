package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ado;
import com.tencent.mm.protocal.c.adp;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class b
  extends m
  implements k
{
  private final com.tencent.mm.ah.b dmK;
  private f dmL;
  public String inn;
  public String ioI = "";
  
  public b(double paramDouble1, double paramDouble2, String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ado();
    ((b.a)localObject).ecI = new adp();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/getcardshomepage";
    ((b.a)localObject).ecG = 1164;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (ado)this.dmK.ecE.ecN;
    ((ado)localObject).latitude = paramDouble1;
    ((ado)localObject).longitude = paramDouble2;
    ((ado)localObject).ioI = paramString;
    ((ado)localObject).tbI = ((String)g.DP().Dz().get(ac.a.uoZ, ""));
    y.d("MicroMsg.NetSceneGetCardsHomePageLayout", "red_buff:" + ((ado)localObject).tbI);
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetCardsHomePageLayout", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(1164), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (adp)this.dmK.ecF.ecN;
      y.v("MicroMsg.NetSceneGetCardsHomePageLayout", "json:" + paramq.inn);
      this.inn = paramq.inn;
      this.ioI = paramq.ioI;
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1164;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.b
 * JD-Core Version:    0.7.0.1
 */