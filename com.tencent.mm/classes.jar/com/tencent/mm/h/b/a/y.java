package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Arrays;

public final class y
  extends a
{
  private String chL = "";
  private int chM = 0;
  private String chN = "";
  private String chX = "";
  private long chY = 0L;
  private String cjT = "";
  private String cjU = "";
  private String cjV = "";
  private String cjW = "";
  private long cjX = 0L;
  private long cjY = 0L;
  private long cjZ = 0L;
  private long cka = 0L;
  private long ckb = 0L;
  private long ckc = 0L;
  private long ckd = 0L;
  private long cke = 0L;
  private long ckf = 0L;
  private int ckg = 0;
  private long ckh = 0L;
  private long cki = 0L;
  private long ckj = 0L;
  private long ckk = 0L;
  private long ckl = 0L;
  private long ckm = 0L;
  private long ckn = 0L;
  private long cko = 0L;
  
  public y() {}
  
  public y(String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 27) {
          break label485;
        }
        String[] arrayOfString = new String[27];
        Arrays.fill(arrayOfString, 0, 27, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label485:
    for (;;)
    {
      this.cjT = paramString[0];
      this.cjU = paramString[1];
      this.chM = bk.getInt(paramString[2], 0);
      this.cjV = paramString[3];
      this.chN = paramString[4];
      this.cjW = paramString[5];
      this.cjX = bk.getLong(paramString[6], 0L);
      this.cjY = bk.getLong(paramString[7], 0L);
      this.cjZ = bk.getLong(paramString[8], 0L);
      this.cka = bk.getLong(paramString[9], 0L);
      this.ckb = bk.getLong(paramString[10], 0L);
      this.ckc = bk.getLong(paramString[11], 0L);
      this.ckd = bk.getLong(paramString[12], 0L);
      this.cke = bk.getLong(paramString[13], 0L);
      this.ckf = bk.getLong(paramString[14], 0L);
      this.ckg = bk.getInt(paramString[15], 0);
      this.ckh = bk.getLong(paramString[16], 0L);
      this.cki = bk.getLong(paramString[17], 0L);
      this.ckj = bk.getLong(paramString[18], 0L);
      this.ckk = bk.getLong(paramString[19], 0L);
      this.ckl = bk.getLong(paramString[20], 0L);
      this.ckm = bk.getLong(paramString[21], 0L);
      this.ckn = bk.getLong(paramString[22], 0L);
      this.cko = bk.getLong(paramString[23], 0L);
      this.chX = paramString[24];
      this.chY = bk.getLong(paramString[25], 0L);
      this.chL = paramString[26];
      return;
    }
  }
  
  public final int getId()
  {
    return 13794;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cjT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cka);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ckb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ckc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ckd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cke);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ckf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ckg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ckh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cki);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ckj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ckk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ckl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ckm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ckn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cko);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chL);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("ToUser:").append(this.cjT);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("MsgSource:").append(this.cjU);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("NetType:").append(this.chM);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("FieldId:").append(this.cjV);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("NewMd5:").append(this.chN);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("SnsInfoId:").append(this.cjW);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("UploadStartTime:").append(this.cjX);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("UploadEndTime:").append(this.cjY);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("OriginalSize:").append(this.cjZ);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("OriginalDuration:").append(this.cka);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("OriginalVideoBitrate:").append(this.ckb);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("OriginalAudioBitrate:").append(this.ckc);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("OriginalFps:").append(this.ckd);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("OriginalWidth:").append(this.cke);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("OriginalHeight:").append(this.ckf);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("CpStatus:").append(this.ckg);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("CpSize:").append(this.ckh);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("CpDuration:").append(this.cki);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("CpVideoBitrate:").append(this.ckj);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("CpAudioiBitrate:").append(this.ckk);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("CpFps:").append(this.ckl);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("CpWidth:").append(this.ckm);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("CpHeight:").append(this.ckn);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("SendScene:").append(this.cko);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("CDNIp:").append(this.chX);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("OriginalAudioChannel:").append(this.chY);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("SnsUrl:").append(this.chL);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.h.b.a.y
 * JD-Core Version:    0.7.0.1
 */