package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;

public final class z
  extends a
{
  public long ckp = 0L;
  public long ckq = 0L;
  
  public final int getId()
  {
    return 15522;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ckp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ckq);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("ReportScene:").append(this.ckp);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ResetScece:").append(this.ckq);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.h.b.a.z
 * JD-Core Version:    0.7.0.1
 */