package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p.a;
import com.tencent.mm.am.p.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dtt;
import com.tencent.mm.protocal.protobuf.fwb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class u
  extends q
  implements f
{
  private final s ouH;
  private boolean zSb;
  private String zSg;
  
  public u(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103629);
    this.zSb = false;
    this.zSg = "";
    this.ouH = new h();
    l.a locala = (l.a)this.ouH.getReqObj();
    locala.zRK.aaoV = bIQ();
    locala.zRK.aaoY = paramLong;
    locala.zRK.abta = paramString2;
    locala.zRK.absZ = paramString1;
    AppMethodBeat.o(103629);
  }
  
  final void atG(String paramString)
  {
    AppMethodBeat.i(103632);
    ((l.a)this.ouH.getReqObj()).zRK.aaoV = paramString;
    AppMethodBeat.o(103632);
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, s params)
  {
    boolean bool2 = true;
    AppMethodBeat.i(103631);
    Log.d("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: onGYNetEnd  errType:" + paramInt1 + " errCode:" + paramInt2);
    params = (l.b)params.getRespObj();
    boolean bool1;
    label119:
    int i;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (params.zRL.abtc == 0)
      {
        bool1 = true;
        this.zSb = bool1;
        this.zSg = params.zRL.abtb;
        boolean bool3 = this.zSb;
        paramInt2 = params.zRL.abtc;
        if (Util.isNullOrNil(this.zSg)) {
          break label189;
        }
        bool1 = bool2;
        Log.i("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: is verify ok: %b, youtuRet: %d, has random pwd: %b", new Object[] { Boolean.valueOf(bool3), Integer.valueOf(paramInt2), Boolean.valueOf(bool1) });
        i = params.zRL.abtc;
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
        if (params.zRL != null)
        {
          i = paramInt2;
          if (params.zRL.abtc != 0)
          {
            Log.i("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: has detail ret. use");
            i = params.zRL.abtc;
          }
        }
      }
    }
  }
  
  public final boolean dOD()
  {
    return true;
  }
  
  public final String dOE()
  {
    return this.zSg;
  }
  
  final int g(g paramg)
  {
    AppMethodBeat.i(103630);
    this.ouH.getReqObj();
    int i = dispatch(paramg, this.ouH, this);
    AppMethodBeat.o(103630);
    return i;
  }
  
  protected final dtt g(s params)
  {
    AppMethodBeat.i(103633);
    params = ((l.b)params.getRespObj()).zRL.aapa;
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
  
  public final p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
  }
  
  public final void setSecurityCheckError(p.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.u
 * JD-Core Version:    0.7.0.1
 */