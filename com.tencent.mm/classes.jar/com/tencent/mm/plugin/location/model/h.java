package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.azn;
import com.tencent.mm.protocal.protobuf.azo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;

public final class h
  extends n
  implements k
{
  private g callback;
  public final com.tencent.mm.ak.b rr;
  private byte[] tWT;
  String tWU;
  
  public h(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(55691);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new azn();
    ((b.a)localObject).hvu = new azo();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getlocimg";
    ((b.a)localObject).funcId = 648;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (azn)this.rr.hvr.hvw;
    ((azn)localObject).pAD = paramString2;
    if (bs.ja(ai.getContext())) {}
    for (((azn)localObject).EQN = 1;; ((azn)localObject).EQN = 0)
    {
      ((azn)localObject).Ehu = paramFloat1;
      ((azn)localObject).Eht = paramFloat2;
      ((azn)localObject).EQO = paramInt1;
      ac.i("MicroMsg.NetSceneGetLocImg", "src w %d h %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      while (paramInt2 * paramInt3 > 270000)
      {
        paramInt2 = (int)(paramInt2 / 1.2D);
        paramInt3 = (int)(paramInt3 / 1.2D);
      }
    }
    ac.i("MicroMsg.NetSceneGetLocImg", "NetSceneGetLocImg %f %f %d w = %d h = %d lan=%s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), ((azn)localObject).pAD });
    ((azn)localObject).Height = paramInt3;
    ((azn)localObject).Width = paramInt2;
    this.tWU = paramString1;
    AppMethodBeat.o(55691);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(55692);
    this.callback = paramg;
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
    ac.d("MicroMsg.NetSceneGetLocImg", "onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramq = (azo)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    try
    {
      this.tWT = paramq.DPX.getBuffer().xy;
      i.f(this.tWU, this.tWT, this.tWT.length);
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
        ac.printErrStackTrace("MicroMsg.NetSceneGetLocImg", paramq, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.h
 * JD-Core Version:    0.7.0.1
 */