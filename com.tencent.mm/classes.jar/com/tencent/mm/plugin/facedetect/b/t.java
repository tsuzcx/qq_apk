package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ccd;
import com.tencent.mm.protocal.protobuf.dun;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class t
  extends p
  implements k, e
{
  private final q hON;
  private boolean rgp;
  private String rgt;
  
  public t(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103629);
    this.rgp = false;
    this.rgt = "";
    this.hON = new g();
    k.a locala = (k.a)this.hON.getReqObj();
    locala.rgd.Gvv = p.rgu;
    locala.rgd.Gvx = paramLong;
    locala.rgd.Hld = paramString2;
    locala.rgd.Hlc = paramString1;
    AppMethodBeat.o(103629);
  }
  
  final void afS(String paramString)
  {
    AppMethodBeat.i(103632);
    ((k.a)this.hON.getReqObj()).rgd.Gvv = paramString;
    AppMethodBeat.o(103632);
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    boolean bool2 = true;
    AppMethodBeat.i(103631);
    ad.d("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: onGYNetEnd  errType:" + paramInt1 + " errCode:" + paramInt2);
    paramq = (k.b)paramq.getRespObj();
    boolean bool1;
    label119:
    int i;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (paramq.rge.Hlf == 0)
      {
        bool1 = true;
        this.rgp = bool1;
        this.rgt = paramq.rge.Hle;
        boolean bool3 = this.rgp;
        paramInt2 = paramq.rge.Hlf;
        if (bt.isNullOrNil(this.rgt)) {
          break label189;
        }
        bool1 = bool2;
        ad.i("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: is verify ok: %b, youtuRet: %d, has random pwd: %b", new Object[] { Boolean.valueOf(bool3), Integer.valueOf(paramInt2), Boolean.valueOf(bool1) });
        i = paramq.rge.Hlf;
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt1, i, paramString, this);
      AppMethodBeat.o(103631);
      return;
      bool1 = false;
      break;
      label189:
      bool1 = false;
      break label119;
      i = paramInt2;
      if (paramq != null)
      {
        i = paramInt2;
        if (paramq.rge != null)
        {
          i = paramInt2;
          if (paramq.rge.Hlf != 0)
          {
            ad.i("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: has detail ret. use");
            i = paramq.rge.Hlf;
          }
        }
      }
    }
  }
  
  public final boolean csE()
  {
    return true;
  }
  
  public final String csF()
  {
    return this.rgt;
  }
  
  final int f(com.tencent.mm.network.e parame)
  {
    AppMethodBeat.i(103630);
    this.hON.getReqObj();
    int i = dispatch(parame, this.hON, this);
    AppMethodBeat.o(103630);
    return i;
  }
  
  protected final ccd f(q paramq)
  {
    AppMethodBeat.i(103633);
    paramq = ((k.b)paramq.getRespObj()).rge.Gvz;
    AppMethodBeat.o(103633);
    return paramq;
  }
  
  public final int getType()
  {
    return 930;
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
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.t
 * JD-Core Version:    0.7.0.1
 */