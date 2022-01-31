package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;

public final class ac
  extends a
{
  public long ckA = 0L;
  public long ckw = 0L;
  public long ckx = 0L;
  public long cky = 0L;
  public long ckz = 0L;
  
  public final int getId()
  {
    return 15401;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ckw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ckx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cky);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ckz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ckA);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("AllPackageSize:").append(this.ckw);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("AllPackageClientStoragePercent:").append(this.ckx);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ClientStorageFreePercent:").append(this.cky);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("AbtestStatus:").append(this.ckz);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("WeappCountThatHasPackage:").append(this.ckA);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.h.b.a.ac
 * JD-Core Version:    0.7.0.1
 */