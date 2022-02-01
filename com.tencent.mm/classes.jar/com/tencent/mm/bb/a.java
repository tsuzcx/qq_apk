package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.ftr;
import com.tencent.mm.protocal.protobuf.fts;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

public final class a
  extends p
  implements m
{
  private int audioFormat;
  private h callback;
  private String filemd5;
  String filename;
  private String oUw;
  private int oUx;
  private int oUy;
  private int oUz;
  MTimerHandler orP;
  private c rr;
  private int sampleRate;
  
  public a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(148371);
    this.oUw = null;
    this.filemd5 = null;
    this.filename = null;
    this.sampleRate = 0;
    this.oUx = 0;
    this.audioFormat = 0;
    this.oUy = 0;
    this.oUz = 5;
    this.orP = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148370);
        long l = y.bEl(a.a(a.this));
        Log.d("MicroMsg.NetSceneUploadMedia", f.aPX() + " onTimerExpired: file:" + a.a(a.this) + " nowlen:" + l + " oldoff:" + a.b(a.this));
        if (a.this.doScene(a.c(a.this), a.d(a.this)) == -1) {
          a.d(a.this).onSceneEnd(3, -1, "doScene failed", a.this);
        }
        AppMethodBeat.o(148370);
        return false;
      }
    }, true);
    this.oUw = Util.nowMilliSecond();
    this.filename = paramString;
    this.oUz = paramInt1;
    this.sampleRate = paramInt2;
    this.oUx = paramInt3;
    this.audioFormat = paramInt4;
    paramInt1 = (int)y.bEl(this.filename);
    this.filemd5 = com.tencent.mm.b.g.getMessageDigest(y.bi(this.filename, 0, paramInt1));
    AppMethodBeat.o(148371);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    int i = 3960;
    AppMethodBeat.i(148372);
    this.callback = paramh;
    int k = (int)y.bEl(this.filename);
    Log.d("MicroMsg.NetSceneUploadMedia", f.aPX() + " read file:" + this.filename + " filelen:" + k + " oldoff:" + this.oUy + "this.filemd5 " + this.filemd5);
    if (k <= 0)
    {
      Log.e("MicroMsg.NetSceneUploadMedia", "read failed :" + this.filename);
      AppMethodBeat.o(148372);
      return -1;
    }
    int j = k - this.oUy;
    if (j > 3960) {}
    for (;;)
    {
      Log.i("MicroMsg.NetSceneUploadMedia", f.aPX() + " read file:" + this.filename + " filelen:" + k + " oldoff:" + this.oUy + "  canReadLen " + i);
      paramh = y.bi(this.filename, this.oUy, i);
      if (paramh == null)
      {
        Log.e("MicroMsg.NetSceneUploadMedia", "read data error");
        AppMethodBeat.o(148372);
        return -1;
      }
      Object localObject = new c.a();
      ((c.a)localObject).otE = new ftr();
      ((c.a)localObject).otF = new fts();
      ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/mmuploadmedia";
      ((c.a)localObject).funcId = 240;
      ((c.a)localObject).otG = 111;
      ((c.a)localObject).respCmdId = 1000000111;
      this.rr = ((c.a)localObject).bEF();
      localObject = (ftr)c.b.b(this.rr.otB);
      ((ftr)localObject).abRM = new etl().btH(this.oUw);
      ((ftr)localObject).NkQ = new gol().df(paramh);
      ((ftr)localObject).NkP = paramh.length;
      ((ftr)localObject).abRN = new etl().btH(this.filemd5);
      ((ftr)localObject).NkN = k;
      ((ftr)localObject).NkO = this.oUy;
      ((ftr)localObject).Idt = this.oUz;
      ((ftr)localObject).abRO = 1;
      ((ftr)localObject).abRP = this.sampleRate;
      ((ftr)localObject).abRQ = this.oUx;
      ((ftr)localObject).abRR = this.audioFormat;
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
    Log.d("MicroMsg.NetSceneUploadMedia", f.aPX() + " onGYNetEnd file:" + this.filename + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (ftr)c.b.b(((c)params).otB);
    params = ((fts)c.c.b(((c)params).otC)).oOL;
    Log.i("MicroMsg.NetSceneUploadMedia", "fileName:%s, md5:%s, totalLen:%d, dataLen:%d, startPos:%d", new Object[] { this.filename, params, Integer.valueOf(paramArrayOfByte.NkN), Integer.valueOf(paramArrayOfByte.NkP), Integer.valueOf(paramArrayOfByte.NkO) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneUploadMedia", f.aPX() + " onGYNetEnd file:" + this.filename + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148373);
      return;
    }
    if ((paramArrayOfByte.NkN <= paramArrayOfByte.NkP + paramArrayOfByte.NkO) && (params != null) && (!params.equals("0")))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148373);
      return;
    }
    paramInt1 = paramArrayOfByte.NkO;
    this.oUy = (paramArrayOfByte.NkQ.abwJ + paramInt1);
    Log.d("MicroMsg.NetSceneUploadMedia", "onGYNetEnd file:" + this.filename + " delay:500");
    this.orP.startTimer(500L);
    AppMethodBeat.o(148373);
  }
  
  public final int securityLimitCount()
  {
    return 60;
  }
  
  public final p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bb.a
 * JD-Core Version:    0.7.0.1
 */