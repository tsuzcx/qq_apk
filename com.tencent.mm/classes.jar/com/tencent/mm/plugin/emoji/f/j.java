package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bba;
import com.tencent.mm.protocal.protobuf.bbb;
import com.tencent.mm.sdk.platformtools.ae;

public final class j
  extends n
  implements k
{
  private f gCo;
  private String pMA;
  public String pMz;
  public final b rr;
  
  public j(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108692);
    b.a locala = new b.a();
    locala.hQF = new bba();
    locala.hQG = new bbb();
    locala.uri = "/cgi-bin/micromsg-bin/getemotionactivity";
    locala.funcId = 368;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    this.pMz = paramString1;
    this.pMA = paramString2;
    AppMethodBeat.o(108692);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(108693);
    this.gCo = paramf;
    paramf = (bba)this.rr.hQD.hQJ;
    paramf.GRa = this.pMz;
    paramf.Md5 = this.pMA;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(108693);
    return i;
  }
  
  public final int getType()
  {
    return 368;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108694);
    ae.i("MicroMsg.emoji.NetSceneGetEmotionActivity", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.j
 * JD-Core Version:    0.7.0.1
 */