package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dsr;
import com.tencent.mm.protocal.protobuf.dss;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.vfs.i;
import java.util.List;

public final class e
  extends a
  implements k
{
  com.tencent.mm.al.f callback;
  private int encodeType;
  String filename;
  av hMj;
  private long ifU;
  int inw;
  boolean iwe;
  private boolean ixQ;
  private String[] ixS;
  int retCode;
  private com.tencent.mm.al.b rr;
  
  public e(String paramString, int paramInt)
  {
    AppMethodBeat.i(148531);
    this.retCode = 0;
    this.iwe = false;
    this.inw = 0;
    this.filename = null;
    this.ifU = -1L;
    this.ixQ = false;
    this.encodeType = 0;
    this.ixS = new String[0];
    this.hMj = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148530);
        long l = i.aYo(e.this.filename);
        ad.d("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.f.abi() + " onTimerExpired: file:" + e.this.filename + " nowlen:" + l + " oldoff:" + e.this.inw + " isFin:" + e.this.iwe);
        if ((l - e.this.inw < 3300L) && (!e.this.iwe))
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
    this.ifU = bt.flT().hashCode();
    this.filename = paramString;
    this.encodeType = paramInt;
    AppMethodBeat.o(148531);
  }
  
  public final void aNH()
  {
    this.iwe = true;
  }
  
  public final String[] aNI()
  {
    return this.ixS;
  }
  
  public final long aNJ()
  {
    return this.ifU;
  }
  
  public final int aNK()
  {
    return this.retCode;
  }
  
  public final List<String> aNL()
  {
    return null;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(148532);
    this.callback = paramf;
    int k = (int)i.aYo(this.filename);
    ad.d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %d, isFin: %b", new Object[] { this.filename, Integer.valueOf(k), Integer.valueOf(this.inw), Boolean.valueOf(this.iwe) });
    if (k <= 0)
    {
      ad.e("MicroMsg.NetSceneVoiceInput", "read failed :" + this.filename);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 40000);
      AppMethodBeat.o(148532);
      return -1;
    }
    int j = k - this.inw;
    if (j > 3960) {
      i = 3960;
    }
    for (;;)
    {
      ad.d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %b, isFin:%b, endFlag: %b", new Object[] { this.filename, Integer.valueOf(k), Boolean.valueOf(this.iwe), Boolean.valueOf(this.iwe), Boolean.valueOf(this.ixQ) });
      paramf = i.aY(this.filename, this.inw, i);
      if (paramf != null) {
        break;
      }
      ad.e("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.f.abi() + " read failed :" + this.filename + " read:" + i);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 40000);
      AppMethodBeat.o(148532);
      return -1;
      if ((j < 3300) && (!this.iwe))
      {
        ad.e("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.f.abi() + " read failed :" + this.filename + "can read:" + j + " isfinish:" + this.iwe);
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 40000);
        AppMethodBeat.o(148532);
        return -1;
      }
      i = j;
      if (this.iwe)
      {
        this.ixQ = true;
        i = j;
      }
    }
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dsr();
    ((b.a)localObject).hNN = new dss();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
    ((b.a)localObject).funcId = 349;
    ((b.a)localObject).hNO = 158;
    ((b.a)localObject).respCmdId = 1000000158;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dsr)this.rr.hNK.hNQ;
    ((dsr)localObject).nDo = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(2, ""));
    ((dsr)localObject).xcN = new SKBuiltinBuffer_t().setBuffer(paramf);
    ad.d("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.f.abi() + " read file:" + this.filename + " readlen:" + paramf.length + " datalen:" + ((dsr)localObject).xcN.getBuffer().toByteArray().length + " dataiLen:" + ((dsr)localObject).xcN.getILen() + " md5:" + com.tencent.mm.b.g.getMessageDigest(paramf) + " datamd5:" + com.tencent.mm.b.g.getMessageDigest(((dsr)localObject).xcN.getBuffer().toByteArray()));
    ((dsr)localObject).FMu = this.inw;
    ((dsr)localObject).HFt = this.ifU;
    if (this.ixQ) {}
    for (int i = 1;; i = 0)
    {
      ((dsr)localObject).ihf = i;
      ((dsr)localObject).HFu = 0;
      ((dsr)localObject).Fyy = 0;
      ((dsr)localObject).HFv = this.encodeType;
      ((dsr)localObject).Fyv = 0;
      ad.d("MicroMsg.NetSceneVoiceInput", "clientId " + this.ifU);
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
    paramArrayOfByte = (dsr)((com.tencent.mm.al.b)paramq).hNK.hNQ;
    paramq = (dss)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.f.abi() + " onGYNetEnd file:" + this.filename + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148534);
      return;
    }
    ad.d("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.f.abi() + " onGYNetEnd  file:" + this.filename + " endflag:" + paramq.ihf);
    if (paramArrayOfByte.ihf == 1)
    {
      if ((paramq.HFw != null) && (paramq.HFw.getBuffer() != null)) {
        this.ixS = new String[] { paramq.HFw.getBuffer().ffY() };
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148534);
      return;
    }
    paramInt1 = paramArrayOfByte.FMu;
    this.inw = (paramArrayOfByte.xcN.getILen() + paramInt1);
    if (this.iwe) {}
    for (long l = 0L;; l = 500L)
    {
      ad.d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " delay:" + l);
      this.hMj.az(l, l);
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
    return n.b.hOp;
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