package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;

public final class r
  extends a
{
  public String cjr = "";
  public long cjs = 0L;
  public long cjt = 0L;
  public long cju = 0L;
  public String cjv = "";
  public long cjw = 0L;
  public long cjx = 0L;
  public String cjy = "";
  public String cjz = "";
  
  public final int getId()
  {
    return 14452;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cjr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cju);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjz);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("statId:").append(this.cjr);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("statEvent:").append(this.cjs);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("statTimeStamp:").append(this.cjt);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("success:").append(this.cju);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("appid:").append(this.cjv);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("searchType:").append(this.cjw);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("hasInitData:").append(this.cjx);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("netType:").append(this.cjy);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("jsError:").append(this.cjz);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.h.b.a.r
 * JD-Core Version:    0.7.0.1
 */