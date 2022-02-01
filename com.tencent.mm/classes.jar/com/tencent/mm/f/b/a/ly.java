package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ly
  extends a
{
  public long gRi = 0L;
  public long gSs = 0L;
  public long gSt = 0L;
  public long gSu = 0L;
  private long gSv = 0L;
  private long gSw = 0L;
  private long gSx = 0L;
  
  public final String agH()
  {
    AppMethodBeat.i(118510);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gSs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSx);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(118510);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(118511);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickMyProfileTime:").append(this.gSs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickCameraTime:").append(this.gSt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickGuidePageTime:").append(this.gSu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isProfileRedPoint:").append(this.gSv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isCameraRedPoint:").append(this.gSw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoObjectId:").append(this.gRi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isStoryCommentRedDot:").append(this.gSx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118511);
    return localObject;
  }
  
  public final ly anc()
  {
    this.gSs = 0L;
    return this;
  }
  
  public final ly and()
  {
    this.gSt = 0L;
    return this;
  }
  
  public final ly ane()
  {
    this.gSu = 0L;
    return this;
  }
  
  public final ly anf()
  {
    this.gRi = 0L;
    return this;
  }
  
  public final long ang()
  {
    return this.gRi;
  }
  
  public final int getId()
  {
    return 16844;
  }
  
  public final ly wA(long paramLong)
  {
    this.gSv = paramLong;
    return this;
  }
  
  public final ly wB(long paramLong)
  {
    this.gSw = paramLong;
    return this;
  }
  
  public final ly wC(long paramLong)
  {
    this.gSx = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ly
 * JD-Core Version:    0.7.0.1
 */