package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ajc;
import com.tencent.mm.protocal.protobuf.ajd;
import com.tencent.mm.sdk.platformtools.ad;

public final class m
  extends n
  implements k, e
{
  private f callback;
  public boolean pQM;
  private boolean rgp;
  public String rgq;
  private String rgr;
  private b rr;
  
  public m(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, float paramFloat, int paramInt2)
  {
    AppMethodBeat.i(103607);
    this.rgp = false;
    this.rgq = null;
    this.pQM = false;
    this.rgr = "";
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new ajc();
    ((b.a)localObject).hNN = new ajd();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/faceidentify";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (ajc)this.rr.hNK.hNQ;
    ((ajc)localObject).duW = paramString1;
    ((ajc)localObject).Ggm = paramLong;
    ((ajc)localObject).FFt = paramString2;
    ((ajc)localObject).Ggo = paramString3;
    ((ajc)localObject).Ggn = paramString4;
    ((ajc)localObject).rgn = paramInt1;
    ((ajc)localObject).Ggq = paramFloat;
    ((ajc)localObject).Ggr = paramInt2;
    ad.i("MicroMsg.NetSceneFaceVerifyFace", "create NetSceneFacePicThirdVerifyFace, checkAliveType: %s  ,light:%f ,upload_video:%d", new Object[] { Integer.valueOf(paramInt1), Float.valueOf(paramFloat), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(103607);
  }
  
  public final boolean csE()
  {
    return this.pQM;
  }
  
  public final String csF()
  {
    return this.rgq;
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
    ad.d("MicroMsg.NetSceneFaceVerifyFace", "alvinluo NetSceneFacePicThirdVerifyFace errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (ajd)((b)paramq).hNL.hNQ;
    ad.i("MicroMsg.NetSceneFaceVerifyFace", "identity_id: %s", new Object[] { paramq.Ggs });
    this.rgq = paramq.Ggs;
    this.pQM = paramq.Ggt;
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