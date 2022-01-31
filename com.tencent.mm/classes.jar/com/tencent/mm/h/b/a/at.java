package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;

public final class at
  extends a
{
  public long cpR = 0L;
  public long cpS = 0L;
  public String cpT = "";
  public long cpU = 0L;
  public String cpV = "";
  public String cpW = "";
  
  public final int getId()
  {
    return 14688;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cpR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cpS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cpT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cpU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cpV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cpW);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("actionType:").append(this.cpR);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("clientTimestamp:").append(this.cpS);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("appId:").append(this.cpT);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("serviceType:").append(this.cpU);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("statBuffer:").append(this.cpV);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("switchId:").append(this.cpW);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.h.b.a.at
 * JD-Core Version:    0.7.0.1
 */