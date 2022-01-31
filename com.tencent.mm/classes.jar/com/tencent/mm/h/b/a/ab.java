package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;

public final class ab
  extends a
{
  public long ckp = 0L;
  public String cku = "";
  public long ckv = 0L;
  
  public final int getId()
  {
    return 16016;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ckp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cku);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ckv);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("ReportScene:").append(this.ckp);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("TransferUserName:").append(this.cku);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("TransferAmount:").append(this.ckv);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.h.b.a.ab
 * JD-Core Version:    0.7.0.1
 */