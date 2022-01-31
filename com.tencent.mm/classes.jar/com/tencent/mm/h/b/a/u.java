package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bk;

public final class u
  extends a
{
  public String cie = "";
  public long cjI = 0L;
  private long cjJ = 0L;
  
  public final int getId()
  {
    return 15987;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cjI);
    ((StringBuffer)localObject).append(",");
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
    localStringBuffer.append("Entrance:").append(this.cjI);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("SessionId:").append(this.cie);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ClickTimeStampMs:").append(this.cjJ);
    return localStringBuffer.toString();
  }
  
  public final u uQ()
  {
    this.cjJ = bk.UY();
    super.ag("ClickTimeStampMs", this.cjJ);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.h.b.a.u
 * JD-Core Version:    0.7.0.1
 */