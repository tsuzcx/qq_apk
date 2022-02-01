package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q.a;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.bw.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.enm;
import com.tencent.mm.protocal.protobuf.enn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.util.List;

public final class e
  extends a
  implements m
{
  i callback;
  private int encodeType;
  String filename;
  MTimerHandler iKj;
  private long jdI;
  int jlB;
  boolean jul;
  private boolean jvY;
  private String[] jwa;
  int retCode;
  private d rr;
  
  public e(String paramString, int paramInt)
  {
    AppMethodBeat.i(148531);
    this.retCode = 0;
    this.jul = false;
    this.jlB = 0;
    this.filename = null;
    this.jdI = -1L;
    this.jvY = false;
    this.encodeType = 0;
    this.jwa = new String[0];
    this.iKj = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148530);
        long l = com.tencent.mm.vfs.s.boW(e.this.filename);
        Log.d("MicroMsg.NetSceneVoiceInput", f.apq() + " onTimerExpired: file:" + e.this.filename + " nowlen:" + l + " oldoff:" + e.this.jlB + " isFin:" + e.this.jul);
        if ((l - e.this.jlB < 3300L) && (!e.this.jul))
        {
          AppMethodBeat.o(148530);
          return true;
        }
        if (e.this.doScene(e.this.dispatcher(), e.this.callback) == -1)
        {
          e.this.retCode = (f.getLine() + 40000);
          e.this.callback.onSceneEnd(3, -1, "doScene failed", e.this);
        }
        AppMethodBeat.o(148530);
        return false;
      }
    }, true);
    this.jdI = Util.nowMilliSecond().hashCode();
    this.filename = paramString;
    this.encodeType = paramInt;
    AppMethodBeat.o(148531);
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
    AppMethodBeat.i(148532);
    this.callback = parami;
    int k = (int)com.tencent.mm.vfs.s.boW(this.filename);
    Log.d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %d, isFin: %b", new Object[] { this.filename, Integer.valueOf(k), Integer.valueOf(this.jlB), Boolean.valueOf(this.jul) });
    if (k <= 0)
    {
      Log.e("MicroMsg.NetSceneVoiceInput", "read failed :" + this.filename);
      this.retCode = (f.getLine() + 40000);
      AppMethodBeat.o(148532);
      return -1;
    }
    int j = k - this.jlB;
    if (j > 3960) {
      i = 3960;
    }
    for (;;)
    {
      Log.d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %b, isFin:%b, endFlag: %b", new Object[] { this.filename, Integer.valueOf(k), Boolean.valueOf(this.jul), Boolean.valueOf(this.jul), Boolean.valueOf(this.jvY) });
      parami = com.tencent.mm.vfs.s.aW(this.filename, this.jlB, i);
      if (parami != null) {
        break;
      }
      Log.e("MicroMsg.NetSceneVoiceInput", f.apq() + " read failed :" + this.filename + " read:" + i);
      this.retCode = (f.getLine() + 40000);
      AppMethodBeat.o(148532);
      return -1;
      if ((j < 3300) && (!this.jul))
      {
        Log.e("MicroMsg.NetSceneVoiceInput", f.apq() + " read failed :" + this.filename + "can read:" + j + " isfinish:" + this.jul);
        this.retCode = (f.getLine() + 40000);
        AppMethodBeat.o(148532);
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
    ((d.a)localObject).iLN = new enm();
    ((d.a)localObject).iLO = new enn();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
    ((d.a)localObject).funcId = 349;
    ((d.a)localObject).iLP = 158;
    ((d.a)localObject).respCmdId = 1000000158;
    this.rr = ((d.a)localObject).aXF();
    localObject = (enm)this.rr.iLK.iLR;
    ((enm)localObject).UserName = ((String)com.tencent.mm.kernel.g.aAh().azQ().get(2, ""));
    ((enm)localObject).BsI = new SKBuiltinBuffer_t().setBuffer(parami);
    Log.d("MicroMsg.NetSceneVoiceInput", f.apq() + " read file:" + this.filename + " readlen:" + parami.length + " datalen:" + ((enm)localObject).BsI.getBuffer().toByteArray().length + " dataiLen:" + ((enm)localObject).BsI.getILen() + " md5:" + com.tencent.mm.b.g.getMessageDigest(parami) + " datamd5:" + com.tencent.mm.b.g.getMessageDigest(((enm)localObject).BsI.getBuffer().toByteArray()));
    ((enm)localObject).KZk = this.jlB;
    ((enm)localObject).Nln = this.jdI;
    if (this.jvY) {}
    for (int i = 1;; i = 0)
    {
      ((enm)localObject).jeU = i;
      ((enm)localObject).Nlo = 0;
      ((enm)localObject).KKD = 0;
      ((enm)localObject).Nlp = this.encodeType;
      ((enm)localObject).KKA = 0;
      Log.d("MicroMsg.NetSceneVoiceInput", "clientId " + this.jdI);
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(148532);
      return i;
    }
  }
  
  public final int getType()
  {
    return 349;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148534);
    Log.d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    updateDispatchId(paramInt1);
    paramArrayOfByte = (enm)((d)params).iLK.iLR;
    params = (enn)((d)params).iLL.iLR;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneVoiceInput", f.apq() + " onGYNetEnd file:" + this.filename + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148534);
      return;
    }
    Log.d("MicroMsg.NetSceneVoiceInput", f.apq() + " onGYNetEnd  file:" + this.filename + " endflag:" + params.jeU);
    if (paramArrayOfByte.jeU == 1)
    {
      if ((params.Nlq != null) && (params.Nlq.getBuffer() != null)) {
        this.jwa = new String[] { params.Nlq.getBuffer().yO() };
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148534);
      return;
    }
    paramInt1 = paramArrayOfByte.KZk;
    this.jlB = (paramArrayOfByte.BsI.getILen() + paramInt1);
    if (this.jul) {}
    for (long l = 0L;; l = 500L)
    {
      Log.d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " delay:" + l);
      this.iKj.startTimer(l);
      AppMethodBeat.o(148534);
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
    AppMethodBeat.i(148533);
    this.callback.onSceneEnd(3, f.getLine() + 40000, "ecurityCheckError", this);
    AppMethodBeat.o(148533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.e
 * JD-Core Version:    0.7.0.1
 */