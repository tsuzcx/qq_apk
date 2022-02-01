package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ed
  extends a
{
  public long dNc = 0L;
  public long dTL = 0L;
  public long dTM = 0L;
  public long dTN = 0L;
  public long dTO = 0L;
  public long dTP = 0L;
  private long dTQ = 0L;
  public String dTR = "";
  
  public final String PR()
  {
    AppMethodBeat.i(94843);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dNc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTR);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(94843);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(94844);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Source:").append(this.dNc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadLikeCount:").append(this.dTL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadCommentCount:").append(this.dTM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTime:").append(this.dTN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickLikeCount:").append(this.dTO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickCommentCount:").append(this.dTP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterStartTimeMs:").append(this.dTQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseJson:").append(this.dTR);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94844);
    return localObject;
  }
  
  public final int getId()
  {
    return 13677;
  }
  
  public final ed is(long paramLong)
  {
    AppMethodBeat.i(94842);
    this.dTQ = paramLong;
    super.bc("EnterStartTimeMs", this.dTQ);
    AppMethodBeat.o(94842);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ed
 * JD-Core Version:    0.7.0.1
 */