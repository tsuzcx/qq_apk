package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.awr;
import com.tencent.mm.sdk.platformtools.ac;

public final class m
  extends n
  implements k
{
  private g callback;
  public byte[] pcq;
  private String pcr;
  private final b rr;
  
  public m(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108703);
    this.pcq = null;
    b.a locala = new b.a();
    locala.hvt = new awq();
    locala.hvu = new awr();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetemotiondonorlist";
    locala.funcId = 299;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    this.pcq = paramArrayOfByte;
    this.pcr = paramString;
    AppMethodBeat.o(108703);
  }
  
  public final awr ccE()
  {
    return (awr)this.rr.hvs.hvw;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(108705);
    this.callback = paramg;
    paramg = (awq)this.rr.hvr.hvw;
    if (this.pcq != null) {}
    for (paramg.ReqBuf = z.al(this.pcq);; paramg.ReqBuf = new SKBuiltinBuffer_t())
    {
      paramg.ProductID = this.pcr;
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
    ac.d("MicroMsg.emoji.NetSceneGetEmotionDonorList", "ErrType:" + paramInt2 + "   errCode:" + paramInt3);
    paramq = (awr)((b)paramq).hvs.hvw;
    if (paramq.DQM != null) {
      this.pcq = z.a(paramq.DQM);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.m
 * JD-Core Version:    0.7.0.1
 */