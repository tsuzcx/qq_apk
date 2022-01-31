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
import com.tencent.mm.protocal.protobuf.cof;
import com.tencent.mm.protocal.protobuf.cog;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.List;

public final class e
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
  private String[] gbk;
  private int gbm;
  int retCode;
  private com.tencent.mm.ai.b rr;
  
  public e(String paramString, int paramInt)
  {
    AppMethodBeat.i(116689);
    this.retCode = 0;
    this.fZu = false;
    this.fQS = 0;
    this.filename = null;
    this.gbh = -1L;
    this.gbi = false;
    this.gbm = 0;
    this.gbk = new String[0];
    this.frx = new ap(new e.1(this), true);
    this.gbh = bo.aoy().hashCode();
    this.filename = paramString;
    this.gbm = paramInt;
    AppMethodBeat.o(116689);
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
    AppMethodBeat.i(116690);
    this.callback = paramf;
    int k = (int)com.tencent.mm.vfs.e.avI(this.filename);
    ab.d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %d, isFin: %b", new Object[] { this.filename, Integer.valueOf(k), Integer.valueOf(this.fQS), Boolean.valueOf(this.fZu) });
    if (k <= 0)
    {
      ab.e("MicroMsg.NetSceneVoiceInput", "read failed :" + this.filename);
      this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 40000);
      AppMethodBeat.o(116690);
      return -1;
    }
    int j = k - this.fQS;
    if (j > 3960) {
      i = 3960;
    }
    for (;;)
    {
      ab.d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %b, isFin:%b, endFlag: %b", new Object[] { this.filename, Integer.valueOf(k), Boolean.valueOf(this.fZu), Boolean.valueOf(this.fZu), Boolean.valueOf(this.gbi) });
      paramf = com.tencent.mm.vfs.e.i(this.filename, this.fQS, i);
      if (paramf != null) {
        break;
      }
      ab.e("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.g.Ml() + " read failed :" + this.filename + " read:" + i);
      this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 40000);
      AppMethodBeat.o(116690);
      return -1;
      if ((j < 3300) && (!this.fZu))
      {
        ab.e("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.g.Ml() + " read failed :" + this.filename + "can read:" + j + " isfinish:" + this.fZu);
        this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 40000);
        AppMethodBeat.o(116690);
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
    ((b.a)localObject).fsX = new cof();
    ((b.a)localObject).fsY = new cog();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
    ((b.a)localObject).funcId = 349;
    ((b.a)localObject).reqCmdId = 158;
    ((b.a)localObject).respCmdId = 1000000158;
    this.rr = ((b.a)localObject).ado();
    localObject = (cof)this.rr.fsV.fta;
    ((cof)localObject).jJA = ((String)com.tencent.mm.kernel.g.RL().Ru().get(2, ""));
    ((cof)localObject).pIA = new SKBuiltinBuffer_t().setBuffer(paramf);
    ab.d("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.g.Ml() + " read file:" + this.filename + " readlen:" + paramf.length + " datalen:" + ((cof)localObject).pIA.getBuffer().toByteArray().length + " dataiLen:" + ((cof)localObject).pIA.getILen() + " md5:" + com.tencent.mm.a.g.w(paramf) + " datamd5:" + com.tencent.mm.a.g.w(((cof)localObject).pIA.getBuffer().toByteArray()));
    ((cof)localObject).wzS = this.fQS;
    ((cof)localObject).xWW = this.gbh;
    if (this.gbi) {}
    for (int i = 1;; i = 0)
    {
      ((cof)localObject).fKi = i;
      ((cof)localObject).xWX = 0;
      ((cof)localObject).wrv = 0;
      ((cof)localObject).xWY = this.gbm;
      ((cof)localObject).wrs = 0;
      ab.d("MicroMsg.NetSceneVoiceInput", "clientId " + this.gbh);
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(116690);
      return i;
    }
  }
  
  public final int getType()
  {
    return 349;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(116692);
    ab.d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    updateDispatchId(paramInt1);
    paramArrayOfByte = (cof)((com.tencent.mm.ai.b)paramq).fsV.fta;
    paramq = (cog)((com.tencent.mm.ai.b)paramq).fsW.fta;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ab.e("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.g.Ml() + " onGYNetEnd file:" + this.filename + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(116692);
      return;
    }
    ab.d("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.g.Ml() + " onGYNetEnd  file:" + this.filename + " endflag:" + paramq.fKi);
    if (paramArrayOfByte.fKi == 1)
    {
      if ((paramq.xWZ != null) && (paramq.xWZ.getBuffer() != null)) {
        this.gbk = new String[] { paramq.xWZ.getBuffer().dqj() };
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(116692);
      return;
    }
    paramInt1 = paramArrayOfByte.wzS;
    this.fQS = (paramArrayOfByte.pIA.getILen() + paramInt1);
    if (this.fZu) {}
    for (long l = 0L;; l = 500L)
    {
      ab.d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " delay:" + l);
      this.frx.ag(l, l);
      AppMethodBeat.o(116692);
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
    AppMethodBeat.i(116691);
    this.callback.onSceneEnd(3, com.tencent.mm.compatible.util.g.getLine() + 40000, "ecurityCheckError", this);
    AppMethodBeat.o(116691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.e
 * JD-Core Version:    0.7.0.1
 */