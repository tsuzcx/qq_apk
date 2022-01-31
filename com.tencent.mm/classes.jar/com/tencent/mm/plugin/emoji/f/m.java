package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aka;
import com.tencent.mm.protocal.protobuf.akb;
import com.tencent.mm.sdk.platformtools.ab;

public final class m
  extends com.tencent.mm.ai.m
  implements k
{
  private f callback;
  public byte[] liN;
  private String liO;
  private final b rr;
  
  public m(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(53131);
    this.liN = null;
    b.a locala = new b.a();
    locala.fsX = new aka();
    locala.fsY = new akb();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetemotiondonorlist";
    locala.funcId = 299;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    this.liN = paramArrayOfByte;
    this.liO = paramString;
    AppMethodBeat.o(53131);
  }
  
  public final akb blG()
  {
    return (akb)this.rr.fsW.fta;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(53133);
    this.callback = paramf;
    paramf = (aka)this.rr.fsV.fta;
    if (this.liN != null) {}
    for (paramf.ReqBuf = aa.ac(this.liN);; paramf.ReqBuf = new SKBuiltinBuffer_t())
    {
      paramf.ProductID = this.liO;
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(53133);
      return i;
    }
  }
  
  public final int getType()
  {
    return 299;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(53132);
    ab.d("MicroMsg.emoji.NetSceneGetEmotionDonorList", "ErrType:" + paramInt2 + "   errCode:" + paramInt3);
    paramq = (akb)((b)paramq).fsW.fta;
    if (paramq.wpD != null) {
      this.liN = aa.a(paramq.wpD);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(53132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.m
 * JD-Core Version:    0.7.0.1
 */