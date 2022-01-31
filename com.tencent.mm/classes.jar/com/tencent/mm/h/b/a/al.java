package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;

public final class al
  extends a
{
  public long cic = 0L;
  public String ckF = "";
  public String ckG = "";
  public long ckH = 0L;
  private long ckK = 0L;
  private long ckL = 0L;
  private long ckM = 0L;
  public al.a cmP;
  public al.b cmQ;
  public long cmR = 0L;
  public long cmS = 0L;
  public long cmT = 0L;
  public long cmU = 0L;
  public long cmV = 0L;
  public long cmW = 0L;
  public long cmX = 0L;
  public long cmY = 0L;
  public long cmZ = 0L;
  public long cna = 0L;
  public long cnb = 0L;
  public long cnc = 0L;
  public long cnd = 0L;
  
  public final int getId()
  {
    return 16023;
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
    if (this.cmP != null) {}
    for (int i = this.cmP.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.cmQ != null) {
        i = this.cmQ.value;
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
      ((StringBuffer)localObject).append(this.cmR);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cmS);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cmT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cmU);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cmV);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cmW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cmX);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cmY);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cmZ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cna);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cnb);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cnc);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cnd);
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
    localStringBuffer.append("AppState:").append(this.cmP);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("AppType:").append(this.cmQ);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("CostTimeMs:").append(this.ckK);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("Scene:").append(this.cic);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("StartTimeStampMs:").append(this.ckL);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("EndTimeStampMs:").append(this.ckM);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("fps:").append(this.cmR);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("fpsVariance:").append(this.cmS);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("cpu:").append(this.cmT);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("memory:").append(this.cmU);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("memoryDiff:").append(this.cmV);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("androidNativeMemory:").append(this.cmW);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("androidDalvikMemory:").append(this.cmX);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("runtimeDuration:").append(this.cmY);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("runtimeCount:").append(this.cmZ);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("mainCanvasType:").append(this.cna);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("triangles:").append(this.cnb);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("drawcall:").append(this.cnc);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("vertex:").append(this.cnd);
    return localStringBuffer.toString();
  }
  
  public final al uY()
  {
    this.ckK = 0L;
    super.af("CostTimeMs", this.ckK);
    return this;
  }
  
  public final al uZ()
  {
    this.ckL = 0L;
    super.ag("StartTimeStampMs", this.ckL);
    return this;
  }
  
  public final al va()
  {
    this.ckM = 0L;
    super.ag("EndTimeStampMs", this.ckM);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.b.a.al
 * JD-Core Version:    0.7.0.1
 */