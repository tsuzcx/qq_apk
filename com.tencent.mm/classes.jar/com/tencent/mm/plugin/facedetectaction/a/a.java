package com.tencent.mm.plugin.facedetectaction.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bus;
import com.tencent.mm.protocal.protobuf.but;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends q
  implements m
{
  private i callback;
  private d rr;
  private bus wDd;
  public but wDe;
  
  public a(int paramInt, String paramString1, String paramString2)
  {
    this(paramInt, paramString1, paramString2, 1, new byte[1]);
    AppMethodBeat.i(104195);
    AppMethodBeat.o(104195);
  }
  
  public a(int paramInt1, String paramString1, String paramString2, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(194219);
    d.a locala = new d.a();
    locala.lBU = new bus();
    locala.lBV = new but();
    locala.funcId = 2696;
    locala.uri = "/cgi-bin/mmpay-bin/getfacecheckaction";
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    this.wDd = ((bus)d.b.b(this.rr.lBR));
    this.wDd.scene = paramInt1;
    this.wDd.ufq = paramString1;
    this.wDd.TeR = paramString2;
    this.wDd.live_type = paramInt2;
    this.wDd.TeS = b.cU(paramArrayOfByte);
    Log.i("MicroMsg.NetSceneGetFaceCheckAction", "create GetFaceCheckAction, scene: %s, packageName: %s, packageSign: %s", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2 });
    AppMethodBeat.o(194219);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(104196);
    this.callback = parami;
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
    this.wDe = ((but)d.c.b(((d)params).lBS));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(104197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.a.a
 * JD-Core Version:    0.7.0.1
 */