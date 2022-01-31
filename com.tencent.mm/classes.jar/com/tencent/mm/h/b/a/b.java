package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bk;

public final class b
  extends a
{
  public long cfB = 0L;
  private long cfC = 0L;
  public long cfD = 0L;
  public long cfE = 0L;
  public long cfF = 0L;
  public long cfG = 0L;
  
  public final b al(long paramLong)
  {
    this.cfB = paramLong;
    super.ag("FirstInputTimeStampMs", this.cfB);
    return this;
  }
  
  public final b am(long paramLong)
  {
    this.cfC = paramLong;
    super.ag("LastInputTimeStampMs", this.cfC);
    return this;
  }
  
  public final int getId()
  {
    return 16113;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cfB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cfC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cfD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cfE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cfF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cfG);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("FirstInputTimeStampMs:").append(this.cfB);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("LastInputTimeStampMs:").append(this.cfC);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("SendStampMs:").append(this.cfD);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ClickCount:").append(this.cfE);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("TextLength:").append(this.cfF);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("EmojiCount:").append(this.cfG);
    return localStringBuffer.toString();
  }
  
  public final b uK()
  {
    return al(bk.UY());
  }
  
  public final b uL()
  {
    return am(bk.UY());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.h.b.a.b
 * JD-Core Version:    0.7.0.1
 */