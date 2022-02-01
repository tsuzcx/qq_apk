package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.ao.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.axi;
import com.tencent.mm.protocal.protobuf.ccd;
import com.tencent.mm.protocal.protobuf.lx;
import com.tencent.mm.sdk.platformtools.ad;

public final class v
  extends p
  implements k, b
{
  private final q hON;
  private byte[] rgA;
  private long rgz;
  
  public v(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103637);
    this.rgz = -1L;
    this.rgA = null;
    this.hON = new h();
    i.a locala = (i.a)this.hON.getReqObj();
    locala.rfZ.Gvv = p.rgu;
    locala.rfZ.nEf = 1;
    locala.rfZ.Scene = paramInt1;
    locala.rfZ.Gvw = paramInt2;
    AppMethodBeat.o(103637);
  }
  
  final void afS(String paramString)
  {
    AppMethodBeat.i(103640);
    ((i.a)this.hON.getReqObj()).rfZ.Gvv = paramString;
    AppMethodBeat.o(103640);
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(103639);
    ad.d("MicroMsg.NetSceneGetBioConfigRsa", "hy: onGYNetEnd  errType:" + paramInt1 + " errCode:" + paramInt2);
    i.b localb;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      localb = (i.b)paramq.getRespObj();
      this.rgz = localb.rga.Gvx;
      if (localb.rga.Gvy != null) {
        this.rgA = localb.rga.Gvy.zr;
      }
      if (localb.rga.GvA != null)
      {
        if ((localb.rga.GvA.FEG == null) || (localb.rga.GvA.FEG.getILen() <= 0)) {
          break label393;
        }
        ad.i("MicroMsg.NetSceneGetBioConfigRsa", "summersafecdn onGYNetEnd cdnrule:%d", new Object[] { Integer.valueOf(localb.rga.GvA.FEG.getILen()) });
      }
    }
    label393:
    for (paramq = z.a(localb.rga.GvA.FEG);; paramq = null)
    {
      if ((localb.rga.GvA.FEH != null) && (localb.rga.GvA.FEH.getILen() > 0)) {
        ad.i("MicroMsg.NetSceneGetBioConfigRsa", "summersafecdn onGYNetEnd safecdnrule:%d", new Object[] { Integer.valueOf(localb.rga.GvA.FEH.getILen()) });
      }
      for (byte[] arrayOfByte = z.a(localb.rga.GvA.FEH);; arrayOfByte = null)
      {
        com.tencent.mm.ao.f.aGJ().a(localb.rga.GvA.FED, localb.rga.GvA.FEE, localb.rga.GvA.FEF, paramq, arrayOfByte, localb.rga.GvA.FEI);
        long l = this.rgz;
        if (this.rgA == null) {}
        for (int i = 0;; i = this.rgA.length)
        {
          ad.i("MicroMsg.NetSceneGetBioConfigRsa", "hy: get bio config: bioId: %s, bioConfigSize: %d", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
          this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
          AppMethodBeat.o(103639);
          return;
        }
      }
    }
  }
  
  public final long csC()
  {
    return this.rgz;
  }
  
  public final byte[] csD()
  {
    return this.rgA;
  }
  
  final int f(e parame)
  {
    AppMethodBeat.i(103638);
    int i = dispatch(parame, this.hON, this);
    AppMethodBeat.o(103638);
    return i;
  }
  
  protected final ccd f(q paramq)
  {
    AppMethodBeat.i(103641);
    paramq = ((i.b)paramq.getRespObj()).rga.Gvz;
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
    return n.b.hOp;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.v
 * JD-Core Version:    0.7.0.1
 */