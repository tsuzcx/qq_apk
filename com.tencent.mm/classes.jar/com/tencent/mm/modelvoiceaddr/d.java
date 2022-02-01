package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.fcp;
import com.tencent.mm.protocal.protobuf.fcq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.vfs.u;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends a
  implements m
{
  private i callback;
  private String filename;
  MTimerHandler lAo;
  private long lUh;
  private int mbD;
  private boolean mjP;
  private boolean mlB;
  private int mlC;
  private String[] mlD;
  private int retCode;
  private com.tencent.mm.an.d rr;
  
  public d(String paramString, int paramInt)
  {
    AppMethodBeat.i(148526);
    this.retCode = 0;
    this.mbD = 0;
    this.filename = null;
    this.lUh = -1L;
    this.mlB = false;
    this.mjP = false;
    this.mlD = new String[0];
    this.lAo = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148525);
        long l = u.bBQ(d.a(d.this));
        Log.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.avD() + " onTimerExpired: file:" + d.a(d.this) + " nowlen:" + l + " oldoff:" + d.b(d.this) + " isFin:" + d.c(d.this));
        if ((l - d.b(d.this) < 3300L) && (!d.c(d.this)))
        {
          AppMethodBeat.o(148525);
          return true;
        }
        if (d.this.doScene(d.d(d.this), d.e(d.this)) == -1)
        {
          d.a(d.this, com.tencent.mm.compatible.util.f.getLine() + 40000);
          d.e(d.this).onSceneEnd(3, -1, "doScene failed", d.this);
        }
        AppMethodBeat.o(148525);
        return false;
      }
    }, true);
    this.lUh = Util.nowMilliSecond();
    this.filename = paramString;
    this.mlC = paramInt;
    AppMethodBeat.o(148526);
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
    AppMethodBeat.i(148527);
    this.callback = parami;
    long l = u.bBQ(this.filename);
    Log.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.avD() + " read file:" + this.filename + " filelen:" + l + " oldoff:" + this.mbD + " isFin:" + this.mjP);
    if (l <= 0L)
    {
      Log.e("MicroMsg.NetSceneVoiceAddr", "read failed :" + this.filename);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 40000);
      AppMethodBeat.o(148527);
      return -1;
    }
    int j = (int)(l - this.mbD);
    if (j > 3960) {
      i = 3960;
    }
    for (;;)
    {
      Log.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.avD() + " read file:" + this.filename + " filelen:" + l + " oldoff:" + this.mbD + " isFin:" + this.mjP + " endFlag:" + this.mlB);
      parami = u.aY(this.filename, this.mbD, i);
      if (parami != null) {
        break;
      }
      Log.e("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.avD() + " read failed :" + this.filename + " read:" + i);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 40000);
      AppMethodBeat.o(148527);
      return -1;
      if ((j < 3300) && (!this.mjP))
      {
        Log.e("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.avD() + " read failed :" + this.filename + "can read:" + j + " isfinish:" + this.mjP);
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 40000);
        AppMethodBeat.o(148527);
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
    ((d.a)localObject).lBU = new fcp();
    ((d.a)localObject).lBV = new fcq();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/voiceaddr";
    ((d.a)localObject).funcId = 206;
    ((d.a)localObject).lBW = 94;
    ((d.a)localObject).respCmdId = 1000000094;
    this.rr = ((d.a)localObject).bgN();
    localObject = (fcp)d.b.b(this.rr.lBR);
    ((fcp)localObject).Hnc = new eae().dc(parami);
    Log.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.avD() + " read file:" + this.filename + " readlen:" + parami.length + " datalen:" + ((fcp)localObject).Hnc.Tkb.toByteArray().length + " dataiLen:" + ((fcp)localObject).Hnc.Ufv + " md5:" + com.tencent.mm.b.g.getMessageDigest(parami) + " datamd5:" + com.tencent.mm.b.g.getMessageDigest(((fcp)localObject).Hnc.Tkb.toByteArray()));
    ((fcp)localObject).UserName = ((String)h.aHG().aHp().b(2, ""));
    ((fcp)localObject).Sat = this.mbD;
    ((fcp)localObject).UxY = this.lUh;
    if (this.mlB) {}
    for (int i = 1;; i = 0)
    {
      ((fcp)localObject).lVs = i;
      ((fcp)localObject).UxZ = 0;
      ((fcp)localObject).RLv = 0;
      ((fcp)localObject).Uya = 0;
      ((fcp)localObject).RLs = 0;
      ((fcp)localObject).UCo = this.mlC;
      Log.d("MicroMsg.NetSceneVoiceAddr", "clientId " + this.lUh);
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(148527);
      return i;
    }
  }
  
  public final int getType()
  {
    return 206;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148529);
    Log.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.avD() + " onGYNetEnd file:" + this.filename + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    updateDispatchId(paramInt1);
    paramArrayOfByte = (fcp)d.b.b(((com.tencent.mm.an.d)params).lBR);
    params = (fcq)d.c.b(((com.tencent.mm.an.d)params).lBS);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.avD() + " onGYNetEnd file:" + this.filename + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148529);
      return;
    }
    Log.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.avD() + " onGYNetEnd  file:" + this.filename + " endflag:" + params.lVs + " lst:" + params.RIj);
    if (paramArrayOfByte.lVs == 1)
    {
      this.mlD = new String[params.RIj.size()];
      paramInt1 = 0;
      while (paramInt1 < params.RIj.size())
      {
        this.mlD[paramInt1] = ((eaf)params.RIj.get(paramInt1)).Ufy;
        paramInt1 += 1;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148529);
      return;
    }
    paramInt1 = paramArrayOfByte.Sat;
    this.mbD = (paramArrayOfByte.Hnc.Ufv + paramInt1);
    if (this.mjP) {}
    for (long l = 0L;; l = 500L)
    {
      Log.d("MicroMsg.NetSceneVoiceAddr", "onGYNetEnd file:" + this.filename + " delay:" + l);
      this.lAo.startTimer(l);
      AppMethodBeat.o(148529);
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
    AppMethodBeat.i(148528);
    this.callback.onSceneEnd(3, com.tencent.mm.compatible.util.f.getLine() + 40000, "ecurityCheckError", this);
    AppMethodBeat.o(148528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.d
 * JD-Core Version:    0.7.0.1
 */