package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bsv;
import com.tencent.mm.protocal.protobuf.cim;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class o
  extends p
  implements k, e
{
  private final q gVZ;
  private boolean pNR;
  private String pNV;
  
  public o(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103613);
    this.pNR = false;
    this.pNV = "";
    this.gVZ = new f();
    j.a locala = (j.a)this.gVZ.getReqObj();
    locala.pND.Drp = p.pNW;
    locala.pND.Drr = paramLong;
    locala.pND.EdQ = paramString1;
    locala.pND.EdR = paramString2;
    AppMethodBeat.o(103613);
  }
  
  final void XG(String paramString)
  {
    AppMethodBeat.i(103616);
    ((j.a)this.gVZ.getReqObj()).pND.Drp = paramString;
    AppMethodBeat.o(103616);
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    boolean bool2 = true;
    AppMethodBeat.i(103615);
    ad.d("MicroMsg.NetSceneFaceRegFaceRsa", "hy: onGYNetEnd  errType:" + paramInt1 + " errCode:" + paramInt2);
    paramq = (j.b)paramq.getRespObj();
    boolean bool1;
    int i;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (paramq.pNE.EdT == 0)
      {
        bool1 = true;
        this.pNR = bool1;
        this.pNV = paramq.pNE.EdS;
        i = paramq.pNE.EdT;
        boolean bool3 = this.pNR;
        paramInt2 = paramq.pNE.EdT;
        if (bt.isNullOrNil(this.pNV)) {
          break label189;
        }
        bool1 = bool2;
        label129:
        ad.i("MicroMsg.NetSceneFaceRegFaceRsa", "hy: is verify ok: %b, youtuRet; %d, has random pwd: %b", new Object[] { Boolean.valueOf(bool3), Integer.valueOf(paramInt2), Boolean.valueOf(bool1) });
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt1, i, paramString, this);
      AppMethodBeat.o(103615);
      return;
      bool1 = false;
      break;
      label189:
      bool1 = false;
      break label129;
      i = paramInt2;
      if (paramq != null)
      {
        i = paramInt2;
        if (paramq.pNE != null)
        {
          i = paramInt2;
          if (paramq.pNE.EdT != 0)
          {
            ad.i("MicroMsg.NetSceneFaceRegFaceRsa", "hy: has detail ret. use");
            i = paramq.pNE.EdT;
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
    AppMethodBeat.i(103614);
    this.gVZ.getReqObj();
    int i = dispatch(parame, this.gVZ, this);
    AppMethodBeat.o(103614);
    return i;
  }
  
  protected final bsv f(q paramq)
  {
    AppMethodBeat.i(103617);
    paramq = ((j.b)paramq.getRespObj()).pNE.Drt;
    AppMethodBeat.o(103617);
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
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.o
 * JD-Core Version:    0.7.0.1
 */