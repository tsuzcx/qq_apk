package com.tencent.mm.bb;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.cap;
import com.tencent.mm.protocal.c.caq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.io.File;

public final class b
  extends m
  implements k
{
  private String clientId;
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  private int ebK;
  private int ebL;
  public String exA;
  private String imgPath;
  private String username;
  
  private b(String paramString)
  {
    this.username = paramString;
    this.ebK = 0;
    this.ebL = 0;
    paramString = new StringBuilder();
    g.DN();
    this.clientId = (com.tencent.mm.kernel.a.CK() + System.currentTimeMillis());
  }
  
  public b(String paramString1, String paramString2)
  {
    this(paramString1);
    this.imgPath = paramString2;
  }
  
  protected final int Ka()
  {
    return 100;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    if ((this.imgPath == null) || (this.imgPath.length() == 0))
    {
      y.e("MicroMsg.NetSceneUploadCardImg", "imgPath is null or length = 0");
      return -1;
    }
    if (!com.tencent.mm.a.e.bK(this.imgPath))
    {
      y.e("MicroMsg.NetSceneUploadCardImg", "The img does not exist, imgPath = " + this.imgPath);
      return -1;
    }
    if (this.ebK == 0) {
      this.ebK = ((int)new File(this.imgPath).length());
    }
    paramf = new b.a();
    paramf.ecH = new cap();
    paramf.ecI = new caq();
    paramf.uri = "/cgi-bin/micromsg-bin/uploadcardimg";
    paramf.ecG = 575;
    paramf.ecJ = 0;
    paramf.ecK = 0;
    this.dmK = paramf.Kt();
    int i = Math.min(this.ebK - this.ebL, 32768);
    paramf = com.tencent.mm.a.e.c(this.imgPath, this.ebL, i);
    if (paramf == null)
    {
      y.e("MicroMsg.NetSceneUploadCardImg", "readFromFile error");
      return -1;
    }
    y.i("MicroMsg.NetSceneUploadCardImg", "doScene uploadLen:%d, total: %d", new Object[] { Integer.valueOf(paramf.length), Integer.valueOf(this.ebK) });
    cap localcap = (cap)this.dmK.ecE.ecN;
    localcap.sQG = this.username;
    localcap.ndf = this.ebK;
    localcap.ndg = this.ebL;
    localcap.ndi = new bmk().bs(paramf);
    localcap.ndh = localcap.ndi.tFK;
    localcap.nde = this.clientId;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneUploadCardImg", "onGYNetEnd:%s, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      y.e("MicroMsg.NetSceneUploadCardImg", "upload card img error");
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramq = (caq)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    this.exA = paramq.ttE;
    this.ebL = paramq.ndg;
    if (this.ebL < this.ebK)
    {
      if (a(this.edc, this.dmL) < 0)
      {
        y.e("MicroMsg.NetSceneUploadCardImg", "doScene again failed");
        this.dmL.onSceneEnd(3, -1, "", this);
      }
      y.d("MicroMsg.NetSceneUploadCardImg", "doScene again");
      return;
    }
    if (!bk.bl(this.exA))
    {
      paramq = ((j)g.r(j.class)).Fw().abl(this.username);
      if ((paramq != null) && ((int)paramq.dBe > 0) && (com.tencent.mm.n.a.gR(paramq.field_type)))
      {
        paramq.dH(this.exA);
        ((j)g.r(j.class)).Fw().a(this.username, paramq);
      }
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  protected final m.b b(q paramq)
  {
    if ((this.imgPath == null) || (this.imgPath.length() == 0)) {
      return m.b.eds;
    }
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 575;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.bb.b
 * JD-Core Version:    0.7.0.1
 */