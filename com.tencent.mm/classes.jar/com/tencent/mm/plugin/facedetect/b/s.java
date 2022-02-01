package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.aqw;
import com.tencent.mm.protocal.protobuf.aqx;
import com.tencent.mm.sdk.platformtools.Log;

public final class s
  extends p
  implements m
{
  private h callback;
  public String mFileName;
  private c rr;
  
  public s(String paramString1, long paramLong, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(103623);
    this.mFileName = "";
    c.a locala = new c.a();
    locala.otE = new aqw();
    locala.otF = new aqx();
    locala.uri = "/cgi-bin/mmbiz-bin/usrmsg/facevideobindbioid";
    locala.funcId = getType();
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    this.mFileName = paramString1;
    paramString1 = (aqw)c.b.b(this.rr.otB);
    paramString1.appid = paramString2;
    paramString1.Zyc = paramLong;
    paramString1.Zyd = paramString4;
    paramString1.Zyj = paramString3;
    AppMethodBeat.o(103623);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(103624);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(103624);
    return i;
  }
  
  public final int getType()
  {
    return 1197;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103625);
    Log.d("MicroMsg.NetSceneFaceThirdBindVideo", "hy:  errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    c.c.b(((c)params).otC);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(103625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.s
 * JD-Core Version:    0.7.0.1
 */