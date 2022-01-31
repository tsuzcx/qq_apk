package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;

public final class g
  extends a
{
  public String chm = "";
  public String chn = "";
  public int cho = 0;
  
  public final int getId()
  {
    return 15459;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.chm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cho);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("ChatroomName:").append(this.chm);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ExptScore:").append(this.chn);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ExptFlag:").append(this.cho);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.h.b.a.g
 * JD-Core Version:    0.7.0.1
 */