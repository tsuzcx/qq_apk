package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nx
  extends a
{
  public long iCY = 0L;
  public long iOd = 0L;
  public long iuR = 0L;
  public long jgE = 0L;
  public long jgF = 0L;
  public long jgG = 0L;
  private long jgH = 0L;
  public String jgI = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(94843);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iOd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jgE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jgF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jgG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jgH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jgI);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(94843);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(94844);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Source:").append(this.iOd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadLikeCount:").append(this.jgE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadCommentCount:").append(this.jgF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTime:").append(this.iuR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickLikeCount:").append(this.iCY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickCommentCount:").append(this.jgG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterStartTimeMs:").append(this.jgH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseJson:").append(this.jgI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94844);
    return localObject;
  }
  
  public final nx fo(long paramLong)
  {
    AppMethodBeat.i(94842);
    this.jgH = paramLong;
    super.bw("EnterStartTimeMs", this.jgH);
    AppMethodBeat.o(94842);
    return this;
  }
  
  public final int getId()
  {
    return 13677;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.nx
 * JD-Core Version:    0.7.0.1
 */