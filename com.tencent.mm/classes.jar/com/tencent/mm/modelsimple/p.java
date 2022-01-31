package com.tencent.mm.modelsimple;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.auk;
import com.tencent.mm.protocal.c.aul;
import com.tencent.mm.sdk.platformtools.y;

public final class p
  extends m
  implements k
{
  public final b dmK;
  private f dmL;
  
  public p()
  {
    b.a locala = new b.a();
    locala.ecH = new auk();
    locala.ecI = new aul();
    locala.uri = "/cgi-bin/micromsg-bin/logout";
    locala.ecG = 282;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((auk)this.dmK.ecE.ecN).pyo = 0;
  }
  
  public final int a(e parame, f paramf)
  {
    y.d("MicroMsg.NetSceneLogout", "doScene");
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      y.d("MicroMsg.NetSceneLogout", "logout Error. ");
    }
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 282;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelsimple.p
 * JD-Core Version:    0.7.0.1
 */