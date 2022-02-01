package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.ao.a;
import com.tencent.mm.ao.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aqg;
import com.tencent.mm.protocal.protobuf.bsv;
import com.tencent.mm.protocal.protobuf.lh;
import com.tencent.mm.sdk.platformtools.ad;

public final class v
  extends p
  implements k, b
{
  private final q gVZ;
  private long pOb;
  private byte[] pOc;
  
  public v(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103637);
    this.pOb = -1L;
    this.pOc = null;
    this.gVZ = new h();
    i.a locala = (i.a)this.gVZ.getReqObj();
    locala.pNB.Drp = p.pNW;
    locala.pNB.mBH = 1;
    locala.pNB.Scene = paramInt1;
    locala.pNB.Drq = paramInt2;
    AppMethodBeat.o(103637);
  }
  
  final void XG(String paramString)
  {
    AppMethodBeat.i(103640);
    ((i.a)this.gVZ.getReqObj()).pNB.Drp = paramString;
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
      this.pOb = localb.pNC.Drr;
      if (localb.pNC.Drs != null) {
        this.pOc = localb.pNC.Drs.wA;
      }
      if (localb.pNC.Dru != null)
      {
        if ((localb.pNC.Dru.CGK == null) || (localb.pNC.Dru.CGK.getILen() <= 0)) {
          break label393;
        }
        ad.i("MicroMsg.NetSceneGetBioConfigRsa", "summersafecdn onGYNetEnd cdnrule:%d", new Object[] { Integer.valueOf(localb.pNC.Dru.CGK.getILen()) });
      }
    }
    label393:
    for (paramq = z.a(localb.pNC.Dru.CGK);; paramq = null)
    {
      if ((localb.pNC.Dru.CGL != null) && (localb.pNC.Dru.CGL.getILen() > 0)) {
        ad.i("MicroMsg.NetSceneGetBioConfigRsa", "summersafecdn onGYNetEnd safecdnrule:%d", new Object[] { Integer.valueOf(localb.pNC.Dru.CGL.getILen()) });
      }
      for (byte[] arrayOfByte = z.a(localb.pNC.Dru.CGL);; arrayOfByte = null)
      {
        f.awM().a(localb.pNC.Dru.CGH, localb.pNC.Dru.CGI, localb.pNC.Dru.CGJ, paramq, arrayOfByte, localb.pNC.Dru.CGM);
        long l = this.pOb;
        if (this.pOc == null) {}
        for (int i = 0;; i = this.pOc.length)
        {
          ad.i("MicroMsg.NetSceneGetBioConfigRsa", "hy: get bio config: bioId: %s, bioConfigSize: %d", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
          this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
          AppMethodBeat.o(103639);
          return;
        }
      }
    }
  }
  
  public final long cfq()
  {
    return this.pOb;
  }
  
  public final byte[] cfr()
  {
    return this.pOc;
  }
  
  final int f(e parame)
  {
    AppMethodBeat.i(103638);
    int i = dispatch(parame, this.gVZ, this);
    AppMethodBeat.o(103638);
    return i;
  }
  
  protected final bsv f(q paramq)
  {
    AppMethodBeat.i(103641);
    paramq = ((i.b)paramq.getRespObj()).pNC.Drt;
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
    return n.b.gVB;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.v
 * JD-Core Version:    0.7.0.1
 */