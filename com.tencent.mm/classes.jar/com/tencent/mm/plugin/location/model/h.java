package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bpv;
import com.tencent.mm.protocal.protobuf.bpw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class h
  extends q
  implements m
{
  private i callback;
  public final d rr;
  private byte[] yFF;
  String yFG;
  
  public h(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(55691);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bpv();
    ((d.a)localObject).iLO = new bpw();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getlocimg";
    ((d.a)localObject).funcId = 648;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bpv)this.rr.iLK.iLR;
    ((bpv)localObject).rBI = paramString2;
    if (Util.isOverseasUser(MMApplicationContext.getContext())) {}
    for (((bpv)localObject).LXN = 1;; ((bpv)localObject).LXN = 0)
    {
      ((bpv)localObject).LbD = paramFloat1;
      ((bpv)localObject).LbC = paramFloat2;
      ((bpv)localObject).LXO = paramInt1;
      Log.i("MicroMsg.NetSceneGetLocImg", "src w %d h %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      while (paramInt2 * paramInt3 > 270000)
      {
        paramInt2 = (int)(paramInt2 / 1.2D);
        paramInt3 = (int)(paramInt3 / 1.2D);
      }
    }
    Log.i("MicroMsg.NetSceneGetLocImg", "NetSceneGetLocImg %f %f %d w = %d h = %d lan=%s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), ((bpv)localObject).rBI });
    ((bpv)localObject).Height = paramInt3;
    ((bpv)localObject).Width = paramInt2;
    this.yFG = paramString1;
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(55693);
    Log.d("MicroMsg.NetSceneGetLocImg", "onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    params = (bpw)((d)params).iLL.iLR;
    try
    {
      this.yFF = params.KHp.getBuffer().zy;
      com.tencent.mm.vfs.s.f(this.yFG, this.yFF, this.yFF.length);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.h
 * JD-Core Version:    0.7.0.1
 */