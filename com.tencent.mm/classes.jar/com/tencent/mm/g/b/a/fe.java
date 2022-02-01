package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fe
  extends a
{
  public long edv = 0L;
  public long elK = 0L;
  public long elL = 0L;
  public long elM = 0L;
  public long elN = 0L;
  public long elO = 0L;
  private long elP = 0L;
  public String elQ = "";
  
  public final String RC()
  {
    AppMethodBeat.i(94843);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.edv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elQ);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(94843);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(94844);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Source:").append(this.edv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadLikeCount:").append(this.elK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadCommentCount:").append(this.elL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTime:").append(this.elM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickLikeCount:").append(this.elN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickCommentCount:").append(this.elO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterStartTimeMs:").append(this.elP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseJson:").append(this.elQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94844);
    return localObject;
  }
  
  public final int getId()
  {
    return 13677;
  }
  
  public final fe kp(long paramLong)
  {
    AppMethodBeat.i(94842);
    this.elP = paramLong;
    super.bg("EnterStartTimeMs", this.elP);
    AppMethodBeat.o(94842);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fe
 * JD-Core Version:    0.7.0.1
 */