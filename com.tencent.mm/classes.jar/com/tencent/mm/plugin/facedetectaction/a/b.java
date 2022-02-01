package com.tencent.mm.plugin.facedetectaction.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.buu;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends q
  implements m
{
  private i callback;
  private d rr;
  private buu wDf;
  public buv wDg;
  
  public b(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(193035);
    d.a locala = new d.a();
    locala.lBU = new buu();
    locala.lBV = new buv();
    locala.funcId = 5965;
    locala.uri = "/cgi-bin/mmpay-bin/getfacechecklivetype";
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    this.wDf = ((buu)d.b.b(this.rr.lBR));
    this.wDf.scene = paramInt;
    this.wDf.ufq = paramString1;
    this.wDf.TeR = paramString2;
    Log.i("MicroMsg.NetSceneGetFaceCheckLiveType", "NetSceneGetFaceCheckLiveType: %s, packageName: %s, packageSign: %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    AppMethodBeat.o(193035);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(193039);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(193039);
    return i;
  }
  
  public final int getType()
  {
    return 5965;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(193047);
    Log.i("MicroMsg.NetSceneGetFaceCheckLiveType", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.wDg = ((buv)d.c.b(((d)params).lBS));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(193047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.a.b
 * JD-Core Version:    0.7.0.1
 */