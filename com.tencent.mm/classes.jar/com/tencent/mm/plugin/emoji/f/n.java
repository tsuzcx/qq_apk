package com.tencent.mm.plugin.emoji.f;

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
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.bue;
import com.tencent.mm.protocal.protobuf.buf;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
  extends q
  implements m
{
  private i callback;
  private final d rr;
  public byte[] uGe;
  private String uGf;
  
  public n(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108703);
    this.uGe = null;
    d.a locala = new d.a();
    locala.lBU = new bue();
    locala.lBV = new buf();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetemotiondonorlist";
    locala.funcId = 299;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    this.uGe = paramArrayOfByte;
    this.uGf = paramString;
    AppMethodBeat.o(108703);
  }
  
  public final buf cVf()
  {
    AppMethodBeat.i(258314);
    buf localbuf = (buf)d.c.b(this.rr.lBS);
    AppMethodBeat.o(258314);
    return localbuf;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(108705);
    this.callback = parami;
    parami = (bue)d.b.b(this.rr.lBR);
    if (this.uGe != null) {}
    for (parami.RJA = z.aN(this.uGe);; parami.RJA = new eae())
    {
      parami.ProductID = this.uGf;
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
    params = (buf)d.c.b(((d)params).lBS);
    if (params.RJB != null) {
      this.uGe = z.a(params.RJB);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.n
 * JD-Core Version:    0.7.0.1
 */