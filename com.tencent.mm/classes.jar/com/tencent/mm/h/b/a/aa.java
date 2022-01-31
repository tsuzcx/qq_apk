package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;

public final class aa
  extends a
{
  public long ckr = 0L;
  public long cks = 0L;
  public long ckt = 0L;
  
  public final int getId()
  {
    return 15661;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ckr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cks);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ckt);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("ClickScene:").append(this.ckr);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ReportValue:").append(this.cks);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("EntryScene:").append(this.ckt);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.b.a.aa
 * JD-Core Version:    0.7.0.1
 */