package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.abq;
import com.tencent.mm.protocal.protobuf.abr;
import com.tencent.mm.sdk.platformtools.ab;

public final class m
  extends com.tencent.mm.ai.m
  implements k, e
{
  private f callback;
  private boolean mhc;
  public String mhd;
  public boolean mhe;
  private String mhf;
  private b rr;
  
  public m(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, float paramFloat, int paramInt2)
  {
    AppMethodBeat.i(82);
    this.mhc = false;
    this.mhd = null;
    this.mhe = false;
    this.mhf = "";
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new abq();
    ((b.a)localObject).fsY = new abr();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/faceidentify";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (abq)this.rr.fsV.fta;
    ((abq)localObject).cwc = paramString1;
    ((abq)localObject).wSa = paramLong;
    ((abq)localObject).wRS = paramString2;
    ((abq)localObject).wSc = paramString3;
    ((abq)localObject).wSb = paramString4;
    ((abq)localObject).mha = paramInt1;
    ((abq)localObject).wSe = paramFloat;
    ((abq)localObject).wSf = paramInt2;
    ab.i("MicroMsg.NetSceneFaceVerifyFace", "create NetSceneFacePicThirdVerifyFace, checkAliveType: %s  ,light:%f ,upload_video:%d", new Object[] { Integer.valueOf(paramInt1), Float.valueOf(paramFloat), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(82);
  }
  
  public final boolean btY()
  {
    return this.mhe;
  }
  
  public final String btZ()
  {
    return this.mhd;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(83);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(83);
    return i;
  }
  
  public final int getType()
  {
    return 1080;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(84);
    ab.d("MicroMsg.NetSceneFaceVerifyFace", "alvinluo NetSceneFacePicThirdVerifyFace errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (abr)((b)paramq).fsW.fta;
    ab.i("MicroMsg.NetSceneFaceVerifyFace", "identity_id: %s", new Object[] { paramq.wSg });
    this.mhd = paramq.wSg;
    this.mhe = paramq.wSh;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(84);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.m
 * JD-Core Version:    0.7.0.1
 */