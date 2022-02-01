package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bdr;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

public final class h
  extends n
  implements k
{
  private f callback;
  public final com.tencent.mm.al.b rr;
  private byte[] uZC;
  String uZD;
  
  public h(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(55691);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bdr();
    ((b.a)localObject).hNN = new bds();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getlocimg";
    ((b.a)localObject).funcId = 648;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bdr)this.rr.hNK.hNQ;
    ((bdr)localObject).qei = paramString2;
    if (bt.jk(aj.getContext())) {}
    for (((bdr)localObject).GAe = 1;; ((bdr)localObject).GAe = 0)
    {
      ((bdr)localObject).FOB = paramFloat1;
      ((bdr)localObject).FOA = paramFloat2;
      ((bdr)localObject).GAf = paramInt1;
      ad.i("MicroMsg.NetSceneGetLocImg", "src w %d h %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      while (paramInt2 * paramInt3 > 270000)
      {
        paramInt2 = (int)(paramInt2 / 1.2D);
        paramInt3 = (int)(paramInt3 / 1.2D);
      }
    }
    ad.i("MicroMsg.NetSceneGetLocImg", "NetSceneGetLocImg %f %f %d w = %d h = %d lan=%s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), ((bdr)localObject).qei });
    ((bdr)localObject).Height = paramInt3;
    ((bdr)localObject).Width = paramInt2;
    this.uZD = paramString1;
    AppMethodBeat.o(55691);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(55692);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(55692);
    return i;
  }
  
  public final int getType()
  {
    return 648;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(55693);
    ad.d("MicroMsg.NetSceneGetLocImg", "onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramq = (bds)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    try
    {
      this.uZC = paramq.Fvm.getBuffer().zr;
      i.f(this.uZD, this.uZC, this.uZC.length);
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(55693);
      return;
    }
    catch (Exception paramq)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.NetSceneGetLocImg", paramq, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.h
 * JD-Core Version:    0.7.0.1
 */