package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m.a;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.crb;
import com.tencent.mm.protocal.protobuf.crc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends a
  implements k
{
  f callback;
  int fQS;
  boolean fZu;
  String filename;
  ap frx;
  private long gbh;
  private boolean gbi;
  private int gbj;
  private String[] gbk;
  int retCode;
  private com.tencent.mm.ai.b rr;
  
  public d(String paramString, int paramInt)
  {
    AppMethodBeat.i(116684);
    this.retCode = 0;
    this.fQS = 0;
    this.filename = null;
    this.gbh = -1L;
    this.gbi = false;
    this.fZu = false;
    this.gbk = new String[0];
    this.frx = new ap(new d.1(this), true);
    this.gbh = bo.aoy();
    this.filename = paramString;
    this.gbj = paramInt;
    AppMethodBeat.o(116684);
  }
  
  public final void amB()
  {
    this.fZu = true;
  }
  
  public final String[] amC()
  {
    return this.gbk;
  }
  
  public final long amD()
  {
    return this.gbh;
  }
  
  public final int amE()
  {
    return this.retCode;
  }
  
  public final List<String> amF()
  {
    return null;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(116685);
    this.callback = paramf;
    long l = com.tencent.mm.vfs.e.avI(this.filename);
    ab.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.g.Ml() + " read file:" + this.filename + " filelen:" + l + " oldoff:" + this.fQS + " isFin:" + this.fZu);
    if (l <= 0L)
    {
      ab.e("MicroMsg.NetSceneVoiceAddr", "read failed :" + this.filename);
      this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 40000);
      AppMethodBeat.o(116685);
      return -1;
    }
    int j = (int)(l - this.fQS);
    if (j > 3960) {
      i = 3960;
    }
    for (;;)
    {
      ab.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.g.Ml() + " read file:" + this.filename + " filelen:" + l + " oldoff:" + this.fQS + " isFin:" + this.fZu + " endFlag:" + this.gbi);
      paramf = com.tencent.mm.vfs.e.i(this.filename, this.fQS, i);
      if (paramf != null) {
        break;
      }
      ab.e("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.g.Ml() + " read failed :" + this.filename + " read:" + i);
      this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 40000);
      AppMethodBeat.o(116685);
      return -1;
      if ((j < 3300) && (!this.fZu))
      {
        ab.e("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.g.Ml() + " read failed :" + this.filename + "can read:" + j + " isfinish:" + this.fZu);
        this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 40000);
        AppMethodBeat.o(116685);
        return -1;
      }
      i = j;
      if (this.fZu)
      {
        this.gbi = true;
        i = j;
      }
    }
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new crb();
    ((b.a)localObject).fsY = new crc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voiceaddr";
    ((b.a)localObject).funcId = 206;
    ((b.a)localObject).reqCmdId = 94;
    ((b.a)localObject).respCmdId = 1000000094;
    this.rr = ((b.a)localObject).ado();
    localObject = (crb)this.rr.fsV.fta;
    ((crb)localObject).pIA = new SKBuiltinBuffer_t().setBuffer(paramf);
    ab.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.g.Ml() + " read file:" + this.filename + " readlen:" + paramf.length + " datalen:" + ((crb)localObject).pIA.getBuffer().toByteArray().length + " dataiLen:" + ((crb)localObject).pIA.getILen() + " md5:" + com.tencent.mm.a.g.w(paramf) + " datamd5:" + com.tencent.mm.a.g.w(((crb)localObject).pIA.getBuffer().toByteArray()));
    ((crb)localObject).jJA = ((String)com.tencent.mm.kernel.g.RL().Ru().get(2, ""));
    ((crb)localObject).wzS = this.fQS;
    ((crb)localObject).xWW = this.gbh;
    if (this.gbi) {}
    for (int i = 1;; i = 0)
    {
      ((crb)localObject).fKi = i;
      ((crb)localObject).xWX = 0;
      ((crb)localObject).wrv = 0;
      ((crb)localObject).xWY = 0;
      ((crb)localObject).wrs = 0;
      ((crb)localObject).xZG = this.gbj;
      ab.d("MicroMsg.NetSceneVoiceAddr", "clientId " + this.gbh);
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(116685);
      return i;
    }
  }
  
  public final int getType()
  {
    return 206;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(116687);
    ab.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.g.Ml() + " onGYNetEnd file:" + this.filename + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    updateDispatchId(paramInt1);
    paramArrayOfByte = (crb)((com.tencent.mm.ai.b)paramq).fsV.fta;
    paramq = (crc)((com.tencent.mm.ai.b)paramq).fsW.fta;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ab.e("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.g.Ml() + " onGYNetEnd file:" + this.filename + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(116687);
      return;
    }
    ab.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.g.Ml() + " onGYNetEnd  file:" + this.filename + " endflag:" + paramq.fKi + " lst:" + paramq.wou);
    if (paramArrayOfByte.fKi == 1)
    {
      this.gbk = new String[paramq.wou.size()];
      paramInt1 = 0;
      while (paramInt1 < paramq.wou.size())
      {
        this.gbk[paramInt1] = ((bwc)paramq.wou.get(paramInt1)).xJE;
        paramInt1 += 1;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(116687);
      return;
    }
    paramInt1 = paramArrayOfByte.wzS;
    this.fQS = (paramArrayOfByte.pIA.getILen() + paramInt1);
    if (this.fZu) {}
    for (long l = 0L;; l = 500L)
    {
      ab.d("MicroMsg.NetSceneVoiceAddr", "onGYNetEnd file:" + this.filename + " delay:" + l);
      this.frx.ag(l, l);
      AppMethodBeat.o(116687);
      return;
    }
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
  
  public final void setSecurityCheckError(m.a parama)
  {
    AppMethodBeat.i(116686);
    this.callback.onSceneEnd(3, com.tencent.mm.compatible.util.g.getLine() + 40000, "ecurityCheckError", this);
    AppMethodBeat.o(116686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.d
 * JD-Core Version:    0.7.0.1
 */