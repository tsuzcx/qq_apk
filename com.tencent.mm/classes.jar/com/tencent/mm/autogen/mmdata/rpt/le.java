package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class le
  extends a
{
  private String iMV;
  private long iRV;
  private long iVU;
  private long iXC;
  private String iYS;
  private long iYT;
  private long iYU;
  private long iYV;
  private long iYW;
  private long iYX;
  private long iYY;
  private long iYZ;
  private int iZA;
  private long iZB;
  private String iZC;
  private int iZD;
  private long iZa;
  private int iZb;
  private long iZc;
  private long iZd;
  private long iZe;
  private long iZf;
  private int iZg;
  private long iZh;
  private long iZi;
  private long iZj;
  private long iZk;
  private long iZl;
  private long iZm;
  private long iZn;
  private int iZo;
  private int iZp;
  private long iZq;
  private int iZr;
  private long iZs;
  private long iZt;
  private long iZu;
  private int iZv;
  private String iZw;
  private int iZx;
  private long iZy;
  private int iZz;
  private String imN;
  private long imZ;
  private String irB;
  private long irD;
  private long irE;
  private String irn;
  private long irv;
  private long irw;
  
  public le()
  {
    this.irn = "";
    this.iYS = "";
    this.iYT = 0L;
    this.irv = 0L;
    this.iYU = 0L;
    this.iXC = 0L;
    this.iYV = 0L;
    this.iYW = 0L;
    this.iYX = 0L;
    this.iRV = 0L;
    this.iVU = 0L;
    this.iYY = 0L;
    this.iYZ = 0L;
    this.iZa = 0L;
    this.imN = "";
    this.imZ = 0L;
    this.iZb = 0;
    this.iZc = 0L;
    this.iZd = 0L;
    this.iZe = 0L;
    this.iZf = 0L;
    this.iZg = 0;
    this.iZh = 0L;
    this.iZi = 0L;
    this.iZj = 0L;
    this.iZk = 0L;
    this.iZl = 0L;
    this.iZm = 0L;
    this.iZn = 0L;
    this.iZo = 0;
    this.iZp = 0;
    this.iZq = 0L;
    this.iZr = 0;
    this.irw = 0L;
    this.irB = "";
    this.iZs = 0L;
    this.iZt = 0L;
    this.iZu = 0L;
    this.iZv = 0;
    this.iZw = "";
    this.iZx = 0;
    this.iZy = 0L;
    this.irD = 0L;
    this.irE = 0L;
    this.iZz = 0;
    this.iZA = 0;
    this.iZB = 0L;
    this.iZC = "";
    this.iMV = "";
    this.iZD = 0;
  }
  
  public le(String paramString)
  {
    AppMethodBeat.i(126684);
    this.irn = "";
    this.iYS = "";
    this.iYT = 0L;
    this.irv = 0L;
    this.iYU = 0L;
    this.iXC = 0L;
    this.iYV = 0L;
    this.iYW = 0L;
    this.iYX = 0L;
    this.iRV = 0L;
    this.iVU = 0L;
    this.iYY = 0L;
    this.iYZ = 0L;
    this.iZa = 0L;
    this.imN = "";
    this.imZ = 0L;
    this.iZb = 0;
    this.iZc = 0L;
    this.iZd = 0L;
    this.iZe = 0L;
    this.iZf = 0L;
    this.iZg = 0;
    this.iZh = 0L;
    this.iZi = 0L;
    this.iZj = 0L;
    this.iZk = 0L;
    this.iZl = 0L;
    this.iZm = 0L;
    this.iZn = 0L;
    this.iZo = 0;
    this.iZp = 0;
    this.iZq = 0L;
    this.iZr = 0;
    this.irw = 0L;
    this.irB = "";
    this.iZs = 0L;
    this.iZt = 0L;
    this.iZu = 0L;
    this.iZv = 0;
    this.iZw = "";
    this.iZx = 0;
    this.iZy = 0L;
    this.irD = 0L;
    this.irE = 0L;
    this.iZz = 0;
    this.iZA = 0;
    this.iZB = 0L;
    this.iZC = "";
    this.iMV = "";
    this.iZD = 0;
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 50) {
          break label935;
        }
        String[] arrayOfString = new String[50];
        Arrays.fill(arrayOfString, 0, 50, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label935:
    for (;;)
    {
      this.irn = F("FileId", paramString[0], true);
      this.iYS = F("FileAesKey", paramString[1], true);
      this.iYT = Util.getLong(paramString[2], 0L);
      this.irv = Util.getLong(paramString[3], 0L);
      this.iYU = Util.getLong(paramString[4], 0L);
      this.iXC = Util.getLong(paramString[5], 0L);
      this.iYV = Util.getLong(paramString[6], 0L);
      this.iYW = Util.getLong(paramString[7], 0L);
      this.iYX = Util.getLong(paramString[8], 0L);
      this.iRV = Util.getLong(paramString[9], 0L);
      this.iVU = Util.getLong(paramString[10], 0L);
      this.iYY = Util.getLong(paramString[11], 0L);
      this.iYZ = Util.getLong(paramString[12], 0L);
      this.iZa = Util.getLong(paramString[13], 0L);
      this.imN = F("ChatName", paramString[14], true);
      this.imZ = Util.getLong(paramString[15], 0L);
      this.iZb = Util.getInt(paramString[16], 0);
      this.iZc = Util.getLong(paramString[17], 0L);
      this.iZd = Util.getLong(paramString[18], 0L);
      this.iZe = Util.getLong(paramString[19], 0L);
      this.iZf = Util.getLong(paramString[20], 0L);
      this.iZg = Util.getInt(paramString[21], 0);
      this.iZh = Util.getLong(paramString[22], 0L);
      this.iZi = Util.getLong(paramString[23], 0L);
      this.iZj = Util.getLong(paramString[24], 0L);
      this.iZk = Util.getLong(paramString[25], 0L);
      this.iZl = Util.getLong(paramString[26], 0L);
      this.iZm = Util.getLong(paramString[27], 0L);
      this.iZn = Util.getLong(paramString[28], 0L);
      this.iZo = Util.getInt(paramString[29], 0);
      this.iZp = Util.getInt(paramString[30], 0);
      this.iZq = Util.getLong(paramString[31], 0L);
      this.iZr = Util.getInt(paramString[32], 0);
      this.irw = Util.getLong(paramString[33], 0L);
      this.irB = F("CDNIp", paramString[34], true);
      this.iZs = Util.getLong(paramString[35], 0L);
      this.iZt = Util.getLong(paramString[36], 0L);
      this.iZu = Util.getLong(paramString[37], 0L);
      this.iZv = Util.getInt(paramString[38], 0);
      this.iZw = F("XClientIp", paramString[39], true);
      this.iZx = Util.getInt(paramString[40], 0);
      this.iZy = Util.getLong(paramString[41], 0L);
      this.irD = Util.getLong(paramString[42], 0L);
      this.irE = Util.getLong(paramString[43], 0L);
      this.iZz = Util.getInt(paramString[44], 0);
      this.iZA = Util.getInt(paramString[45], 0);
      this.iZB = Util.getLong(paramString[46], 0L);
      this.iZC = F("SnsVideoFlag", paramString[47], true);
      this.iMV = F("VideoCdnMsg", paramString[48], true);
      this.iZD = Util.getInt(paramString[49], 0);
      AppMethodBeat.o(126684);
      return;
    }
  }
  
  public final String aIE()
  {
    AppMethodBeat.i(126685);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.irn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iXC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iRV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iVU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iMV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZD);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(126685);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(126686);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FileId:").append(this.irn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileAesKey:").append(this.iYS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileLength:").append(this.iYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoDuration:").append(this.irv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadLength:").append(this.iYU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayDuration:").append(this.iXC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstPlayWaitTime:").append(this.iYV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovWaitTime:").append(this.iYW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BlockCount:").append(this.iYX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RegainAvgTime:").append(this.iRV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.iVU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadType:").append(this.iYY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartDownloadTime:").append(this.iYZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndDownloadTime:").append(this.iZa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatName:").append(this.imN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MemberCount:").append(this.imZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RetCode:").append(this.iZb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterQueueTime:").append(this.iZc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstReqCostTime:").append(this.iZd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstReqSize:").append(this.iZe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstReqDownloadSize:").append(this.iZf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstReqCompleted:").append(this.iZg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AvgSpeed:").append(this.iZh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AvgConnectCost:").append(this.iZi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstConnectCostTime:").append(this.iZj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetConnectTimes:").append(this.iZk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovReqTimes:").append(this.iZl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovCostTime:").append(this.iZm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovSize:").append(this.iZn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovCompleted:").append(this.iZo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovFailReason:").append(this.iZp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UiStayTime:").append(this.iZq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayErrorCode:").append(this.iZr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoBitrate:").append(this.irw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.irB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MessageCreateTime:").append(this.iZs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMsgId:").append(this.iZt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InitialDownloadLength:").append(this.iZu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoFormat:").append(this.iZv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("XClientIp:").append(this.iZw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsCrossNet:").append(this.iZx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovPosition:").append(this.iZy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadSize:").append(this.irD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadCompletion:").append(this.irE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransportProtocol:").append(this.iZz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransportProtocolError:").append(this.iZA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TraceId:").append(this.iZB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsVideoFlag:").append(this.iZC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoCdnMsg:").append(this.iMV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BackSrcNum:").append(this.iZD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(126686);
    return localObject;
  }
  
  public final int getId()
  {
    return 13570;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.le
 * JD-Core Version:    0.7.0.1
 */