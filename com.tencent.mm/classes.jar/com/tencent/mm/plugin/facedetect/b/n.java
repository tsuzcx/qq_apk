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
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dme;
import com.tencent.mm.protocal.protobuf.dmf;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
  extends q
  implements m, e
{
  private i callback;
  private d rr;
  private boolean sPX;
  private String sQa;
  
  public n(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103610);
    this.sPX = false;
    this.sQa = null;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dme();
    ((d.a)localObject).iLO = new dmf();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/registerface";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dme)this.rr.iLK.iLR;
    ((dme)localObject).LTb = paramLong;
    ((dme)localObject).MPK = paramString1;
    ((dme)localObject).MPL = paramString2;
    AppMethodBeat.o(103610);
  }
  
  public final boolean cSO()
  {
    return true;
  }
  
  public final String cSP()
  {
    return this.sQa;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(103611);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(103611);
    return i;
  }
  
  public final int getType()
  {
    return 918;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103612);
    params = (dmf)((d)params).iLL.iLR;
    boolean bool;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      if (params.MPN == 0)
      {
        bool = true;
        this.sPX = bool;
        this.sQa = params.MPM;
        paramInt1 = params.MPN;
        Log.i("MicroMsg.NetSceneFaceRegFace", "hy: is Verified: %b", new Object[] { Boolean.valueOf(this.sPX) });
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
      if (params != null)
      {
        paramInt1 = paramInt3;
        if (params.MPN != 0)
        {
          Log.i("MicroMsg.NetSceneFaceRegFace", "hy: has detail ret. use");
          paramInt1 = params.MPN;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.n
 * JD-Core Version:    0.7.0.1
 */