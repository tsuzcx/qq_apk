package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.afl;
import com.tencent.mm.protocal.protobuf.afm;
import com.tencent.mm.protocal.protobuf.bkm;
import com.tencent.mm.protocal.protobuf.ccl;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class l
  extends n
  implements k
{
  private g callback;
  private LinkedList<bkm> pNH;
  public ccl pNI;
  public String pNJ;
  public String pNK;
  public String pNL;
  public String pNM;
  public String pNN;
  public float pNO;
  public int pNP;
  public String pNQ;
  private b rr;
  
  public l(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(103603);
    this.pNH = null;
    this.pNI = null;
    this.pNL = null;
    this.pNM = null;
    this.pNN = null;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new afl();
    ((b.a)localObject).gUV = new afm();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/faceidentifyprepage";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (afl)this.rr.gUS.gUX;
    ((afl)localObject).dlB = paramString1;
    ((afl)localObject).CHp = paramString2;
    ((afl)localObject).pNP = paramInt;
    AppMethodBeat.o(103603);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(103604);
    this.callback = paramg;
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
    paramq = (afm)((b)paramq).gUT.gUX;
    if (paramq != null)
    {
      this.pNH = paramq.CUw;
      this.pNI = paramq.Dfn;
      this.pNL = paramq.Dfp;
      this.pNM = paramq.Dfq;
      this.pNN = paramq.Dfr;
      this.pNO = paramq.Dfs;
      this.pNP = paramq.pNP;
      this.pNQ = paramq.pNQ;
      this.pNJ = paramq.Dft;
      this.pNK = paramq.Dfo;
      ad.d("MicroMsg.NetSceneFaceGetConfirmPageInfo", "Light threshold is A : " + this.pNO);
      ad.d("MicroMsg.NetSceneFaceGetConfirmPageInfo", "check_alive_type is  : " + this.pNP);
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
    }
    AppMethodBeat.o(103605);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(103606);
    String str = "NetSceneFaceGetConfirmPageInfo{callback=" + this.callback + ", rr=" + this.rr + ", mFaceConfirmInfoList=" + this.pNH + ", mPromptButtonInfo=" + this.pNI + ", bizHeadUrl='" + this.pNJ + '\'' + ", bizNickName='" + this.pNK + '\'' + ", mHeaderPrompt='" + this.pNL + '\'' + ", mFeedbackUrl='" + this.pNM + '\'' + ", mComplainUrl='" + this.pNN + '\'' + ", mLight_threshold=" + this.pNO + ", check_alive_type=" + this.pNP + ", business_tips='" + this.pNQ + '\'' + '}';
    AppMethodBeat.o(103606);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.l
 * JD-Core Version:    0.7.0.1
 */