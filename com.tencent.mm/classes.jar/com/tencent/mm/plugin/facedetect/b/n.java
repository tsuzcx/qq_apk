package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.protocal.protobuf.aqu;
import com.tencent.mm.protocal.protobuf.aqv;
import com.tencent.mm.protocal.protobuf.gdd;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
  extends a
  implements m, f
{
  private h callback;
  private String ovT;
  private c rr;
  private boolean ygJ;
  private boolean zSb;
  public String zSc;
  public String zSd;
  private String zSe;
  
  public n(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, float paramFloat, int paramInt2)
  {
    AppMethodBeat.i(103607);
    this.zSb = false;
    this.zSc = null;
    this.zSd = "";
    this.ovT = "";
    this.ygJ = false;
    this.zSe = "";
    Object localObject1 = new c.a();
    ((c.a)localObject1).otE = new aqu();
    ((c.a)localObject1).otF = new aqv();
    ((c.a)localObject1).uri = "/cgi-bin/mmbiz-bin/usrmsg/faceidentify";
    ((c.a)localObject1).funcId = getType();
    ((c.a)localObject1).otG = 0;
    ((c.a)localObject1).respCmdId = 0;
    this.rr = ((c.a)localObject1).bEF();
    localObject1 = (aqu)c.b.b(this.rr.otB);
    ((aqu)localObject1).appid = paramString1;
    ((aqu)localObject1).Zyc = paramLong;
    ((aqu)localObject1).YQb = paramString2;
    ((aqu)localObject1).Zye = paramString3;
    ((aqu)localObject1).Zyd = paramString4;
    ((aqu)localObject1).zRU = paramInt1;
    ((aqu)localObject1).Zyg = paramFloat;
    ((aqu)localObject1).Zyh = paramInt2;
    try
    {
      gdd localgdd = new gdd();
      localgdd.acaX = new gol().df(d.MtP.gtE());
      ((aqu)localObject1).ZxO = new b(localgdd.toByteArray());
      label228:
      Log.i("MicroMsg.NetSceneFaceVerifyFace", "NetSceneFacePicThirdVerifyFace, checkAliveType: %s  ,light:%f ,upload_video:%d  appid:%s  bioid:%s json_str:%s picture_cdn_id:%s cdnAesKey:%s uploadVideo:%s", new Object[] { Integer.valueOf(paramInt1), Float.valueOf(paramFloat), Integer.valueOf(paramInt2), paramString1, Long.valueOf(paramLong), paramString2, paramString3, paramString4, Integer.valueOf(paramInt2) });
      AppMethodBeat.o(103607);
      return;
    }
    finally
    {
      break label228;
    }
  }
  
  public final boolean dOD()
  {
    return this.ygJ;
  }
  
  public final String dOE()
  {
    return this.zSc;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(103608);
    this.callback = paramh;
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
    params = (aqv)c.c.b(((c)params).otC);
    Log.i("MicroMsg.NetSceneFaceVerifyFace", "identity_id: %s canRetry:%b tip:%s bizName:%s", new Object[] { params.ZxY, Boolean.valueOf(params.Zyi), params.ZxX, params.ZxQ });
    this.zSc = params.ZxY;
    this.ygJ = params.Zyi;
    this.zSd = params.ZxX;
    this.ovT = params.ZxQ;
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