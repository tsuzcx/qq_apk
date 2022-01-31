package com.tencent.mm.openim.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aie;
import com.tencent.mm.protocal.c.aif;
import com.tencent.mm.sdk.platformtools.y;

public final class j
  extends m
  implements k
{
  public String bUF;
  private final b dmK;
  private f dmL;
  
  public j(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new aie();
    locala.ecI = new aif();
    locala.uri = "/cgi-bin/micromsg-bin/getopenurl";
    locala.ecG = 913;
    this.dmK = locala.Kt();
    y.i("MicroMsg.NetSceneGetOpenIMUrl", "NetSceneGetOpenIMUrl username: %s", new Object[] { paramString });
    ((aie)this.dmK.ecE.ecN).userName = paramString;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetOpenIMUrl", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    this.bUF = ((aif)this.dmK.ecF.ecN).bUF;
    y.i("MicroMsg.NetSceneGetOpenIMUrl", "openUrl %s", new Object[] { this.bUF });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 913;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.openim.b.j
 * JD-Core Version:    0.7.0.1
 */