package com.tencent.mm.plugin.facedetectaction.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bbs;
import com.tencent.mm.protocal.protobuf.bbt;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends n
  implements k
{
  private f callback;
  private b rr;
  private bbs rxi;
  public bbt rxj;
  
  public a(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(104195);
    b.a locala = new b.a();
    locala.hQF = new bbs();
    locala.hQG = new bbt();
    locala.funcId = 2696;
    locala.uri = "/cgi-bin/mmpay-bin/getfacecheckaction";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    this.rxi = ((bbs)this.rr.hQD.hQJ);
    this.rxi.scene = paramInt;
    this.rxi.pqK = paramString1;
    this.rxi.GRH = paramString2;
    ae.i("MicroMsg.NetSceneGetFaceCheckAction", "create GetFaceCheckAction, scene: %s, packageName: %s, packageSign: %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    AppMethodBeat.o(104195);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(104196);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(104196);
    return i;
  }
  
  public final int getType()
  {
    return 2696;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104197);
    ae.i("MicroMsg.NetSceneGetFaceCheckAction", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.rxj = ((bbt)((b)paramq).hQE.hQJ);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(104197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.a.a
 * JD-Core Version:    0.7.0.1
 */