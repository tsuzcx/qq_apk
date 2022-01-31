package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bk;

public final class v
  extends a
{
  public String cie = "";
  private long cjJ = 0L;
  
  public final int getId()
  {
    return 15988;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cie);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjJ);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("SessionId:").append(this.cie);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ClickTimeStampMs:").append(this.cjJ);
    return localStringBuffer.toString();
  }
  
  public final v uR()
  {
    this.cjJ = bk.UY();
    super.ag("ClickTimeStampMs", this.cjJ);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.b.a.v
 * JD-Core Version:    0.7.0.1
 */