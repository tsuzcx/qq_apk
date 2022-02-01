package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.djg;
import com.tencent.mm.protocal.protobuf.djh;
import com.tencent.mm.sdk.platformtools.ad;

public final class s
  extends n
  implements k, e
{
  private g callback;
  private boolean pNR;
  private b rr;
  
  public s(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103626);
    this.pNR = false;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new djg();
    ((b.a)localObject).gUV = new djh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyface";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (djg)this.rr.gUS.gUX;
    ((djg)localObject).Drr = paramLong;
    ((djg)localObject).EdQ = paramString1;
    ((djg)localObject).EdR = paramString2;
    AppMethodBeat.o(103626);
  }
  
  public final boolean cfs()
  {
    return true;
  }
  
  public final String cft()
  {
    return null;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(103627);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(103627);
    return i;
  }
  
  public final int getType()
  {
    return 797;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103628);
    paramq = (djh)((b)paramq).gUT.gUX;
    boolean bool;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      if (paramq.EdT == 0)
      {
        bool = true;
        this.pNR = bool;
        paramInt1 = paramq.EdT;
        ad.i("MicroMsg.NetSceneFaceVerifyFace", "hy: is Verified: %b", new Object[] { Boolean.valueOf(this.pNR) });
      }
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
      }
      AppMethodBeat.o(103628);
      return;
      bool = false;
      break;
      paramInt1 = paramInt3;
      if (paramq != null)
      {
        paramInt1 = paramInt3;
        if (paramq.EdT != 0)
        {
          ad.i("MicroMsg.NetSceneFaceVerifyFace", "hy: has DetailRet, use it");
          paramInt1 = paramq.EdT;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.s
 * JD-Core Version:    0.7.0.1
 */