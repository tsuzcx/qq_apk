package com.tencent.mm.bh;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.b.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.dsv;
import com.tencent.mm.protocal.protobuf.dsw;
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
  com.tencent.mm.al.f callback;
  private String filemd5;
  String filename;
  av hMj;
  private String inu;
  private int inv;
  int inw;
  private int inx;
  private b rr;
  private int sampleRate;
  
  public a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(148371);
    this.inu = null;
    this.filemd5 = null;
    this.filename = null;
    this.sampleRate = 0;
    this.inv = 0;
    this.audioFormat = 0;
    this.inw = 0;
    this.inx = 5;
    this.hMj = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148370);
        long l = i.aYo(a.this.filename);
        ad.d("MicroMsg.NetSceneUploadMedia", com.tencent.mm.compatible.util.f.abi() + " onTimerExpired: file:" + a.this.filename + " nowlen:" + l + " oldoff:" + a.this.inw);
        if (a.this.doScene(a.this.dispatcher(), a.this.callback) == -1) {
          a.this.callback.onSceneEnd(3, -1, "doScene failed", a.this);
        }
        AppMethodBeat.o(148370);
        return false;
      }
    }, true);
    this.inu = bt.flT();
    this.filename = paramString;
    this.inx = paramInt1;
    this.sampleRate = paramInt2;
    this.inv = paramInt3;
    this.audioFormat = paramInt4;
    paramInt1 = (int)i.aYo(this.filename);
    this.filemd5 = g.getMessageDigest(i.aY(this.filename, 0, paramInt1));
    AppMethodBeat.o(148371);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    int i = 3960;
    AppMethodBeat.i(148372);
    this.callback = paramf;
    int k = (int)i.aYo(this.filename);
    ad.d("MicroMsg.NetSceneUploadMedia", com.tencent.mm.compatible.util.f.abi() + " read file:" + this.filename + " filelen:" + k + " oldoff:" + this.inw + "this.filemd5 " + this.filemd5);
    if (k <= 0)
    {
      ad.e("MicroMsg.NetSceneUploadMedia", "read failed :" + this.filename);
      AppMethodBeat.o(148372);
      return -1;
    }
    int j = k - this.inw;
    if (j > 3960) {}
    for (;;)
    {
      ad.i("MicroMsg.NetSceneUploadMedia", com.tencent.mm.compatible.util.f.abi() + " read file:" + this.filename + " filelen:" + k + " oldoff:" + this.inw + "  canReadLen " + i);
      paramf = i.aY(this.filename, this.inw, i);
      if (paramf == null)
      {
        ad.e("MicroMsg.NetSceneUploadMedia", "read data error");
        AppMethodBeat.o(148372);
        return -1;
      }
      Object localObject = new b.a();
      ((b.a)localObject).hNM = new dsv();
      ((b.a)localObject).hNN = new dsw();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmuploadmedia";
      ((b.a)localObject).funcId = 240;
      ((b.a)localObject).hNO = 111;
      ((b.a)localObject).respCmdId = 1000000111;
      this.rr = ((b.a)localObject).aDC();
      localObject = (dsv)this.rr.hNK.hNQ;
      ((dsv)localObject).HFA = new cwt().aPy(this.inu);
      ((dsv)localObject).xcN = new SKBuiltinBuffer_t().setBuffer(paramf);
      ((dsv)localObject).xcM = paramf.length;
      ((dsv)localObject).HFB = new cwt().aPy(this.filemd5);
      ((dsv)localObject).xcK = k;
      ((dsv)localObject).xcL = this.inw;
      ((dsv)localObject).tSp = this.inx;
      ((dsv)localObject).HFC = 1;
      ((dsv)localObject).HFD = this.sampleRate;
      ((dsv)localObject).HFE = this.inv;
      ((dsv)localObject).HFF = this.audioFormat;
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
    ad.d("MicroMsg.NetSceneUploadMedia", com.tencent.mm.compatible.util.f.abi() + " onGYNetEnd file:" + this.filename + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (dsv)((b)paramq).hNK.hNQ;
    paramq = ((dsw)((b)paramq).hNL.hNQ).ihw;
    ad.i("MicroMsg.NetSceneUploadMedia", "fileName:%s, md5:%s, totalLen:%d, dataLen:%d, startPos:%d", new Object[] { this.filename, paramq, Integer.valueOf(paramArrayOfByte.xcK), Integer.valueOf(paramArrayOfByte.xcM), Integer.valueOf(paramArrayOfByte.xcL) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneUploadMedia", com.tencent.mm.compatible.util.f.abi() + " onGYNetEnd file:" + this.filename + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148373);
      return;
    }
    if ((paramArrayOfByte.xcK <= paramArrayOfByte.xcM + paramArrayOfByte.xcL) && (paramq != null) && (!paramq.equals("0")))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148373);
      return;
    }
    paramInt1 = paramArrayOfByte.xcL;
    this.inw = (paramArrayOfByte.xcN.getILen() + paramInt1);
    ad.d("MicroMsg.NetSceneUploadMedia", "onGYNetEnd file:" + this.filename + " delay:500");
    this.hMj.az(500L, 500L);
    AppMethodBeat.o(148373);
  }
  
  public final int securityLimitCount()
  {
    return 60;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hOp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bh.a
 * JD-Core Version:    0.7.0.1
 */