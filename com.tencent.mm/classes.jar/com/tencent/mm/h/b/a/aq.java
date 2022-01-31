package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bk;

public final class aq
  extends a
{
  public long cic = 0L;
  public long cis = 0L;
  public String ckF = "";
  public String ckG = "";
  public long ckH = 0L;
  private long ckK = 0L;
  private long ckL = 0L;
  public long ckM = 0L;
  public aq.a coR;
  public aq.b coS;
  public long coT = 0L;
  public aq.d coU;
  public aq.c coV;
  public long coW = 0L;
  
  public final aq aR(long paramLong)
  {
    this.ckK = paramLong;
    super.af("CostTimeMs", this.ckK);
    return this;
  }
  
  public final aq aS(long paramLong)
  {
    this.ckL = paramLong;
    super.ag("StartTimeStampMs", this.ckL);
    return this;
  }
  
  public final int getId()
  {
    return 15766;
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
    if (this.coR != null)
    {
      i = this.coR.value;
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      if (this.coS == null) {
        break label295;
      }
      i = this.coS.value;
      label101:
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
      ((StringBuffer)localObject).append(this.coT);
      ((StringBuffer)localObject).append(",");
      if (this.coU == null) {
        break label300;
      }
    }
    label295:
    label300:
    for (int i = this.coU.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.coV != null) {
        i = this.coV.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cis);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.coW);
      localObject = ((StringBuffer)localObject).toString();
      LT((String)localObject);
      return localObject;
      i = -1;
      break;
      i = -1;
      break label101;
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
    localStringBuffer.append("AppState:").append(this.coR);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("AppType:").append(this.coS);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("CostTimeMs:").append(this.ckK);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("Scene:").append(this.cic);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("StartTimeStampMs:").append(this.ckL);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("EndTimeStampMs:").append(this.ckM);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("PkgSize:").append(this.coT);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("IsLaunchSync:").append(this.coU);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("IsContactSync:").append(this.coV);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("NetworkType:").append(this.cis);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("HasDownloadCode:").append(this.coW);
    return localStringBuffer.toString();
  }
  
  public final aq vb()
  {
    this.ckM = bk.UY();
    super.ag("EndTimeStampMs", this.ckM);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.h.b.a.aq
 * JD-Core Version:    0.7.0.1
 */