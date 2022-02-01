package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dov;
import com.tencent.mm.protocal.protobuf.dow;
import com.tencent.mm.sdk.platformtools.ac;

public final class s
  extends n
  implements k, e
{
  private g callback;
  private boolean qwz;
  private b rr;
  
  public s(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103626);
    this.qwz = false;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dov();
    ((b.a)localObject).hvu = new dow();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyface";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dov)this.rr.hvr.hvw;
    ((dov)localObject).EMt = paramLong;
    ((dov)localObject).FAO = paramString1;
    ((dov)localObject).FAP = paramString2;
    AppMethodBeat.o(103626);
  }
  
  public final boolean cmZ()
  {
    return true;
  }
  
  public final String cna()
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
    paramq = (dow)((b)paramq).hvs.hvw;
    boolean bool;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      if (paramq.FAS == 0)
      {
        bool = true;
        this.qwz = bool;
        paramInt1 = paramq.FAS;
        ac.i("MicroMsg.NetSceneFaceVerifyFace", "hy: is Verified: %b", new Object[] { Boolean.valueOf(this.qwz) });
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
        if (paramq.FAS != 0)
        {
          ac.i("MicroMsg.NetSceneFaceVerifyFace", "hy: has DetailRet, use it");
          paramInt1 = paramq.FAS;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.s
 * JD-Core Version:    0.7.0.1
 */