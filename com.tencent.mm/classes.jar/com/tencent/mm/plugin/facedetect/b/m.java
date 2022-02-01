package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ama;
import com.tencent.mm.protocal.protobuf.amb;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  extends q
  implements com.tencent.mm.network.m, e
{
  private i callback;
  private boolean rop;
  private d rr;
  private boolean sPX;
  public String sPY;
  private String sPZ;
  
  public m(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, float paramFloat, int paramInt2)
  {
    AppMethodBeat.i(103607);
    this.sPX = false;
    this.sPY = null;
    this.rop = false;
    this.sPZ = "";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ama();
    ((d.a)localObject).iLO = new amb();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/faceidentify";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ama)this.rr.iLK.iLR;
    ((ama)localObject).dNI = paramString1;
    ((ama)localObject).LuJ = paramLong;
    ((ama)localObject).KRB = paramString2;
    ((ama)localObject).LuL = paramString3;
    ((ama)localObject).LuK = paramString4;
    ((ama)localObject).sPV = paramInt1;
    ((ama)localObject).LuN = paramFloat;
    ((ama)localObject).LuO = paramInt2;
    Log.i("MicroMsg.NetSceneFaceVerifyFace", "NetSceneFacePicThirdVerifyFace, checkAliveType: %s  ,light:%f ,upload_video:%d  appid:%s  bioid:%s json_str:%s picture_cdn_id:%s cdnAesKey:%s uploadVideo:%s", new Object[] { Integer.valueOf(paramInt1), Float.valueOf(paramFloat), Integer.valueOf(paramInt2), paramString1, Long.valueOf(paramLong), paramString2, paramString3, paramString4, Integer.valueOf(paramInt2) });
    AppMethodBeat.o(103607);
  }
  
  public final boolean cSO()
  {
    return this.rop;
  }
  
  public final String cSP()
  {
    return this.sPY;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(103608);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(103608);
    return i;
  }
  
  public final int getType()
  {
    return 1080;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103609);
    Log.i("MicroMsg.NetSceneFaceVerifyFace", "alvinluo NetSceneFacePicThirdVerifyFace errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = (amb)((d)params).iLL.iLR;
    Log.i("MicroMsg.NetSceneFaceVerifyFace", "identity_id: %s", new Object[] { params.LuP });
    this.sPY = params.LuP;
    this.rop = params.LuQ;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(103609);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.m
 * JD-Core Version:    0.7.0.1
 */