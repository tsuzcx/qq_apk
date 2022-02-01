package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ip
  extends a
{
  public long eDV = 0L;
  public long ePk = 0L;
  public long ePl = 0L;
  public long ePm = 0L;
  private long ePn = 0L;
  public String ePo = "";
  public long eqw = 0L;
  public long eww = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(94843);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eDV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ePk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ePl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eww);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ePm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ePn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ePo);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(94843);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(94844);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Source:").append(this.eDV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadLikeCount:").append(this.ePk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadCommentCount:").append(this.ePl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTime:").append(this.eqw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickLikeCount:").append(this.eww);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickCommentCount:").append(this.ePm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterStartTimeMs:").append(this.ePn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseJson:").append(this.ePo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94844);
    return localObject;
  }
  
  public final int getId()
  {
    return 13677;
  }
  
  public final ip rr(long paramLong)
  {
    AppMethodBeat.i(94842);
    this.ePn = paramLong;
    super.bi("EnterStartTimeMs", this.ePn);
    AppMethodBeat.o(94842);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ip
 * JD-Core Version:    0.7.0.1
 */