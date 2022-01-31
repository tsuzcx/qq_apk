package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;

public final class h
  extends a
{
  public String chm = "";
  public int chp = 0;
  public long chq = 0L;
  public long chr = 0L;
  public long chs = 0L;
  private long cht = 0L;
  public long chu = 0L;
  public String chv = "";
  
  public final h an(long paramLong)
  {
    this.cht = paramLong;
    super.af("StayTimeMs", this.cht);
    return this;
  }
  
  public final int getId()
  {
    return 15460;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.chm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cht);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chv);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("ChatroomName:").append(this.chm);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ChatroomMute:").append(this.chp);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("UnreadCount:").append(this.chq);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("DisRedDotCount:").append(this.chr);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("EnterCount:").append(this.chs);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("StayTimeMs:").append(this.cht);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("SendCount:").append(this.chu);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("Score:").append(this.chv);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.h.b.a.h
 * JD-Core Version:    0.7.0.1
 */