package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ati;
import com.tencent.mm.protocal.protobuf.atj;
import com.tencent.mm.sdk.platformtools.ad;

public final class j
  extends n
  implements k
{
  private g gbr;
  public String oyL;
  private String oyM;
  public final b rr;
  
  public j(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108692);
    b.a locala = new b.a();
    locala.gUU = new ati();
    locala.gUV = new atj();
    locala.uri = "/cgi-bin/micromsg-bin/getemotionactivity";
    locala.funcId = 368;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    this.oyL = paramString1;
    this.oyM = paramString2;
    AppMethodBeat.o(108692);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(108693);
    this.gbr = paramg;
    paramg = (ati)this.rr.gUS.gUX;
    paramg.Dts = this.oyL;
    paramg.Md5 = this.oyM;
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
    this.gbr.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.j
 * JD-Core Version:    0.7.0.1
 */