package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ccd;
import com.tencent.mm.protocal.protobuf.csv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class o
  extends p
  implements k, e
{
  private final q hON;
  private boolean rgp;
  private String rgt;
  
  public o(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103613);
    this.rgp = false;
    this.rgt = "";
    this.hON = new f();
    j.a locala = (j.a)this.hON.getReqObj();
    locala.rgb.Gvv = p.rgu;
    locala.rgb.Gvx = paramLong;
    locala.rgb.Hlc = paramString1;
    locala.rgb.Hld = paramString2;
    AppMethodBeat.o(103613);
  }
  
  final void afS(String paramString)
  {
    AppMethodBeat.i(103616);
    ((j.a)this.hON.getReqObj()).rgb.Gvv = paramString;
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
      if (paramq.rgc.Hlf == 0)
      {
        bool1 = true;
        this.rgp = bool1;
        this.rgt = paramq.rgc.Hle;
        i = paramq.rgc.Hlf;
        boolean bool3 = this.rgp;
        paramInt2 = paramq.rgc.Hlf;
        if (bt.isNullOrNil(this.rgt)) {
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
        if (paramq.rgc != null)
        {
          i = paramInt2;
          if (paramq.rgc.Hlf != 0)
          {
            ad.i("MicroMsg.NetSceneFaceRegFaceRsa", "hy: has detail ret. use");
            i = paramq.rgc.Hlf;
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
    AppMethodBeat.i(103614);
    this.hON.getReqObj();
    int i = dispatch(parame, this.hON, this);
    AppMethodBeat.o(103614);
    return i;
  }
  
  protected final ccd f(q paramq)
  {
    AppMethodBeat.i(103617);
    paramq = ((j.b)paramq.getRespObj()).rgc.Gvz;
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
    return n.b.hOp;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.o
 * JD-Core Version:    0.7.0.1
 */