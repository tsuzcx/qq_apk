package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.vfs.i;
import java.util.List;

public final class e
  extends a
  implements k
{
  com.tencent.mm.ak.g callback;
  private int encodeType;
  String filename;
  int hUb;
  au htR;
  boolean icI;
  private long iev;
  private boolean iew;
  private String[] iey;
  int retCode;
  private com.tencent.mm.ak.b rr;
  
  public e(String paramString, int paramInt)
  {
    AppMethodBeat.i(148531);
    this.retCode = 0;
    this.icI = false;
    this.hUb = 0;
    this.filename = null;
    this.iev = -1L;
    this.iew = false;
    this.encodeType = 0;
    this.iey = new String[0];
    this.htR = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148530);
        long l = i.aSp(e.this.filename);
        ac.d("MicroMsg.NetSceneVoiceInput", f.YG() + " onTimerExpired: file:" + e.this.filename + " nowlen:" + l + " oldoff:" + e.this.hUb + " isFin:" + e.this.icI);
        if ((l - e.this.hUb < 3300L) && (!e.this.icI))
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
    this.iev = bs.eWj().hashCode();
    this.filename = paramString;
    this.encodeType = paramInt;
    AppMethodBeat.o(148531);
  }
  
  public final long aKA()
  {
    return this.iev;
  }
  
  public final int aKB()
  {
    return this.retCode;
  }
  
  public final List<String> aKC()
  {
    return null;
  }
  
  public final void aKy()
  {
    this.icI = true;
  }
  
  public final String[] aKz()
  {
    return this.iey;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(148532);
    this.callback = paramg;
    int k = (int)i.aSp(this.filename);
    ac.d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %d, isFin: %b", new Object[] { this.filename, Integer.valueOf(k), Integer.valueOf(this.hUb), Boolean.valueOf(this.icI) });
    if (k <= 0)
    {
      ac.e("MicroMsg.NetSceneVoiceInput", "read failed :" + this.filename);
      this.retCode = (f.getLine() + 40000);
      AppMethodBeat.o(148532);
      return -1;
    }
    int j = k - this.hUb;
    if (j > 3960) {
      i = 3960;
    }
    for (;;)
    {
      ac.d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %b, isFin:%b, endFlag: %b", new Object[] { this.filename, Integer.valueOf(k), Boolean.valueOf(this.icI), Boolean.valueOf(this.icI), Boolean.valueOf(this.iew) });
      paramg = i.aU(this.filename, this.hUb, i);
      if (paramg != null) {
        break;
      }
      ac.e("MicroMsg.NetSceneVoiceInput", f.YG() + " read failed :" + this.filename + " read:" + i);
      this.retCode = (f.getLine() + 40000);
      AppMethodBeat.o(148532);
      return -1;
      if ((j < 3300) && (!this.icI))
      {
        ac.e("MicroMsg.NetSceneVoiceInput", f.YG() + " read failed :" + this.filename + "can read:" + j + " isfinish:" + this.icI);
        this.retCode = (f.getLine() + 40000);
        AppMethodBeat.o(148532);
        return -1;
      }
      i = j;
      if (this.icI)
      {
        this.iew = true;
        i = j;
      }
    }
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dna();
    ((b.a)localObject).hvu = new dnb();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
    ((b.a)localObject).funcId = 349;
    ((b.a)localObject).reqCmdId = 158;
    ((b.a)localObject).respCmdId = 1000000158;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dna)this.rr.hvr.hvw;
    ((dna)localObject).ncR = ((String)com.tencent.mm.kernel.g.agR().agA().get(2, ""));
    ((dna)localObject).vTK = new SKBuiltinBuffer_t().setBuffer(paramg);
    ac.d("MicroMsg.NetSceneVoiceInput", f.YG() + " read file:" + this.filename + " readlen:" + paramg.length + " datalen:" + ((dna)localObject).vTK.getBuffer().toByteArray().length + " dataiLen:" + ((dna)localObject).vTK.getILen() + " md5:" + com.tencent.mm.b.g.getMessageDigest(paramg) + " datamd5:" + com.tencent.mm.b.g.getMessageDigest(((dna)localObject).vTK.getBuffer().toByteArray()));
    ((dna)localObject).EfV = this.hUb;
    ((dna)localObject).FUF = this.iev;
    if (this.iew) {}
    for (int i = 1;; i = 0)
    {
      ((dna)localObject).hNR = i;
      ((dna)localObject).FUG = 0;
      ((dna)localObject).DTf = 0;
      ((dna)localObject).FUH = this.encodeType;
      ((dna)localObject).DTc = 0;
      ac.d("MicroMsg.NetSceneVoiceInput", "clientId " + this.iev);
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
    ac.d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    updateDispatchId(paramInt1);
    paramArrayOfByte = (dna)((com.tencent.mm.ak.b)paramq).hvr.hvw;
    paramq = (dnb)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ac.e("MicroMsg.NetSceneVoiceInput", f.YG() + " onGYNetEnd file:" + this.filename + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148534);
      return;
    }
    ac.d("MicroMsg.NetSceneVoiceInput", f.YG() + " onGYNetEnd  file:" + this.filename + " endflag:" + paramq.hNR);
    if (paramArrayOfByte.hNR == 1)
    {
      if ((paramq.FUI != null) && (paramq.FUI.getBuffer() != null)) {
        this.iey = new String[] { paramq.FUI.getBuffer().eQU() };
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148534);
      return;
    }
    paramInt1 = paramArrayOfByte.EfV;
    this.hUb = (paramArrayOfByte.vTK.getILen() + paramInt1);
    if (this.icI) {}
    for (long l = 0L;; l = 500L)
    {
      ac.d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " delay:" + l);
      this.htR.au(l, l);
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
    return n.b.hwa;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(148533);
    this.callback.onSceneEnd(3, f.getLine() + 40000, "ecurityCheckError", this);
    AppMethodBeat.o(148533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.e
 * JD-Core Version:    0.7.0.1
 */