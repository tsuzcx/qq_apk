package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eov;
import com.tencent.mm.protocal.protobuf.eow;
import com.tencent.mm.sdk.platformtools.Log;

public final class o
  extends p
  implements m, f
{
  private h callback;
  private c rr;
  private boolean zSb;
  private String zSf;
  
  public o(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103610);
    this.zSb = false;
    this.zSf = null;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new eov();
    ((c.a)localObject).otF = new eow();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/registerface";
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (eov)c.b.b(this.rr.otB);
    ((eov)localObject).aaoY = paramLong;
    ((eov)localObject).absZ = paramString1;
    ((eov)localObject).abta = paramString2;
    AppMethodBeat.o(103610);
  }
  
  public final boolean dOD()
  {
    return true;
  }
  
  public final String dOE()
  {
    return this.zSf;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(103611);
    this.callback = paramh;
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
    params = (eow)c.c.b(((c)params).otC);
    boolean bool;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      if (params.abtc == 0)
      {
        bool = true;
        this.zSb = bool;
        this.zSf = params.abtb;
        paramInt1 = params.abtc;
        Log.i("MicroMsg.NetSceneFaceRegFace", "hy: is Verified: %b", new Object[] { Boolean.valueOf(this.zSb) });
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
        if (params.abtc != 0)
        {
          Log.i("MicroMsg.NetSceneFaceRegFace", "hy: has detail ret. use");
          paramInt1 = params.abtc;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.o
 * JD-Core Version:    0.7.0.1
 */