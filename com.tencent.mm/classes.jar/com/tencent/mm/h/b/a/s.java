package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;

public final class s
  extends a
{
  public String cjA = "";
  public String cjB = "";
  private long cjC = 0L;
  public String cjv = "";
  
  public final s ap(long paramLong)
  {
    this.cjC = paramLong;
    super.ag("timestampMs", this.cjC);
    return this;
  }
  
  public final int getId()
  {
    return 15961;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cjv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjC);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("appid:").append(this.cjv);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("api:").append(this.cjA);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("arg:").append(this.cjB);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("timestampMs:").append(this.cjC);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.h.b.a.s
 * JD-Core Version:    0.7.0.1
 */