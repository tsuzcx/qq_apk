package com.tencent.mm.plugin.facedetect.b;

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
import com.tencent.mm.protocal.protobuf.aja;
import com.tencent.mm.protocal.protobuf.ajb;
import com.tencent.mm.protocal.protobuf.bst;
import com.tencent.mm.protocal.protobuf.cmn;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class l
  extends n
  implements k
{
  private f callback;
  private LinkedList<bst> rgf;
  public cmn rgg;
  public String rgh;
  public String rgi;
  public String rgj;
  public String rgk;
  public String rgl;
  public float rgm;
  public int rgn;
  public String rgo;
  private b rr;
  
  public l(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(103603);
    this.rgf = null;
    this.rgg = null;
    this.rgj = null;
    this.rgk = null;
    this.rgl = null;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new aja();
    ((b.a)localObject).hNN = new ajb();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/faceidentifyprepage";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (aja)this.rr.hNK.hNQ;
    ((aja)localObject).duW = paramString1;
    ((aja)localObject).FFt = paramString2;
    ((aja)localObject).rgn = paramInt;
    AppMethodBeat.o(103603);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(103604);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(103604);
    return i;
  }
  
  public final int getType()
  {
    return 1147;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103605);
    ad.i("MicroMsg.NetSceneFaceGetConfirmPageInfo", "alvinluo errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (ajb)((b)paramq).hNL.hNQ;
    if (paramq != null)
    {
      this.rgf = paramq.FUp;
      this.rgg = paramq.Ggf;
      this.rgj = paramq.Ggh;
      this.rgk = paramq.Ggi;
      this.rgl = paramq.Ggj;
      this.rgm = paramq.Ggk;
      this.rgn = paramq.rgn;
      this.rgo = paramq.rgo;
      this.rgh = paramq.Ggl;
      this.rgi = paramq.Ggg;
      ad.d("MicroMsg.NetSceneFaceGetConfirmPageInfo", "Light threshold is A : " + this.rgm);
      ad.d("MicroMsg.NetSceneFaceGetConfirmPageInfo", "check_alive_type is  : " + this.rgn);
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
    }
    AppMethodBeat.o(103605);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(103606);
    String str = "NetSceneFaceGetConfirmPageInfo{callback=" + this.callback + ", rr=" + this.rr + ", mFaceConfirmInfoList=" + this.rgf + ", mPromptButtonInfo=" + this.rgg + ", bizHeadUrl='" + this.rgh + '\'' + ", bizNickName='" + this.rgi + '\'' + ", mHeaderPrompt='" + this.rgj + '\'' + ", mFeedbackUrl='" + this.rgk + '\'' + ", mComplainUrl='" + this.rgl + '\'' + ", mLight_threshold=" + this.rgm + ", check_alive_type=" + this.rgn + ", business_tips='" + this.rgo + '\'' + '}';
    AppMethodBeat.o(103606);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.l
 * JD-Core Version:    0.7.0.1
 */