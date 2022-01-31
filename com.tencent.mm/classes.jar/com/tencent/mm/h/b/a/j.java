package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Arrays;

public final class j
  extends a
{
  private String chH = "";
  private String chI = "";
  private long chJ = 0L;
  private String chK = "";
  private String chL = "";
  private int chM = 0;
  private String chN = "";
  private long chO = 0L;
  private long chP = 0L;
  private long chQ = 0L;
  private long chR = 0L;
  private long chS = 0L;
  private long chT = 0L;
  private long chU = 0L;
  private long chV = 0L;
  private long chW = 0L;
  private String chX = "";
  private long chY = 0L;
  private long chZ = 0L;
  private long cia = 0L;
  private String cib = "";
  
  public j() {}
  
  public j(String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 21) {
          break label383;
        }
        String[] arrayOfString = new String[21];
        Arrays.fill(arrayOfString, 0, 21, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label383:
    for (;;)
    {
      this.chH = paramString[0];
      this.chI = paramString[1];
      this.chJ = bk.getLong(paramString[2], 0L);
      this.chK = paramString[3];
      this.chL = paramString[4];
      this.chM = bk.getInt(paramString[5], 0);
      this.chN = paramString[6];
      this.chO = bk.getLong(paramString[7], 0L);
      this.chP = bk.getLong(paramString[8], 0L);
      this.chQ = bk.getLong(paramString[9], 0L);
      this.chR = bk.getLong(paramString[10], 0L);
      this.chS = bk.getLong(paramString[11], 0L);
      this.chT = bk.getLong(paramString[12], 0L);
      this.chU = bk.getLong(paramString[13], 0L);
      this.chV = bk.getLong(paramString[14], 0L);
      this.chW = bk.getLong(paramString[15], 0L);
      this.chX = paramString[16];
      this.chY = bk.getLong(paramString[17], 0L);
      this.chZ = bk.getLong(paramString[18], 0L);
      this.cia = bk.getLong(paramString[19], 0L);
      this.cib = paramString[20];
      return;
    }
  }
  
  public final int getId()
  {
    return 13795;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.chH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cia);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cib);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("FromUser:").append(this.chH);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("Session:").append(this.chI);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ChatNum:").append(this.chJ);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("FileId:").append(this.chK);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("SnsUrl:").append(this.chL);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("NetType:").append(this.chM);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("NewMd5:").append(this.chN);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("DownloadStartTime:").append(this.chO);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("DownloadEndTime:").append(this.chP);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("VideoSize:").append(this.chQ);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("VideoDuration:").append(this.chR);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("VideoBitrate:").append(this.chS);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("AudioBitrate:").append(this.chT);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("VideoFps:").append(this.chU);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("VideoWidth:").append(this.chV);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("VideoHeight:").append(this.chW);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("CDNIp:").append(this.chX);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("OriginalAudioChannel:").append(this.chY);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("HadPreloadSize:").append(this.chZ);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("HadPreloadCompletion:").append(this.cia);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("Publishid:").append(this.cib);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.h.b.a.j
 * JD-Core Version:    0.7.0.1
 */