package com.tencent.mm.bg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.protocal.protobuf.dnf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;

public final class a
  extends n
  implements k
{
  private int audioFormat;
  com.tencent.mm.ak.g callback;
  private String filemd5;
  String filename;
  private String hTZ;
  private int hUa;
  int hUb;
  private int hUc;
  au htR;
  private b rr;
  private int sampleRate;
  
  public a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(148371);
    this.hTZ = null;
    this.filemd5 = null;
    this.filename = null;
    this.sampleRate = 0;
    this.hUa = 0;
    this.audioFormat = 0;
    this.hUb = 0;
    this.hUc = 5;
    this.htR = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148370);
        long l = i.aSp(a.this.filename);
        ac.d("MicroMsg.NetSceneUploadMedia", f.YG() + " onTimerExpired: file:" + a.this.filename + " nowlen:" + l + " oldoff:" + a.this.hUb);
        if (a.this.doScene(a.this.dispatcher(), a.this.callback) == -1) {
          a.this.callback.onSceneEnd(3, -1, "doScene failed", a.this);
        }
        AppMethodBeat.o(148370);
        return false;
      }
    }, true);
    this.hTZ = bs.eWj();
    this.filename = paramString;
    this.hUc = paramInt1;
    this.sampleRate = paramInt2;
    this.hUa = paramInt3;
    this.audioFormat = paramInt4;
    paramInt1 = (int)i.aSp(this.filename);
    this.filemd5 = com.tencent.mm.b.g.getMessageDigest(i.aU(this.filename, 0, paramInt1));
    AppMethodBeat.o(148371);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    int i = 3960;
    AppMethodBeat.i(148372);
    this.callback = paramg;
    int k = (int)i.aSp(this.filename);
    ac.d("MicroMsg.NetSceneUploadMedia", f.YG() + " read file:" + this.filename + " filelen:" + k + " oldoff:" + this.hUb + "this.filemd5 " + this.filemd5);
    if (k <= 0)
    {
      ac.e("MicroMsg.NetSceneUploadMedia", "read failed :" + this.filename);
      AppMethodBeat.o(148372);
      return -1;
    }
    int j = k - this.hUb;
    if (j > 3960) {}
    for (;;)
    {
      ac.i("MicroMsg.NetSceneUploadMedia", f.YG() + " read file:" + this.filename + " filelen:" + k + " oldoff:" + this.hUb + "  canReadLen " + i);
      paramg = i.aU(this.filename, this.hUb, i);
      if (paramg == null)
      {
        ac.e("MicroMsg.NetSceneUploadMedia", "read data error");
        AppMethodBeat.o(148372);
        return -1;
      }
      Object localObject = new b.a();
      ((b.a)localObject).hvt = new dne();
      ((b.a)localObject).hvu = new dnf();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmuploadmedia";
      ((b.a)localObject).funcId = 240;
      ((b.a)localObject).reqCmdId = 111;
      ((b.a)localObject).respCmdId = 1000000111;
      this.rr = ((b.a)localObject).aAz();
      localObject = (dne)this.rr.hvr.hvw;
      ((dne)localObject).FUM = new crm().aJV(this.hTZ);
      ((dne)localObject).vTK = new SKBuiltinBuffer_t().setBuffer(paramg);
      ((dne)localObject).vTJ = paramg.length;
      ((dne)localObject).FUN = new crm().aJV(this.filemd5);
      ((dne)localObject).vTH = k;
      ((dne)localObject).vTI = this.hUb;
      ((dne)localObject).sVK = this.hUc;
      ((dne)localObject).FUO = 1;
      ((dne)localObject).FUP = this.sampleRate;
      ((dne)localObject).FUQ = this.hUa;
      ((dne)localObject).FUR = this.audioFormat;
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
    ac.d("MicroMsg.NetSceneUploadMedia", f.YG() + " onGYNetEnd file:" + this.filename + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (dne)((b)paramq).hvr.hvw;
    paramq = ((dnf)((b)paramq).hvs.hvw).hOi;
    ac.i("MicroMsg.NetSceneUploadMedia", "fileName:%s, md5:%s, totalLen:%d, dataLen:%d, startPos:%d", new Object[] { this.filename, paramq, Integer.valueOf(paramArrayOfByte.vTH), Integer.valueOf(paramArrayOfByte.vTJ), Integer.valueOf(paramArrayOfByte.vTI) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ac.e("MicroMsg.NetSceneUploadMedia", f.YG() + " onGYNetEnd file:" + this.filename + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148373);
      return;
    }
    if ((paramArrayOfByte.vTH <= paramArrayOfByte.vTJ + paramArrayOfByte.vTI) && (paramq != null) && (!paramq.equals("0")))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148373);
      return;
    }
    paramInt1 = paramArrayOfByte.vTI;
    this.hUb = (paramArrayOfByte.vTK.getILen() + paramInt1);
    ac.d("MicroMsg.NetSceneUploadMedia", "onGYNetEnd file:" + this.filename + " delay:500");
    this.htR.au(500L, 500L);
    AppMethodBeat.o(148373);
  }
  
  public final int securityLimitCount()
  {
    return 60;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hwa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bg.a
 * JD-Core Version:    0.7.0.1
 */