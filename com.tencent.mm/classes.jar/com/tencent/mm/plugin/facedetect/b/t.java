package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ezw;
import com.tencent.mm.protocal.protobuf.ezx;
import com.tencent.mm.sdk.platformtools.Log;

public final class t
  extends a
  implements m, f
{
  private i callback;
  private d rr;
  private boolean wvU;
  
  public t(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103626);
    this.wvU = false;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ezw();
    ((d.a)localObject).lBV = new ezx();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyface";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (ezw)d.b.b(this.rr.lBR);
    ((ezw)localObject).TbM = paramLong;
    ((ezw)localObject).UbO = paramString1;
    ((ezw)localObject).UbP = paramString2;
    AppMethodBeat.o(103626);
  }
  
  public final boolean dhS()
  {
    return true;
  }
  
  public final String dhT()
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103628);
    params = (ezx)d.c.b(((d)params).lBS);
    boolean bool;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      if (params.UbR == 0)
      {
        bool = true;
        this.wvU = bool;
        paramInt1 = params.UbR;
        Log.i("MicroMsg.NetSceneFaceVerifyFace", "hy: is Verified: %b", new Object[] { Boolean.valueOf(this.wvU) });
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
        if (params.UbR != 0)
        {
          Log.i("MicroMsg.NetSceneFaceVerifyFace", "hy: has DetailRet, use it");
          paramInt1 = params.UbR;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.t
 * JD-Core Version:    0.7.0.1
 */