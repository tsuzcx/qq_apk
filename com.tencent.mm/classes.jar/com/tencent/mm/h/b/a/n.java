package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;

public final class n
  extends a
{
  public String ciW = "";
  public long ciX = 0L;
  public long ciY = 0L;
  public long ciZ = 0L;
  
  public final int getId()
  {
    return 15850;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ciW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ciX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ciY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ciZ);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("sessionID:").append(this.ciW);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("actionCode:").append(this.ciX);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("actionCodeResult:").append(this.ciY);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("clickAddContact:").append(this.ciZ);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.h.b.a.n
 * JD-Core Version:    0.7.0.1
 */