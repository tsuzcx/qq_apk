package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.atm;
import com.tencent.mm.protocal.protobuf.atn;
import com.tencent.mm.sdk.platformtools.ad;

public final class m
  extends n
  implements k
{
  private g callback;
  public byte[] oyQ;
  private String oyR;
  private final b rr;
  
  public m(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108703);
    this.oyQ = null;
    b.a locala = new b.a();
    locala.gUU = new atm();
    locala.gUV = new atn();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetemotiondonorlist";
    locala.funcId = 299;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    this.oyQ = paramArrayOfByte;
    this.oyR = paramString;
    AppMethodBeat.o(108703);
  }
  
  public final atn bVr()
  {
    return (atn)this.rr.gUT.gUX;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(108705);
    this.callback = paramg;
    paramg = (atm)this.rr.gUS.gUX;
    if (this.oyQ != null) {}
    for (paramg.ReqBuf = z.am(this.oyQ);; paramg.ReqBuf = new SKBuiltinBuffer_t())
    {
      paramg.ProductID = this.oyR;
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
    paramq = (atn)((b)paramq).gUT.gUX;
    if (paramq.Cyq != null) {
      this.oyQ = z.a(paramq.Cyq);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.m
 * JD-Core Version:    0.7.0.1
 */