package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;

public final class ax
  extends a
{
  private long cjo = 0L;
  public long cqA = 0L;
  public long cqB = 0L;
  private long cqC = 0L;
  public String cqD = "";
  public String cqE = "";
  public long cqz = 0L;
  
  public final ax aX(long paramLong)
  {
    this.cjo = paramLong;
    super.ah("StartTimeStampSec", this.cjo);
    return this;
  }
  
  public final ax aY(long paramLong)
  {
    this.cqC = paramLong;
    super.ah("EndTimeStampSec", this.cqC);
    return this;
  }
  
  public final int getId()
  {
    return 15452;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cqz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cqA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cqB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cqC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cqD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cqE);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("ExptId:").append(this.cqz);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("GroupId:").append(this.cqA);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ExptSeq:").append(this.cqB);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("StartTimeStampSec:").append(this.cjo);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("EndTimeStampSec:").append(this.cqC);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ExptKey:").append(this.cqD);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ExptVal:").append(this.cqE);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.h.b.a.ax
 * JD-Core Version:    0.7.0.1
 */