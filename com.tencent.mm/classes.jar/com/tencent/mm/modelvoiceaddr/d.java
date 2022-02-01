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
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.dkw;
import com.tencent.mm.protocal.protobuf.dkx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends a
  implements k
{
  com.tencent.mm.al.g callback;
  String filename;
  av gTs;
  boolean hCh;
  private long hDT;
  private boolean hDU;
  private int hDV;
  private String[] hDW;
  int htz;
  int retCode;
  private com.tencent.mm.al.b rr;
  
  public d(String paramString, int paramInt)
  {
    AppMethodBeat.i(148526);
    this.retCode = 0;
    this.htz = 0;
    this.filename = null;
    this.hDT = -1L;
    this.hDU = false;
    this.hCh = false;
    this.hDW = new String[0];
    this.gTs = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148525);
        long l = i.aMN(d.this.filename);
        ad.d("MicroMsg.NetSceneVoiceAddr", f.XJ() + " onTimerExpired: file:" + d.this.filename + " nowlen:" + l + " oldoff:" + d.this.htz + " isFin:" + d.this.hCh);
        if ((l - d.this.htz < 3300L) && (!d.this.hCh))
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
    this.hDT = bt.eGO();
    this.filename = paramString;
    this.hDV = paramInt;
    AppMethodBeat.o(148526);
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
    AppMethodBeat.i(148527);
    this.callback = paramg;
    long l = i.aMN(this.filename);
    ad.d("MicroMsg.NetSceneVoiceAddr", f.XJ() + " read file:" + this.filename + " filelen:" + l + " oldoff:" + this.htz + " isFin:" + this.hCh);
    if (l <= 0L)
    {
      ad.e("MicroMsg.NetSceneVoiceAddr", "read failed :" + this.filename);
      this.retCode = (f.getLine() + 40000);
      AppMethodBeat.o(148527);
      return -1;
    }
    int j = (int)(l - this.htz);
    if (j > 3960) {
      i = 3960;
    }
    for (;;)
    {
      ad.d("MicroMsg.NetSceneVoiceAddr", f.XJ() + " read file:" + this.filename + " filelen:" + l + " oldoff:" + this.htz + " isFin:" + this.hCh + " endFlag:" + this.hDU);
      paramg = i.aR(this.filename, this.htz, i);
      if (paramg != null) {
        break;
      }
      ad.e("MicroMsg.NetSceneVoiceAddr", f.XJ() + " read failed :" + this.filename + " read:" + i);
      this.retCode = (f.getLine() + 40000);
      AppMethodBeat.o(148527);
      return -1;
      if ((j < 3300) && (!this.hCh))
      {
        ad.e("MicroMsg.NetSceneVoiceAddr", f.XJ() + " read failed :" + this.filename + "can read:" + j + " isfinish:" + this.hCh);
        this.retCode = (f.getLine() + 40000);
        AppMethodBeat.o(148527);
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
    ((b.a)localObject).gUU = new dkw();
    ((b.a)localObject).gUV = new dkx();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voiceaddr";
    ((b.a)localObject).funcId = 206;
    ((b.a)localObject).reqCmdId = 94;
    ((b.a)localObject).respCmdId = 1000000094;
    this.rr = ((b.a)localObject).atI();
    localObject = (dkw)this.rr.gUS.gUX;
    ((dkw)localObject).uKT = new SKBuiltinBuffer_t().setBuffer(paramg);
    ad.d("MicroMsg.NetSceneVoiceAddr", f.XJ() + " read file:" + this.filename + " readlen:" + paramg.length + " datalen:" + ((dkw)localObject).uKT.getBuffer().toByteArray().length + " dataiLen:" + ((dkw)localObject).uKT.getILen() + " md5:" + com.tencent.mm.b.g.getMessageDigest(paramg) + " datamd5:" + com.tencent.mm.b.g.getMessageDigest(((dkw)localObject).uKT.getBuffer().toByteArray()));
    ((dkw)localObject).mAQ = ((String)com.tencent.mm.kernel.g.afB().afk().get(2, ""));
    ((dkw)localObject).CNt = this.htz;
    ((dkw)localObject).ExD = this.hDT;
    if (this.hDU) {}
    for (int i = 1;; i = 0)
    {
      ((dkw)localObject).hno = i;
      ((dkw)localObject).ExE = 0;
      ((dkw)localObject).CAJ = 0;
      ((dkw)localObject).ExF = 0;
      ((dkw)localObject).CAG = 0;
      ((dkw)localObject).EAD = this.hDV;
      ad.d("MicroMsg.NetSceneVoiceAddr", "clientId " + this.hDT);
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(148527);
      return i;
    }
  }
  
  public final int getType()
  {
    return 206;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148529);
    ad.d("MicroMsg.NetSceneVoiceAddr", f.XJ() + " onGYNetEnd file:" + this.filename + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    updateDispatchId(paramInt1);
    paramArrayOfByte = (dkw)((com.tencent.mm.al.b)paramq).gUS.gUX;
    paramq = (dkx)((com.tencent.mm.al.b)paramq).gUT.gUX;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneVoiceAddr", f.XJ() + " onGYNetEnd file:" + this.filename + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148529);
      return;
    }
    ad.d("MicroMsg.NetSceneVoiceAddr", f.XJ() + " onGYNetEnd  file:" + this.filename + " endflag:" + paramq.hno + " lst:" + paramq.Cxc);
    if (paramArrayOfByte.hno == 1)
    {
      this.hDW = new String[paramq.Cxc.size()];
      paramInt1 = 0;
      while (paramInt1 < paramq.Cxc.size())
      {
        this.hDW[paramInt1] = ((cmf)paramq.Cxc.get(paramInt1)).Ehn;
        paramInt1 += 1;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148529);
      return;
    }
    paramInt1 = paramArrayOfByte.CNt;
    this.htz = (paramArrayOfByte.uKT.getILen() + paramInt1);
    if (this.hCh) {}
    for (long l = 0L;; l = 500L)
    {
      ad.d("MicroMsg.NetSceneVoiceAddr", "onGYNetEnd file:" + this.filename + " delay:" + l);
      this.gTs.av(l, l);
      AppMethodBeat.o(148529);
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
    AppMethodBeat.i(148528);
    this.callback.onSceneEnd(3, f.getLine() + 40000, "ecurityCheckError", this);
    AppMethodBeat.o(148528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.d
 * JD-Core Version:    0.7.0.1
 */