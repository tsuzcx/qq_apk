package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fj
  extends a
{
  private String iHA = "";
  public int iHB;
  private String iHC = "";
  public int iHD;
  public int iHE;
  private String iHF = "";
  private String iHG = "";
  public int iHH;
  public int iHz;
  public int inj;
  public int ivK;
  
  public final String aIE()
  {
    AppMethodBeat.i(368081);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iHz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iHA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iHB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iHC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iHD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iHE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iHF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iHG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iHH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inj);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368081);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368087);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InnerVersion:").append(this.iHz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FlowId:").append(this.iHA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StageId:").append(this.iHB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StageName:").append(this.iHC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Succ:").append(this.iHD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("KeyStage:").append(this.iHE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MediaInfoJson:").append(this.iHF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CustomInfoJson:").append(this.iHG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MediaType:").append(this.iHH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrorType:").append(this.ivK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrorCode:").append(this.inj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368087);
    return localObject;
  }
  
  public final int getId()
  {
    return 23825;
  }
  
  public final fj pS(String paramString)
  {
    AppMethodBeat.i(368061);
    this.iHA = F("FlowId", paramString, true);
    AppMethodBeat.o(368061);
    return this;
  }
  
  public final fj pT(String paramString)
  {
    AppMethodBeat.i(368069);
    this.iHC = F("StageName", paramString, true);
    AppMethodBeat.o(368069);
    return this;
  }
  
  public final fj pU(String paramString)
  {
    AppMethodBeat.i(368072);
    this.iHF = F("MediaInfoJson", paramString, true);
    AppMethodBeat.o(368072);
    return this;
  }
  
  public final fj pV(String paramString)
  {
    AppMethodBeat.i(368077);
    this.iHG = F("CustomInfoJson", paramString, true);
    AppMethodBeat.o(368077);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.fj
 * JD-Core Version:    0.7.0.1
 */