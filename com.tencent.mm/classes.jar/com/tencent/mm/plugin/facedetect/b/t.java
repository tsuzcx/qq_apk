package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.protocal.protobuf.dow;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class t
  extends p
  implements k, e
{
  private final q hwy;
  private String qwD;
  private boolean qwz;
  
  public t(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103629);
    this.qwz = false;
    this.qwD = "";
    this.hwy = new g();
    k.a locala = (k.a)this.hwy.getReqObj();
    locala.qwn.EMr = p.qwE;
    locala.qwn.EMt = paramLong;
    locala.qwn.FAP = paramString2;
    locala.qwn.FAO = paramString1;
    AppMethodBeat.o(103629);
  }
  
  final void acd(String paramString)
  {
    AppMethodBeat.i(103632);
    ((k.a)this.hwy.getReqObj()).qwn.EMr = paramString;
    AppMethodBeat.o(103632);
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    boolean bool2 = true;
    AppMethodBeat.i(103631);
    ac.d("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: onGYNetEnd  errType:" + paramInt1 + " errCode:" + paramInt2);
    paramq = (k.b)paramq.getRespObj();
    boolean bool1;
    label119:
    int i;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (paramq.qwo.FAS == 0)
      {
        bool1 = true;
        this.qwz = bool1;
        this.qwD = paramq.qwo.FAQ;
        boolean bool3 = this.qwz;
        paramInt2 = paramq.qwo.FAS;
        if (bs.isNullOrNil(this.qwD)) {
          break label189;
        }
        bool1 = bool2;
        ac.i("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: is verify ok: %b, youtuRet: %d, has random pwd: %b", new Object[] { Boolean.valueOf(bool3), Integer.valueOf(paramInt2), Boolean.valueOf(bool1) });
        i = paramq.qwo.FAS;
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
        if (paramq.qwo != null)
        {
          i = paramInt2;
          if (paramq.qwo.FAS != 0)
          {
            ac.i("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: has detail ret. use");
            i = paramq.qwo.FAS;
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
    AppMethodBeat.i(103630);
    this.hwy.getReqObj();
    int i = dispatch(parame, this.hwy, this);
    AppMethodBeat.o(103630);
    return i;
  }
  
  protected final bxm f(q paramq)
  {
    AppMethodBeat.i(103633);
    paramq = ((k.b)paramq.getRespObj()).qwo.EMv;
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
    return n.b.hwa;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.t
 * JD-Core Version:    0.7.0.1
 */