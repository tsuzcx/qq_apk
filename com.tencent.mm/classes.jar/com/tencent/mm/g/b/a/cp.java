package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cp
  extends a
{
  public long dMB = 0L;
  public long dRX = 0L;
  public long dRY = 0L;
  public long dRZ = 0L;
  public long dSa = 0L;
  public long dSb = 0L;
  private long dSc = 0L;
  public String dSd = "";
  
  public final String PV()
  {
    AppMethodBeat.i(94843);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dMB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSd);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(94843);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(94844);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Source:").append(this.dMB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadLikeCount:").append(this.dRX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadCommentCount:").append(this.dRY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTime:").append(this.dRZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickLikeCount:").append(this.dSa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickCommentCount:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterStartTimeMs:").append(this.dSc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseJson:").append(this.dSd);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94844);
    return localObject;
  }
  
  public final cp ff(long paramLong)
  {
    AppMethodBeat.i(94842);
    this.dSc = paramLong;
    super.ba("EnterStartTimeMs", this.dSc);
    AppMethodBeat.o(94842);
    return this;
  }
  
  public final int getId()
  {
    return 13677;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cp
 * JD-Core Version:    0.7.0.1
 */