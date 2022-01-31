package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;

public final class ak
  extends a
{
  private String bmf;
  private long cic;
  private String ckF;
  private String ckG;
  private long ckH;
  private long ckK;
  private long ckL;
  private long ckM;
  private long clr;
  private ak.a cmA;
  private ak.b cmB;
  private String cmC;
  
  public final int getId()
  {
    return 16006;
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
    if (this.cmA != null) {}
    for (int i = this.cmA.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.cmB != null) {
        i = this.cmB.value;
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
      ((StringBuffer)localObject).append(this.cmC);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.clr);
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
    localStringBuffer.append("AppState:").append(this.cmA);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("AppType:").append(this.cmB);
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
    localStringBuffer.append("referrer:").append(this.cmC);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("fileSize:").append(this.clr);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.h.b.a.ak
 * JD-Core Version:    0.7.0.1
 */