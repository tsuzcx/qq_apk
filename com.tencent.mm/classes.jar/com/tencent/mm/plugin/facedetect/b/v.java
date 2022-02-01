package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.an.a;
import com.tencent.mm.an.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.atk;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.protocal.protobuf.ln;
import com.tencent.mm.sdk.platformtools.ac;

public final class v
  extends p
  implements k, b
{
  private final q hwy;
  private long qwJ;
  private byte[] qwK;
  
  public v(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103637);
    this.qwJ = -1L;
    this.qwK = null;
    this.hwy = new h();
    i.a locala = (i.a)this.hwy.getReqObj();
    locala.qwj.EMr = p.qwE;
    locala.qwj.ndI = 1;
    locala.qwj.Scene = paramInt1;
    locala.qwj.EMs = paramInt2;
    AppMethodBeat.o(103637);
  }
  
  final void acd(String paramString)
  {
    AppMethodBeat.i(103640);
    ((i.a)this.hwy.getReqObj()).qwj.EMr = paramString;
    AppMethodBeat.o(103640);
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(103639);
    ac.d("MicroMsg.NetSceneGetBioConfigRsa", "hy: onGYNetEnd  errType:" + paramInt1 + " errCode:" + paramInt2);
    i.b localb;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      localb = (i.b)paramq.getRespObj();
      this.qwJ = localb.qwk.EMt;
      if (localb.qwk.EMu != null) {
        this.qwK = localb.qwk.EMu.xy;
      }
      if (localb.qwk.EMw != null)
      {
        if ((localb.qwk.EMw.DZk == null) || (localb.qwk.EMw.DZk.getILen() <= 0)) {
          break label393;
        }
        ac.i("MicroMsg.NetSceneGetBioConfigRsa", "summersafecdn onGYNetEnd cdnrule:%d", new Object[] { Integer.valueOf(localb.qwk.EMw.DZk.getILen()) });
      }
    }
    label393:
    for (paramq = z.a(localb.qwk.EMw.DZk);; paramq = null)
    {
      if ((localb.qwk.EMw.DZl != null) && (localb.qwk.EMw.DZl.getILen() > 0)) {
        ac.i("MicroMsg.NetSceneGetBioConfigRsa", "summersafecdn onGYNetEnd safecdnrule:%d", new Object[] { Integer.valueOf(localb.qwk.EMw.DZl.getILen()) });
      }
      for (byte[] arrayOfByte = z.a(localb.qwk.EMw.DZl);; arrayOfByte = null)
      {
        f.aDE().a(localb.qwk.EMw.DZh, localb.qwk.EMw.DZi, localb.qwk.EMw.DZj, paramq, arrayOfByte, localb.qwk.EMw.DZm);
        long l = this.qwJ;
        if (this.qwK == null) {}
        for (int i = 0;; i = this.qwK.length)
        {
          ac.i("MicroMsg.NetSceneGetBioConfigRsa", "hy: get bio config: bioId: %s, bioConfigSize: %d", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
          this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
          AppMethodBeat.o(103639);
          return;
        }
      }
    }
  }
  
  public final long cmX()
  {
    return this.qwJ;
  }
  
  public final byte[] cmY()
  {
    return this.qwK;
  }
  
  final int f(e parame)
  {
    AppMethodBeat.i(103638);
    int i = dispatch(parame, this.hwy, this);
    AppMethodBeat.o(103638);
    return i;
  }
  
  protected final bxm f(q paramq)
  {
    AppMethodBeat.i(103641);
    paramq = ((i.b)paramq.getRespObj()).qwk.EMv;
    AppMethodBeat.o(103641);
    return paramq;
  }
  
  public final int getType()
  {
    return 733;
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hwa;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.v
 * JD-Core Version:    0.7.0.1
 */