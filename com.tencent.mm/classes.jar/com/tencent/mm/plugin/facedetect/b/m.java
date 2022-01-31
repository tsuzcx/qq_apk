package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.xl;
import com.tencent.mm.protocal.c.xm;
import com.tencent.mm.sdk.platformtools.y;

public final class m
  extends com.tencent.mm.ah.m
  implements k, e
{
  private b dmK;
  private f dmL;
  private boolean jMT = false;
  public String jMU = null;
  public boolean jMV = false;
  private String jMW = "";
  
  public m(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new xl();
    ((b.a)localObject).ecI = new xm();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/faceidentify";
    ((b.a)localObject).ecG = 1080;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (xl)this.dmK.ecE.ecN;
    ((xl)localObject).bOL = paramString1;
    ((xl)localObject).sUf = paramLong;
    ((xl)localObject).sTW = paramString2;
    ((xl)localObject).sUh = paramString3;
    ((xl)localObject).sUg = paramString4;
    ((xl)localObject).jMS = paramInt;
    y.i("MicroMsg.NetSceneFaceVerifyFace", "create NetSceneFacePicThirdVerifyFace, checkAliveType: %s", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneFaceVerifyFace", "alvinluo NetSceneFacePicThirdVerifyFace errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (xm)((b)paramq).ecF.ecN;
    y.i("MicroMsg.NetSceneFaceVerifyFace", "identity_id: %s", new Object[] { paramq.sUj });
    this.jMU = paramq.sUj;
    this.jMV = paramq.sUk;
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final boolean aNV()
  {
    return this.jMV;
  }
  
  public final String aNW()
  {
    return this.jMU;
  }
  
  public final int getType()
  {
    return 1080;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.m
 * JD-Core Version:    0.7.0.1
 */