package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;

public final class x
  extends a
{
  public long cjQ = 0L;
  public String cjR = "";
  public String cjS = "";
  
  public final int getId()
  {
    return 15493;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cjQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjS);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("LogType:").append(this.cjQ);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("WechatLanguage:").append(this.cjR);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("InputLanguage:").append(this.cjS);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.h.b.a.x
 * JD-Core Version:    0.7.0.1
 */