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
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.dwh;
import com.tencent.mm.protocal.protobuf.dwi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends a
  implements k
{
  com.tencent.mm.al.f callback;
  String filename;
  av hMj;
  private long ifU;
  int inw;
  boolean iwe;
  private boolean ixQ;
  private int ixR;
  private String[] ixS;
  int retCode;
  private com.tencent.mm.al.b rr;
  
  public d(String paramString, int paramInt)
  {
    AppMethodBeat.i(148526);
    this.retCode = 0;
    this.inw = 0;
    this.filename = null;
    this.ifU = -1L;
    this.ixQ = false;
    this.iwe = false;
    this.ixS = new String[0];
    this.hMj = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148525);
        long l = i.aYo(d.this.filename);
        ad.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.abi() + " onTimerExpired: file:" + d.this.filename + " nowlen:" + l + " oldoff:" + d.this.inw + " isFin:" + d.this.iwe);
        if ((l - d.this.inw < 3300L) && (!d.this.iwe))
        {
          AppMethodBeat.o(148525);
          return true;
        }
        if (d.this.doScene(d.this.dispatcher(), d.this.callback) == -1)
        {
          d.this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 40000);
          d.this.callback.onSceneEnd(3, -1, "doScene failed", d.this);
        }
        AppMethodBeat.o(148525);
        return false;
      }
    }, true);
    this.ifU = bt.flT();
    this.filename = paramString;
    this.ixR = paramInt;
    AppMethodBeat.o(148526);
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
    AppMethodBeat.i(148527);
    this.callback = paramf;
    long l = i.aYo(this.filename);
    ad.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.abi() + " read file:" + this.filename + " filelen:" + l + " oldoff:" + this.inw + " isFin:" + this.iwe);
    if (l <= 0L)
    {
      ad.e("MicroMsg.NetSceneVoiceAddr", "read failed :" + this.filename);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 40000);
      AppMethodBeat.o(148527);
      return -1;
    }
    int j = (int)(l - this.inw);
    if (j > 3960) {
      i = 3960;
    }
    for (;;)
    {
      ad.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.abi() + " read file:" + this.filename + " filelen:" + l + " oldoff:" + this.inw + " isFin:" + this.iwe + " endFlag:" + this.ixQ);
      paramf = i.aY(this.filename, this.inw, i);
      if (paramf != null) {
        break;
      }
      ad.e("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.abi() + " read failed :" + this.filename + " read:" + i);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 40000);
      AppMethodBeat.o(148527);
      return -1;
      if ((j < 3300) && (!this.iwe))
      {
        ad.e("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.abi() + " read failed :" + this.filename + "can read:" + j + " isfinish:" + this.iwe);
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 40000);
        AppMethodBeat.o(148527);
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
    ((b.a)localObject).hNM = new dwh();
    ((b.a)localObject).hNN = new dwi();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voiceaddr";
    ((b.a)localObject).funcId = 206;
    ((b.a)localObject).hNO = 94;
    ((b.a)localObject).respCmdId = 1000000094;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dwh)this.rr.hNK.hNQ;
    ((dwh)localObject).xcN = new SKBuiltinBuffer_t().setBuffer(paramf);
    ad.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.abi() + " read file:" + this.filename + " readlen:" + paramf.length + " datalen:" + ((dwh)localObject).xcN.getBuffer().toByteArray().length + " dataiLen:" + ((dwh)localObject).xcN.getILen() + " md5:" + com.tencent.mm.b.g.getMessageDigest(paramf) + " datamd5:" + com.tencent.mm.b.g.getMessageDigest(((dwh)localObject).xcN.getBuffer().toByteArray()));
    ((dwh)localObject).nDo = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(2, ""));
    ((dwh)localObject).FMu = this.inw;
    ((dwh)localObject).HFt = this.ifU;
    if (this.ixQ) {}
    for (int i = 1;; i = 0)
    {
      ((dwh)localObject).ihf = i;
      ((dwh)localObject).HFu = 0;
      ((dwh)localObject).Fyy = 0;
      ((dwh)localObject).HFv = 0;
      ((dwh)localObject).Fyv = 0;
      ((dwh)localObject).HIM = this.ixR;
      ad.d("MicroMsg.NetSceneVoiceAddr", "clientId " + this.ifU);
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
    ad.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.abi() + " onGYNetEnd file:" + this.filename + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    updateDispatchId(paramInt1);
    paramArrayOfByte = (dwh)((com.tencent.mm.al.b)paramq).hNK.hNQ;
    paramq = (dwi)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.abi() + " onGYNetEnd file:" + this.filename + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148529);
      return;
    }
    ad.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.abi() + " onGYNetEnd  file:" + this.filename + " endflag:" + paramq.ihf + " lst:" + paramq.FuM);
    if (paramArrayOfByte.ihf == 1)
    {
      this.ixS = new String[paramq.FuM.size()];
      paramInt1 = 0;
      while (paramInt1 < paramq.FuM.size())
      {
        this.ixS[paramInt1] = ((cwt)paramq.FuM.get(paramInt1)).HoB;
        paramInt1 += 1;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148529);
      return;
    }
    paramInt1 = paramArrayOfByte.FMu;
    this.inw = (paramArrayOfByte.xcN.getILen() + paramInt1);
    if (this.iwe) {}
    for (long l = 0L;; l = 500L)
    {
      ad.d("MicroMsg.NetSceneVoiceAddr", "onGYNetEnd file:" + this.filename + " delay:" + l);
      this.hMj.az(l, l);
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
    return n.b.hOp;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(148528);
    this.callback.onSceneEnd(3, com.tencent.mm.compatible.util.f.getLine() + 40000, "ecurityCheckError", this);
    AppMethodBeat.o(148528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.d
 * JD-Core Version:    0.7.0.1
 */