package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.epl;
import com.tencent.mm.protocal.protobuf.epm;
import com.tencent.mm.sdk.platformtools.Log;

public final class s
  extends q
  implements m, e
{
  private i callback;
  private d rr;
  private boolean sPX;
  
  public s(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103626);
    this.sPX = false;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new epl();
    ((d.a)localObject).iLO = new epm();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyface";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (epl)this.rr.iLK.iLR;
    ((epl)localObject).LTb = paramLong;
    ((epl)localObject).MPK = paramString1;
    ((epl)localObject).MPL = paramString2;
    AppMethodBeat.o(103626);
  }
  
  public final boolean cSO()
  {
    return true;
  }
  
  public final String cSP()
  {
    return null;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(103627);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(103627);
    return i;
  }
  
  public final int getType()
  {
    return 797;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103628);
    params = (epm)((d)params).iLL.iLR;
    boolean bool;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      if (params.MPN == 0)
      {
        bool = true;
        this.sPX = bool;
        paramInt1 = params.MPN;
        Log.i("MicroMsg.NetSceneFaceVerifyFace", "hy: is Verified: %b", new Object[] { Boolean.valueOf(this.sPX) });
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
      if (params != null)
      {
        paramInt1 = paramInt3;
        if (params.MPN != 0)
        {
          Log.i("MicroMsg.NetSceneFaceVerifyFace", "hy: has DetailRet, use it");
          paramInt1 = params.MPN;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.s
 * JD-Core Version:    0.7.0.1
 */