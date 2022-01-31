package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bb
  extends a
{
  public long cVu = 0L;
  public long cWB = 0L;
  public long cWC = 0L;
  public long cWD = 0L;
  private long cWE = 0L;
  private long cWF = 0L;
  private long cWG = 0L;
  
  public final bb FP()
  {
    this.cWB = 0L;
    return this;
  }
  
  public final bb FQ()
  {
    this.cWC = 0L;
    return this;
  }
  
  public final bb FR()
  {
    this.cWD = 0L;
    return this;
  }
  
  public final bb FS()
  {
    this.cVu = 0L;
    return this;
  }
  
  public final long FT()
  {
    return this.cVu;
  }
  
  public final String Ff()
  {
    AppMethodBeat.i(108867);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cWB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cWC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cWD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cWE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cWF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cWG);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(108867);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(108868);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickMyProfileTime:").append(this.cWB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickCameraTime:").append(this.cWC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickGuidePageTime:").append(this.cWD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isProfileRedPoint:").append(this.cWE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isCameraRedPoint:").append(this.cWF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoObjectId:").append(this.cVu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isStoryCommentRedDot:").append(this.cWG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(108868);
    return localObject;
  }
  
  public final bb cR(long paramLong)
  {
    this.cWE = paramLong;
    return this;
  }
  
  public final bb cS(long paramLong)
  {
    this.cWF = paramLong;
    return this;
  }
  
  public final bb cT(long paramLong)
  {
    this.cWG = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 16844;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bb
 * JD-Core Version:    0.7.0.1
 */