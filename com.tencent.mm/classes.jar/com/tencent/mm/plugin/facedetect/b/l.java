package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.agk;
import com.tencent.mm.protocal.protobuf.agl;
import com.tencent.mm.protocal.protobuf.bog;
import com.tencent.mm.protocal.protobuf.chn;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class l
  extends n
  implements k
{
  private g callback;
  private LinkedList<bog> qwp;
  public chn qwq;
  public String qwr;
  public String qws;
  public String qwt;
  public String qwu;
  public String qwv;
  public float qww;
  public int qwx;
  public String qwy;
  private b rr;
  
  public l(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(103603);
    this.qwp = null;
    this.qwq = null;
    this.qwt = null;
    this.qwu = null;
    this.qwv = null;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new agk();
    ((b.a)localObject).hvu = new agl();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/faceidentifyprepage";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (agk)this.rr.hvr.hvw;
    ((agk)localObject).djj = paramString1;
    ((agk)localObject).DZR = paramString2;
    ((agk)localObject).qwx = paramInt;
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
    ac.i("MicroMsg.NetSceneFaceGetConfirmPageInfo", "alvinluo errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (agl)((b)paramq).hvs.hvw;
    if (paramq != null)
    {
      this.qwp = paramq.Eng;
      this.qwq = paramq.Eyt;
      this.qwt = paramq.Eyv;
      this.qwu = paramq.Eyw;
      this.qwv = paramq.Eyx;
      this.qww = paramq.Eyy;
      this.qwx = paramq.qwx;
      this.qwy = paramq.qwy;
      this.qwr = paramq.Eyz;
      this.qws = paramq.Eyu;
      ac.d("MicroMsg.NetSceneFaceGetConfirmPageInfo", "Light threshold is A : " + this.qww);
      ac.d("MicroMsg.NetSceneFaceGetConfirmPageInfo", "check_alive_type is  : " + this.qwx);
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
    }
    AppMethodBeat.o(103605);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(103606);
    String str = "NetSceneFaceGetConfirmPageInfo{callback=" + this.callback + ", rr=" + this.rr + ", mFaceConfirmInfoList=" + this.qwp + ", mPromptButtonInfo=" + this.qwq + ", bizHeadUrl='" + this.qwr + '\'' + ", bizNickName='" + this.qws + '\'' + ", mHeaderPrompt='" + this.qwt + '\'' + ", mFeedbackUrl='" + this.qwu + '\'' + ", mComplainUrl='" + this.qwv + '\'' + ", mLight_threshold=" + this.qww + ", check_alive_type=" + this.qwx + ", business_tips='" + this.qwy + '\'' + '}';
    AppMethodBeat.o(103606);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.l
 * JD-Core Version:    0.7.0.1
 */