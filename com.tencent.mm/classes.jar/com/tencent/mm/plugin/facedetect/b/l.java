package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aly;
import com.tencent.mm.protocal.protobuf.alz;
import com.tencent.mm.protocal.protobuf.cgi;
import com.tencent.mm.protocal.protobuf.dfb;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class l
  extends q
  implements m
{
  private i callback;
  private d rr;
  private LinkedList<cgi> sPN;
  public dfb sPO;
  public String sPP;
  public String sPQ;
  public String sPR;
  public String sPS;
  public String sPT;
  public float sPU;
  public int sPV;
  public String sPW;
  
  public l(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(103603);
    this.sPN = null;
    this.sPO = null;
    this.sPR = null;
    this.sPS = null;
    this.sPT = null;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new aly();
    ((d.a)localObject).iLO = new alz();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/faceidentifyprepage";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (aly)this.rr.iLK.iLR;
    ((aly)localObject).dNI = paramString1;
    ((aly)localObject).KRB = paramString2;
    ((aly)localObject).sPV = paramInt;
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
    params = (alz)((d)params).iLL.iLR;
    if (params != null)
    {
      this.sPN = params.Lhs;
      this.sPO = params.LuC;
      this.sPR = params.LuE;
      this.sPS = params.LuF;
      this.sPT = params.LuG;
      this.sPU = params.LuH;
      this.sPV = params.sPV;
      this.sPW = params.sPW;
      this.sPP = params.LuI;
      this.sPQ = params.LuD;
      Log.d("MicroMsg.NetSceneFaceGetConfirmPageInfo", "Light threshold is A : " + this.sPU);
      Log.d("MicroMsg.NetSceneFaceGetConfirmPageInfo", "check_alive_type is  : " + this.sPV);
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
    }
    AppMethodBeat.o(103605);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(103606);
    String str = "NetSceneFaceGetConfirmPageInfo{callback=" + this.callback + ", rr=" + this.rr + ", mFaceConfirmInfoList=" + this.sPN + ", mPromptButtonInfo=" + this.sPO + ", bizHeadUrl='" + this.sPP + '\'' + ", bizNickName='" + this.sPQ + '\'' + ", mHeaderPrompt='" + this.sPR + '\'' + ", mFeedbackUrl='" + this.sPS + '\'' + ", mComplainUrl='" + this.sPT + '\'' + ", mLight_threshold=" + this.sPU + ", check_alive_type=" + this.sPV + ", business_tips='" + this.sPW + '\'' + '}';
    AppMethodBeat.o(103606);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.l
 * JD-Core Version:    0.7.0.1
 */