package com.tencent.mm.ai;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.cia;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public class g
  extends f
{
  public String gGH;
  public String gGI;
  public String gGJ;
  public String gGK;
  public String gGL;
  public String gGM;
  public String gGN;
  public String gGO;
  public String gGP;
  public String gGQ;
  public String gGR;
  public String gGS;
  public boolean gGT;
  public int gGU;
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(169181);
    paramb = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.coverinfo"));
    paramMap = new cia();
    try
    {
      if (!bt.isNullOrNil(paramb)) {
        paramMap.parseFrom(Base64.decode(paramb, 0));
      }
      this.gGH = paramMap.gGH;
      this.gGI = paramMap.gGI;
      this.gGJ = paramMap.gGJ;
      this.gGK = paramMap.gGK;
      this.gGL = paramMap.gGL;
      this.gGM = paramMap.gGM;
      this.gGN = paramMap.gGN;
      this.gGO = paramMap.gGO;
      this.gGP = paramMap.gGP;
      this.gGQ = paramMap.gGQ;
      this.gGR = paramMap.gGR;
      this.gGS = paramMap.gGS;
      this.gGT = paramMap.gGT;
      this.gGU = paramMap.gGU;
      AppMethodBeat.o(169181);
      return;
    }
    catch (Exception paramb)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.AppContentRedPacketCoverInfoPiece", paramb, "", new Object[0]);
      }
    }
  }
  
  public final f apu()
  {
    AppMethodBeat.i(169180);
    g localg = new g();
    AppMethodBeat.o(169180);
    return localg;
  }
  
  public final void b(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ai.g
 * JD-Core Version:    0.7.0.1
 */