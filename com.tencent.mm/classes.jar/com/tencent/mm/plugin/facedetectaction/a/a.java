package com.tencent.mm.plugin.facedetectaction.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cjq;
import com.tencent.mm.protocal.protobuf.cjr;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends p
  implements m
{
  private h callback;
  private c rr;
  private cjq zZo;
  public cjr zZp;
  
  public a(int paramInt, String paramString1, String paramString2)
  {
    this(paramInt, paramString1, paramString2, 1, new byte[1]);
    AppMethodBeat.i(104195);
    AppMethodBeat.o(104195);
  }
  
  public a(int paramInt1, String paramString1, String paramString2, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(262597);
    c.a locala = new c.a();
    locala.otE = new cjq();
    locala.otF = new cjr();
    locala.funcId = 2696;
    locala.uri = "/cgi-bin/mmpay-bin/getfacecheckaction";
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    this.zZo = ((cjq)c.b.b(this.rr.otB));
    this.zZo.scene = paramInt1;
    this.zZo.xlr = paramString1;
    this.zZo.aasl = paramString2;
    this.zZo.live_type = paramInt2;
    this.zZo.aasm = b.cX(paramArrayOfByte);
    Log.i("MicroMsg.NetSceneGetFaceCheckAction", "create GetFaceCheckAction, scene: %s, packageName: %s, packageSign: %s", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2 });
    AppMethodBeat.o(262597);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(104196);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(104196);
    return i;
  }
  
  public final int getType()
  {
    return 2696;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104197);
    Log.i("MicroMsg.NetSceneGetFaceCheckAction", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.zZp = ((cjr)c.c.b(((c)params).otC));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(104197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.a.a
 * JD-Core Version:    0.7.0.1
 */