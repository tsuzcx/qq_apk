package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bk;

public final class as
  extends a
{
  public String bmf = "";
  public long cic = 0L;
  public String ckF = "";
  public String ckG = "";
  public long ckH = 0L;
  private long ckK = 0L;
  private long ckL = 0L;
  public long ckM = 0L;
  public long ckN = 0L;
  public long clX = 0L;
  public as.a cpD;
  public as.b cpE;
  
  public final as aV(long paramLong)
  {
    this.ckK = paramLong;
    super.af("CostTimeMs", this.ckK);
    return this;
  }
  
  public final as aW(long paramLong)
  {
    this.ckL = paramLong;
    super.ag("StartTimeStampMs", this.ckL);
    return this;
  }
  
  public final int getId()
  {
    return 16011;
  }
  
  public final String uI()
  {
    int j = -1;
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ckF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ckG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ckH);
    ((StringBuffer)localObject).append(",");
    if (this.cpD != null) {}
    for (int i = this.cpD.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.cpE != null) {
        i = this.cpE.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ckK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cic);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ckL);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ckM);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.bmf);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ckN);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.clX);
      localObject = ((StringBuffer)localObject).toString();
      LT((String)localObject);
      return localObject;
    }
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("InstanceId:").append(this.ckF);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("AppId:").append(this.ckG);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("AppVersion:").append(this.ckH);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("AppState:").append(this.cpD);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("AppType:").append(this.cpE);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("CostTimeMs:").append(this.ckK);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("Scene:").append(this.cic);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("StartTimeStampMs:").append(this.ckL);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("EndTimeStampMs:").append(this.ckM);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("path:").append(this.bmf);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("isPreload:").append(this.ckN);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("isPreloadPageFrame:").append(this.clX);
    return localStringBuffer.toString();
  }
  
  public final as vd()
  {
    this.ckM = bk.UY();
    super.ag("EndTimeStampMs", this.ckM);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.h.b.a.as
 * JD-Core Version:    0.7.0.1
 */