package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bao;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.sdk.platformtools.ad;

public final class m
  extends n
  implements k
{
  private f callback;
  public byte[] pGa;
  private String pGb;
  private final b rr;
  
  public m(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108703);
    this.pGa = null;
    b.a locala = new b.a();
    locala.hNM = new bao();
    locala.hNN = new bap();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetemotiondonorlist";
    locala.funcId = 299;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.pGa = paramArrayOfByte;
    this.pGb = paramString;
    AppMethodBeat.o(108703);
  }
  
  public final bap chi()
  {
    return (bap)this.rr.hNL.hNQ;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(108705);
    this.callback = paramf;
    paramf = (bao)this.rr.hNK.hNQ;
    if (this.pGa != null) {}
    for (paramf.ReqBuf = z.al(this.pGa);; paramf.ReqBuf = new SKBuiltinBuffer_t())
    {
      paramf.ProductID = this.pGb;
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(108705);
      return i;
    }
  }
  
  public final int getType()
  {
    return 299;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108704);
    ad.d("MicroMsg.emoji.NetSceneGetEmotionDonorList", "ErrType:" + paramInt2 + "   errCode:" + paramInt3);
    paramq = (bap)((b)paramq).hNL.hNQ;
    if (paramq.Fwe != null) {
      this.pGa = z.a(paramq.Fwe);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.m
 * JD-Core Version:    0.7.0.1
 */