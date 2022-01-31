package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bk;

public final class ah
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
  public ah.a clF;
  public ah.b clG;
  public long clH = 0L;
  public long clI = 0L;
  
  public final ah aw(long paramLong)
  {
    this.ckK = paramLong;
    super.af("CostTimeMs", this.ckK);
    return this;
  }
  
  public final ah ax(long paramLong)
  {
    this.ckL = paramLong;
    super.ag("StartTimeStampMs", this.ckL);
    return this;
  }
  
  public final int getId()
  {
    return 16010;
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
    if (this.clF != null) {}
    for (int i = this.clF.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.clG != null) {
        i = this.clG.value;
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
      ((StringBuffer)localObject).append(this.clH);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.clI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ckN);
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
    localStringBuffer.append("AppState:").append(this.clF);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("AppType:").append(this.clG);
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
    localStringBuffer.append("isDownloadCode:").append(this.clH);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("isPatch:").append(this.clI);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("isPreload:").append(this.ckN);
    return localStringBuffer.toString();
  }
  
  public final ah uV()
  {
    this.ckM = bk.UY();
    super.ag("EndTimeStampMs", this.ckM);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.h.b.a.ah
 * JD-Core Version:    0.7.0.1
 */