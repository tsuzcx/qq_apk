package com.tencent.mm.bi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.exy;
import com.tencent.mm.protocal.protobuf.exz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public final class a
  extends q
  implements m
{
  private int audioFormat;
  private i callback;
  private String filemd5;
  String filename;
  MTimerHandler lAo;
  private String mbB;
  private int mbC;
  private int mbD;
  private int mbE;
  private d rr;
  private int sampleRate;
  
  public a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(148371);
    this.mbB = null;
    this.filemd5 = null;
    this.filename = null;
    this.sampleRate = 0;
    this.mbC = 0;
    this.audioFormat = 0;
    this.mbD = 0;
    this.mbE = 5;
    this.lAo = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148370);
        long l = u.bBQ(a.a(a.this));
        Log.d("MicroMsg.NetSceneUploadMedia", f.avD() + " onTimerExpired: file:" + a.a(a.this) + " nowlen:" + l + " oldoff:" + a.b(a.this));
        if (a.this.doScene(a.c(a.this), a.d(a.this)) == -1) {
          a.d(a.this).onSceneEnd(3, -1, "doScene failed", a.this);
        }
        AppMethodBeat.o(148370);
        return false;
      }
    }, true);
    this.mbB = Util.nowMilliSecond();
    this.filename = paramString;
    this.mbE = paramInt1;
    this.sampleRate = paramInt2;
    this.mbC = paramInt3;
    this.audioFormat = paramInt4;
    paramInt1 = (int)u.bBQ(this.filename);
    this.filemd5 = com.tencent.mm.b.g.getMessageDigest(u.aY(this.filename, 0, paramInt1));
    AppMethodBeat.o(148371);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    int i = 3960;
    AppMethodBeat.i(148372);
    this.callback = parami;
    int k = (int)u.bBQ(this.filename);
    Log.d("MicroMsg.NetSceneUploadMedia", f.avD() + " read file:" + this.filename + " filelen:" + k + " oldoff:" + this.mbD + "this.filemd5 " + this.filemd5);
    if (k <= 0)
    {
      Log.e("MicroMsg.NetSceneUploadMedia", "read failed :" + this.filename);
      AppMethodBeat.o(148372);
      return -1;
    }
    int j = k - this.mbD;
    if (j > 3960) {}
    for (;;)
    {
      Log.i("MicroMsg.NetSceneUploadMedia", f.avD() + " read file:" + this.filename + " filelen:" + k + " oldoff:" + this.mbD + "  canReadLen " + i);
      parami = u.aY(this.filename, this.mbD, i);
      if (parami == null)
      {
        Log.e("MicroMsg.NetSceneUploadMedia", "read data error");
        AppMethodBeat.o(148372);
        return -1;
      }
      Object localObject = new d.a();
      ((d.a)localObject).lBU = new exy();
      ((d.a)localObject).lBV = new exz();
      ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/mmuploadmedia";
      ((d.a)localObject).funcId = 240;
      ((d.a)localObject).lBW = 111;
      ((d.a)localObject).respCmdId = 1000000111;
      this.rr = ((d.a)localObject).bgN();
      localObject = (exy)d.b.b(this.rr.lBR);
      ((exy)localObject).Uyf = new eaf().btQ(this.mbB);
      ((exy)localObject).Hnc = new eae().dc(parami);
      ((exy)localObject).Hnb = parami.length;
      ((exy)localObject).Uyg = new eaf().btQ(this.filemd5);
      ((exy)localObject).HmZ = k;
      ((exy)localObject).Hna = this.mbD;
      ((exy)localObject).Crm = this.mbE;
      ((exy)localObject).Uyh = 1;
      ((exy)localObject).Uyi = this.sampleRate;
      ((exy)localObject).Uyj = this.mbC;
      ((exy)localObject).Uyk = this.audioFormat;
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(148372);
      return i;
      i = j;
    }
  }
  
  public final int getType()
  {
    return 240;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148373);
    updateDispatchId(paramInt1);
    Log.d("MicroMsg.NetSceneUploadMedia", f.avD() + " onGYNetEnd file:" + this.filename + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (exy)d.b.b(((d)params).lBR);
    params = ((exz)d.c.b(((d)params).lBS)).lVJ;
    Log.i("MicroMsg.NetSceneUploadMedia", "fileName:%s, md5:%s, totalLen:%d, dataLen:%d, startPos:%d", new Object[] { this.filename, params, Integer.valueOf(paramArrayOfByte.HmZ), Integer.valueOf(paramArrayOfByte.Hnb), Integer.valueOf(paramArrayOfByte.Hna) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneUploadMedia", f.avD() + " onGYNetEnd file:" + this.filename + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148373);
      return;
    }
    if ((paramArrayOfByte.HmZ <= paramArrayOfByte.Hnb + paramArrayOfByte.Hna) && (params != null) && (!params.equals("0")))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148373);
      return;
    }
    paramInt1 = paramArrayOfByte.Hna;
    this.mbD = (paramArrayOfByte.Hnc.Ufv + paramInt1);
    Log.d("MicroMsg.NetSceneUploadMedia", "onGYNetEnd file:" + this.filename + " delay:500");
    this.lAo.startTimer(500L);
    AppMethodBeat.o(148373);
  }
  
  public final int securityLimitCount()
  {
    return 60;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bi.a
 * JD-Core Version:    0.7.0.1
 */