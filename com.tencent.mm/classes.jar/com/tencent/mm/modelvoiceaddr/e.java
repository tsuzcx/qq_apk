package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dto;
import com.tencent.mm.protocal.protobuf.dtp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.vfs.o;
import java.util.List;

public final class e
  extends a
  implements k
{
  com.tencent.mm.ak.f callback;
  private int encodeType;
  String filename;
  aw hPc;
  private boolean iAJ;
  private String[] iAL;
  private long iiN;
  int iqq;
  boolean iyX;
  int retCode;
  private com.tencent.mm.ak.b rr;
  
  public e(String paramString, int paramInt)
  {
    AppMethodBeat.i(148531);
    this.retCode = 0;
    this.iyX = false;
    this.iqq = 0;
    this.filename = null;
    this.iiN = -1L;
    this.iAJ = false;
    this.encodeType = 0;
    this.iAL = new String[0];
    this.hPc = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148530);
        long l = o.aZR(e.this.filename);
        ae.d("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.f.abr() + " onTimerExpired: file:" + e.this.filename + " nowlen:" + l + " oldoff:" + e.this.iqq + " isFin:" + e.this.iyX);
        if ((l - e.this.iqq < 3300L) && (!e.this.iyX))
        {
          AppMethodBeat.o(148530);
          return true;
        }
        if (e.this.doScene(e.this.dispatcher(), e.this.callback) == -1)
        {
          e.this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 40000);
          e.this.callback.onSceneEnd(3, -1, "doScene failed", e.this);
        }
        AppMethodBeat.o(148530);
        return false;
      }
    }, true);
    this.iiN = bu.fpO().hashCode();
    this.filename = paramString;
    this.encodeType = paramInt;
    AppMethodBeat.o(148531);
  }
  
  public final void aOf()
  {
    this.iyX = true;
  }
  
  public final String[] aOg()
  {
    return this.iAL;
  }
  
  public final long aOh()
  {
    return this.iiN;
  }
  
  public final int aOi()
  {
    return this.retCode;
  }
  
  public final List<String> aOj()
  {
    return null;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(148532);
    this.callback = paramf;
    int k = (int)o.aZR(this.filename);
    ae.d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %d, isFin: %b", new Object[] { this.filename, Integer.valueOf(k), Integer.valueOf(this.iqq), Boolean.valueOf(this.iyX) });
    if (k <= 0)
    {
      ae.e("MicroMsg.NetSceneVoiceInput", "read failed :" + this.filename);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 40000);
      AppMethodBeat.o(148532);
      return -1;
    }
    int j = k - this.iqq;
    if (j > 3960) {
      i = 3960;
    }
    for (;;)
    {
      ae.d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %b, isFin:%b, endFlag: %b", new Object[] { this.filename, Integer.valueOf(k), Boolean.valueOf(this.iyX), Boolean.valueOf(this.iyX), Boolean.valueOf(this.iAJ) });
      paramf = o.bb(this.filename, this.iqq, i);
      if (paramf != null) {
        break;
      }
      ae.e("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.f.abr() + " read failed :" + this.filename + " read:" + i);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 40000);
      AppMethodBeat.o(148532);
      return -1;
      if ((j < 3300) && (!this.iyX))
      {
        ae.e("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.f.abr() + " read failed :" + this.filename + "can read:" + j + " isfinish:" + this.iyX);
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 40000);
        AppMethodBeat.o(148532);
        return -1;
      }
      i = j;
      if (this.iyX)
      {
        this.iAJ = true;
        i = j;
      }
    }
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dto();
    ((b.a)localObject).hQG = new dtp();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
    ((b.a)localObject).funcId = 349;
    ((b.a)localObject).hQH = 158;
    ((b.a)localObject).respCmdId = 1000000158;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dto)this.rr.hQD.hQJ;
    ((dto)localObject).nIJ = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(2, ""));
    ((dto)localObject).xsE = new SKBuiltinBuffer_t().setBuffer(paramf);
    ae.d("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.f.abr() + " read file:" + this.filename + " readlen:" + paramf.length + " datalen:" + ((dto)localObject).xsE.getBuffer().toByteArray().length + " dataiLen:" + ((dto)localObject).xsE.getILen() + " md5:" + com.tencent.mm.b.g.getMessageDigest(paramf) + " datamd5:" + com.tencent.mm.b.g.getMessageDigest(((dto)localObject).xsE.getBuffer().toByteArray()));
    ((dto)localObject).GeT = this.iqq;
    ((dto)localObject).HZg = this.iiN;
    if (this.iAJ) {}
    for (int i = 1;; i = 0)
    {
      ((dto)localObject).ijY = i;
      ((dto)localObject).HZh = 0;
      ((dto)localObject).FQW = 0;
      ((dto)localObject).HZi = this.encodeType;
      ((dto)localObject).FQT = 0;
      ae.d("MicroMsg.NetSceneVoiceInput", "clientId " + this.iiN);
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(148532);
      return i;
    }
  }
  
  public final int getType()
  {
    return 349;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148534);
    ae.d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    updateDispatchId(paramInt1);
    paramArrayOfByte = (dto)((com.tencent.mm.ak.b)paramq).hQD.hQJ;
    paramq = (dtp)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ae.e("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.f.abr() + " onGYNetEnd file:" + this.filename + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148534);
      return;
    }
    ae.d("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.f.abr() + " onGYNetEnd  file:" + this.filename + " endflag:" + paramq.ijY);
    if (paramArrayOfByte.ijY == 1)
    {
      if ((paramq.HZj != null) && (paramq.HZj.getBuffer() != null)) {
        this.iAL = new String[] { paramq.HZj.getBuffer().fjO() };
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148534);
      return;
    }
    paramInt1 = paramArrayOfByte.GeT;
    this.iqq = (paramArrayOfByte.xsE.getILen() + paramInt1);
    if (this.iyX) {}
    for (long l = 0L;; l = 500L)
    {
      ae.d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " delay:" + l);
      this.hPc.ay(l, l);
      AppMethodBeat.o(148534);
      return;
    }
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hRi;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(148533);
    this.callback.onSceneEnd(3, com.tencent.mm.compatible.util.f.getLine() + 40000, "ecurityCheckError", this);
    AppMethodBeat.o(148533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.e
 * JD-Core Version:    0.7.0.1
 */