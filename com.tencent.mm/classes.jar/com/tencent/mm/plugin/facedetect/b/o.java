package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ccx;
import com.tencent.mm.protocal.protobuf.ctp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class o
  extends p
  implements k, e
{
  private final q hRG;
  private boolean ros;
  private String rox;
  
  public o(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103613);
    this.ros = false;
    this.rox = "";
    this.hRG = new f();
    j.a locala = (j.a)this.hRG.getReqObj();
    locala.roe.GOU = p.roy;
    locala.roe.GOW = paramLong;
    locala.roe.HEC = paramString1;
    locala.roe.HED = paramString2;
    AppMethodBeat.o(103613);
  }
  
  final void agO(String paramString)
  {
    AppMethodBeat.i(103616);
    ((j.a)this.hRG.getReqObj()).roe.GOU = paramString;
    AppMethodBeat.o(103616);
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    boolean bool2 = true;
    AppMethodBeat.i(103615);
    ae.d("MicroMsg.NetSceneFaceRegFaceRsa", "hy: onGYNetEnd  errType:" + paramInt1 + " errCode:" + paramInt2);
    paramq = (j.b)paramq.getRespObj();
    boolean bool1;
    int i;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (paramq.rof.HEF == 0)
      {
        bool1 = true;
        this.ros = bool1;
        this.rox = paramq.rof.HEE;
        i = paramq.rof.HEF;
        boolean bool3 = this.ros;
        paramInt2 = paramq.rof.HEF;
        if (bu.isNullOrNil(this.rox)) {
          break label189;
        }
        bool1 = bool2;
        label129:
        ae.i("MicroMsg.NetSceneFaceRegFaceRsa", "hy: is verify ok: %b, youtuRet; %d, has random pwd: %b", new Object[] { Boolean.valueOf(bool3), Integer.valueOf(paramInt2), Boolean.valueOf(bool1) });
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
        if (paramq.rof != null)
        {
          i = paramInt2;
          if (paramq.rof.HEF != 0)
          {
            ae.i("MicroMsg.NetSceneFaceRegFaceRsa", "hy: has detail ret. use");
            i = paramq.rof.HEF;
          }
        }
      }
    }
  }
  
  public final boolean cuf()
  {
    return true;
  }
  
  public final String cug()
  {
    return this.rox;
  }
  
  final int f(com.tencent.mm.network.e parame)
  {
    AppMethodBeat.i(103614);
    this.hRG.getReqObj();
    int i = dispatch(parame, this.hRG, this);
    AppMethodBeat.o(103614);
    return i;
  }
  
  protected final ccx f(q paramq)
  {
    AppMethodBeat.i(103617);
    paramq = ((j.b)paramq.getRespObj()).rof.GOY;
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
    return n.b.hRi;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.o
 * JD-Core Version:    0.7.0.1
 */