package com.tencent.mm.be;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.cbd;
import com.tencent.mm.protocal.c.cbe;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends m
  implements k
{
  private b dmK;
  f dmL;
  private String eAX = null;
  private int eAY = 0;
  private int eAZ = 0;
  int eBa = 0;
  private int eBb = 5;
  am ebj = new am(new a.1(this), true);
  private String filemd5 = null;
  String filename = null;
  private int sampleRate = 0;
  
  public a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.filename = paramString;
    this.eBb = paramInt1;
    this.sampleRate = paramInt2;
    this.eAY = paramInt3;
    this.eAZ = paramInt4;
    paramInt1 = (int)com.tencent.mm.vfs.e.aeQ(this.filename);
    this.filemd5 = com.tencent.mm.a.g.o(com.tencent.mm.vfs.e.c(this.filename, 0, paramInt1));
  }
  
  protected final int Ka()
  {
    return 60;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    int i = 3960;
    this.dmL = paramf;
    int k = (int)com.tencent.mm.vfs.e.aeQ(this.filename);
    y.d("MicroMsg.NetSceneUploadMedia", com.tencent.mm.compatible.util.g.zI() + " read file:" + this.filename + " filelen:" + k + " oldoff:" + this.eBa + "this.filemd5 " + this.filemd5);
    if (k <= 0)
    {
      y.e("MicroMsg.NetSceneUploadMedia", "read failed :" + this.filename);
      return -1;
    }
    int j = k - this.eBa;
    if (j > 3960) {}
    for (;;)
    {
      y.i("MicroMsg.NetSceneUploadMedia", com.tencent.mm.compatible.util.g.zI() + " read file:" + this.filename + " filelen:" + k + " oldoff:" + this.eBa + "  canReadLen " + i);
      paramf = com.tencent.mm.vfs.e.c(this.filename, this.eBa, i);
      if (paramf == null)
      {
        y.e("MicroMsg.NetSceneUploadMedia", "read data error");
        return -1;
      }
      Object localObject = new b.a();
      ((b.a)localObject).ecH = new cbd();
      ((b.a)localObject).ecI = new cbe();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmuploadmedia";
      ((b.a)localObject).ecG = 240;
      ((b.a)localObject).ecJ = 111;
      ((b.a)localObject).ecK = 1000000111;
      this.dmK = ((b.a)localObject).Kt();
      localObject = (cbd)this.dmK.ecE.ecN;
      ((cbd)localObject).tQi = new bml().YI(this.eAX);
      ((cbd)localObject).ndi = new bmk().bs(paramf);
      ((cbd)localObject).ndh = paramf.length;
      ((cbd)localObject).tQj = new bml().YI(this.filemd5);
      ((cbd)localObject).ndf = k;
      ((cbd)localObject).ndg = this.eBa;
      ((cbd)localObject).kVG = this.eBb;
      ((cbd)localObject).tQk = 1;
      ((cbd)localObject).tQl = this.sampleRate;
      ((cbd)localObject).tQm = this.eAY;
      ((cbd)localObject).tQn = this.eAZ;
      return a(parame, this.dmK, this);
      i = j;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneUploadMedia", com.tencent.mm.compatible.util.g.zI() + " onGYNetEnd file:" + this.filename + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (cbd)((b)paramq).ecE.ecN;
    paramq = ((cbe)((b)paramq).ecF.ecN).euN;
    y.i("MicroMsg.NetSceneUploadMedia", "fileName:%s, md5:%s, totalLen:%d, dataLen:%d, startPos:%d", new Object[] { this.filename, paramq, Integer.valueOf(paramArrayOfByte.ndf), Integer.valueOf(paramArrayOfByte.ndh), Integer.valueOf(paramArrayOfByte.ndg) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      y.e("MicroMsg.NetSceneUploadMedia", com.tencent.mm.compatible.util.g.zI() + " onGYNetEnd file:" + this.filename + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if ((paramArrayOfByte.ndf <= paramArrayOfByte.ndh + paramArrayOfByte.ndg) && (paramq != null) && (!paramq.equals("0")))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramInt1 = paramArrayOfByte.ndg;
    this.eBa = (paramArrayOfByte.ndi.tFK + paramInt1);
    y.d("MicroMsg.NetSceneUploadMedia", "onGYNetEnd file:" + this.filename + " delay:500");
    this.ebj.S(500L, 500L);
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 240;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.be.a
 * JD-Core Version:    0.7.0.1
 */