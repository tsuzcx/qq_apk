package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;

public final class az
  extends a
{
  public long ciV = 0L;
  public String cjD = "";
  public String cja = "";
  public String cqG = "";
  public long cqH = 0L;
  public String cqI = "";
  public long cqJ = 0L;
  public String cqK = "";
  public long cqL = 0L;
  
  public final int getId()
  {
    return 16033;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ciV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cqG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cqH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cqI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cqJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cqK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cja);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cqL);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("scene:").append(this.ciV);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("searchid:").append(this.cqG);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("businesstype:").append(this.cqH);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("docid:").append(this.cqI);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("timestampInMs:").append(this.cqJ);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("expand2:").append(this.cqK);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("query:").append(this.cjD);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("sessionid:").append(this.cja);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("resultsubtype:").append(this.cqL);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.h.b.a.az
 * JD-Core Version:    0.7.0.1
 */