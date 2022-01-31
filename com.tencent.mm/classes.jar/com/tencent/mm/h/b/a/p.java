package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Arrays;

public final class p
  extends a
{
  private String chH = "";
  private String chI = "";
  private String chK = "";
  private String chL = "";
  private String chN = "";
  private long chO = 0L;
  private long chP = 0L;
  private String chX = "";
  private String cib = "";
  private long cji = 0L;
  private long cjj = 0L;
  private int cjk = 0;
  private long cjl = 0L;
  private long cjm = 0L;
  
  public p() {}
  
  public p(String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 14) {
          break label264;
        }
        String[] arrayOfString = new String[14];
        Arrays.fill(arrayOfString, 0, 14, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label264:
    for (;;)
    {
      this.chO = bk.getLong(paramString[0], 0L);
      this.chP = bk.getLong(paramString[1], 0L);
      this.cji = bk.getLong(paramString[2], 0L);
      this.chN = paramString[3];
      this.cjj = bk.getLong(paramString[4], 0L);
      this.cjk = bk.getInt(paramString[5], 0);
      this.cjl = bk.getLong(paramString[6], 0L);
      this.chX = paramString[7];
      this.chH = paramString[8];
      this.chI = paramString[9];
      this.cjm = bk.getLong(paramString[10], 0L);
      this.chK = paramString[11];
      this.chL = paramString[12];
      this.cib = paramString[13];
      return;
    }
  }
  
  public final int getId()
  {
    return 14499;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.chO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cji);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cib);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("DownloadStartTime:").append(this.chO);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("DownloadEndTime:").append(this.chP);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("DownloadSize:").append(this.cji);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("NewMd5:").append(this.chN);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("MsgType:").append(this.cjj);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("DownloadSpeed:").append(this.cjk);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("HadFinishSize:").append(this.cjl);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("CDNIp:").append(this.chX);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("FromUser:").append(this.chH);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("Session:").append(this.chI);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ChatroomNum:").append(this.cjm);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("FileId:").append(this.chK);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("SnsUrl:").append(this.chL);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("Publishid:").append(this.cib);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.h.b.a.p
 * JD-Core Version:    0.7.0.1
 */