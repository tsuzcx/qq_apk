package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;

public final class ad
  extends a
{
  public long ckB = 0L;
  public String ckC = "";
  public long ckD = 0L;
  public long ckE = 0L;
  public long ckz = 0L;
  
  public final int getId()
  {
    return 15402;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ckB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ckC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ckD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ckE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ckz);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("DeleteReason:").append(this.ckB);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("Appid:").append(this.ckC);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("DebugType:").append(this.ckD);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("DeleteCount:").append(this.ckE);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("AbtestStatus:").append(this.ckz);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.b.a.ad
 * JD-Core Version:    0.7.0.1
 */