package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bk;

public final class ag
  extends a
{
  public long cic = 0L;
  public String ckF = "";
  public String ckG = "";
  public long ckH = 0L;
  private long ckK = 0L;
  private long ckL = 0L;
  public long ckM = 0L;
  public a clp;
  public ag.b clq;
  public long clr = 0L;
  public String cls = "";
  
  public final ag au(long paramLong)
  {
    this.ckK = paramLong;
    super.af("CostTimeMs", this.ckK);
    return this;
  }
  
  public final ag av(long paramLong)
  {
    this.ckL = paramLong;
    super.ag("StartTimeStampMs", this.ckL);
    return this;
  }
  
  public final int getId()
  {
    return 16007;
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
    if (this.clp != null) {}
    for (int i = this.clp.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.clq != null) {
        i = this.clq.value;
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
      ((StringBuffer)localObject).append(this.clr);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cls);
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
    localStringBuffer.append("AppState:").append(this.clp);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("AppType:").append(this.clq);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("CostTimeMs:").append(this.ckK);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("Scene:").append(this.cic);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("StartTimeStampMs:").append(this.ckL);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("EndTimeStampMs:").append(this.ckM);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("fileSize:").append(this.clr);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("filePath:").append(this.cls);
    return localStringBuffer.toString();
  }
  
  public final ag uU()
  {
    this.ckM = bk.UY();
    super.ag("EndTimeStampMs", this.ckM);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a eE(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return clt;
      case 2: 
        return clu;
      }
      return clv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.h.b.a.ag
 * JD-Core Version:    0.7.0.1
 */