package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m.a;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.al.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.agz;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.protocal.protobuf.jz;
import com.tencent.mm.sdk.platformtools.ab;

public final class v
  extends p
  implements k, b
{
  private final q ftU;
  private long mhn;
  private byte[] mho;
  
  public v(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(112);
    this.mhn = -1L;
    this.mho = null;
    this.ftU = new h();
    i.a locala = (i.a)this.ftU.getReqObj();
    locala.mgM.wZA = p.mhi;
    locala.mgM.jKs = 1;
    locala.mgM.Scene = paramInt1;
    locala.mgM.wZB = paramInt2;
    AppMethodBeat.o(112);
  }
  
  final void Nm(String paramString)
  {
    AppMethodBeat.i(115);
    ((i.a)this.ftU.getReqObj()).mgM.wZA = paramString;
    AppMethodBeat.o(115);
  }
  
  public final long btW()
  {
    return this.mhn;
  }
  
  public final byte[] btX()
  {
    return this.mho;
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(114);
    ab.d("MicroMsg.NetSceneGetBioConfigRsa", "hy: onGYNetEnd  errType:" + paramInt1 + " errCode:" + paramInt2);
    i.b localb;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      localb = (i.b)paramq.getRespObj();
      this.mhn = localb.mgN.wZC;
      if (localb.mgN.wZD != null) {
        this.mho = localb.mgN.wZD.pW;
      }
      if (localb.mgN.wZF != null)
      {
        if ((localb.mgN.wZF.wwB == null) || (localb.mgN.wZF.wwB.getILen() <= 0)) {
          break label393;
        }
        ab.i("MicroMsg.NetSceneGetBioConfigRsa", "summersafecdn onGYNetEnd cdnrule:%d", new Object[] { Integer.valueOf(localb.mgN.wZF.wwB.getILen()) });
      }
    }
    label393:
    for (paramq = aa.a(localb.mgN.wZF.wwB);; paramq = null)
    {
      if ((localb.mgN.wZF.wwC != null) && (localb.mgN.wZF.wwC.getILen() > 0)) {
        ab.i("MicroMsg.NetSceneGetBioConfigRsa", "summersafecdn onGYNetEnd safecdnrule:%d", new Object[] { Integer.valueOf(localb.mgN.wZF.wwC.getILen()) });
      }
      for (byte[] arrayOfByte = aa.a(localb.mgN.wZF.wwC);; arrayOfByte = null)
      {
        com.tencent.mm.al.f.afP().a(localb.mgN.wZF.wwy, localb.mgN.wZF.wwz, localb.mgN.wZF.wwA, paramq, arrayOfByte, localb.mgN.wZF.wwD);
        long l = this.mhn;
        if (this.mho == null) {}
        for (int i = 0;; i = this.mho.length)
        {
          ab.i("MicroMsg.NetSceneGetBioConfigRsa", "hy: get bio config: bioId: %s, bioConfigSize: %d", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
          this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
          AppMethodBeat.o(114);
          return;
        }
      }
    }
  }
  
  final int f(e parame)
  {
    AppMethodBeat.i(113);
    int i = dispatch(parame, this.ftU, this);
    AppMethodBeat.o(113);
    return i;
  }
  
  protected final bfu f(q paramq)
  {
    AppMethodBeat.i(116);
    paramq = ((i.b)paramq.getRespObj()).mgN.wZE;
    AppMethodBeat.o(116);
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
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
  
  public final void setSecurityCheckError(m.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.v
 * JD-Core Version:    0.7.0.1
 */