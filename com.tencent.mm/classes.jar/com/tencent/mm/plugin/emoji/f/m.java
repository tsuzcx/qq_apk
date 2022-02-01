package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bbe;
import com.tencent.mm.protocal.protobuf.bbf;
import com.tencent.mm.sdk.platformtools.ae;

public final class m
  extends n
  implements k
{
  private f callback;
  public byte[] pME;
  private String pMF;
  private final b rr;
  
  public m(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108703);
    this.pME = null;
    b.a locala = new b.a();
    locala.hQF = new bbe();
    locala.hQG = new bbf();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetemotiondonorlist";
    locala.funcId = 299;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    this.pME = paramArrayOfByte;
    this.pMF = paramString;
    AppMethodBeat.o(108703);
  }
  
  public final bbf ciy()
  {
    return (bbf)this.rr.hQE.hQJ;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(108705);
    this.callback = paramf;
    paramf = (bbe)this.rr.hQD.hQJ;
    if (this.pME != null) {}
    for (paramf.ReqBuf = z.al(this.pME);; paramf.ReqBuf = new SKBuiltinBuffer_t())
    {
      paramf.ProductID = this.pMF;
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
    ae.d("MicroMsg.emoji.NetSceneGetEmotionDonorList", "ErrType:" + paramInt2 + "   errCode:" + paramInt3);
    paramq = (bbf)((b)paramq).hQE.hQJ;
    if (paramq.FOC != null) {
      this.pME = z.a(paramq.FOC);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.m
 * JD-Core Version:    0.7.0.1
 */