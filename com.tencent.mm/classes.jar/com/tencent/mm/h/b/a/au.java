package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;

public final class au
  extends a
{
  private String cjD = "";
  public String cjv = "";
  public long cjx = 0L;
  public long cpX = 0L;
  
  public final int getId()
  {
    return 15831;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cjv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cpX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjx);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("appid:").append(this.cjv);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("query:").append(this.cjD);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("timecost:").append(this.cpX);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("hasInitData:").append(this.cjx);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.h.b.a.au
 * JD-Core Version:    0.7.0.1
 */