package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gb
  extends a
{
  public long eng = 0L;
  public long eos = 0L;
  public long eot = 0L;
  public long eou = 0L;
  private long eov = 0L;
  private long eow = 0L;
  private long eox = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(118510);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eos);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eot);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eou);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eov);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eow);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eng);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eox);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(118510);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(118511);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickMyProfileTime:").append(this.eos);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickCameraTime:").append(this.eot);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickGuidePageTime:").append(this.eou);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isProfileRedPoint:").append(this.eov);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isCameraRedPoint:").append(this.eow);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoObjectId:").append(this.eng);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isStoryCommentRedDot:").append(this.eox);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118511);
    return localObject;
  }
  
  public final gb TR()
  {
    this.eos = 0L;
    return this;
  }
  
  public final gb TS()
  {
    this.eot = 0L;
    return this;
  }
  
  public final gb TT()
  {
    this.eou = 0L;
    return this;
  }
  
  public final gb TU()
  {
    this.eng = 0L;
    return this;
  }
  
  public final long TV()
  {
    return this.eng;
  }
  
  public final int getId()
  {
    return 16844;
  }
  
  public final gb lw(long paramLong)
  {
    this.eov = paramLong;
    return this;
  }
  
  public final gb lx(long paramLong)
  {
    this.eow = paramLong;
    return this;
  }
  
  public final gb ly(long paramLong)
  {
    this.eox = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gb
 * JD-Core Version:    0.7.0.1
 */