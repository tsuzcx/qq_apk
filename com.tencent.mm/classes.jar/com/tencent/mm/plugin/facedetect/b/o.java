package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dvv;
import com.tencent.mm.protocal.protobuf.dvw;
import com.tencent.mm.sdk.platformtools.Log;

public final class o
  extends q
  implements m, f
{
  private i callback;
  private d rr;
  private boolean wvU;
  private String wvY;
  
  public o(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103610);
    this.wvU = false;
    this.wvY = null;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dvv();
    ((d.a)localObject).lBV = new dvw();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/registerface";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (dvv)d.b.b(this.rr.lBR);
    ((dvv)localObject).TbM = paramLong;
    ((dvv)localObject).UbO = paramString1;
    ((dvv)localObject).UbP = paramString2;
    AppMethodBeat.o(103610);
  }
  
  public final boolean dhS()
  {
    return true;
  }
  
  public final String dhT()
  {
    return this.wvY;
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
    params = (dvw)d.c.b(((d)params).lBS);
    boolean bool;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      if (params.UbR == 0)
      {
        bool = true;
        this.wvU = bool;
        this.wvY = params.UbQ;
        paramInt1 = params.UbR;
        Log.i("MicroMsg.NetSceneFaceRegFace", "hy: is Verified: %b", new Object[] { Boolean.valueOf(this.wvU) });
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
        if (params.UbR != 0)
        {
          Log.i("MicroMsg.NetSceneFaceRegFace", "hy: has detail ret. use");
          paramInt1 = params.UbR;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.o
 * JD-Core Version:    0.7.0.1
 */