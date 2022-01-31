package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;

public final class k
  extends a
{
  private long cic = 0L;
  public String cid = "";
  public String cie = "";
  public String cif = "";
  public long cig = 0L;
  public String cih = "";
  public String cii = "";
  public long cij = 0L;
  
  public final int getId()
  {
    return 16019;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cic);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cid);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cie);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cif);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cig);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cih);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cii);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cij);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("Scene:").append(this.cic);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("SearchId:").append(this.cid);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("SessionId:").append(this.cie);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("Query:").append(this.cif);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("JumpType:").append(this.cig);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("Path:").append(this.cih);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("WeappUsrname:").append(this.cii);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ServiceType:").append(this.cij);
    return localStringBuffer.toString();
  }
  
  public final k uO()
  {
    this.cic = 47L;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.b.a.k
 * JD-Core Version:    0.7.0.1
 */