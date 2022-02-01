package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bsv;
import com.tencent.mm.protocal.protobuf.djh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class t
  extends p
  implements k, e
{
  private final q gVZ;
  private boolean pNR;
  private String pNV;
  
  public t(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103629);
    this.pNR = false;
    this.pNV = "";
    this.gVZ = new g();
    k.a locala = (k.a)this.gVZ.getReqObj();
    locala.pNF.Drp = p.pNW;
    locala.pNF.Drr = paramLong;
    locala.pNF.EdR = paramString2;
    locala.pNF.EdQ = paramString1;
    AppMethodBeat.o(103629);
  }
  
  final void XG(String paramString)
  {
    AppMethodBeat.i(103632);
    ((k.a)this.gVZ.getReqObj()).pNF.Drp = paramString;
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
      if (paramq.pNG.EdT == 0)
      {
        bool1 = true;
        this.pNR = bool1;
        this.pNV = paramq.pNG.EdS;
        boolean bool3 = this.pNR;
        paramInt2 = paramq.pNG.EdT;
        if (bt.isNullOrNil(this.pNV)) {
          break label189;
        }
        bool1 = bool2;
        ad.i("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: is verify ok: %b, youtuRet: %d, has random pwd: %b", new Object[] { Boolean.valueOf(bool3), Integer.valueOf(paramInt2), Boolean.valueOf(bool1) });
        i = paramq.pNG.EdT;
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
        if (paramq.pNG != null)
        {
          i = paramInt2;
          if (paramq.pNG.EdT != 0)
          {
            ad.i("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: has detail ret. use");
            i = paramq.pNG.EdT;
          }
        }
      }
    }
  }
  
  public final boolean cfs()
  {
    return true;
  }
  
  public final String cft()
  {
    return this.pNV;
  }
  
  final int f(com.tencent.mm.network.e parame)
  {
    AppMethodBeat.i(103630);
    this.gVZ.getReqObj();
    int i = dispatch(parame, this.gVZ, this);
    AppMethodBeat.o(103630);
    return i;
  }
  
  protected final bsv f(q paramq)
  {
    AppMethodBeat.i(103633);
    paramq = ((k.b)paramq.getRespObj()).pNG.Drt;
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
    return n.b.gVB;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.t
 * JD-Core Version:    0.7.0.1
 */