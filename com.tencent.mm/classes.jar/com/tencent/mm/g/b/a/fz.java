package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fz
  extends a
{
  public long ely = 0L;
  public long emJ = 0L;
  public long emK = 0L;
  public long emL = 0L;
  private long emM = 0L;
  private long emN = 0L;
  private long emO = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(118510);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.emJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ely);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emO);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(118510);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(118511);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickMyProfileTime:").append(this.emJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickCameraTime:").append(this.emK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickGuidePageTime:").append(this.emL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isProfileRedPoint:").append(this.emM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isCameraRedPoint:").append(this.emN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoObjectId:").append(this.ely);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isStoryCommentRedDot:").append(this.emO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118511);
    return localObject;
  }
  
  public final fz TL()
  {
    this.emJ = 0L;
    return this;
  }
  
  public final fz TM()
  {
    this.emK = 0L;
    return this;
  }
  
  public final fz TN()
  {
    this.emL = 0L;
    return this;
  }
  
  public final fz TO()
  {
    this.ely = 0L;
    return this;
  }
  
  public final long TP()
  {
    return this.ely;
  }
  
  public final int getId()
  {
    return 16844;
  }
  
  public final fz ll(long paramLong)
  {
    this.emM = paramLong;
    return this;
  }
  
  public final fz lm(long paramLong)
  {
    this.emN = paramLong;
    return this;
  }
  
  public final fz ln(long paramLong)
  {
    this.emO = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fz
 * JD-Core Version:    0.7.0.1
 */