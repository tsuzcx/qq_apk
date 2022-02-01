package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ue
  extends a
{
  private long iLN = 0L;
  private long iOd = 0L;
  private long jFM;
  public long jFN = 0L;
  public long jFO = 0L;
  private String jFP = "";
  
  public final ue Ab(String paramString)
  {
    AppMethodBeat.i(94858);
    this.jFP = F("OpenimUsername", paramString, true);
    AppMethodBeat.o(94858);
    return this;
  }
  
  public final String aIE()
  {
    AppMethodBeat.i(94859);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jFM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFP);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(94859);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(94860);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("OpenimUin:").append(this.jFM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OptionType:").append(this.jFN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OptionResult:").append(this.jFO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Source:").append(this.iOd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAction:").append(this.iLN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpenimUsername:").append(this.jFP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94860);
    return localObject;
  }
  
  public final int getId()
  {
    return 18337;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ue
 * JD-Core Version:    0.7.0.1
 */