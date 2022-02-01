package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.amz;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.cpe;
import com.tencent.mm.protocal.protobuf.dov;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class m
  extends a
  implements com.tencent.mm.network.m
{
  private i callback;
  private d rr;
  private LinkedList<cpe> wvH;
  public dov wvI;
  public String wvJ;
  public String wvK;
  public String wvL;
  public String wvM;
  public String wvN;
  public float wvO;
  public int wvP;
  public String wvQ;
  public float wvR;
  public String wvS;
  public String wvT;
  
  public m(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(103603);
    this.wvH = null;
    this.wvI = null;
    this.wvL = null;
    this.wvM = null;
    this.wvN = null;
    this.wvR = 0.0F;
    this.wvS = "";
    this.wvT = "";
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new amz();
    ((d.a)localObject).lBV = new ana();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/faceidentifyprepage";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (amz)d.b.b(this.rr.lBR);
    ((amz)localObject).appid = paramString1;
    ((amz)localObject).RSB = paramString2;
    ((amz)localObject).wvP = paramInt;
    AppMethodBeat.o(103603);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(103604);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(103604);
    return i;
  }
  
  public final int getType()
  {
    return 1147;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103605);
    Log.i("MicroMsg.NetSceneFaceGetConfirmPageInfo", "alvinluo errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = (ana)d.c.b(((d)params).lBS);
    if (params != null)
    {
      this.wvH = params.SiG;
      this.wvI = params.Sxa;
      this.wvL = params.Sxc;
      this.wvM = params.Sxd;
      this.wvN = params.Sxe;
      this.wvO = params.Sxf;
      this.wvP = params.wvP;
      this.wvQ = params.wvQ;
      this.wvJ = params.Sxg;
      this.wvK = params.Sxb;
      this.wvR = params.Sxh;
      this.wvS = params.Sxi;
      this.wvT = params.Sxj;
      Log.i("MicroMsg.NetSceneFaceGetConfirmPageInfo", "Light threshold is %f check_alive_type:%d faceRatio:%f errorTip:%s identifyId:%s", new Object[] { Float.valueOf(this.wvO), Integer.valueOf(this.wvP), Float.valueOf(this.wvR), this.wvS, this.wvT });
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
    }
    AppMethodBeat.o(103605);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(103606);
    String str = "NetSceneFaceGetConfirmPageInfo{callback=" + this.callback + ", rr=" + this.rr + ", mFaceConfirmInfoList=" + this.wvH + ", mPromptButtonInfo=" + this.wvI + ", bizHeadUrl='" + this.wvJ + '\'' + ", bizNickName='" + this.wvK + '\'' + ", mHeaderPrompt='" + this.wvL + '\'' + ", mFeedbackUrl='" + this.wvM + '\'' + ", mComplainUrl='" + this.wvN + '\'' + ", mLight_threshold=" + this.wvO + ", check_alive_type=" + this.wvP + ", business_tips='" + this.wvQ + '\'' + ", faceRatio=" + this.wvR + ", errorTip='" + this.wvS + '\'' + ", identifyId='" + this.wvT + '\'' + '}';
    AppMethodBeat.o(103606);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.m
 * JD-Core Version:    0.7.0.1
 */