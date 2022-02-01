package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class g
  extends a
{
  public int ika;
  private String ikb = "";
  public int ikc;
  public int ikd;
  private String ike = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368637);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ika);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ike);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368637);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368645);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("NeedSync:").append(this.ika);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Score:").append(this.ikb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ScorePos:").append(this.ikc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ConfigPos:").append(this.ikd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HistoryStr:").append(this.ike);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368645);
    return localObject;
  }
  
  public final int getId()
  {
    return 22176;
  }
  
  public final g jY(String paramString)
  {
    AppMethodBeat.i(368623);
    this.ikb = F("Score", paramString, true);
    AppMethodBeat.o(368623);
    return this;
  }
  
  public final g jZ(String paramString)
  {
    AppMethodBeat.i(368628);
    this.ike = F("HistoryStr", paramString, true);
    AppMethodBeat.o(368628);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.g
 * JD-Core Version:    0.7.0.1
 */