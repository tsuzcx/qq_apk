package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q.a;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.bw.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.ese;
import com.tencent.mm.protocal.protobuf.esf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends a
  implements m
{
  i callback;
  String filename;
  MTimerHandler iKj;
  private long jdI;
  int jlB;
  boolean jul;
  private boolean jvY;
  private int jvZ;
  private String[] jwa;
  int retCode;
  private com.tencent.mm.ak.d rr;
  
  public d(String paramString, int paramInt)
  {
    AppMethodBeat.i(148526);
    this.retCode = 0;
    this.jlB = 0;
    this.filename = null;
    this.jdI = -1L;
    this.jvY = false;
    this.jul = false;
    this.jwa = new String[0];
    this.iKj = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148525);
        long l = com.tencent.mm.vfs.s.boW(d.this.filename);
        Log.d("MicroMsg.NetSceneVoiceAddr", f.apq() + " onTimerExpired: file:" + d.this.filename + " nowlen:" + l + " oldoff:" + d.this.jlB + " isFin:" + d.this.jul);
        if ((l - d.this.jlB < 3300L) && (!d.this.jul))
        {
          AppMethodBeat.o(148525);
          return true;
        }
        if (d.this.doScene(d.this.dispatcher(), d.this.callback) == -1)
        {
          d.this.retCode = (f.getLine() + 40000);
          d.this.callback.onSceneEnd(3, -1, "doScene failed", d.this);
        }
        AppMethodBeat.o(148525);
        return false;
      }
    }, true);
    this.jdI = Util.nowMilliSecond();
    this.filename = paramString;
    this.jvZ = paramInt;
    AppMethodBeat.o(148526);
  }
  
  public final void bim()
  {
    this.jul = true;
  }
  
  public final String[] bin()
  {
    return this.jwa;
  }
  
  public final long bio()
  {
    return this.jdI;
  }
  
  public final int bip()
  {
    return this.retCode;
  }
  
  public final List<String> biq()
  {
    return null;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(148527);
    this.callback = parami;
    long l = com.tencent.mm.vfs.s.boW(this.filename);
    Log.d("MicroMsg.NetSceneVoiceAddr", f.apq() + " read file:" + this.filename + " filelen:" + l + " oldoff:" + this.jlB + " isFin:" + this.jul);
    if (l <= 0L)
    {
      Log.e("MicroMsg.NetSceneVoiceAddr", "read failed :" + this.filename);
      this.retCode = (f.getLine() + 40000);
      AppMethodBeat.o(148527);
      return -1;
    }
    int j = (int)(l - this.jlB);
    if (j > 3960) {
      i = 3960;
    }
    for (;;)
    {
      Log.d("MicroMsg.NetSceneVoiceAddr", f.apq() + " read file:" + this.filename + " filelen:" + l + " oldoff:" + this.jlB + " isFin:" + this.jul + " endFlag:" + this.jvY);
      parami = com.tencent.mm.vfs.s.aW(this.filename, this.jlB, i);
      if (parami != null) {
        break;
      }
      Log.e("MicroMsg.NetSceneVoiceAddr", f.apq() + " read failed :" + this.filename + " read:" + i);
      this.retCode = (f.getLine() + 40000);
      AppMethodBeat.o(148527);
      return -1;
      if ((j < 3300) && (!this.jul))
      {
        Log.e("MicroMsg.NetSceneVoiceAddr", f.apq() + " read failed :" + this.filename + "can read:" + j + " isfinish:" + this.jul);
        this.retCode = (f.getLine() + 40000);
        AppMethodBeat.o(148527);
        return -1;
      }
      i = j;
      if (this.jul)
      {
        this.jvY = true;
        i = j;
      }
    }
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ese();
    ((d.a)localObject).iLO = new esf();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/voiceaddr";
    ((d.a)localObject).funcId = 206;
    ((d.a)localObject).iLP = 94;
    ((d.a)localObject).respCmdId = 1000000094;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ese)this.rr.iLK.iLR;
    ((ese)localObject).BsI = new SKBuiltinBuffer_t().setBuffer(parami);
    Log.d("MicroMsg.NetSceneVoiceAddr", f.apq() + " read file:" + this.filename + " readlen:" + parami.length + " datalen:" + ((ese)localObject).BsI.getBuffer().toByteArray().length + " dataiLen:" + ((ese)localObject).BsI.getILen() + " md5:" + com.tencent.mm.b.g.getMessageDigest(parami) + " datamd5:" + com.tencent.mm.b.g.getMessageDigest(((ese)localObject).BsI.getBuffer().toByteArray()));
    ((ese)localObject).UserName = ((String)com.tencent.mm.kernel.g.aAh().azQ().get(2, ""));
    ((ese)localObject).KZk = this.jlB;
    ((ese)localObject).Nln = this.jdI;
    if (this.jvY) {}
    for (int i = 1;; i = 0)
    {
      ((ese)localObject).jeU = i;
      ((ese)localObject).Nlo = 0;
      ((ese)localObject).KKD = 0;
      ((ese)localObject).Nlp = 0;
      ((ese)localObject).KKA = 0;
      ((ese)localObject).Nps = this.jvZ;
      Log.d("MicroMsg.NetSceneVoiceAddr", "clientId " + this.jdI);
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(148527);
      return i;
    }
  }
  
  public final int getType()
  {
    return 206;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148529);
    Log.d("MicroMsg.NetSceneVoiceAddr", f.apq() + " onGYNetEnd file:" + this.filename + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    updateDispatchId(paramInt1);
    paramArrayOfByte = (ese)((com.tencent.mm.ak.d)params).iLK.iLR;
    params = (esf)((com.tencent.mm.ak.d)params).iLL.iLR;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneVoiceAddr", f.apq() + " onGYNetEnd file:" + this.filename + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148529);
      return;
    }
    Log.d("MicroMsg.NetSceneVoiceAddr", f.apq() + " onGYNetEnd  file:" + this.filename + " endflag:" + params.jeU + " lst:" + params.KGP);
    if (paramArrayOfByte.jeU == 1)
    {
      this.jwa = new String[params.KGP.size()];
      paramInt1 = 0;
      while (paramInt1 < params.KGP.size())
      {
        this.jwa[paramInt1] = ((dqi)params.KGP.get(paramInt1)).MTo;
        paramInt1 += 1;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148529);
      return;
    }
    paramInt1 = paramArrayOfByte.KZk;
    this.jlB = (paramArrayOfByte.BsI.getILen() + paramInt1);
    if (this.jul) {}
    for (long l = 0L;; l = 500L)
    {
      Log.d("MicroMsg.NetSceneVoiceAddr", "onGYNetEnd file:" + this.filename + " delay:" + l);
      this.iKj.startTimer(l);
      AppMethodBeat.o(148529);
      return;
    }
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return q.b.iMq;
  }
  
  public final void setSecurityCheckError(q.a parama)
  {
    AppMethodBeat.i(148528);
    this.callback.onSceneEnd(3, f.getLine() + 40000, "ecurityCheckError", this);
    AppMethodBeat.o(148528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.d
 * JD-Core Version:    0.7.0.1
 */