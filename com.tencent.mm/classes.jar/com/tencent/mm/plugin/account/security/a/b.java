package com.tencent.mm.plugin.account.security.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.akb;
import com.tencent.mm.protocal.c.akc;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends m
  implements k
{
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  public akc fjR;
  
  public final int a(e parame, f paramf)
  {
    b.a locala = new b.a();
    locala.ecH = new akb();
    locala.ecI = new akc();
    locala.uri = "/cgi-bin/micromsg-bin/getsafetyinfo";
    locala.ecG = 850;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      y.e("MicroMsg.NetSceneGetSafetyInfo", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    this.fjR = ((akc)((com.tencent.mm.ah.b)paramq).ecF.ecN);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 850;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.a.b
 * JD-Core Version:    0.7.0.1
 */