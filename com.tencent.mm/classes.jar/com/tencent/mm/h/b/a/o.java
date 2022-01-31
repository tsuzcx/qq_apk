package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;

public final class o
  extends a
{
  public String cja = "";
  public String cjb = "";
  public long cjc = 0L;
  public long cjd = 0L;
  public long cje = 0L;
  public long cjf = 0L;
  public long cjg = 0L;
  public long cjh = 0L;
  
  public final int getId()
  {
    return 15855;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cja);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cje);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjh);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("sessionid:").append(this.cja);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("userName:").append(this.cjb);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("succeedStatus:").append(this.cjc);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("userStatus:").append(this.cjd);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("showSucceedMethod:").append(this.cje);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("clickSucceedAction:").append(this.cjf);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("watchMessageRecord:").append(this.cjg);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("sendMessageStatus:").append(this.cjh);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.h.b.a.o
 * JD-Core Version:    0.7.0.1
 */