package com.tencent.mm.bg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.b.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.dts;
import com.tencent.mm.protocal.protobuf.dtt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;

public final class a
  extends n
  implements k
{
  private int audioFormat;
  com.tencent.mm.ak.f callback;
  private String filemd5;
  String filename;
  aw hPc;
  private String iqo;
  private int iqp;
  int iqq;
  private int iqr;
  private b rr;
  private int sampleRate;
  
  public a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(148371);
    this.iqo = null;
    this.filemd5 = null;
    this.filename = null;
    this.sampleRate = 0;
    this.iqp = 0;
    this.audioFormat = 0;
    this.iqq = 0;
    this.iqr = 5;
    this.hPc = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148370);
        long l = o.aZR(a.this.filename);
        ae.d("MicroMsg.NetSceneUploadMedia", com.tencent.mm.compatible.util.f.abr() + " onTimerExpired: file:" + a.this.filename + " nowlen:" + l + " oldoff:" + a.this.iqq);
        if (a.this.doScene(a.this.dispatcher(), a.this.callback) == -1) {
          a.this.callback.onSceneEnd(3, -1, "doScene failed", a.this);
        }
        AppMethodBeat.o(148370);
        return false;
      }
    }, true);
    this.iqo = bu.fpO();
    this.filename = paramString;
    this.iqr = paramInt1;
    this.sampleRate = paramInt2;
    this.iqp = paramInt3;
    this.audioFormat = paramInt4;
    paramInt1 = (int)o.aZR(this.filename);
    this.filemd5 = g.getMessageDigest(o.bb(this.filename, 0, paramInt1));
    AppMethodBeat.o(148371);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    int i = 3960;
    AppMethodBeat.i(148372);
    this.callback = paramf;
    int k = (int)o.aZR(this.filename);
    ae.d("MicroMsg.NetSceneUploadMedia", com.tencent.mm.compatible.util.f.abr() + " read file:" + this.filename + " filelen:" + k + " oldoff:" + this.iqq + "this.filemd5 " + this.filemd5);
    if (k <= 0)
    {
      ae.e("MicroMsg.NetSceneUploadMedia", "read failed :" + this.filename);
      AppMethodBeat.o(148372);
      return -1;
    }
    int j = k - this.iqq;
    if (j > 3960) {}
    for (;;)
    {
      ae.i("MicroMsg.NetSceneUploadMedia", com.tencent.mm.compatible.util.f.abr() + " read file:" + this.filename + " filelen:" + k + " oldoff:" + this.iqq + "  canReadLen " + i);
      paramf = o.bb(this.filename, this.iqq, i);
      if (paramf == null)
      {
        ae.e("MicroMsg.NetSceneUploadMedia", "read data error");
        AppMethodBeat.o(148372);
        return -1;
      }
      Object localObject = new b.a();
      ((b.a)localObject).hQF = new dts();
      ((b.a)localObject).hQG = new dtt();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmuploadmedia";
      ((b.a)localObject).funcId = 240;
      ((b.a)localObject).hQH = 111;
      ((b.a)localObject).respCmdId = 1000000111;
      this.rr = ((b.a)localObject).aDS();
      localObject = (dts)this.rr.hQD.hQJ;
      ((dts)localObject).HZn = new cxn().aQV(this.iqo);
      ((dts)localObject).xsE = new SKBuiltinBuffer_t().setBuffer(paramf);
      ((dts)localObject).xsD = paramf.length;
      ((dts)localObject).HZo = new cxn().aQV(this.filemd5);
      ((dts)localObject).xsB = k;
      ((dts)localObject).xsC = this.iqq;
      ((dts)localObject).udg = this.iqr;
      ((dts)localObject).HZp = 1;
      ((dts)localObject).HZq = this.sampleRate;
      ((dts)localObject).HZr = this.iqp;
      ((dts)localObject).HZs = this.audioFormat;
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
    ae.d("MicroMsg.NetSceneUploadMedia", com.tencent.mm.compatible.util.f.abr() + " onGYNetEnd file:" + this.filename + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (dts)((b)paramq).hQD.hQJ;
    paramq = ((dtt)((b)paramq).hQE.hQJ).ikp;
    ae.i("MicroMsg.NetSceneUploadMedia", "fileName:%s, md5:%s, totalLen:%d, dataLen:%d, startPos:%d", new Object[] { this.filename, paramq, Integer.valueOf(paramArrayOfByte.xsB), Integer.valueOf(paramArrayOfByte.xsD), Integer.valueOf(paramArrayOfByte.xsC) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ae.e("MicroMsg.NetSceneUploadMedia", com.tencent.mm.compatible.util.f.abr() + " onGYNetEnd file:" + this.filename + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148373);
      return;
    }
    if ((paramArrayOfByte.xsB <= paramArrayOfByte.xsD + paramArrayOfByte.xsC) && (paramq != null) && (!paramq.equals("0")))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148373);
      return;
    }
    paramInt1 = paramArrayOfByte.xsC;
    this.iqq = (paramArrayOfByte.xsE.getILen() + paramInt1);
    ae.d("MicroMsg.NetSceneUploadMedia", "onGYNetEnd file:" + this.filename + " delay:500");
    this.hPc.ay(500L, 500L);
    AppMethodBeat.o(148373);
  }
  
  public final int securityLimitCount()
  {
    return 60;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hRi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bg.a
 * JD-Core Version:    0.7.0.1
 */