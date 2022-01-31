package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;

public final class bc
  extends a
{
  public String cjv = "";
  public long cqR = 0L;
  public String cqS = "";
  public String cqT = "";
  public long cqU = 0L;
  public long cqV = 0L;
  public long cqW = 0L;
  public long cqX = 0L;
  
  public final int getId()
  {
    return 15778;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cjv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cqR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cqS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cqT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cqU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cqV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cqW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cqX);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("appid:").append(this.cjv);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("appVersion:").append(this.cqR);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("pkgMd5:").append(this.cqS);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("downloadUrl:").append(this.cqT);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("isSuccess:").append(this.cqU);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("timeCostInMs:").append(this.cqV);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("timeStampInMs:").append(this.cqW);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("totalLen:").append(this.cqX);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.h.b.a.bc
 * JD-Core Version:    0.7.0.1
 */