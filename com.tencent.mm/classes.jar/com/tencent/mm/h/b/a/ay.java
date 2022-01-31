package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;

public final class ay
  extends a
{
  public long cfv = 0L;
  public String cjD = "";
  public long cqF = 0L;
  
  public final int getId()
  {
    return 15776;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cqF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cfv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjD);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("actionScene:").append(this.cqF);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("action:").append(this.cfv);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("query:").append(this.cjD);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.h.b.a.ay
 * JD-Core Version:    0.7.0.1
 */