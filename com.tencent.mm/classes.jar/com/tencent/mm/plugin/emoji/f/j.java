package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bak;
import com.tencent.mm.protocal.protobuf.bal;
import com.tencent.mm.sdk.platformtools.ad;

public final class j
  extends n
  implements k
{
  private f gzH;
  public String pFV;
  private String pFW;
  public final b rr;
  
  public j(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108692);
    b.a locala = new b.a();
    locala.hNM = new bak();
    locala.hNN = new bal();
    locala.uri = "/cgi-bin/micromsg-bin/getemotionactivity";
    locala.funcId = 368;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.pFV = paramString1;
    this.pFW = paramString2;
    AppMethodBeat.o(108692);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(108693);
    this.gzH = paramf;
    paramf = (bak)this.rr.hNK.hNQ;
    paramf.GxA = this.pFV;
    paramf.Md5 = this.pFW;
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
    ad.i("MicroMsg.emoji.NetSceneGetEmotionActivity", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.j
 * JD-Core Version:    0.7.0.1
 */