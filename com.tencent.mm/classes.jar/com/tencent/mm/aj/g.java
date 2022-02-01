package com.tencent.mm.aj;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.dvj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class g
  extends f
{
  public String llA;
  public String llB;
  public String llC;
  public String llD;
  public String llE;
  public String llF;
  public String llG;
  public String llH;
  public String llI;
  public String llJ;
  public boolean llK;
  public int llL;
  public String lly;
  public String llz;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2) {}
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(169181);
    paramb = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.coverinfo"));
    paramMap = new dvj();
    try
    {
      if (!Util.isNullOrNil(paramb)) {
        paramMap.parseFrom(Base64.decode(paramb, 0));
      }
      this.lly = paramMap.lly;
      this.llz = paramMap.llz;
      this.llA = paramMap.llA;
      this.llB = paramMap.llB;
      this.llC = paramMap.llC;
      this.llD = paramMap.llD;
      this.llE = paramMap.llE;
      this.llF = paramMap.llF;
      this.llG = paramMap.llG;
      this.llH = paramMap.llH;
      this.llI = paramMap.llI;
      this.llJ = paramMap.llJ;
      this.llK = paramMap.llK;
      this.llL = paramMap.llL;
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
  
  public final f aPj()
  {
    AppMethodBeat.i(169180);
    g localg = new g();
    AppMethodBeat.o(169180);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aj.g
 * JD-Core Version:    0.7.0.1
 */