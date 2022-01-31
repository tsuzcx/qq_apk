package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m.a;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.protocal.protobuf.cpw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class t
  extends p
  implements k, e
{
  private final q ftU;
  private boolean mhc;
  private String mhh;
  
  public t(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(104);
    this.mhc = false;
    this.mhh = "";
    this.ftU = new g();
    k.a locala = (k.a)this.ftU.getReqObj();
    locala.mgQ.wZA = p.mhi;
    locala.mgQ.wZC = paramLong;
    locala.mgQ.xGI = paramString2;
    locala.mgQ.xGH = paramString1;
    AppMethodBeat.o(104);
  }
  
  final void Nm(String paramString)
  {
    AppMethodBeat.i(107);
    ((k.a)this.ftU.getReqObj()).mgQ.wZA = paramString;
    AppMethodBeat.o(107);
  }
  
  public final boolean btY()
  {
    return true;
  }
  
  public final String btZ()
  {
    return this.mhh;
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    boolean bool2 = true;
    AppMethodBeat.i(106);
    ab.d("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: onGYNetEnd  errType:" + paramInt1 + " errCode:" + paramInt2);
    paramq = (k.b)paramq.getRespObj();
    boolean bool1;
    label119:
    int i;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (paramq.mgR.xGK == 0)
      {
        bool1 = true;
        this.mhc = bool1;
        this.mhh = paramq.mgR.xGJ;
        boolean bool3 = this.mhc;
        paramInt2 = paramq.mgR.xGK;
        if (bo.isNullOrNil(this.mhh)) {
          break label189;
        }
        bool1 = bool2;
        ab.i("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: is verify ok: %b, youtuRet: %d, has random pwd: %b", new Object[] { Boolean.valueOf(bool3), Integer.valueOf(paramInt2), Boolean.valueOf(bool1) });
        i = paramq.mgR.xGK;
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt1, i, paramString, this);
      AppMethodBeat.o(106);
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
        if (paramq.mgR != null)
        {
          i = paramInt2;
          if (paramq.mgR.xGK != 0)
          {
            ab.i("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: has detail ret. use");
            i = paramq.mgR.xGK;
          }
        }
      }
    }
  }
  
  final int f(com.tencent.mm.network.e parame)
  {
    AppMethodBeat.i(105);
    this.ftU.getReqObj();
    int i = dispatch(parame, this.ftU, this);
    AppMethodBeat.o(105);
    return i;
  }
  
  protected final bfu f(q paramq)
  {
    AppMethodBeat.i(108);
    paramq = ((k.b)paramq.getRespObj()).mgR.wZE;
    AppMethodBeat.o(108);
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
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
  
  public final void setSecurityCheckError(m.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.t
 * JD-Core Version:    0.7.0.1
 */