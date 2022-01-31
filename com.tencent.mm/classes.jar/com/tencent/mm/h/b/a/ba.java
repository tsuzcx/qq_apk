package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;

public final class ba
  extends a
{
  public long ciV = 0L;
  public String cjD = "";
  public String cja = "";
  public String cqG = "";
  public String cqM = "";
  public String cqN = "";
  public String cqO = "";
  
  public final int getId()
  {
    return 16032;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ciV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cqM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cqG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cja);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cqN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cqO);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("scene:").append(this.ciV);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("content:").append(this.cqM);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("searchid:").append(this.cqG);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("sessionid:").append(this.cja);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("query:").append(this.cjD);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("resulttype:").append(this.cqN);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("resultsubtypelist:").append(this.cqO);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.h.b.a.ba
 * JD-Core Version:    0.7.0.1
 */