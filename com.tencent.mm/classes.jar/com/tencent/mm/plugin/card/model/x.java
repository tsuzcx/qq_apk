package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.adc;
import com.tencent.mm.protocal.c.add;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

public final class x
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  private String inz = "";
  
  public x()
  {
    b.a locala = new b.a();
    locala.ecH = new adc();
    locala.ecI = new add();
    locala.uri = "/cgi-bin/micromsg-bin/getcardconfiginfo";
    locala.ecG = 692;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetCardConfigInfo", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.inz = ((add)this.dmK.ecF.ecN).inn;
      g.DP().Dz().o(282885, this.inz);
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 692;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.x
 * JD-Core Version:    0.7.0.1
 */