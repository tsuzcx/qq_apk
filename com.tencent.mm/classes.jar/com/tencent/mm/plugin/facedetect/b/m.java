package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.afn;
import com.tencent.mm.protocal.protobuf.afo;
import com.tencent.mm.sdk.platformtools.ad;

public final class m
  extends n
  implements k, e
{
  private g callback;
  public boolean oJO;
  private boolean pNR;
  public String pNS;
  private String pNT;
  private b rr;
  
  public m(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, float paramFloat, int paramInt2)
  {
    AppMethodBeat.i(103607);
    this.pNR = false;
    this.pNS = null;
    this.oJO = false;
    this.pNT = "";
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new afn();
    ((b.a)localObject).gUV = new afo();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/faceidentify";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (afn)this.rr.gUS.gUX;
    ((afn)localObject).dlB = paramString1;
    ((afn)localObject).Dfu = paramLong;
    ((afn)localObject).CHp = paramString2;
    ((afn)localObject).Dfw = paramString3;
    ((afn)localObject).Dfv = paramString4;
    ((afn)localObject).pNP = paramInt1;
    ((afn)localObject).Dfy = paramFloat;
    ((afn)localObject).Dfz = paramInt2;
    ad.i("MicroMsg.NetSceneFaceVerifyFace", "create NetSceneFacePicThirdVerifyFace, checkAliveType: %s  ,light:%f ,upload_video:%d", new Object[] { Integer.valueOf(paramInt1), Float.valueOf(paramFloat), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(103607);
  }
  
  public final boolean cfs()
  {
    return this.oJO;
  }
  
  public final String cft()
  {
    return this.pNS;
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
    ad.d("MicroMsg.NetSceneFaceVerifyFace", "alvinluo NetSceneFacePicThirdVerifyFace errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (afo)((b)paramq).gUT.gUX;
    ad.i("MicroMsg.NetSceneFaceVerifyFace", "identity_id: %s", new Object[] { paramq.DfA });
    this.pNS = paramq.DfA;
    this.oJO = paramq.DfB;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(103609);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.m
 * JD-Core Version:    0.7.0.1
 */