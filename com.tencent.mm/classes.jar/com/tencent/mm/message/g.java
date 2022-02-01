package com.tencent.mm.message;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.g.d;
import com.tencent.mm.protocal.protobuf.eof;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class g
  extends f
{
  public String nQA;
  public String nQB;
  public String nQC;
  public String nQD;
  public String nQE;
  public int nQF;
  public String nQG;
  public String nQH;
  public boolean nQI;
  public int nQJ;
  public String nQK;
  public String nQL;
  public String nQM;
  public String nQN;
  public String nQO;
  public String nQP;
  public int nQQ;
  public String nQR;
  public String nQv;
  public String nQw;
  public String nQx;
  public String nQy;
  public String nQz;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2) {}
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(169181);
    paramb = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.coverinfo"));
    paramMap = new eof();
    try
    {
      if (!Util.isNullOrNil(paramb)) {
        paramMap.parseFrom(Base64.decode(paramb, 0));
      }
      this.nQv = paramMap.nQv;
      this.nQw = paramMap.nQw;
      this.nQx = paramMap.nQx;
      this.nQy = paramMap.nQy;
      this.nQz = paramMap.nQz;
      this.nQA = paramMap.nQA;
      this.nQB = paramMap.nQB;
      this.nQC = paramMap.nQC;
      this.nQD = paramMap.nQD;
      this.nQE = paramMap.nQE;
      this.nQF = paramMap.nQF;
      this.nQG = paramMap.nQG;
      this.nQH = paramMap.nQH;
      this.nQI = paramMap.nQI;
      this.nQJ = paramMap.nQJ;
      this.nQK = paramMap.nQK;
      this.nQL = paramMap.nQL;
      this.nQM = paramMap.nQM;
      this.nQN = paramMap.nQN;
      this.nQO = paramMap.nQO;
      this.nQP = paramMap.nQP;
      this.nQQ = paramMap.nQQ;
      if (paramMap.aaxW != null) {
        this.nQR = paramMap.aaxW.ZV();
      }
      AppMethodBeat.o(169181);
      return;
    }
    catch (Exception paramb)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AppContentRedPacketCoverInfoPiece", paramb, "", new Object[0]);
      }
    }
  }
  
  public final f biW()
  {
    AppMethodBeat.i(169180);
    g localg = new g();
    AppMethodBeat.o(169180);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.message.g
 * JD-Core Version:    0.7.0.1
 */