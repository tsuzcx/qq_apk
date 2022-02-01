package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.protocal.protobuf.aqs;
import com.tencent.mm.protocal.protobuf.aqt;
import com.tencent.mm.protocal.protobuf.dfy;
import com.tencent.mm.protocal.protobuf.ehp;
import com.tencent.mm.protocal.protobuf.gdd;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class m
  extends a
  implements com.tencent.mm.network.m
{
  private h callback;
  private c rr;
  private LinkedList<dfy> zRM;
  public ehp zRN;
  public String zRO;
  public String zRP;
  public String zRQ;
  public String zRR;
  public String zRS;
  public float zRT;
  public int zRU;
  public String zRV;
  public float zRW;
  public String zRX;
  public String zRY;
  public ehp zRZ;
  public String zSa;
  
  public m(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(103603);
    this.zRM = null;
    this.zRN = null;
    this.zRQ = null;
    this.zRR = null;
    this.zRS = null;
    this.zRW = 0.0F;
    this.zRX = "";
    this.zRY = "";
    this.zRZ = null;
    this.zSa = "";
    Object localObject = new c.a();
    ((c.a)localObject).otE = new aqs();
    ((c.a)localObject).otF = new aqt();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/faceidentifyprepage";
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (aqs)c.b.b(this.rr.otB);
    ((aqs)localObject).appid = paramString1;
    ((aqs)localObject).YQb = paramString2;
    ((aqs)localObject).zRU = paramInt;
    try
    {
      paramString1 = new gdd();
      paramString1.acaX = new gol().df(d.MtP.gtE());
      ((aqs)localObject).ZxO = new b(paramString1.toByteArray());
      return;
    }
    finally
    {
      AppMethodBeat.o(103603);
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(103604);
    this.callback = paramh;
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
    params = (aqt)c.c.b(((c)params).otC);
    if (params != null)
    {
      this.zRM = params.ZgM;
      this.zRN = params.ZxP;
      this.zRQ = params.ZxR;
      this.zRR = params.ZxS;
      this.zRS = params.ZxT;
      this.zRT = params.ZxU;
      this.zRU = params.zRU;
      this.zRV = params.zRV;
      this.zRO = params.ZxV;
      this.zRP = params.ZxQ;
      this.zRW = params.ZxW;
      this.zRX = params.ZxX;
      this.zRY = params.ZxY;
      this.zSa = params.Zya;
      this.zRZ = params.Zyb;
      Log.i("MicroMsg.NetSceneFaceGetConfirmPageInfo", "Light threshold is %f check_alive_type:%d faceRatio:%f errorTip:%s identifyId:%s", new Object[] { Float.valueOf(this.zRT), Integer.valueOf(this.zRU), Float.valueOf(this.zRW), this.zRX, this.zRY });
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
    }
    AppMethodBeat.o(103605);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(103606);
    String str = "NetSceneFaceGetConfirmPageInfo{callback=" + this.callback + ", rr=" + this.rr + ", mFaceConfirmInfoList=" + this.zRM + ", mPromptButtonInfo=" + this.zRN + ", bizHeadUrl='" + this.zRO + '\'' + ", bizNickName='" + this.zRP + '\'' + ", mHeaderPrompt='" + this.zRQ + '\'' + ", mFeedbackUrl='" + this.zRR + '\'' + ", mComplainUrl='" + this.zRS + '\'' + ", mLight_threshold=" + this.zRT + ", check_alive_type=" + this.zRU + ", business_tips='" + this.zRV + '\'' + ", faceRatio=" + this.zRW + ", errorTip='" + this.zRX + '\'' + ", identifyId='" + this.zRY + '\'' + '}';
    AppMethodBeat.o(103606);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.m
 * JD-Core Version:    0.7.0.1
 */