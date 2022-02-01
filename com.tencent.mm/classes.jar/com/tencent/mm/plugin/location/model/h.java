package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bxp;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public final class h
  extends q
  implements m
{
  private byte[] Ejy;
  String Ejz;
  private i callback;
  public final d rr;
  
  public h(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(55691);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new bxp();
    ((d.a)localObject).lBV = new bxq();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getlocimg";
    ((d.a)localObject).funcId = 648;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (bxp)d.b.b(this.rr.lBR);
    ((bxp)localObject).vhq = paramString2;
    if (Util.isOverseasUser(MMApplicationContext.getContext())) {}
    for (((bxp)localObject).The = 1;; ((bxp)localObject).The = 0)
    {
      ((bxp)localObject).ScP = paramFloat1;
      ((bxp)localObject).ScO = paramFloat2;
      ((bxp)localObject).Thf = paramInt1;
      Log.i("MicroMsg.NetSceneGetLocImg", "src w %d h %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      while (paramInt2 * paramInt3 > 270000)
      {
        paramInt2 = (int)(paramInt2 / 1.2D);
        paramInt3 = (int)(paramInt3 / 1.2D);
      }
    }
    Log.i("MicroMsg.NetSceneGetLocImg", "NetSceneGetLocImg %f %f %d w = %d h = %d lan=%s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), ((bxp)localObject).vhq });
    ((bxp)localObject).Height = paramInt3;
    ((bxp)localObject).Width = paramInt2;
    this.Ejz = paramString1;
    AppMethodBeat.o(55691);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(55692);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(55692);
    return i;
  }
  
  public final int getType()
  {
    return 648;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(55693);
    Log.d("MicroMsg.NetSceneGetLocImg", "onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    params = (bxq)d.c.b(((d)params).lBS);
    try
    {
      this.Ejy = params.RIH.Tkb.UH;
      u.f(this.Ejz, this.Ejy, this.Ejy.length);
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(55693);
      return;
    }
    catch (Exception params)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneGetLocImg", params, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.h
 * JD-Core Version:    0.7.0.1
 */