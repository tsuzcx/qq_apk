package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m.a;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class o
  extends p
  implements k, e
{
  private final q ftU;
  private boolean mhc;
  private String mhh;
  
  public o(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(88);
    this.mhc = false;
    this.mhh = "";
    this.ftU = new f();
    j.a locala = (j.a)this.ftU.getReqObj();
    locala.mgO.wZA = p.mhi;
    locala.mgO.wZC = paramLong;
    locala.mgO.xGH = paramString1;
    locala.mgO.xGI = paramString2;
    AppMethodBeat.o(88);
  }
  
  final void Nm(String paramString)
  {
    AppMethodBeat.i(91);
    ((j.a)this.ftU.getReqObj()).mgO.wZA = paramString;
    AppMethodBeat.o(91);
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
    AppMethodBeat.i(90);
    ab.d("MicroMsg.NetSceneFaceRegFaceRsa", "hy: onGYNetEnd  errType:" + paramInt1 + " errCode:" + paramInt2);
    paramq = (j.b)paramq.getRespObj();
    boolean bool1;
    int i;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (paramq.mgP.xGK == 0)
      {
        bool1 = true;
        this.mhc = bool1;
        this.mhh = paramq.mgP.xGJ;
        i = paramq.mgP.xGK;
        boolean bool3 = this.mhc;
        paramInt2 = paramq.mgP.xGK;
        if (bo.isNullOrNil(this.mhh)) {
          break label189;
        }
        bool1 = bool2;
        label129:
        ab.i("MicroMsg.NetSceneFaceRegFaceRsa", "hy: is verify ok: %b, youtuRet; %d, has random pwd: %b", new Object[] { Boolean.valueOf(bool3), Integer.valueOf(paramInt2), Boolean.valueOf(bool1) });
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt1, i, paramString, this);
      AppMethodBeat.o(90);
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
        if (paramq.mgP != null)
        {
          i = paramInt2;
          if (paramq.mgP.xGK != 0)
          {
            ab.i("MicroMsg.NetSceneFaceRegFaceRsa", "hy: has detail ret. use");
            i = paramq.mgP.xGK;
          }
        }
      }
    }
  }
  
  final int f(com.tencent.mm.network.e parame)
  {
    AppMethodBeat.i(89);
    this.ftU.getReqObj();
    int i = dispatch(parame, this.ftU, this);
    AppMethodBeat.o(89);
    return i;
  }
  
  protected final bfu f(q paramq)
  {
    AppMethodBeat.i(92);
    paramq = ((j.b)paramq.getRespObj()).mgP.wZE;
    AppMethodBeat.o(92);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.o
 * JD-Core Version:    0.7.0.1
 */