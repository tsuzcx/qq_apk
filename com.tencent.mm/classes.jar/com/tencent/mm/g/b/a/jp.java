package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jp
  extends a
{
  public long eQM = 0L;
  public long eRW = 0L;
  public long eRX = 0L;
  public long eRY = 0L;
  private long eRZ = 0L;
  private long eSa = 0L;
  private long eSb = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(118510);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eRW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSb);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(118510);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(118511);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickMyProfileTime:").append(this.eRW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickCameraTime:").append(this.eRX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickGuidePageTime:").append(this.eRY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isProfileRedPoint:").append(this.eRZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isCameraRedPoint:").append(this.eSa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoObjectId:").append(this.eQM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isStoryCommentRedDot:").append(this.eSb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118511);
    return localObject;
  }
  
  public final jp ahG()
  {
    this.eRW = 0L;
    return this;
  }
  
  public final jp ahH()
  {
    this.eRX = 0L;
    return this;
  }
  
  public final jp ahI()
  {
    this.eRY = 0L;
    return this;
  }
  
  public final jp ahJ()
  {
    this.eQM = 0L;
    return this;
  }
  
  public final long ahK()
  {
    return this.eQM;
  }
  
  public final int getId()
  {
    return 16844;
  }
  
  public final jp sA(long paramLong)
  {
    this.eSb = paramLong;
    return this;
  }
  
  public final jp sy(long paramLong)
  {
    this.eRZ = paramLong;
    return this;
  }
  
  public final jp sz(long paramLong)
  {
    this.eSa = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jp
 * JD-Core Version:    0.7.0.1
 */