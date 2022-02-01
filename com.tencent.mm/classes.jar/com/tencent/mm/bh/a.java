package com.tencent.mm.bh;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.dhp;
import com.tencent.mm.protocal.protobuf.dhq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

public final class a
  extends n
  implements k
{
  private int audioFormat;
  com.tencent.mm.al.g callback;
  private String filemd5;
  String filename;
  av gTs;
  private int htA;
  private String htx;
  private int hty;
  int htz;
  private b rr;
  private int sampleRate;
  
  public a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(148371);
    this.htx = null;
    this.filemd5 = null;
    this.filename = null;
    this.sampleRate = 0;
    this.hty = 0;
    this.audioFormat = 0;
    this.htz = 0;
    this.htA = 5;
    this.gTs = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148370);
        long l = i.aMN(a.this.filename);
        ad.d("MicroMsg.NetSceneUploadMedia", f.XJ() + " onTimerExpired: file:" + a.this.filename + " nowlen:" + l + " oldoff:" + a.this.htz);
        if (a.this.doScene(a.this.dispatcher(), a.this.callback) == -1) {
          a.this.callback.onSceneEnd(3, -1, "doScene failed", a.this);
        }
        AppMethodBeat.o(148370);
        return false;
      }
    }, true);
    this.htx = bt.eGO();
    this.filename = paramString;
    this.htA = paramInt1;
    this.sampleRate = paramInt2;
    this.hty = paramInt3;
    this.audioFormat = paramInt4;
    paramInt1 = (int)i.aMN(this.filename);
    this.filemd5 = com.tencent.mm.b.g.getMessageDigest(i.aR(this.filename, 0, paramInt1));
    AppMethodBeat.o(148371);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    int i = 3960;
    AppMethodBeat.i(148372);
    this.callback = paramg;
    int k = (int)i.aMN(this.filename);
    ad.d("MicroMsg.NetSceneUploadMedia", f.XJ() + " read file:" + this.filename + " filelen:" + k + " oldoff:" + this.htz + "this.filemd5 " + this.filemd5);
    if (k <= 0)
    {
      ad.e("MicroMsg.NetSceneUploadMedia", "read failed :" + this.filename);
      AppMethodBeat.o(148372);
      return -1;
    }
    int j = k - this.htz;
    if (j > 3960) {}
    for (;;)
    {
      ad.i("MicroMsg.NetSceneUploadMedia", f.XJ() + " read file:" + this.filename + " filelen:" + k + " oldoff:" + this.htz + "  canReadLen " + i);
      paramg = i.aR(this.filename, this.htz, i);
      if (paramg == null)
      {
        ad.e("MicroMsg.NetSceneUploadMedia", "read data error");
        AppMethodBeat.o(148372);
        return -1;
      }
      Object localObject = new b.a();
      ((b.a)localObject).gUU = new dhp();
      ((b.a)localObject).gUV = new dhq();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmuploadmedia";
      ((b.a)localObject).funcId = 240;
      ((b.a)localObject).reqCmdId = 111;
      ((b.a)localObject).respCmdId = 1000000111;
      this.rr = ((b.a)localObject).atI();
      localObject = (dhp)this.rr.gUS.gUX;
      ((dhp)localObject).ExK = new cmf().aEE(this.htx);
      ((dhp)localObject).uKT = new SKBuiltinBuffer_t().setBuffer(paramg);
      ((dhp)localObject).uKS = paramg.length;
      ((dhp)localObject).ExL = new cmf().aEE(this.filemd5);
      ((dhp)localObject).uKQ = k;
      ((dhp)localObject).uKR = this.htz;
      ((dhp)localObject).rNT = this.htA;
      ((dhp)localObject).ExM = 1;
      ((dhp)localObject).ExN = this.sampleRate;
      ((dhp)localObject).ExO = this.hty;
      ((dhp)localObject).ExP = this.audioFormat;
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(148372);
      return i;
      i = j;
    }
  }
  
  public final int getType()
  {
    return 240;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148373);
    updateDispatchId(paramInt1);
    ad.d("MicroMsg.NetSceneUploadMedia", f.XJ() + " onGYNetEnd file:" + this.filename + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (dhp)((b)paramq).gUS.gUX;
    paramq = ((dhq)((b)paramq).gUT.gUX).hnF;
    ad.i("MicroMsg.NetSceneUploadMedia", "fileName:%s, md5:%s, totalLen:%d, dataLen:%d, startPos:%d", new Object[] { this.filename, paramq, Integer.valueOf(paramArrayOfByte.uKQ), Integer.valueOf(paramArrayOfByte.uKS), Integer.valueOf(paramArrayOfByte.uKR) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneUploadMedia", f.XJ() + " onGYNetEnd file:" + this.filename + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148373);
      return;
    }
    if ((paramArrayOfByte.uKQ <= paramArrayOfByte.uKS + paramArrayOfByte.uKR) && (paramq != null) && (!paramq.equals("0")))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148373);
      return;
    }
    paramInt1 = paramArrayOfByte.uKR;
    this.htz = (paramArrayOfByte.uKT.getILen() + paramInt1);
    ad.d("MicroMsg.NetSceneUploadMedia", "onGYNetEnd file:" + this.filename + " delay:500");
    this.gTs.av(500L, 500L);
    AppMethodBeat.o(148373);
  }
  
  public final int securityLimitCount()
  {
    return 60;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.gVB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bh.a
 * JD-Core Version:    0.7.0.1
 */