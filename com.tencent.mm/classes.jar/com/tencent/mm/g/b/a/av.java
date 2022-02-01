package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class av
  extends a
{
  public int dYC;
  public String dYD = "";
  public String dYE = "";
  public long dYF;
  public long dYG;
  public long dYH;
  public String dYI = "";
  public int dYJ;
  public int dYK;
  public int dYL;
  public int dYM;
  private String dYN = "";
  public String dYO = "";
  public String dYP = "";
  
  public final String RC()
  {
    AppMethodBeat.i(169253);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYP);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(169253);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(169254);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PID:").append(this.dYC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PName:").append(this.dYD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionId:").append(this.dYE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("frontTime:").append(this.dYF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("stayTotalTime:").append(this.dYG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scrollTotalTime:").append(this.dYH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reportFeedList:").append(this.dYI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reportFeedCount:").append(this.dYJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.dYK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeq:").append(this.dYL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeqSum:").append(this.dYM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Performance:").append(this.dYN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionPageId:").append(this.dYO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionKey:").append(this.dYP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(169254);
    return localObject;
  }
  
  public final int getId()
  {
    return 18260;
  }
  
  public final av iA(String paramString)
  {
    AppMethodBeat.i(169249);
    this.dYD = t("PName", paramString, true);
    AppMethodBeat.o(169249);
    return this;
  }
  
  public final av iB(String paramString)
  {
    AppMethodBeat.i(169250);
    this.dYE = t("sessionId", paramString, true);
    AppMethodBeat.o(169250);
    return this;
  }
  
  public final av iC(String paramString)
  {
    AppMethodBeat.i(169251);
    this.dYO = t("SessionPageId", paramString, true);
    AppMethodBeat.o(169251);
    return this;
  }
  
  public final av iD(String paramString)
  {
    AppMethodBeat.i(169252);
    this.dYP = t("SessionKey", paramString, true);
    AppMethodBeat.o(169252);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.av
 * JD-Core Version:    0.7.0.1
 */