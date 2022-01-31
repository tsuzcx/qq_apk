package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ama;
import com.tencent.mm.protocal.protobuf.amb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class g
  extends m
  implements k
{
  private f callback;
  private byte[] oag;
  String oah;
  public final com.tencent.mm.ai.b rr;
  
  public g(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(113312);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new ama();
    ((b.a)localObject).fsY = new amb();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getlocimg";
    ((b.a)localObject).funcId = 648;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (ama)this.rr.fsV.fta;
    ((ama)localObject).lGH = paramString2;
    if (bo.hl(ah.getContext())) {}
    for (((ama)localObject).xcS = 1;; ((ama)localObject).xcS = 0)
    {
      ((ama)localObject).wDi = paramFloat1;
      ((ama)localObject).wDh = paramFloat2;
      ((ama)localObject).xcT = paramInt1;
      ab.i("MicroMsg.NetSceneGetLocImg", "src w %d h %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      while (paramInt2 * paramInt3 > 270000)
      {
        paramInt2 = (int)(paramInt2 / 1.2D);
        paramInt3 = (int)(paramInt3 / 1.2D);
      }
    }
    ab.i("MicroMsg.NetSceneGetLocImg", "NetSceneGetLocImg %f %f %d w = %d h = %d lan=%s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), ((ama)localObject).lGH });
    ((ama)localObject).Height = paramInt3;
    ((ama)localObject).Width = paramInt2;
    this.oah = paramString1;
    AppMethodBeat.o(113312);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(113313);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(113313);
    return i;
  }
  
  public final int getType()
  {
    return 648;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(113314);
    ab.d("MicroMsg.NetSceneGetLocImg", "onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramq = (amb)((com.tencent.mm.ai.b)paramq).fsW.fta;
    try
    {
      this.oag = paramq.woT.getBuffer().pW;
      com.tencent.mm.vfs.e.b(this.oah, this.oag, this.oag.length);
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(113314);
      return;
    }
    catch (Exception paramq)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.NetSceneGetLocImg", paramq, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.g
 * JD-Core Version:    0.7.0.1
 */