package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;

public final class ao
  extends a
{
  private long cic = 0L;
  public long cis = 0L;
  private String ckF = "";
  private String ckG = "";
  private long ckH = 0L;
  private long ckK = 0L;
  public long ckL = 0L;
  private long ckM = 0L;
  private ao.a coe;
  private b cof;
  public ao.d cog;
  public ao.c coh;
  
  public final ao a(ao.a parama)
  {
    this.coe = parama;
    return this;
  }
  
  public final ao a(b paramb)
  {
    this.cof = paramb;
    return this;
  }
  
  public final ao aK(long paramLong)
  {
    this.ckH = paramLong;
    return this;
  }
  
  public final ao aL(long paramLong)
  {
    this.ckK = paramLong;
    super.af("CostTimeMs", this.ckK);
    return this;
  }
  
  public final ao aM(long paramLong)
  {
    this.cic = paramLong;
    return this;
  }
  
  public final ao aN(long paramLong)
  {
    this.ckL = paramLong;
    super.ag("StartTimeStampMs", this.ckL);
    return this;
  }
  
  public final ao aO(long paramLong)
  {
    this.ckM = paramLong;
    super.ag("EndTimeStampMs", this.ckM);
    return this;
  }
  
  public final ao cJ(String paramString)
  {
    this.ckF = paramString;
    return this;
  }
  
  public final ao cK(String paramString)
  {
    this.ckG = paramString;
    return this;
  }
  
  public final int getId()
  {
    return 15765;
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
    if (this.coe != null)
    {
      i = this.coe.value;
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      if (this.cof == null) {
        break label263;
      }
      i = this.cof.value;
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
      if (this.cog == null) {
        break label268;
      }
    }
    label263:
    label268:
    for (int i = this.cog.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.coh != null) {
        i = this.coh.value;
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
    localStringBuffer.append("AppState:").append(this.coe);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("AppType:").append(this.cof);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("CostTimeMs:").append(this.ckK);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("Scene:").append(this.cic);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("StartTimeStampMs:").append(this.ckL);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("EndTimeStampMs:").append(this.ckM);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("Ret:").append(this.cog);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("IsSync:").append(this.coh);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("NetworkType:").append(this.cis);
    return localStringBuffer.toString();
  }
  
  public static enum b
  {
    final int value;
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static b eU(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        return com;
      case 1000: 
        return con;
      case 1001: 
        return coo;
      case 1002: 
        return cop;
      case 1003: 
        return coq;
      case 1004: 
        return cor;
      }
      return cos;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.h.b.a.ao
 * JD-Core Version:    0.7.0.1
 */