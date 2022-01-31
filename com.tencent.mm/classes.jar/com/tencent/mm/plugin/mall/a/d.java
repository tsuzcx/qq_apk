package com.tencent.mm.plugin.mall.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aiq;
import com.tencent.mm.protocal.c.air;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class d
  extends m
  implements k
{
  private f dmL;
  private b eWr;
  private aiq lYo;
  public air lYp;
  
  public d()
  {
    b.a locala = new b.a();
    locala.ecH = new aiq();
    locala.ecI = new air();
    locala.ecG = 1754;
    locala.uri = "/cgi-bin/mmpay-bin/tenpay/getpaymenu";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.eWr = locala.Kt();
    this.lYo = ((aiq)this.eWr.ecE.ecN);
  }
  
  public final int a(e parame, f paramf)
  {
    y.d("MicroMsg.NetSceneGetPayMenu", "doScene");
    this.dmL = paramf;
    return a(parame, this.eWr, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetPayMenu", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.lYp = ((air)this.eWr.ecF.ecN);
      paramq = this.lYp.title;
      paramArrayOfByte = this.lYp.tfI;
      if (this.lYp.tfI == null) {
        break label132;
      }
    }
    label132:
    for (paramInt1 = this.lYp.tfI.size();; paramInt1 = 0)
    {
      y.i("MicroMsg.NetSceneGetPayMenu", "onGYNetEnd, title: %s, sectors: %s, sectors.size: %s", new Object[] { paramq, paramArrayOfByte, Integer.valueOf(paramInt1) });
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
  }
  
  public final int getType()
  {
    return 1754;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.d
 * JD-Core Version:    0.7.0.1
 */