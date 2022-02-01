package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cil;
import com.tencent.mm.protocal.protobuf.cim;
import com.tencent.mm.sdk.platformtools.ad;

public final class n
  extends com.tencent.mm.al.n
  implements k, e
{
  private g callback;
  private boolean pNR;
  private String pNU;
  private b rr;
  
  public n(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103610);
    this.pNR = false;
    this.pNU = null;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cil();
    ((b.a)localObject).gUV = new cim();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/registerface";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (cil)this.rr.gUS.gUX;
    ((cil)localObject).Drr = paramLong;
    ((cil)localObject).EdQ = paramString1;
    ((cil)localObject).EdR = paramString2;
    AppMethodBeat.o(103610);
  }
  
  public final boolean cfs()
  {
    return true;
  }
  
  public final String cft()
  {
    return this.pNU;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(103611);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(103611);
    return i;
  }
  
  public final int getType()
  {
    return 918;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103612);
    paramq = (cim)((b)paramq).gUT.gUX;
    boolean bool;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      if (paramq.EdT == 0)
      {
        bool = true;
        this.pNR = bool;
        this.pNU = paramq.EdS;
        paramInt1 = paramq.EdT;
        ad.i("MicroMsg.NetSceneFaceRegFace", "hy: is Verified: %b", new Object[] { Boolean.valueOf(this.pNR) });
      }
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
      }
      AppMethodBeat.o(103612);
      return;
      bool = false;
      break;
      paramInt1 = paramInt3;
      if (paramq != null)
      {
        paramInt1 = paramInt3;
        if (paramq.EdT != 0)
        {
          ad.i("MicroMsg.NetSceneFaceRegFace", "hy: has detail ret. use");
          paramInt1 = paramq.EdT;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.n
 * JD-Core Version:    0.7.0.1
 */