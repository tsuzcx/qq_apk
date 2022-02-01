package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q.a;
import com.tencent.mm.an.q.b;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dcb;
import com.tencent.mm.protocal.protobuf.dvw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class p
  extends q
  implements f
{
  private final s lCW;
  private boolean wvU;
  private String wvZ;
  
  public p(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103613);
    this.wvU = false;
    this.wvZ = "";
    this.lCW = new g();
    k.a locala = (k.a)this.lCW.getReqObj();
    locala.wvD.TbJ = bkW();
    locala.wvD.TbM = paramLong;
    locala.wvD.UbO = paramString1;
    locala.wvD.UbP = paramString2;
    AppMethodBeat.o(103613);
  }
  
  final void azz(String paramString)
  {
    AppMethodBeat.i(103616);
    ((k.a)this.lCW.getReqObj()).wvD.TbJ = paramString;
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
      if (params.wvE.UbR == 0)
      {
        bool1 = true;
        this.wvU = bool1;
        this.wvZ = params.wvE.UbQ;
        i = params.wvE.UbR;
        boolean bool3 = this.wvU;
        paramInt2 = params.wvE.UbR;
        if (Util.isNullOrNil(this.wvZ)) {
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
        if (params.wvE != null)
        {
          i = paramInt2;
          if (params.wvE.UbR != 0)
          {
            Log.i("MicroMsg.NetSceneFaceRegFaceRsa", "hy: has detail ret. use");
            i = params.wvE.UbR;
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
  
  final int f(com.tencent.mm.network.g paramg)
  {
    AppMethodBeat.i(103614);
    this.lCW.getReqObj();
    int i = dispatch(paramg, this.lCW, this);
    AppMethodBeat.o(103614);
    return i;
  }
  
  protected final dcb g(s params)
  {
    AppMethodBeat.i(103617);
    params = ((k.b)params.getRespObj()).wvE.TbO;
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
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
  
  public final void setSecurityCheckError(q.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.p
 * JD-Core Version:    0.7.0.1
 */