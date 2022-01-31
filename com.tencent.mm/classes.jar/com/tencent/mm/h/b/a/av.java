package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;

public final class av
  extends a
{
  public long cfv = 0L;
  public String cjv = "";
  public long cjx = 0L;
  public long cpX = 0L;
  public long cpY = 0L;
  
  public final int getId()
  {
    return 15841;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cfv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cpX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cpY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjx);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("action:").append(this.cfv);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("appid:").append(this.cjv);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("timecost:").append(this.cpX);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("drawStrategy:").append(this.cpY);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("hasInitData:").append(this.cjx);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.b.a.av
 * JD-Core Version:    0.7.0.1
 */