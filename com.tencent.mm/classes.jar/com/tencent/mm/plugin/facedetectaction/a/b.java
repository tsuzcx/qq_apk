package com.tencent.mm.plugin.facedetectaction.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cjs;
import com.tencent.mm.protocal.protobuf.cjt;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends p
  implements m
{
  private h callback;
  private c rr;
  private cjs zZq;
  public cjt zZr;
  
  public b(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(262596);
    c.a locala = new c.a();
    locala.otE = new cjs();
    locala.otF = new cjt();
    locala.funcId = 5965;
    locala.uri = "/cgi-bin/mmpay-bin/getfacechecklivetype";
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    this.zZq = ((cjs)c.b.b(this.rr.otB));
    this.zZq.scene = paramInt;
    this.zZq.xlr = paramString1;
    this.zZq.aasl = paramString2;
    Log.i("MicroMsg.NetSceneGetFaceCheckLiveType", "NetSceneGetFaceCheckLiveType: %s, packageName: %s, packageSign: %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    AppMethodBeat.o(262596);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(262599);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(262599);
    return i;
  }
  
  public final int getType()
  {
    return 5965;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(262602);
    Log.i("MicroMsg.NetSceneGetFaceCheckLiveType", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.zZr = ((cjt)c.c.b(((c)params).otC));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(262602);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.a.b
 * JD-Core Version:    0.7.0.1
 */