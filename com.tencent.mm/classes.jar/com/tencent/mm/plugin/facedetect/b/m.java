package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.agm;
import com.tencent.mm.protocal.protobuf.agn;
import com.tencent.mm.sdk.platformtools.ac;

public final class m
  extends n
  implements k, e
{
  private g callback;
  public boolean pnm;
  public String qwA;
  private String qwB;
  private boolean qwz;
  private b rr;
  
  public m(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, float paramFloat, int paramInt2)
  {
    AppMethodBeat.i(103607);
    this.qwz = false;
    this.qwA = null;
    this.pnm = false;
    this.qwB = "";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new agm();
    ((b.a)localObject).hvu = new agn();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/faceidentify";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (agm)this.rr.hvr.hvw;
    ((agm)localObject).djj = paramString1;
    ((agm)localObject).EyA = paramLong;
    ((agm)localObject).DZR = paramString2;
    ((agm)localObject).EyC = paramString3;
    ((agm)localObject).EyB = paramString4;
    ((agm)localObject).qwx = paramInt1;
    ((agm)localObject).EyE = paramFloat;
    ((agm)localObject).EyF = paramInt2;
    ac.i("MicroMsg.NetSceneFaceVerifyFace", "create NetSceneFacePicThirdVerifyFace, checkAliveType: %s  ,light:%f ,upload_video:%d", new Object[] { Integer.valueOf(paramInt1), Float.valueOf(paramFloat), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(103607);
  }
  
  public final boolean cmZ()
  {
    return this.pnm;
  }
  
  public final String cna()
  {
    return this.qwA;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(103608);
    this.callback = paramg;
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
    ac.d("MicroMsg.NetSceneFaceVerifyFace", "alvinluo NetSceneFacePicThirdVerifyFace errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (agn)((b)paramq).hvs.hvw;
    ac.i("MicroMsg.NetSceneFaceVerifyFace", "identity_id: %s", new Object[] { paramq.EyG });
    this.qwA = paramq.EyG;
    this.pnm = paramq.EyH;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(103609);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.m
 * JD-Core Version:    0.7.0.1
 */