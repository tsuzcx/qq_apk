package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q.a;
import com.tencent.mm.an.q.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dcb;
import com.tencent.mm.protocal.protobuf.ezx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class u
  extends q
  implements f
{
  private final s lCW;
  private boolean wvU;
  private String wvZ;
  
  public u(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103629);
    this.wvU = false;
    this.wvZ = "";
    this.lCW = new h();
    l.a locala = (l.a)this.lCW.getReqObj();
    locala.wvF.TbJ = bkW();
    locala.wvF.TbM = paramLong;
    locala.wvF.UbP = paramString2;
    locala.wvF.UbO = paramString1;
    AppMethodBeat.o(103629);
  }
  
  final void azz(String paramString)
  {
    AppMethodBeat.i(103632);
    ((l.a)this.lCW.getReqObj()).wvF.TbJ = paramString;
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
      if (params.wvG.UbR == 0)
      {
        bool1 = true;
        this.wvU = bool1;
        this.wvZ = params.wvG.UbQ;
        boolean bool3 = this.wvU;
        paramInt2 = params.wvG.UbR;
        if (Util.isNullOrNil(this.wvZ)) {
          break label189;
        }
        bool1 = bool2;
        Log.i("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: is verify ok: %b, youtuRet: %d, has random pwd: %b", new Object[] { Boolean.valueOf(bool3), Integer.valueOf(paramInt2), Boolean.valueOf(bool1) });
        i = params.wvG.UbR;
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
        if (params.wvG != null)
        {
          i = paramInt2;
          if (params.wvG.UbR != 0)
          {
            Log.i("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: has detail ret. use");
            i = params.wvG.UbR;
          }
        }
      }
    }
  }
  
  public final boolean dhS()
  {
    return true;
  }
  
  public final String dhT()
  {
    return this.wvZ;
  }
  
  final int f(g paramg)
  {
    AppMethodBeat.i(103630);
    this.lCW.getReqObj();
    int i = dispatch(paramg, this.lCW, this);
    AppMethodBeat.o(103630);
    return i;
  }
  
  protected final dcb g(s params)
  {
    AppMethodBeat.i(103633);
    params = ((l.b)params.getRespObj()).wvG.TbO;
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
    return q.b.lCx;
  }
  
  public final void setSecurityCheckError(q.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.u
 * JD-Core Version:    0.7.0.1
 */