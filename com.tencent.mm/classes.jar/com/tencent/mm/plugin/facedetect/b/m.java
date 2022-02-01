package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ajm;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.sdk.platformtools.ae;

public final class m
  extends n
  implements k, e
{
  private f callback;
  public boolean pXr;
  private boolean ros;
  public String rot;
  private String rou;
  private b rr;
  
  public m(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, float paramFloat, int paramInt2)
  {
    AppMethodBeat.i(103607);
    this.ros = false;
    this.rot = null;
    this.pXr = false;
    this.rou = "";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ajm();
    ((b.a)localObject).hQG = new ajn();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/faceidentify";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (ajm)this.rr.hQD.hQJ;
    ((ajm)localObject).dwb = paramString1;
    ((ajm)localObject).GyV = paramLong;
    ((ajm)localObject).FXO = paramString2;
    ((ajm)localObject).GyX = paramString3;
    ((ajm)localObject).GyW = paramString4;
    ((ajm)localObject).roq = paramInt1;
    ((ajm)localObject).GyZ = paramFloat;
    ((ajm)localObject).Gza = paramInt2;
    ae.i("MicroMsg.NetSceneFaceVerifyFace", "create NetSceneFacePicThirdVerifyFace, checkAliveType: %s  ,light:%f ,upload_video:%d", new Object[] { Integer.valueOf(paramInt1), Float.valueOf(paramFloat), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(103607);
  }
  
  public final boolean cuf()
  {
    return this.pXr;
  }
  
  public final String cug()
  {
    return this.rot;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(103608);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(103608);
    return i;
  }
  
  public final int getType()
  {
    return 1080;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103609);
    ae.d("MicroMsg.NetSceneFaceVerifyFace", "alvinluo NetSceneFacePicThirdVerifyFace errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (ajn)((b)paramq).hQE.hQJ;
    ae.i("MicroMsg.NetSceneFaceVerifyFace", "identity_id: %s", new Object[] { paramq.Gzb });
    this.rot = paramq.Gzb;
    this.pXr = paramq.Gzc;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(103609);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.m
 * JD-Core Version:    0.7.0.1
 */