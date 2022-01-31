package com.tencent.mm.plugin.appbrand.n;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.cip;
import com.tencent.mm.protocal.c.ciq;
import com.tencent.mm.protocal.c.cir;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Locale;

public final class b
  extends m
  implements k
{
  private f dIJ;
  private com.tencent.mm.ah.b dZP;
  private ciq gQu;
  
  public b()
  {
    b.a locala = new b.a();
    locala.ecH = new cip();
    locala.ecI = new ciq();
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearchtitle";
    locala.ecG = 1170;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dZP = locala.Kt();
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    y.i("MicroMsg.NetSceneGetWeAppSearchTitle", "doScene");
    this.dIJ = paramf;
    return a(parame, this.dZP, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetWeAppSearchTitle", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gQu = ((ciq)this.dZP.ecF.ecN);
    if (this.dIJ != null) {
      this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.gQu.tWY == null) {
      return;
    }
    paramString = g.DP().Dz();
    paramString.c(ac.a.uuN, Locale.getDefault().getLanguage());
    paramString.c(ac.a.uuO, this.gQu.tWY.lsL);
    paramString.c(ac.a.uuP, this.gQu.tWY.tWX);
    paramString.c(ac.a.uuQ, Long.valueOf(System.currentTimeMillis()));
  }
  
  public final int getType()
  {
    return 1170;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.b
 * JD-Core Version:    0.7.0.1
 */