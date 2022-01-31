package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Arrays;

public final class w
  extends a
{
  private long chR = 0L;
  private long chS = 0L;
  private String chX = "";
  private long chZ = 0L;
  private long ciA = 0L;
  private int ciB = 0;
  private long ciC = 0L;
  private long ciD = 0L;
  private long ciE = 0L;
  private long ciF = 0L;
  private long ciG = 0L;
  private long ciH = 0L;
  private long ciI = 0L;
  private int ciJ = 0;
  private int ciK = 0;
  private long ciL = 0L;
  private int ciM = 0;
  private String ciR = "";
  private int ciS = 0;
  private long ciT = 0L;
  private long cia = 0L;
  private long cil = 0L;
  private long cim = 0L;
  private long cin = 0L;
  private long cio = 0L;
  private long cip = 0L;
  private long ciq = 0L;
  private long cir = 0L;
  private long cis = 0L;
  private long cit = 0L;
  private long ciu = 0L;
  private long civ = 0L;
  private int ciw = 0;
  private long cix = 0L;
  private long ciy = 0L;
  private long ciz = 0L;
  private String cjK = "";
  private String cjL = "";
  private long cjM = 0L;
  private int cjN = 0;
  private String cjO = "";
  private String cjP = "";
  
  public w() {}
  
  public w(String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 42) {
          break label743;
        }
        String[] arrayOfString = new String[42];
        Arrays.fill(arrayOfString, 0, 42, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label743:
    for (;;)
    {
      this.cjK = paramString[0];
      this.cjL = paramString[1];
      this.cil = bk.getLong(paramString[2], 0L);
      this.chR = bk.getLong(paramString[3], 0L);
      this.cim = bk.getLong(paramString[4], 0L);
      this.cin = bk.getLong(paramString[5], 0L);
      this.cio = bk.getLong(paramString[6], 0L);
      this.cip = bk.getLong(paramString[7], 0L);
      this.ciq = bk.getLong(paramString[8], 0L);
      this.cir = bk.getLong(paramString[9], 0L);
      this.cis = bk.getLong(paramString[10], 0L);
      this.cit = bk.getLong(paramString[11], 0L);
      this.ciu = bk.getLong(paramString[12], 0L);
      this.civ = bk.getLong(paramString[13], 0L);
      this.cjM = bk.getLong(paramString[14], 0L);
      this.cjN = bk.getInt(paramString[15], 0);
      this.ciw = bk.getInt(paramString[16], 0);
      this.cix = bk.getLong(paramString[17], 0L);
      this.ciy = bk.getLong(paramString[18], 0L);
      this.ciz = bk.getLong(paramString[19], 0L);
      this.ciA = bk.getLong(paramString[20], 0L);
      this.ciB = bk.getInt(paramString[21], 0);
      this.ciC = bk.getLong(paramString[22], 0L);
      this.ciD = bk.getLong(paramString[23], 0L);
      this.ciE = bk.getLong(paramString[24], 0L);
      this.ciF = bk.getLong(paramString[25], 0L);
      this.ciG = bk.getLong(paramString[26], 0L);
      this.ciH = bk.getLong(paramString[27], 0L);
      this.ciI = bk.getLong(paramString[28], 0L);
      this.ciJ = bk.getInt(paramString[29], 0);
      this.ciK = bk.getInt(paramString[30], 0);
      this.ciL = bk.getLong(paramString[31], 0L);
      this.ciM = bk.getInt(paramString[32], 0);
      this.chS = bk.getLong(paramString[33], 0L);
      this.cjO = paramString[34];
      this.chX = paramString[35];
      this.cjP = paramString[36];
      this.ciR = paramString[37];
      this.ciS = bk.getInt(paramString[38], 0);
      this.ciT = bk.getLong(paramString[39], 0L);
      this.chZ = bk.getLong(paramString[40], 0L);
      this.cia = bk.getLong(paramString[41], 0L);
      return;
    }
  }
  
  public final int getId()
  {
    return 13790;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cjK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cil);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cim);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cin);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cio);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cip);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ciq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cir);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cis);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cit);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ciu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.civ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ciw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cix);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ciy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ciz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ciA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ciB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ciC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ciD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ciE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ciF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ciG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ciH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ciI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ciJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ciK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ciL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ciM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ciR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ciS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ciT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.chZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cia);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("SnsVideoUrl:").append(this.cjK);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("SnsReserved1:").append(this.cjL);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("FileLength:").append(this.cil);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("VideoDuration:").append(this.chR);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("DownloadLength:").append(this.cim);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("PlayDuration:").append(this.cin);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("FirstPlayWaitTime:").append(this.cio);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("MoovWaitTime:").append(this.cip);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("BlockCount:").append(this.ciq);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("RegainAvgTime:").append(this.cir);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("NetworkType:").append(this.cis);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("DownloadType:").append(this.cit);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("StartDownloadTime:").append(this.ciu);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("EndDownloadTime:").append(this.civ);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ChatName:").append(this.cjM);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("HttpStatusCode:").append(this.cjN);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("RetCode:").append(this.ciw);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("EnterQueueTime:").append(this.cix);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("FirstReqCostTime:").append(this.ciy);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("FirstReqSize:").append(this.ciz);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("FirstReqDownloadSize:").append(this.ciA);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("FirstReqCompleted:").append(this.ciB);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("AvgSpeed:").append(this.ciC);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("AvgConnectCost:").append(this.ciD);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("FirstConnectCostTime:").append(this.ciE);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("NetConnectTimes:").append(this.ciF);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("MoovReqTimes:").append(this.ciG);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("MoovCostTime:").append(this.ciH);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("MoovSize:").append(this.ciI);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("MoovCompleted:").append(this.ciJ);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("MoovFailReason:").append(this.ciK);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("UiStayTime:").append(this.ciL);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("PlayErrorCode:").append(this.ciM);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("VideoBitrate:").append(this.chS);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("postname:").append(this.cjO);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("CDNIp:").append(this.chX);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("SnsPublishid:").append(this.cjP);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("XClientIp:").append(this.ciR);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("IsCrossNet:").append(this.ciS);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("MoovPosition:").append(this.ciT);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("HadPreloadSize:").append(this.chZ);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("HadPreloadCompletion:").append(this.cia);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.h.b.a.w
 * JD-Core Version:    0.7.0.1
 */