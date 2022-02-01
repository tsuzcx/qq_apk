package com.tencent.mm.plugin.emoji.e;

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
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.ciz;
import com.tencent.mm.protocal.protobuf.cja;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
  extends p
  implements m
{
  private h callback;
  private final c rr;
  public byte[] xOH;
  private String xOI;
  
  public n(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108703);
    this.xOH = null;
    c.a locala = new c.a();
    locala.otE = new ciz();
    locala.otF = new cja();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetemotiondonorlist";
    locala.funcId = 299;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    this.xOH = paramArrayOfByte;
    this.xOI = paramString;
    AppMethodBeat.o(108703);
  }
  
  public final cja dAE()
  {
    AppMethodBeat.i(269839);
    cja localcja = (cja)c.c.b(this.rr.otC);
    AppMethodBeat.o(269839);
    return localcja;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(108705);
    this.callback = paramh;
    paramh = (ciz)c.b.b(this.rr.otB);
    if (this.xOH != null) {}
    for (paramh.YGU = w.aN(this.xOH);; paramh.YGU = new gol())
    {
      paramh.ProductID = this.xOI;
      int i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(108705);
      return i;
    }
  }
  
  public final int getType()
  {
    return 299;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108704);
    Log.d("MicroMsg.emoji.NetSceneGetEmotionDonorList", "ErrType:" + paramInt2 + "   errCode:" + paramInt3);
    params = (cja)c.c.b(((c)params).otC);
    if (params.YGV != null) {
      this.xOH = w.a(params.YGV);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.n
 * JD-Core Version:    0.7.0.1
 */