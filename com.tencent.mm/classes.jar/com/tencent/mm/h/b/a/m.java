package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;

public final class m
  extends a
{
  public String ciU = "";
  public long ciV = 0L;
  
  public final int getId()
  {
    return 15848;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ciU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ciV);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("chatRoomUserName:").append(this.ciU);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("scene:").append(this.ciV);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.h.b.a.m
 * JD-Core Version:    0.7.0.1
 */