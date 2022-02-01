package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fc
  extends a
{
  public long eca = 0L;
  public long ekd = 0L;
  public long eke = 0L;
  public long ekf = 0L;
  public long ekg = 0L;
  public long ekh = 0L;
  private long eki = 0L;
  public String ekj = "";
  
  public final String RD()
  {
    AppMethodBeat.i(94843);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eca);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eke);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eki);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekj);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(94843);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(94844);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Source:").append(this.eca);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadLikeCount:").append(this.ekd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadCommentCount:").append(this.eke);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTime:").append(this.ekf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickLikeCount:").append(this.ekg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickCommentCount:").append(this.ekh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterStartTimeMs:").append(this.eki);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseJson:").append(this.ekj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94844);
    return localObject;
  }
  
  public final int getId()
  {
    return 13677;
  }
  
  public final fc ke(long paramLong)
  {
    AppMethodBeat.i(94842);
    this.eki = paramLong;
    super.bf("EnterStartTimeMs", this.eki);
    AppMethodBeat.o(94842);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fc
 * JD-Core Version:    0.7.0.1
 */