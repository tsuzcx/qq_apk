package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;

public final class am
  extends a
{
  private long cic = 0L;
  public long cis = 0L;
  private String ckF = "";
  private String ckG = "";
  private long ckH = 0L;
  private long ckK = 0L;
  private long ckL = 0L;
  private long ckM = 0L;
  private am.a cnq;
  private am.b cnr;
  public am.d cns;
  public am.c cnt;
  
  public final am a(am.a parama)
  {
    this.cnq = parama;
    return this;
  }
  
  public final am a(am.b paramb)
  {
    this.cnr = paramb;
    return this;
  }
  
  public final am aC(long paramLong)
  {
    this.ckH = paramLong;
    return this;
  }
  
  public final am aD(long paramLong)
  {
    this.ckK = paramLong;
    super.af("CostTimeMs", this.ckK);
    return this;
  }
  
  public final am aE(long paramLong)
  {
    this.cic = paramLong;
    return this;
  }
  
  public final am aF(long paramLong)
  {
    this.ckL = paramLong;
    super.ag("StartTimeStampMs", this.ckL);
    return this;
  }
  
  public final am aG(long paramLong)
  {
    this.ckM = paramLong;
    super.ag("EndTimeStampMs", this.ckM);
    return this;
  }
  
  public final am cH(String paramString)
  {
    this.ckF = paramString;
    return this;
  }
  
  public final am cI(String paramString)
  {
    this.ckG = paramString;
    return this;
  }
  
  public final int getId()
  {
    return 15764;
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
    if (this.cnq != null)
    {
      i = this.cnq.value;
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      if (this.cnr == null) {
        break label263;
      }
      i = this.cnr.value;
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
      if (this.cns == null) {
        break label268;
      }
    }
    label263:
    label268:
    for (int i = this.cns.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.cnt != null) {
        i = this.cnt.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cis);
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
    localStringBuffer.append("AppState:").append(this.cnq);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("AppType:").append(this.cnr);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("CostTimeMs:").append(this.ckK);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("Scene:").append(this.cic);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("StartTimeStampMs:").append(this.ckL);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("EndTimeStampMs:").append(this.ckM);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("Ret:").append(this.cns);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("IsSync:").append(this.cnt);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("NetworkType:").append(this.cis);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.h.b.a.am
 * JD-Core Version:    0.7.0.1
 */