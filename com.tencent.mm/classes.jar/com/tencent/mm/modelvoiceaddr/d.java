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
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.dqn;
import com.tencent.mm.protocal.protobuf.dqo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends a
  implements k
{
  com.tencent.mm.ak.g callback;
  String filename;
  int hUb;
  au htR;
  boolean icI;
  private long iev;
  private boolean iew;
  private int iex;
  private String[] iey;
  int retCode;
  private com.tencent.mm.ak.b rr;
  
  public d(String paramString, int paramInt)
  {
    AppMethodBeat.i(148526);
    this.retCode = 0;
    this.hUb = 0;
    this.filename = null;
    this.iev = -1L;
    this.iew = false;
    this.icI = false;
    this.iey = new String[0];
    this.htR = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148525);
        long l = i.aSp(d.this.filename);
        ac.d("MicroMsg.NetSceneVoiceAddr", f.YG() + " onTimerExpired: file:" + d.this.filename + " nowlen:" + l + " oldoff:" + d.this.hUb + " isFin:" + d.this.icI);
        if ((l - d.this.hUb < 3300L) && (!d.this.icI))
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
    this.iev = bs.eWj();
    this.filename = paramString;
    this.iex = paramInt;
    AppMethodBeat.o(148526);
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
    AppMethodBeat.i(148527);
    this.callback = paramg;
    long l = i.aSp(this.filename);
    ac.d("MicroMsg.NetSceneVoiceAddr", f.YG() + " read file:" + this.filename + " filelen:" + l + " oldoff:" + this.hUb + " isFin:" + this.icI);
    if (l <= 0L)
    {
      ac.e("MicroMsg.NetSceneVoiceAddr", "read failed :" + this.filename);
      this.retCode = (f.getLine() + 40000);
      AppMethodBeat.o(148527);
      return -1;
    }
    int j = (int)(l - this.hUb);
    if (j > 3960) {
      i = 3960;
    }
    for (;;)
    {
      ac.d("MicroMsg.NetSceneVoiceAddr", f.YG() + " read file:" + this.filename + " filelen:" + l + " oldoff:" + this.hUb + " isFin:" + this.icI + " endFlag:" + this.iew);
      paramg = i.aU(this.filename, this.hUb, i);
      if (paramg != null) {
        break;
      }
      ac.e("MicroMsg.NetSceneVoiceAddr", f.YG() + " read failed :" + this.filename + " read:" + i);
      this.retCode = (f.getLine() + 40000);
      AppMethodBeat.o(148527);
      return -1;
      if ((j < 3300) && (!this.icI))
      {
        ac.e("MicroMsg.NetSceneVoiceAddr", f.YG() + " read failed :" + this.filename + "can read:" + j + " isfinish:" + this.icI);
        this.retCode = (f.getLine() + 40000);
        AppMethodBeat.o(148527);
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
    ((b.a)localObject).hvt = new dqn();
    ((b.a)localObject).hvu = new dqo();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voiceaddr";
    ((b.a)localObject).funcId = 206;
    ((b.a)localObject).reqCmdId = 94;
    ((b.a)localObject).respCmdId = 1000000094;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dqn)this.rr.hvr.hvw;
    ((dqn)localObject).vTK = new SKBuiltinBuffer_t().setBuffer(paramg);
    ac.d("MicroMsg.NetSceneVoiceAddr", f.YG() + " read file:" + this.filename + " readlen:" + paramg.length + " datalen:" + ((dqn)localObject).vTK.getBuffer().toByteArray().length + " dataiLen:" + ((dqn)localObject).vTK.getILen() + " md5:" + com.tencent.mm.b.g.getMessageDigest(paramg) + " datamd5:" + com.tencent.mm.b.g.getMessageDigest(((dqn)localObject).vTK.getBuffer().toByteArray()));
    ((dqn)localObject).ncR = ((String)com.tencent.mm.kernel.g.agR().agA().get(2, ""));
    ((dqn)localObject).EfV = this.hUb;
    ((dqn)localObject).FUF = this.iev;
    if (this.iew) {}
    for (int i = 1;; i = 0)
    {
      ((dqn)localObject).hNR = i;
      ((dqn)localObject).FUG = 0;
      ((dqn)localObject).DTf = 0;
      ((dqn)localObject).FUH = 0;
      ((dqn)localObject).DTc = 0;
      ((dqn)localObject).FXQ = this.iex;
      ac.d("MicroMsg.NetSceneVoiceAddr", "clientId " + this.iev);
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
    ac.d("MicroMsg.NetSceneVoiceAddr", f.YG() + " onGYNetEnd file:" + this.filename + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    updateDispatchId(paramInt1);
    paramArrayOfByte = (dqn)((com.tencent.mm.ak.b)paramq).hvr.hvw;
    paramq = (dqo)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ac.e("MicroMsg.NetSceneVoiceAddr", f.YG() + " onGYNetEnd file:" + this.filename + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148529);
      return;
    }
    ac.d("MicroMsg.NetSceneVoiceAddr", f.YG() + " onGYNetEnd  file:" + this.filename + " endflag:" + paramq.hNR + " lst:" + paramq.DPy);
    if (paramArrayOfByte.hNR == 1)
    {
      this.iey = new String[paramq.DPy.size()];
      paramInt1 = 0;
      while (paramInt1 < paramq.DPy.size())
      {
        this.iey[paramInt1] = ((crm)paramq.DPy.get(paramInt1)).FEm;
        paramInt1 += 1;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148529);
      return;
    }
    paramInt1 = paramArrayOfByte.EfV;
    this.hUb = (paramArrayOfByte.vTK.getILen() + paramInt1);
    if (this.icI) {}
    for (long l = 0L;; l = 500L)
    {
      ac.d("MicroMsg.NetSceneVoiceAddr", "onGYNetEnd file:" + this.filename + " delay:" + l);
      this.htR.au(l, l);
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
    return n.b.hwa;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(148528);
    this.callback.onSceneEnd(3, f.getLine() + 40000, "ecurityCheckError", this);
    AppMethodBeat.o(148528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.d
 * JD-Core Version:    0.7.0.1
 */