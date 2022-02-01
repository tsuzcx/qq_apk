package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fwa;
import com.tencent.mm.protocal.protobuf.fwb;
import com.tencent.mm.sdk.platformtools.Log;

public final class t
  extends a
  implements m, f
{
  private h callback;
  private c rr;
  private boolean zSb;
  
  public t(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103626);
    this.zSb = false;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fwa();
    ((c.a)localObject).otF = new fwb();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyface";
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fwa)c.b.b(this.rr.otB);
    ((fwa)localObject).aaoY = paramLong;
    ((fwa)localObject).absZ = paramString1;
    ((fwa)localObject).abta = paramString2;
    AppMethodBeat.o(103626);
  }
  
  public final boolean dOD()
  {
    return true;
  }
  
  public final String dOE()
  {
    return null;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(103627);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(103627);
    return i;
  }
  
  public final int getType()
  {
    return 797;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103628);
    params = (fwb)c.c.b(((c)params).otC);
    boolean bool;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      if (params.abtc == 0)
      {
        bool = true;
        this.zSb = bool;
        paramInt1 = params.abtc;
        Log.i("MicroMsg.NetSceneFaceVerifyFace", "hy: is Verified: %b", new Object[] { Boolean.valueOf(this.zSb) });
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
        if (params.abtc != 0)
        {
          Log.i("MicroMsg.NetSceneFaceVerifyFace", "hy: has DetailRet, use it");
          paramInt1 = params.abtc;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.t
 * JD-Core Version:    0.7.0.1
 */