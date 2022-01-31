package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;

public final class c
  extends a
{
  public String cfH = "";
  public long cfI = 0L;
  public c.a cfJ;
  
  public final int getId()
  {
    return 15586;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cfH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cfI);
    ((StringBuffer)localObject).append(",");
    if (this.cfJ != null) {}
    for (int i = this.cfJ.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      LT((String)localObject);
      return localObject;
    }
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("Url:").append(this.cfH);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("DownLoadCostStampMs:").append(this.cfI);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("PreLoadStatus:").append(this.cfJ);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.b.a.c
 * JD-Core Version:    0.7.0.1
 */