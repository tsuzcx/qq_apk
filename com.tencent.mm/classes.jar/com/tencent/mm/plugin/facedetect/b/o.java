package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q.a;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.protocal.protobuf.dmf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class o
  extends p
  implements m, e
{
  private final s iMO;
  private boolean sPX;
  private String sQb;
  
  public o(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103613);
    this.sPX = false;
    this.sQb = "";
    this.iMO = new f();
    j.a locala = (j.a)this.iMO.getReqObj();
    locala.sPJ.LSY = p.sQc;
    locala.sPJ.LTb = paramLong;
    locala.sPJ.MPK = paramString1;
    locala.sPJ.MPL = paramString2;
    AppMethodBeat.o(103613);
  }
  
  final void ary(String paramString)
  {
    AppMethodBeat.i(103616);
    ((j.a)this.iMO.getReqObj()).sPJ.LSY = paramString;
    AppMethodBeat.o(103616);
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, s params)
  {
    boolean bool2 = true;
    AppMethodBeat.i(103615);
    Log.d("MicroMsg.NetSceneFaceRegFaceRsa", "hy: onGYNetEnd  errType:" + paramInt1 + " errCode:" + paramInt2);
    params = (j.b)params.getRespObj();
    boolean bool1;
    int i;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (params.sPK.MPN == 0)
      {
        bool1 = true;
        this.sPX = bool1;
        this.sQb = params.sPK.MPM;
        i = params.sPK.MPN;
        boolean bool3 = this.sPX;
        paramInt2 = params.sPK.MPN;
        if (Util.isNullOrNil(this.sQb)) {
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
        if (params.sPK != null)
        {
          i = paramInt2;
          if (params.sPK.MPN != 0)
          {
            Log.i("MicroMsg.NetSceneFaceRegFaceRsa", "hy: has detail ret. use");
            i = params.sPK.MPN;
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
  
  final int f(g paramg)
  {
    AppMethodBeat.i(103614);
    this.iMO.getReqObj();
    int i = dispatch(paramg, this.iMO, this);
    AppMethodBeat.o(103614);
    return i;
  }
  
  protected final ctc f(s params)
  {
    AppMethodBeat.i(103617);
    params = ((j.b)params.getRespObj()).sPK.LTd;
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
    return q.b.iMq;
  }
  
  public final void setSecurityCheckError(q.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.o
 * JD-Core Version:    0.7.0.1
 */