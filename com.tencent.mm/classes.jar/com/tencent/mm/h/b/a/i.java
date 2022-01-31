package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;

public final class i
  extends a
{
  public String chA;
  public String chB;
  public String chC;
  public String chD;
  public String chE;
  public String chF;
  public String chG;
  public int chw = 0;
  public int chx = 0;
  public int chy = 0;
  public String chz;
  
  public final int getId()
  {
    return 15548;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.chw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chG);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("CgiCmd:").append(this.chw);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ErrType:").append(this.chx);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ErrCode:").append(this.chy);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("EncryptKey:").append(this.chz);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("EncryptUserinfo:").append(this.chA);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("EncryptCellinfoLength:").append(this.chB);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("EncryptCellinfo_01:").append(this.chC);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("EncryptCellinfo_02:").append(this.chD);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("EncryptCellinfo_03:").append(this.chE);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("EncryptCellinfo_04:").append(this.chF);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("EncryptCellinfo_05:").append(this.chG);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.h.b.a.i
 * JD-Core Version:    0.7.0.1
 */