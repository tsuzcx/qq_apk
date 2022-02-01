package com.tencent.mm.plugin.emoji.f;

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
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bmt;
import com.tencent.mm.protocal.protobuf.bmu;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
  extends q
  implements m
{
  private i callback;
  public byte[] rcY;
  private String rcZ;
  private final d rr;
  
  public n(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108703);
    this.rcY = null;
    d.a locala = new d.a();
    locala.iLN = new bmt();
    locala.iLO = new bmu();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetemotiondonorlist";
    locala.funcId = 299;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.rcY = paramArrayOfByte;
    this.rcZ = paramString;
    AppMethodBeat.o(108703);
  }
  
  public final bmu cGw()
  {
    return (bmu)this.rr.iLL.iLR;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(108705);
    this.callback = parami;
    parami = (bmt)this.rr.iLK.iLR;
    if (this.rcY != null) {}
    for (parami.ReqBuf = z.aC(this.rcY);; parami.ReqBuf = new SKBuiltinBuffer_t())
    {
      parami.ProductID = this.rcZ;
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
    params = (bmu)((d)params).iLL.iLR;
    if (params.KIk != null) {
      this.rcY = z.a(params.KIk);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.n
 * JD-Core Version:    0.7.0.1
 */