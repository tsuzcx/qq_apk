package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p.a;
import com.tencent.mm.am.p.b;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dtt;
import com.tencent.mm.protocal.protobuf.eow;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class p
  extends q
  implements f
{
  private final s ouH;
  private boolean zSb;
  private String zSg;
  
  public p(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103613);
    this.zSb = false;
    this.zSg = "";
    this.ouH = new g();
    k.a locala = (k.a)this.ouH.getReqObj();
    locala.zRI.aaoV = bIQ();
    locala.zRI.aaoY = paramLong;
    locala.zRI.absZ = paramString1;
    locala.zRI.abta = paramString2;
    AppMethodBeat.o(103613);
  }
  
  final void atG(String paramString)
  {
    AppMethodBeat.i(103616);
    ((k.a)this.ouH.getReqObj()).zRI.aaoV = paramString;
    AppMethodBeat.o(103616);
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, s params)
  {
    boolean bool2 = true;
    AppMethodBeat.i(103615);
    Log.d("MicroMsg.NetSceneFaceRegFaceRsa", "hy: onGYNetEnd  errType:" + paramInt1 + " errCode:" + paramInt2);
    params = (k.b)params.getRespObj();
    boolean bool1;
    int i;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (params.zRJ.abtc == 0)
      {
        bool1 = true;
        this.zSb = bool1;
        this.zSg = params.zRJ.abtb;
        i = params.zRJ.abtc;
        boolean bool3 = this.zSb;
        paramInt2 = params.zRJ.abtc;
        if (Util.isNullOrNil(this.zSg)) {
          break label189;
        }
        bool1 = bool2;
        label129:
        Log.i("MicroMsg.NetSceneFaceRegFaceRsa", "hy: is verify ok: %b, youtuRet; %d, has random pwd: %b", new Object[] { Boolean.valueOf(bool3), Integer.valueOf(paramInt2), Boolean.valueOf(bool1) });
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
      if (params != null)
      {
        i = paramInt2;
        if (params.zRJ != null)
        {
          i = paramInt2;
          if (params.zRJ.abtc != 0)
          {
            Log.i("MicroMsg.NetSceneFaceRegFaceRsa", "hy: has detail ret. use");
            i = params.zRJ.abtc;
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
  
  final int g(com.tencent.mm.network.g paramg)
  {
    AppMethodBeat.i(103614);
    this.ouH.getReqObj();
    int i = dispatch(paramg, this.ouH, this);
    AppMethodBeat.o(103614);
    return i;
  }
  
  protected final dtt g(s params)
  {
    AppMethodBeat.i(103617);
    params = ((k.b)params.getRespObj()).zRJ.aapa;
    AppMethodBeat.o(103617);
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
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.p
 * JD-Core Version:    0.7.0.1
 */