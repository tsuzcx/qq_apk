package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.abp;
import com.tencent.mm.protocal.protobuf.azd;
import com.tencent.mm.protocal.protobuf.bnw;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class l
  extends m
  implements k
{
  private f callback;
  private LinkedList<azd> mgS;
  public bnw mgT;
  public String mgU;
  public String mgV;
  public String mgW;
  public String mgX;
  public String mgY;
  public float mgZ;
  public int mha;
  public String mhb;
  private b rr;
  
  public l(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(78);
    this.mgS = null;
    this.mgT = null;
    this.mgW = null;
    this.mgX = null;
    this.mgY = null;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new abo();
    ((b.a)localObject).fsY = new abp();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/faceidentifyprepage";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (abo)this.rr.fsV.fta;
    ((abo)localObject).cwc = paramString1;
    ((abo)localObject).wRS = paramString2;
    ((abo)localObject).mha = paramInt;
    AppMethodBeat.o(78);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(79);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(79);
    return i;
  }
  
  public final int getType()
  {
    return 1147;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(80);
    ab.i("MicroMsg.NetSceneFaceGetConfirmPageInfo", "alvinluo errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (abp)((b)paramq).fsW.fta;
    if (paramq != null)
    {
      this.mgS = paramq.wID;
      this.mgT = paramq.wRT;
      this.mgW = paramq.wRV;
      this.mgX = paramq.wRW;
      this.mgY = paramq.wRX;
      this.mgZ = paramq.wRY;
      this.mha = paramq.mha;
      this.mhb = paramq.mhb;
      this.mgU = paramq.wRZ;
      this.mgV = paramq.wRU;
      ab.d("MicroMsg.NetSceneFaceGetConfirmPageInfo", "Light threshold is A : " + this.mgZ);
      ab.d("MicroMsg.NetSceneFaceGetConfirmPageInfo", "check_alive_type is  : " + this.mha);
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
    }
    AppMethodBeat.o(80);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(81);
    String str = "NetSceneFaceGetConfirmPageInfo{callback=" + this.callback + ", rr=" + this.rr + ", mFaceConfirmInfoList=" + this.mgS + ", mPromptButtonInfo=" + this.mgT + ", bizHeadUrl='" + this.mgU + '\'' + ", bizNickName='" + this.mgV + '\'' + ", mHeaderPrompt='" + this.mgW + '\'' + ", mFeedbackUrl='" + this.mgX + '\'' + ", mComplainUrl='" + this.mgY + '\'' + ", mLight_threshold=" + this.mgZ + ", check_alive_type=" + this.mha + ", business_tips='" + this.mhb + '\'' + '}';
    AppMethodBeat.o(81);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.l
 * JD-Core Version:    0.7.0.1
 */