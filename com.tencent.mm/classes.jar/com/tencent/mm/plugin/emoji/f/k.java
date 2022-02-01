package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bty;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
  extends q
  implements m
{
  private i jQg;
  public final d rr;
  private String uFY;
  public String uFZ;
  private String uGa;
  
  public k(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(256290);
    Log.i("MicroMsg.emoji.NetSceneGetEmotionActivity", "NetSceneGetEmotionActivity: %s, %s, %s", new Object[] { paramString1, paramString2, paramString3 });
    d.a locala = new d.a();
    locala.lBU = new bty();
    locala.lBV = new btz();
    locala.uri = "/cgi-bin/micromsg-bin/getemotionactivity";
    locala.funcId = 368;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    this.uFY = paramString1;
    this.uFZ = paramString2;
    this.uGa = paramString3;
    AppMethodBeat.o(256290);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(108693);
    this.jQg = parami;
    parami = (bty)d.b.b(this.rr.lBR);
    parami.TdZ = this.uFY;
    parami.Md5 = this.uFZ;
    parami.StN = this.uGa;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(108693);
    return i;
  }
  
  public final int getType()
  {
    return 368;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108694);
    Log.i("MicroMsg.emoji.NetSceneGetEmotionActivity", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.k
 * JD-Core Version:    0.7.0.1
 */