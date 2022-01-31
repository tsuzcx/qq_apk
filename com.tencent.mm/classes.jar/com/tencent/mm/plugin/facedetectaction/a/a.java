package com.tencent.mm.plugin.facedetectaction.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.akg;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  extends m
  implements k
{
  private f callback;
  private akg mpZ;
  public akh mqa;
  private b rr;
  
  public a(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(670);
    b.a locala = new b.a();
    locala.fsX = new akg();
    locala.fsY = new akh();
    locala.funcId = 2696;
    locala.uri = "/cgi-bin/mmpay-bin/getfacecheckaction";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    this.mpZ = ((akg)this.rr.fsV.fta);
    this.mpZ.scene = paramInt;
    this.mpZ.kWn = paramString1;
    this.mpZ.xbx = paramString2;
    ab.i("MicroMsg.NetSceneGetFaceCheckAction", "create GetFaceCheckAction, scene: %s, packageName: %s, packageSign: %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    AppMethodBeat.o(670);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(671);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(671);
    return i;
  }
  
  public final int getType()
  {
    return 2696;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(672);
    ab.i("MicroMsg.NetSceneGetFaceCheckAction", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.mqa = ((akh)((b)paramq).fsW.fta);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(672);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.a.a
 * JD-Core Version:    0.7.0.1
 */