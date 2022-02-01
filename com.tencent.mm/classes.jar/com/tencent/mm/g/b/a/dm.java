package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dm
  extends a
{
  public long dTu = 0L;
  public long dUH = 0L;
  public long dUI = 0L;
  public long dUJ = 0L;
  private long dUK = 0L;
  private long dUL = 0L;
  private long dUM = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(118510);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dUH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUM);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(118510);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(118511);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickMyProfileTime:").append(this.dUH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickCameraTime:").append(this.dUI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickGuidePageTime:").append(this.dUJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isProfileRedPoint:").append(this.dUK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isCameraRedPoint:").append(this.dUL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoObjectId:").append(this.dTu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isStoryCommentRedDot:").append(this.dUM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118511);
    return localObject;
  }
  
  public final dm Rc()
  {
    this.dUH = 0L;
    return this;
  }
  
  public final dm Rd()
  {
    this.dUI = 0L;
    return this;
  }
  
  public final dm Re()
  {
    this.dUJ = 0L;
    return this;
  }
  
  public final dm Rf()
  {
    this.dTu = 0L;
    return this;
  }
  
  public final long Rg()
  {
    return this.dTu;
  }
  
  public final int getId()
  {
    return 16844;
  }
  
  public final dm gm(long paramLong)
  {
    this.dUK = paramLong;
    return this;
  }
  
  public final dm gn(long paramLong)
  {
    this.dUL = paramLong;
    return this;
  }
  
  public final dm go(long paramLong)
  {
    this.dUM = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dm
 * JD-Core Version:    0.7.0.1
 */