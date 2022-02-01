package com.tencent.mm.bg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.enq;
import com.tencent.mm.protocal.protobuf.enr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  extends q
  implements m
{
  private int audioFormat;
  i callback;
  private String filemd5;
  String filename;
  MTimerHandler iKj;
  private int jlA;
  int jlB;
  private int jlC;
  private String jlz;
  private d rr;
  private int sampleRate;
  
  public a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(148371);
    this.jlz = null;
    this.filemd5 = null;
    this.filename = null;
    this.sampleRate = 0;
    this.jlA = 0;
    this.audioFormat = 0;
    this.jlB = 0;
    this.jlC = 5;
    this.iKj = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148370);
        long l = com.tencent.mm.vfs.s.boW(a.this.filename);
        Log.d("MicroMsg.NetSceneUploadMedia", f.apq() + " onTimerExpired: file:" + a.this.filename + " nowlen:" + l + " oldoff:" + a.this.jlB);
        if (a.this.doScene(a.this.dispatcher(), a.this.callback) == -1) {
          a.this.callback.onSceneEnd(3, -1, "doScene failed", a.this);
        }
        AppMethodBeat.o(148370);
        return false;
      }
    }, true);
    this.jlz = Util.nowMilliSecond();
    this.filename = paramString;
    this.jlC = paramInt1;
    this.sampleRate = paramInt2;
    this.jlA = paramInt3;
    this.audioFormat = paramInt4;
    paramInt1 = (int)com.tencent.mm.vfs.s.boW(this.filename);
    this.filemd5 = com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.vfs.s.aW(this.filename, 0, paramInt1));
    AppMethodBeat.o(148371);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    int i = 3960;
    AppMethodBeat.i(148372);
    this.callback = parami;
    int k = (int)com.tencent.mm.vfs.s.boW(this.filename);
    Log.d("MicroMsg.NetSceneUploadMedia", f.apq() + " read file:" + this.filename + " filelen:" + k + " oldoff:" + this.jlB + "this.filemd5 " + this.filemd5);
    if (k <= 0)
    {
      Log.e("MicroMsg.NetSceneUploadMedia", "read failed :" + this.filename);
      AppMethodBeat.o(148372);
      return -1;
    }
    int j = k - this.jlB;
    if (j > 3960) {}
    for (;;)
    {
      Log.i("MicroMsg.NetSceneUploadMedia", f.apq() + " read file:" + this.filename + " filelen:" + k + " oldoff:" + this.jlB + "  canReadLen " + i);
      parami = com.tencent.mm.vfs.s.aW(this.filename, this.jlB, i);
      if (parami == null)
      {
        Log.e("MicroMsg.NetSceneUploadMedia", "read data error");
        AppMethodBeat.o(148372);
        return -1;
      }
      Object localObject = new d.a();
      ((d.a)localObject).iLN = new enq();
      ((d.a)localObject).iLO = new enr();
      ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/mmuploadmedia";
      ((d.a)localObject).funcId = 240;
      ((d.a)localObject).iLP = 111;
      ((d.a)localObject).respCmdId = 1000000111;
      this.rr = ((d.a)localObject).aXF();
      localObject = (enq)this.rr.iLK.iLR;
      ((enq)localObject).Nlu = new dqi().bhy(this.jlz);
      ((enq)localObject).BsI = new SKBuiltinBuffer_t().setBuffer(parami);
      ((enq)localObject).BsH = parami.length;
      ((enq)localObject).Nlv = new dqi().bhy(this.filemd5);
      ((enq)localObject).BsF = k;
      ((enq)localObject).BsG = this.jlB;
      ((enq)localObject).xuT = this.jlC;
      ((enq)localObject).Nlw = 1;
      ((enq)localObject).Nlx = this.sampleRate;
      ((enq)localObject).Nly = this.jlA;
      ((enq)localObject).Nlz = this.audioFormat;
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148373);
    updateDispatchId(paramInt1);
    Log.d("MicroMsg.NetSceneUploadMedia", f.apq() + " onGYNetEnd file:" + this.filename + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (enq)((d)params).iLK.iLR;
    params = ((enr)((d)params).iLL.iLR).jfl;
    Log.i("MicroMsg.NetSceneUploadMedia", "fileName:%s, md5:%s, totalLen:%d, dataLen:%d, startPos:%d", new Object[] { this.filename, params, Integer.valueOf(paramArrayOfByte.BsF), Integer.valueOf(paramArrayOfByte.BsH), Integer.valueOf(paramArrayOfByte.BsG) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneUploadMedia", f.apq() + " onGYNetEnd file:" + this.filename + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148373);
      return;
    }
    if ((paramArrayOfByte.BsF <= paramArrayOfByte.BsH + paramArrayOfByte.BsG) && (params != null) && (!params.equals("0")))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148373);
      return;
    }
    paramInt1 = paramArrayOfByte.BsG;
    this.jlB = (paramArrayOfByte.BsI.getILen() + paramInt1);
    Log.d("MicroMsg.NetSceneUploadMedia", "onGYNetEnd file:" + this.filename + " delay:500");
    this.iKj.startTimer(500L);
    AppMethodBeat.o(148373);
  }
  
  public final int securityLimitCount()
  {
    return 60;
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return q.b.iMq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bg.a
 * JD-Core Version:    0.7.0.1
 */