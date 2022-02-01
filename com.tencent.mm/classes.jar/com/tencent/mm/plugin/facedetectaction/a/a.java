package com.tencent.mm.plugin.facedetectaction.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bbc;
import com.tencent.mm.protocal.protobuf.bbd;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends n
  implements k
{
  private f callback;
  private bbc rpe;
  public bbd rpf;
  private b rr;
  
  public a(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(104195);
    b.a locala = new b.a();
    locala.hNM = new bbc();
    locala.hNN = new bbd();
    locala.funcId = 2696;
    locala.uri = "/cgi-bin/mmpay-bin/getfacecheckaction";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.rpe = ((bbc)this.rr.hNK.hNQ);
    this.rpe.scene = paramInt;
    this.rpe.pkf = paramString1;
    this.rpe.Gyh = paramString2;
    ad.i("MicroMsg.NetSceneGetFaceCheckAction", "create GetFaceCheckAction, scene: %s, packageName: %s, packageSign: %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
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
    ad.i("MicroMsg.NetSceneGetFaceCheckAction", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.rpf = ((bbd)((b)paramq).hNL.hNQ);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(104197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.a.a
 * JD-Core Version:    0.7.0.1
 */