package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ajk;
import com.tencent.mm.protocal.protobuf.ajl;
import com.tencent.mm.protocal.protobuf.btn;
import com.tencent.mm.protocal.protobuf.cnh;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class l
  extends n
  implements k
{
  private f callback;
  private LinkedList<btn> roi;
  public cnh roj;
  public String rok;
  public String rol;
  public String rom;
  public String ron;
  public String roo;
  public float rop;
  public int roq;
  public String ror;
  private b rr;
  
  public l(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(103603);
    this.roi = null;
    this.roj = null;
    this.rom = null;
    this.ron = null;
    this.roo = null;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ajk();
    ((b.a)localObject).hQG = new ajl();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/faceidentifyprepage";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (ajk)this.rr.hQD.hQJ;
    ((ajk)localObject).dwb = paramString1;
    ((ajk)localObject).FXO = paramString2;
    ((ajk)localObject).roq = paramInt;
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
    ae.i("MicroMsg.NetSceneFaceGetConfirmPageInfo", "alvinluo errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (ajl)((b)paramq).hQE.hQJ;
    if (paramq != null)
    {
      this.roi = paramq.GmO;
      this.roj = paramq.GyO;
      this.rom = paramq.GyQ;
      this.ron = paramq.GyR;
      this.roo = paramq.GyS;
      this.rop = paramq.GyT;
      this.roq = paramq.roq;
      this.ror = paramq.ror;
      this.rok = paramq.GyU;
      this.rol = paramq.GyP;
      ae.d("MicroMsg.NetSceneFaceGetConfirmPageInfo", "Light threshold is A : " + this.rop);
      ae.d("MicroMsg.NetSceneFaceGetConfirmPageInfo", "check_alive_type is  : " + this.roq);
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
    }
    AppMethodBeat.o(103605);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(103606);
    String str = "NetSceneFaceGetConfirmPageInfo{callback=" + this.callback + ", rr=" + this.rr + ", mFaceConfirmInfoList=" + this.roi + ", mPromptButtonInfo=" + this.roj + ", bizHeadUrl='" + this.rok + '\'' + ", bizNickName='" + this.rol + '\'' + ", mHeaderPrompt='" + this.rom + '\'' + ", mFeedbackUrl='" + this.ron + '\'' + ", mComplainUrl='" + this.roo + '\'' + ", mLight_threshold=" + this.rop + ", check_alive_type=" + this.roq + ", business_tips='" + this.ror + '\'' + '}';
    AppMethodBeat.o(103606);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.l
 * JD-Core Version:    0.7.0.1
 */