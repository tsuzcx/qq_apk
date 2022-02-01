package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.protocal.protobuf.cns;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class o
  extends p
  implements k, e
{
  private final q hwy;
  private String qwD;
  private boolean qwz;
  
  public o(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103613);
    this.qwz = false;
    this.qwD = "";
    this.hwy = new f();
    j.a locala = (j.a)this.hwy.getReqObj();
    locala.qwl.EMr = p.qwE;
    locala.qwl.EMt = paramLong;
    locala.qwl.FAO = paramString1;
    locala.qwl.FAP = paramString2;
    AppMethodBeat.o(103613);
  }
  
  final void acd(String paramString)
  {
    AppMethodBeat.i(103616);
    ((j.a)this.hwy.getReqObj()).qwl.EMr = paramString;
    AppMethodBeat.o(103616);
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    boolean bool2 = true;
    AppMethodBeat.i(103615);
    ac.d("MicroMsg.NetSceneFaceRegFaceRsa", "hy: onGYNetEnd  errType:" + paramInt1 + " errCode:" + paramInt2);
    paramq = (j.b)paramq.getRespObj();
    boolean bool1;
    int i;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (paramq.qwm.FAS == 0)
      {
        bool1 = true;
        this.qwz = bool1;
        this.qwD = paramq.qwm.FAQ;
        i = paramq.qwm.FAS;
        boolean bool3 = this.qwz;
        paramInt2 = paramq.qwm.FAS;
        if (bs.isNullOrNil(this.qwD)) {
          break label189;
        }
        bool1 = bool2;
        label129:
        ac.i("MicroMsg.NetSceneFaceRegFaceRsa", "hy: is verify ok: %b, youtuRet; %d, has random pwd: %b", new Object[] { Boolean.valueOf(bool3), Integer.valueOf(paramInt2), Boolean.valueOf(bool1) });
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
        if (paramq.qwm != null)
        {
          i = paramInt2;
          if (paramq.qwm.FAS != 0)
          {
            ac.i("MicroMsg.NetSceneFaceRegFaceRsa", "hy: has detail ret. use");
            i = paramq.qwm.FAS;
          }
        }
      }
    }
  }
  
  public final boolean cmZ()
  {
    return true;
  }
  
  public final String cna()
  {
    return this.qwD;
  }
  
  final int f(com.tencent.mm.network.e parame)
  {
    AppMethodBeat.i(103614);
    this.hwy.getReqObj();
    int i = dispatch(parame, this.hwy, this);
    AppMethodBeat.o(103614);
    return i;
  }
  
  protected final bxm f(q paramq)
  {
    AppMethodBeat.i(103617);
    paramq = ((j.b)paramq.getRespObj()).qwm.EMv;
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
    return n.b.hwa;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.o
 * JD-Core Version:    0.7.0.1
 */