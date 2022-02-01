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
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.dxy;
import com.tencent.mm.protocal.protobuf.dxz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.vfs.o;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends a
  implements k
{
  com.tencent.mm.ak.f callback;
  String filename;
  aw hPc;
  private boolean iAJ;
  private int iAK;
  private String[] iAL;
  private long iiN;
  int iqq;
  boolean iyX;
  int retCode;
  private com.tencent.mm.ak.b rr;
  
  public d(String paramString, int paramInt)
  {
    AppMethodBeat.i(148526);
    this.retCode = 0;
    this.iqq = 0;
    this.filename = null;
    this.iiN = -1L;
    this.iAJ = false;
    this.iyX = false;
    this.iAL = new String[0];
    this.hPc = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148525);
        long l = o.aZR(d.this.filename);
        ae.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.abr() + " onTimerExpired: file:" + d.this.filename + " nowlen:" + l + " oldoff:" + d.this.iqq + " isFin:" + d.this.iyX);
        if ((l - d.this.iqq < 3300L) && (!d.this.iyX))
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
    this.iiN = bu.fpO();
    this.filename = paramString;
    this.iAK = paramInt;
    AppMethodBeat.o(148526);
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
    AppMethodBeat.i(148527);
    this.callback = paramf;
    long l = o.aZR(this.filename);
    ae.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.abr() + " read file:" + this.filename + " filelen:" + l + " oldoff:" + this.iqq + " isFin:" + this.iyX);
    if (l <= 0L)
    {
      ae.e("MicroMsg.NetSceneVoiceAddr", "read failed :" + this.filename);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 40000);
      AppMethodBeat.o(148527);
      return -1;
    }
    int j = (int)(l - this.iqq);
    if (j > 3960) {
      i = 3960;
    }
    for (;;)
    {
      ae.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.abr() + " read file:" + this.filename + " filelen:" + l + " oldoff:" + this.iqq + " isFin:" + this.iyX + " endFlag:" + this.iAJ);
      paramf = o.bb(this.filename, this.iqq, i);
      if (paramf != null) {
        break;
      }
      ae.e("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.abr() + " read failed :" + this.filename + " read:" + i);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 40000);
      AppMethodBeat.o(148527);
      return -1;
      if ((j < 3300) && (!this.iyX))
      {
        ae.e("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.abr() + " read failed :" + this.filename + "can read:" + j + " isfinish:" + this.iyX);
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 40000);
        AppMethodBeat.o(148527);
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
    ((b.a)localObject).hQF = new dxy();
    ((b.a)localObject).hQG = new dxz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voiceaddr";
    ((b.a)localObject).funcId = 206;
    ((b.a)localObject).hQH = 94;
    ((b.a)localObject).respCmdId = 1000000094;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dxy)this.rr.hQD.hQJ;
    ((dxy)localObject).xsE = new SKBuiltinBuffer_t().setBuffer(paramf);
    ae.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.abr() + " read file:" + this.filename + " readlen:" + paramf.length + " datalen:" + ((dxy)localObject).xsE.getBuffer().toByteArray().length + " dataiLen:" + ((dxy)localObject).xsE.getILen() + " md5:" + com.tencent.mm.b.g.getMessageDigest(paramf) + " datamd5:" + com.tencent.mm.b.g.getMessageDigest(((dxy)localObject).xsE.getBuffer().toByteArray()));
    ((dxy)localObject).nIJ = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(2, ""));
    ((dxy)localObject).GeT = this.iqq;
    ((dxy)localObject).HZg = this.iiN;
    if (this.iAJ) {}
    for (int i = 1;; i = 0)
    {
      ((dxy)localObject).ijY = i;
      ((dxy)localObject).HZh = 0;
      ((dxy)localObject).FQW = 0;
      ((dxy)localObject).HZi = 0;
      ((dxy)localObject).FQT = 0;
      ((dxy)localObject).IcU = this.iAK;
      ae.d("MicroMsg.NetSceneVoiceAddr", "clientId " + this.iiN);
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
    ae.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.abr() + " onGYNetEnd file:" + this.filename + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    updateDispatchId(paramInt1);
    paramArrayOfByte = (dxy)((com.tencent.mm.ak.b)paramq).hQD.hQJ;
    paramq = (dxz)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ae.e("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.abr() + " onGYNetEnd file:" + this.filename + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148529);
      return;
    }
    ae.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.abr() + " onGYNetEnd  file:" + this.filename + " endflag:" + paramq.ijY + " lst:" + paramq.FNk);
    if (paramArrayOfByte.ijY == 1)
    {
      this.iAL = new String[paramq.FNk.size()];
      paramInt1 = 0;
      while (paramInt1 < paramq.FNk.size())
      {
        this.iAL[paramInt1] = ((cxn)paramq.FNk.get(paramInt1)).HId;
        paramInt1 += 1;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148529);
      return;
    }
    paramInt1 = paramArrayOfByte.GeT;
    this.iqq = (paramArrayOfByte.xsE.getILen() + paramInt1);
    if (this.iyX) {}
    for (long l = 0L;; l = 500L)
    {
      ae.d("MicroMsg.NetSceneVoiceAddr", "onGYNetEnd file:" + this.filename + " delay:" + l);
      this.hPc.ay(l, l);
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
    return n.b.hRi;
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