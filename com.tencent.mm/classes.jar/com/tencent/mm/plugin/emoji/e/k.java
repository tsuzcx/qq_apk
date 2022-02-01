package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cit;
import com.tencent.mm.protocal.protobuf.ciu;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
  extends p
  implements m
{
  private h mAY;
  public final c rr;
  private String xOB;
  public String xOC;
  private String xOD;
  
  public k(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(269810);
    Log.i("MicroMsg.emoji.NetSceneGetEmotionActivity", "NetSceneGetEmotionActivity: %s, %s, %s", new Object[] { paramString1, paramString2, paramString3 });
    c.a locala = new c.a();
    locala.otE = new cit();
    locala.otF = new ciu();
    locala.uri = "/cgi-bin/micromsg-bin/getemotionactivity";
    locala.funcId = 368;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    this.xOB = paramString1;
    this.xOC = paramString2;
    this.xOD = paramString3;
    AppMethodBeat.o(269810);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(108693);
    this.mAY = paramh;
    paramh = (cit)c.b.b(this.rr.otB);
    paramh.aaro = this.xOB;
    paramh.Md5 = this.xOC;
    paramh.Ztx = this.xOD;
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
    this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.k
 * JD-Core Version:    0.7.0.1
 */