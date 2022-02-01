package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ccx;
import com.tencent.mm.protocal.protobuf.dvk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class t
  extends p
  implements k, e
{
  private final q hRG;
  private boolean ros;
  private String rox;
  
  public t(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103629);
    this.ros = false;
    this.rox = "";
    this.hRG = new g();
    k.a locala = (k.a)this.hRG.getReqObj();
    locala.rog.GOU = p.roy;
    locala.rog.GOW = paramLong;
    locala.rog.HED = paramString2;
    locala.rog.HEC = paramString1;
    AppMethodBeat.o(103629);
  }
  
  final void agO(String paramString)
  {
    AppMethodBeat.i(103632);
    ((k.a)this.hRG.getReqObj()).rog.GOU = paramString;
    AppMethodBeat.o(103632);
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    boolean bool2 = true;
    AppMethodBeat.i(103631);
    ae.d("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: onGYNetEnd  errType:" + paramInt1 + " errCode:" + paramInt2);
    paramq = (k.b)paramq.getRespObj();
    boolean bool1;
    label119:
    int i;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (paramq.roh.HEF == 0)
      {
        bool1 = true;
        this.ros = bool1;
        this.rox = paramq.roh.HEE;
        boolean bool3 = this.ros;
        paramInt2 = paramq.roh.HEF;
        if (bu.isNullOrNil(this.rox)) {
          break label189;
        }
        bool1 = bool2;
        ae.i("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: is verify ok: %b, youtuRet: %d, has random pwd: %b", new Object[] { Boolean.valueOf(bool3), Integer.valueOf(paramInt2), Boolean.valueOf(bool1) });
        i = paramq.roh.HEF;
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
        if (paramq.roh != null)
        {
          i = paramInt2;
          if (paramq.roh.HEF != 0)
          {
            ae.i("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: has detail ret. use");
            i = paramq.roh.HEF;
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
    AppMethodBeat.i(103630);
    this.hRG.getReqObj();
    int i = dispatch(parame, this.hRG, this);
    AppMethodBeat.o(103630);
    return i;
  }
  
  protected final ccx f(q paramq)
  {
    AppMethodBeat.i(103633);
    paramq = ((k.b)paramq.getRespObj()).roh.GOY;
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
    return n.b.hRi;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.t
 * JD-Core Version:    0.7.0.1
 */