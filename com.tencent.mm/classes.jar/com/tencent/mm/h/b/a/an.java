package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Arrays;

public final class an
  extends a
{
  public long cic = 0L;
  public long cis = 0L;
  public String ckF = "";
  public String ckG = "";
  public long ckH = 0L;
  private long ckK = 0L;
  private long ckL = 0L;
  private long ckM = 0L;
  public a cnM;
  public an.b cnN;
  public an.c cnO;
  
  public an() {}
  
  public an(String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 11) {
          break label225;
        }
        String[] arrayOfString = new String[11];
        Arrays.fill(arrayOfString, 0, 11, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label225:
    for (;;)
    {
      this.ckF = paramString[0];
      this.ckG = paramString[1];
      this.ckH = bk.getLong(paramString[2], 0L);
      this.cnM = a.eQ(bk.getInt(paramString[3], 0));
      this.cnN = an.b.eR(bk.getInt(paramString[4], 0));
      aH(bk.getLong(paramString[5], 0L));
      this.cic = bk.getLong(paramString[6], 0L);
      aI(bk.getLong(paramString[7], 0L));
      aJ(bk.getLong(paramString[8], 0L));
      this.cnO = an.c.eS(bk.getInt(paramString[9], 0));
      this.cis = bk.getLong(paramString[10], 0L);
      return;
    }
  }
  
  public final an aH(long paramLong)
  {
    this.ckK = paramLong;
    super.af("CostTimeMs", this.ckK);
    return this;
  }
  
  public final an aI(long paramLong)
  {
    this.ckL = paramLong;
    super.ag("StartTimeStampMs", this.ckL);
    return this;
  }
  
  public final an aJ(long paramLong)
  {
    this.ckM = paramLong;
    super.ag("EndTimeStampMs", this.ckM);
    return this;
  }
  
  public final int getId()
  {
    return 15798;
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
    if (this.cnM != null)
    {
      i = this.cnM.value;
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      if (this.cnN == null) {
        break label235;
      }
    }
    label235:
    for (int i = this.cnN.value;; i = -1)
    {
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
      i = j;
      if (this.cnO != null) {
        i = this.cnO.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cis);
      localObject = ((StringBuffer)localObject).toString();
      LT((String)localObject);
      return localObject;
      i = -1;
      break;
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
    localStringBuffer.append("AppState:").append(this.cnM);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("AppType:").append(this.cnN);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("CostTimeMs:").append(this.ckK);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("Scene:").append(this.cic);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("StartTimeStampMs:").append(this.ckL);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("EndTimeStampMs:").append(this.ckM);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("Ret:").append(this.cnO);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("NetworkType:").append(this.cis);
    return localStringBuffer.toString();
  }
  
  public static enum a
  {
    final int value;
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a eQ(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return cnP;
      case 2: 
        return cnQ;
      }
      return cnR;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.h.b.a.an
 * JD-Core Version:    0.7.0.1
 */