package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q.a;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.protocal.protobuf.epm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class t
  extends p
  implements m, e
{
  private final s iMO;
  private boolean sPX;
  private String sQb;
  
  public t(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103629);
    this.sPX = false;
    this.sQb = "";
    this.iMO = new g();
    k.a locala = (k.a)this.iMO.getReqObj();
    locala.sPL.LSY = p.sQc;
    locala.sPL.LTb = paramLong;
    locala.sPL.MPL = paramString2;
    locala.sPL.MPK = paramString1;
    AppMethodBeat.o(103629);
  }
  
  final void ary(String paramString)
  {
    AppMethodBeat.i(103632);
    ((k.a)this.iMO.getReqObj()).sPL.LSY = paramString;
    AppMethodBeat.o(103632);
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, s params)
  {
    boolean bool2 = true;
    AppMethodBeat.i(103631);
    Log.d("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: onGYNetEnd  errType:" + paramInt1 + " errCode:" + paramInt2);
    params = (k.b)params.getRespObj();
    boolean bool1;
    label119:
    int i;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (params.sPM.MPN == 0)
      {
        bool1 = true;
        this.sPX = bool1;
        this.sQb = params.sPM.MPM;
        boolean bool3 = this.sPX;
        paramInt2 = params.sPM.MPN;
        if (Util.isNullOrNil(this.sQb)) {
          break label189;
        }
        bool1 = bool2;
        Log.i("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: is verify ok: %b, youtuRet: %d, has random pwd: %b", new Object[] { Boolean.valueOf(bool3), Integer.valueOf(paramInt2), Boolean.valueOf(bool1) });
        i = params.sPM.MPN;
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
      if (params != null)
      {
        i = paramInt2;
        if (params.sPM != null)
        {
          i = paramInt2;
          if (params.sPM.MPN != 0)
          {
            Log.i("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: has detail ret. use");
            i = params.sPM.MPN;
          }
        }
      }
    }
  }
  
  public final boolean cSO()
  {
    return true;
  }
  
  public final String cSP()
  {
    return this.sQb;
  }
  
  final int f(com.tencent.mm.network.g paramg)
  {
    AppMethodBeat.i(103630);
    this.iMO.getReqObj();
    int i = dispatch(paramg, this.iMO, this);
    AppMethodBeat.o(103630);
    return i;
  }
  
  protected final ctc f(s params)
  {
    AppMethodBeat.i(103633);
    params = ((k.b)params.getRespObj()).sPM.LTd;
    AppMethodBeat.o(103633);
    return params;
  }
  
  public final int getType()
  {
    return 930;
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.iMq;
  }
  
  public final void setSecurityCheckError(q.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.t
 * JD-Core Version:    0.7.0.1
 */