package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anc;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
  extends a
  implements m, f
{
  private i callback;
  private String lEm;
  private d rr;
  private boolean uTW;
  private boolean wvU;
  public String wvV;
  public String wvW;
  private String wvX;
  
  public n(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, float paramFloat, int paramInt2)
  {
    AppMethodBeat.i(103607);
    this.wvU = false;
    this.wvV = null;
    this.wvW = "";
    this.lEm = "";
    this.uTW = false;
    this.wvX = "";
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new anb();
    ((d.a)localObject).lBV = new anc();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/faceidentify";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (anb)d.b.b(this.rr.lBR);
    ((anb)localObject).appid = paramString1;
    ((anb)localObject).Sxk = paramLong;
    ((anb)localObject).RSB = paramString2;
    ((anb)localObject).Sxm = paramString3;
    ((anb)localObject).Sxl = paramString4;
    ((anb)localObject).wvP = paramInt1;
    ((anb)localObject).Sxo = paramFloat;
    ((anb)localObject).Sxp = paramInt2;
    Log.i("MicroMsg.NetSceneFaceVerifyFace", "NetSceneFacePicThirdVerifyFace, checkAliveType: %s  ,light:%f ,upload_video:%d  appid:%s  bioid:%s json_str:%s picture_cdn_id:%s cdnAesKey:%s uploadVideo:%s", new Object[] { Integer.valueOf(paramInt1), Float.valueOf(paramFloat), Integer.valueOf(paramInt2), paramString1, Long.valueOf(paramLong), paramString2, paramString3, paramString4, Integer.valueOf(paramInt2) });
    AppMethodBeat.o(103607);
  }
  
  public final boolean dhS()
  {
    return this.uTW;
  }
  
  public final String dhT()
  {
    return this.wvV;
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
    params = (anc)d.c.b(((d)params).lBS);
    Log.i("MicroMsg.NetSceneFaceVerifyFace", "identity_id: %s canRetry:%b tip:%s bizName:%s", new Object[] { params.Sxj, Boolean.valueOf(params.Sxq), params.Sxi, params.Sxb });
    this.wvV = params.Sxj;
    this.uTW = params.Sxq;
    this.wvW = params.Sxi;
    this.lEm = params.Sxb;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(103609);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.n
 * JD-Core Version:    0.7.0.1
 */