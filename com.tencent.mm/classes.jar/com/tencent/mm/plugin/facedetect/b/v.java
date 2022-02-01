package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.an.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.ccx;
import com.tencent.mm.protocal.protobuf.lx;
import com.tencent.mm.sdk.platformtools.ae;

public final class v
  extends p
  implements k, b
{
  private final q hRG;
  private long roD;
  private byte[] roE;
  
  public v(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103637);
    this.roD = -1L;
    this.roE = null;
    this.hRG = new h();
    i.a locala = (i.a)this.hRG.getReqObj();
    locala.roc.GOU = p.roy;
    locala.roc.nJA = 1;
    locala.roc.Scene = paramInt1;
    locala.roc.GOV = paramInt2;
    AppMethodBeat.o(103637);
  }
  
  final void agO(String paramString)
  {
    AppMethodBeat.i(103640);
    ((i.a)this.hRG.getReqObj()).roc.GOU = paramString;
    AppMethodBeat.o(103640);
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(103639);
    ae.d("MicroMsg.NetSceneGetBioConfigRsa", "hy: onGYNetEnd  errType:" + paramInt1 + " errCode:" + paramInt2);
    i.b localb;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      localb = (i.b)paramq.getRespObj();
      this.roD = localb.rod.GOW;
      if (localb.rod.GOX != null) {
        this.roE = localb.rod.GOX.zr;
      }
      if (localb.rod.GOZ != null)
      {
        if ((localb.rod.GOZ.FXb == null) || (localb.rod.GOZ.FXb.getILen() <= 0)) {
          break label393;
        }
        ae.i("MicroMsg.NetSceneGetBioConfigRsa", "summersafecdn onGYNetEnd cdnrule:%d", new Object[] { Integer.valueOf(localb.rod.GOZ.FXb.getILen()) });
      }
    }
    label393:
    for (paramq = z.a(localb.rod.GOZ.FXb);; paramq = null)
    {
      if ((localb.rod.GOZ.FXc != null) && (localb.rod.GOZ.FXc.getILen() > 0)) {
        ae.i("MicroMsg.NetSceneGetBioConfigRsa", "summersafecdn onGYNetEnd safecdnrule:%d", new Object[] { Integer.valueOf(localb.rod.GOZ.FXc.getILen()) });
      }
      for (byte[] arrayOfByte = z.a(localb.rod.GOZ.FXc);; arrayOfByte = null)
      {
        com.tencent.mm.an.f.aHa().a(localb.rod.GOZ.FWY, localb.rod.GOZ.FWZ, localb.rod.GOZ.FXa, paramq, arrayOfByte, localb.rod.GOZ.FXd);
        long l = this.roD;
        if (this.roE == null) {}
        for (int i = 0;; i = this.roE.length)
        {
          ae.i("MicroMsg.NetSceneGetBioConfigRsa", "hy: get bio config: bioId: %s, bioConfigSize: %d", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
          this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
          AppMethodBeat.o(103639);
          return;
        }
      }
    }
  }
  
  public final long cud()
  {
    return this.roD;
  }
  
  public final byte[] cue()
  {
    return this.roE;
  }
  
  final int f(e parame)
  {
    AppMethodBeat.i(103638);
    int i = dispatch(parame, this.hRG, this);
    AppMethodBeat.o(103638);
    return i;
  }
  
  protected final ccx f(q paramq)
  {
    AppMethodBeat.i(103641);
    paramq = ((i.b)paramq.getRespObj()).rod.GOY;
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
    return n.b.hRi;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.v
 * JD-Core Version:    0.7.0.1
 */