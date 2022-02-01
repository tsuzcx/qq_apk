package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class co
  extends a
{
  public int dYC = 0;
  public String dYD = "";
  public String dYE = "";
  public long dYF = 0L;
  public long dYG = 0L;
  public long dYH = 0L;
  public String dYI = "";
  public int dYJ = 0;
  public int dYK = 0;
  public int dYL = 0;
  public int dYM = 0;
  
  public final String RC()
  {
    AppMethodBeat.i(121751);
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
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(121751);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(121752);
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
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121752);
    return localObject;
  }
  
  public final int getId()
  {
    return 16242;
  }
  
  public final co me(String paramString)
  {
    AppMethodBeat.i(121749);
    this.dYD = t("PName", paramString, true);
    AppMethodBeat.o(121749);
    return this;
  }
  
  public final co mf(String paramString)
  {
    AppMethodBeat.i(121750);
    this.dYE = t("sessionId", paramString, true);
    AppMethodBeat.o(121750);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.co
 * JD-Core Version:    0.7.0.1
 */