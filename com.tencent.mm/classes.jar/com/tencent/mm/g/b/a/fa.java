package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fa
  extends a
{
  public long dVg = 0L;
  public long dWt = 0L;
  public long dWu = 0L;
  public long dWv = 0L;
  private long dWw = 0L;
  private long dWx = 0L;
  private long dWy = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(118510);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWy);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(118510);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(118511);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickMyProfileTime:").append(this.dWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickCameraTime:").append(this.dWu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickGuidePageTime:").append(this.dWv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isProfileRedPoint:").append(this.dWw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isCameraRedPoint:").append(this.dWx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoObjectId:").append(this.dVg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isStoryCommentRedDot:").append(this.dWy);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118511);
    return localObject;
  }
  
  public final fa RE()
  {
    this.dWt = 0L;
    return this;
  }
  
  public final fa RF()
  {
    this.dWu = 0L;
    return this;
  }
  
  public final fa RG()
  {
    this.dWv = 0L;
    return this;
  }
  
  public final fa RH()
  {
    this.dVg = 0L;
    return this;
  }
  
  public final long RI()
  {
    return this.dVg;
  }
  
  public final int getId()
  {
    return 16844;
  }
  
  public final fa jA(long paramLong)
  {
    this.dWx = paramLong;
    return this;
  }
  
  public final fa jB(long paramLong)
  {
    this.dWy = paramLong;
    return this;
  }
  
  public final fa jz(long paramLong)
  {
    this.dWw = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fa
 * JD-Core Version:    0.7.0.1
 */