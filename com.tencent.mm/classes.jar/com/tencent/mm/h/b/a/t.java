package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;

public final class t
  extends a
{
  public String cjD = "";
  public String cjE = "";
  public long cjF = 0L;
  public String cjG = "";
  public String cjH = "";
  
  public final int getId()
  {
    return 15960;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cjD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjH);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("query:").append(this.cjD);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("sessionId:").append(this.cjE);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("isChange:").append(this.cjF);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("appidBefore:").append(this.cjG);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("appidAfter:").append(this.cjH);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.h.b.a.t
 * JD-Core Version:    0.7.0.1
 */