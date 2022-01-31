package com.tencent.mm.modelappbrand;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.h.a.id;
import com.tencent.mm.h.a.id.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.cin;
import com.tencent.mm.protocal.c.cio;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class r
  extends com.tencent.mm.plugin.websearch.api.b
  implements k
{
  private f dIJ;
  private com.tencent.mm.ah.b dZP;
  private cio dZS;
  
  public r(String paramString, int paramInt1, int paramInt2)
  {
    this.Db = paramString;
    this.fzn = paramInt1;
    this.qTt = paramInt2;
    if (!bk.bl(paramString))
    {
      y.i("MicroMsg.NetSceneWeAppSuggest", "Constructors: query = %s", new Object[] { paramString });
      Object localObject = new b.a();
      ((b.a)localObject).ecG = 1173;
      ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearchsuggestion";
      ((b.a)localObject).ecH = new cin();
      ((b.a)localObject).ecI = new cio();
      this.dZP = ((b.a)localObject).Kt();
      localObject = (cin)this.dZP.ecE.ecN;
      ((cin)localObject).bVk = paramString;
      paramString = new id();
      a.udP.m(paramString);
      ((cin)localObject).tpI = paramString.bQn.bQo;
      au.Hx();
      paramString = c.Dz().get(ac.a.uuP, null);
      if ((paramString != null) && ((paramString instanceof String))) {
        ((cin)localObject).tWX = ((String)paramString);
      }
      ((cin)localObject).tpM = b.dZL;
      ((cin)localObject).tWS = b.dZM;
      return;
    }
    y.e("MicroMsg.NetSceneWeAppSuggest", "keyword is unavailable");
  }
  
  public final String Jv()
  {
    if (this.dZS != null) {
      return this.dZS.sEb;
    }
    return "";
  }
  
  public final int a(e parame, f paramf)
  {
    this.dIJ = paramf;
    return a(parame, this.dZP, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneWeAppSuggest", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    this.dZS = ((cio)this.dZP.ecF.ecN);
    if (this.dZS != null) {
      y.v("MicroMsg.NetSceneWeAppSuggest", "return data\n%s", new Object[] { this.dZS.sEb });
    }
    this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1173;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.r
 * JD-Core Version:    0.7.0.1
 */