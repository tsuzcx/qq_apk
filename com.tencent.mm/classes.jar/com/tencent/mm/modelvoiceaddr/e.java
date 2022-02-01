package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q.a;
import com.tencent.mm.an.q.b;
import com.tencent.mm.cd.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.exu;
import com.tencent.mm.protocal.protobuf.exv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.vfs.u;
import java.util.List;

public final class e
  extends a
  implements m
{
  private i callback;
  private int encodeType;
  private String filename;
  MTimerHandler lAo;
  private long lUh;
  private int mbD;
  private boolean mjP;
  private boolean mlB;
  private String[] mlD;
  private int retCode;
  private d rr;
  
  public e(String paramString, int paramInt)
  {
    AppMethodBeat.i(148531);
    this.retCode = 0;
    this.mjP = false;
    this.mbD = 0;
    this.filename = null;
    this.lUh = -1L;
    this.mlB = false;
    this.encodeType = 0;
    this.mlD = new String[0];
    this.lAo = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148530);
        long l = u.bBQ(e.a(e.this));
        Log.d("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.f.avD() + " onTimerExpired: file:" + e.a(e.this) + " nowlen:" + l + " oldoff:" + e.b(e.this) + " isFin:" + e.c(e.this));
        if ((l - e.b(e.this) < 3300L) && (!e.c(e.this)))
        {
          AppMethodBeat.o(148530);
          return true;
        }
        if (e.this.doScene(e.d(e.this), e.e(e.this)) == -1)
        {
          e.a(e.this, com.tencent.mm.compatible.util.f.getLine() + 40000);
          e.e(e.this).onSceneEnd(3, -1, "doScene failed", e.this);
        }
        AppMethodBeat.o(148530);
        return false;
      }
    }, true);
    this.lUh = Util.nowMilliSecond().hashCode();
    this.filename = paramString;
    this.encodeType = paramInt;
    AppMethodBeat.o(148531);
  }
  
  public final void brK()
  {
    this.mjP = true;
  }
  
  public final String[] brL()
  {
    return this.mlD;
  }
  
  public final long brM()
  {
    return this.lUh;
  }
  
  public final int brN()
  {
    return this.retCode;
  }
  
  public final List<String> brO()
  {
    return null;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(148532);
    this.callback = parami;
    int k = (int)u.bBQ(this.filename);
    Log.d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %d, isFin: %b", new Object[] { this.filename, Integer.valueOf(k), Integer.valueOf(this.mbD), Boolean.valueOf(this.mjP) });
    if (k <= 0)
    {
      Log.e("MicroMsg.NetSceneVoiceInput", "read failed :" + this.filename);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 40000);
      AppMethodBeat.o(148532);
      return -1;
    }
    int j = k - this.mbD;
    if (j > 3960) {
      i = 3960;
    }
    for (;;)
    {
      Log.d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %b, isFin:%b, endFlag: %b", new Object[] { this.filename, Integer.valueOf(k), Boolean.valueOf(this.mjP), Boolean.valueOf(this.mjP), Boolean.valueOf(this.mlB) });
      parami = u.aY(this.filename, this.mbD, i);
      if (parami != null) {
        break;
      }
      Log.e("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.f.avD() + " read failed :" + this.filename + " read:" + i);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 40000);
      AppMethodBeat.o(148532);
      return -1;
      if ((j < 3300) && (!this.mjP))
      {
        Log.e("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.f.avD() + " read failed :" + this.filename + "can read:" + j + " isfinish:" + this.mjP);
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 40000);
        AppMethodBeat.o(148532);
        return -1;
      }
      i = j;
      if (this.mjP)
      {
        this.mlB = true;
        i = j;
      }
    }
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new exu();
    ((d.a)localObject).lBV = new exv();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
    ((d.a)localObject).funcId = 349;
    ((d.a)localObject).lBW = 158;
    ((d.a)localObject).respCmdId = 1000000158;
    this.rr = ((d.a)localObject).bgN();
    localObject = (exu)d.b.b(this.rr.lBR);
    ((exu)localObject).UserName = ((String)h.aHG().aHp().b(2, ""));
    ((exu)localObject).Hnc = new eae().dc(parami);
    Log.d("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.f.avD() + " read file:" + this.filename + " readlen:" + parami.length + " datalen:" + ((exu)localObject).Hnc.Tkb.toByteArray().length + " dataiLen:" + ((exu)localObject).Hnc.Ufv + " md5:" + com.tencent.mm.b.g.getMessageDigest(parami) + " datamd5:" + com.tencent.mm.b.g.getMessageDigest(((exu)localObject).Hnc.Tkb.toByteArray()));
    ((exu)localObject).Sat = this.mbD;
    ((exu)localObject).UxY = this.lUh;
    if (this.mlB) {}
    for (int i = 1;; i = 0)
    {
      ((exu)localObject).lVs = i;
      ((exu)localObject).UxZ = 0;
      ((exu)localObject).RLv = 0;
      ((exu)localObject).Uya = this.encodeType;
      ((exu)localObject).RLs = 0;
      Log.d("MicroMsg.NetSceneVoiceInput", "clientId " + this.lUh);
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(148532);
      return i;
    }
  }
  
  public final int getType()
  {
    return 349;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148534);
    Log.d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    updateDispatchId(paramInt1);
    paramArrayOfByte = (exu)d.b.b(((d)params).lBR);
    params = (exv)d.c.b(((d)params).lBS);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.f.avD() + " onGYNetEnd file:" + this.filename + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148534);
      return;
    }
    Log.d("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.f.avD() + " onGYNetEnd  file:" + this.filename + " endflag:" + params.lVs);
    if (paramArrayOfByte.lVs == 1)
    {
      if ((params.Uyb != null) && (params.Uyb.Tkb != null)) {
        this.mlD = new String[] { params.Uyb.Tkb.Ap() };
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148534);
      return;
    }
    paramInt1 = paramArrayOfByte.Sat;
    this.mbD = (paramArrayOfByte.Hnc.Ufv + paramInt1);
    if (this.mjP) {}
    for (long l = 0L;; l = 500L)
    {
      Log.d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " delay:" + l);
      this.lAo.startTimer(l);
      AppMethodBeat.o(148534);
      return;
    }
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
  
  public final void setSecurityCheckError(q.a parama)
  {
    AppMethodBeat.i(148533);
    this.callback.onSceneEnd(3, com.tencent.mm.compatible.util.f.getLine() + 40000, "ecurityCheckError", this);
    AppMethodBeat.o(148533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.e
 * JD-Core Version:    0.7.0.1
 */