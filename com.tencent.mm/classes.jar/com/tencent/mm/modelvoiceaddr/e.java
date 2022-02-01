package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dhl;
import com.tencent.mm.protocal.protobuf.dhm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.vfs.i;
import java.util.List;

public final class e
  extends a
  implements k
{
  com.tencent.mm.al.g callback;
  private int encodeType;
  String filename;
  av gTs;
  boolean hCh;
  private long hDT;
  private boolean hDU;
  private String[] hDW;
  int htz;
  int retCode;
  private com.tencent.mm.al.b rr;
  
  public e(String paramString, int paramInt)
  {
    AppMethodBeat.i(148531);
    this.retCode = 0;
    this.hCh = false;
    this.htz = 0;
    this.filename = null;
    this.hDT = -1L;
    this.hDU = false;
    this.encodeType = 0;
    this.hDW = new String[0];
    this.gTs = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148530);
        long l = i.aMN(e.this.filename);
        ad.d("MicroMsg.NetSceneVoiceInput", f.XJ() + " onTimerExpired: file:" + e.this.filename + " nowlen:" + l + " oldoff:" + e.this.htz + " isFin:" + e.this.hCh);
        if ((l - e.this.htz < 3300L) && (!e.this.hCh))
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
    this.hDT = bt.eGO().hashCode();
    this.filename = paramString;
    this.encodeType = paramInt;
    AppMethodBeat.o(148531);
  }
  
  public final void aDH()
  {
    this.hCh = true;
  }
  
  public final String[] aDI()
  {
    return this.hDW;
  }
  
  public final long aDJ()
  {
    return this.hDT;
  }
  
  public final int aDK()
  {
    return this.retCode;
  }
  
  public final List<String> aDL()
  {
    return null;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(148532);
    this.callback = paramg;
    int k = (int)i.aMN(this.filename);
    ad.d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %d, isFin: %b", new Object[] { this.filename, Integer.valueOf(k), Integer.valueOf(this.htz), Boolean.valueOf(this.hCh) });
    if (k <= 0)
    {
      ad.e("MicroMsg.NetSceneVoiceInput", "read failed :" + this.filename);
      this.retCode = (f.getLine() + 40000);
      AppMethodBeat.o(148532);
      return -1;
    }
    int j = k - this.htz;
    if (j > 3960) {
      i = 3960;
    }
    for (;;)
    {
      ad.d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %b, isFin:%b, endFlag: %b", new Object[] { this.filename, Integer.valueOf(k), Boolean.valueOf(this.hCh), Boolean.valueOf(this.hCh), Boolean.valueOf(this.hDU) });
      paramg = i.aR(this.filename, this.htz, i);
      if (paramg != null) {
        break;
      }
      ad.e("MicroMsg.NetSceneVoiceInput", f.XJ() + " read failed :" + this.filename + " read:" + i);
      this.retCode = (f.getLine() + 40000);
      AppMethodBeat.o(148532);
      return -1;
      if ((j < 3300) && (!this.hCh))
      {
        ad.e("MicroMsg.NetSceneVoiceInput", f.XJ() + " read failed :" + this.filename + "can read:" + j + " isfinish:" + this.hCh);
        this.retCode = (f.getLine() + 40000);
        AppMethodBeat.o(148532);
        return -1;
      }
      i = j;
      if (this.hCh)
      {
        this.hDU = true;
        i = j;
      }
    }
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new dhl();
    ((b.a)localObject).gUV = new dhm();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
    ((b.a)localObject).funcId = 349;
    ((b.a)localObject).reqCmdId = 158;
    ((b.a)localObject).respCmdId = 1000000158;
    this.rr = ((b.a)localObject).atI();
    localObject = (dhl)this.rr.gUS.gUX;
    ((dhl)localObject).mAQ = ((String)com.tencent.mm.kernel.g.afB().afk().get(2, ""));
    ((dhl)localObject).uKT = new SKBuiltinBuffer_t().setBuffer(paramg);
    ad.d("MicroMsg.NetSceneVoiceInput", f.XJ() + " read file:" + this.filename + " readlen:" + paramg.length + " datalen:" + ((dhl)localObject).uKT.getBuffer().toByteArray().length + " dataiLen:" + ((dhl)localObject).uKT.getILen() + " md5:" + com.tencent.mm.b.g.getMessageDigest(paramg) + " datamd5:" + com.tencent.mm.b.g.getMessageDigest(((dhl)localObject).uKT.getBuffer().toByteArray()));
    ((dhl)localObject).CNt = this.htz;
    ((dhl)localObject).ExD = this.hDT;
    if (this.hDU) {}
    for (int i = 1;; i = 0)
    {
      ((dhl)localObject).hno = i;
      ((dhl)localObject).ExE = 0;
      ((dhl)localObject).CAJ = 0;
      ((dhl)localObject).ExF = this.encodeType;
      ((dhl)localObject).CAG = 0;
      ad.d("MicroMsg.NetSceneVoiceInput", "clientId " + this.hDT);
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
    ad.d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    updateDispatchId(paramInt1);
    paramArrayOfByte = (dhl)((com.tencent.mm.al.b)paramq).gUS.gUX;
    paramq = (dhm)((com.tencent.mm.al.b)paramq).gUT.gUX;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneVoiceInput", f.XJ() + " onGYNetEnd file:" + this.filename + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148534);
      return;
    }
    ad.d("MicroMsg.NetSceneVoiceInput", f.XJ() + " onGYNetEnd  file:" + this.filename + " endflag:" + paramq.hno);
    if (paramArrayOfByte.hno == 1)
    {
      if ((paramq.ExG != null) && (paramq.ExG.getBuffer() != null)) {
        this.hDW = new String[] { paramq.ExG.getBuffer().eBA() };
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148534);
      return;
    }
    paramInt1 = paramArrayOfByte.CNt;
    this.htz = (paramArrayOfByte.uKT.getILen() + paramInt1);
    if (this.hCh) {}
    for (long l = 0L;; l = 500L)
    {
      ad.d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " delay:" + l);
      this.gTs.av(l, l);
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
    return n.b.gVB;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(148533);
    this.callback.onSceneEnd(3, f.getLine() + 40000, "ecurityCheckError", this);
    AppMethodBeat.o(148533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.e
 * JD-Core Version:    0.7.0.1
 */