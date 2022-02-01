package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Arrays;

public final class cs
  extends a
{
  private String dEE;
  private long dEF;
  private String dGh;
  private long dGo;
  private long dGp;
  private String dGu;
  private long dGw;
  private long dGx;
  private long dQA;
  private long dQB;
  private long dQC;
  private long dQD;
  private long dQE;
  private long dQF;
  private long dQG;
  private long dQH;
  private int dQI;
  private long dQJ;
  private long dQK;
  private long dQL;
  private long dQM;
  private int dQN;
  private long dQO;
  private long dQP;
  private long dQQ;
  private long dQR;
  private long dQS;
  private long dQT;
  private long dQU;
  private int dQV;
  private int dQW;
  private long dQX;
  private int dQY;
  private long dQZ;
  private String dQw;
  private long dQx;
  private long dQy;
  private long dQz;
  private long dRa;
  private long dRb;
  private int dRc;
  private String dRd;
  private int dRe;
  private long dRf;
  private int dRg;
  private int dRh;
  
  public cs()
  {
    this.dGh = "";
    this.dQw = "";
    this.dQx = 0L;
    this.dGo = 0L;
    this.dQy = 0L;
    this.dQz = 0L;
    this.dQA = 0L;
    this.dQB = 0L;
    this.dQC = 0L;
    this.dQD = 0L;
    this.dQE = 0L;
    this.dQF = 0L;
    this.dQG = 0L;
    this.dQH = 0L;
    this.dEE = "";
    this.dEF = 0L;
    this.dQI = 0;
    this.dQJ = 0L;
    this.dQK = 0L;
    this.dQL = 0L;
    this.dQM = 0L;
    this.dQN = 0;
    this.dQO = 0L;
    this.dQP = 0L;
    this.dQQ = 0L;
    this.dQR = 0L;
    this.dQS = 0L;
    this.dQT = 0L;
    this.dQU = 0L;
    this.dQV = 0;
    this.dQW = 0;
    this.dQX = 0L;
    this.dQY = 0;
    this.dGp = 0L;
    this.dGu = "";
    this.dQZ = 0L;
    this.dRa = 0L;
    this.dRb = 0L;
    this.dRc = 0;
    this.dRd = "";
    this.dRe = 0;
    this.dRf = 0L;
    this.dGw = 0L;
    this.dGx = 0L;
    this.dRg = 0;
    this.dRh = 0;
  }
  
  public cs(String paramString)
  {
    AppMethodBeat.i(126684);
    this.dGh = "";
    this.dQw = "";
    this.dQx = 0L;
    this.dGo = 0L;
    this.dQy = 0L;
    this.dQz = 0L;
    this.dQA = 0L;
    this.dQB = 0L;
    this.dQC = 0L;
    this.dQD = 0L;
    this.dQE = 0L;
    this.dQF = 0L;
    this.dQG = 0L;
    this.dQH = 0L;
    this.dEE = "";
    this.dEF = 0L;
    this.dQI = 0;
    this.dQJ = 0L;
    this.dQK = 0L;
    this.dQL = 0L;
    this.dQM = 0L;
    this.dQN = 0;
    this.dQO = 0L;
    this.dQP = 0L;
    this.dQQ = 0L;
    this.dQR = 0L;
    this.dQS = 0L;
    this.dQT = 0L;
    this.dQU = 0L;
    this.dQV = 0;
    this.dQW = 0;
    this.dQX = 0L;
    this.dQY = 0;
    this.dGp = 0L;
    this.dGu = "";
    this.dQZ = 0L;
    this.dRa = 0L;
    this.dRb = 0L;
    this.dRc = 0;
    this.dRd = "";
    this.dRe = 0;
    this.dRf = 0L;
    this.dGw = 0L;
    this.dGx = 0L;
    this.dRg = 0;
    this.dRh = 0;
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 46) {
          break label859;
        }
        String[] arrayOfString = new String[46];
        Arrays.fill(arrayOfString, 0, 46, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label859:
    for (;;)
    {
      this.dGh = t("FileId", paramString[0], true);
      this.dQw = t("FileAesKey", paramString[1], true);
      this.dQx = bs.getLong(paramString[2], 0L);
      this.dGo = bs.getLong(paramString[3], 0L);
      this.dQy = bs.getLong(paramString[4], 0L);
      this.dQz = bs.getLong(paramString[5], 0L);
      this.dQA = bs.getLong(paramString[6], 0L);
      this.dQB = bs.getLong(paramString[7], 0L);
      this.dQC = bs.getLong(paramString[8], 0L);
      this.dQD = bs.getLong(paramString[9], 0L);
      this.dQE = bs.getLong(paramString[10], 0L);
      this.dQF = bs.getLong(paramString[11], 0L);
      this.dQG = bs.getLong(paramString[12], 0L);
      this.dQH = bs.getLong(paramString[13], 0L);
      this.dEE = t("ChatName", paramString[14], true);
      this.dEF = bs.getLong(paramString[15], 0L);
      this.dQI = bs.getInt(paramString[16], 0);
      this.dQJ = bs.getLong(paramString[17], 0L);
      this.dQK = bs.getLong(paramString[18], 0L);
      this.dQL = bs.getLong(paramString[19], 0L);
      this.dQM = bs.getLong(paramString[20], 0L);
      this.dQN = bs.getInt(paramString[21], 0);
      this.dQO = bs.getLong(paramString[22], 0L);
      this.dQP = bs.getLong(paramString[23], 0L);
      this.dQQ = bs.getLong(paramString[24], 0L);
      this.dQR = bs.getLong(paramString[25], 0L);
      this.dQS = bs.getLong(paramString[26], 0L);
      this.dQT = bs.getLong(paramString[27], 0L);
      this.dQU = bs.getLong(paramString[28], 0L);
      this.dQV = bs.getInt(paramString[29], 0);
      this.dQW = bs.getInt(paramString[30], 0);
      this.dQX = bs.getLong(paramString[31], 0L);
      this.dQY = bs.getInt(paramString[32], 0);
      this.dGp = bs.getLong(paramString[33], 0L);
      this.dGu = t("CDNIp", paramString[34], true);
      this.dQZ = bs.getLong(paramString[35], 0L);
      this.dRa = bs.getLong(paramString[36], 0L);
      this.dRb = bs.getLong(paramString[37], 0L);
      this.dRc = bs.getInt(paramString[38], 0);
      this.dRd = t("XClientIp", paramString[39], true);
      this.dRe = bs.getInt(paramString[40], 0);
      this.dRf = bs.getLong(paramString[41], 0L);
      this.dGw = bs.getLong(paramString[42], 0L);
      this.dGx = bs.getLong(paramString[43], 0L);
      this.dRg = bs.getInt(paramString[44], 0);
      this.dRh = bs.getInt(paramString[45], 0);
      AppMethodBeat.o(126684);
      return;
    }
  }
  
  public final String PR()
  {
    AppMethodBeat.i(126685);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dGh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dEE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dEF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRh);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(126685);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(126686);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FileId:").append(this.dGh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileAesKey:").append(this.dQw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileLength:").append(this.dQx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoDuration:").append(this.dGo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadLength:").append(this.dQy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayDuration:").append(this.dQz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstPlayWaitTime:").append(this.dQA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovWaitTime:").append(this.dQB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BlockCount:").append(this.dQC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RegainAvgTime:").append(this.dQD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.dQE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadType:").append(this.dQF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartDownloadTime:").append(this.dQG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndDownloadTime:").append(this.dQH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatName:").append(this.dEE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MemberCount:").append(this.dEF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RetCode:").append(this.dQI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterQueueTime:").append(this.dQJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstReqCostTime:").append(this.dQK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstReqSize:").append(this.dQL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstReqDownloadSize:").append(this.dQM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstReqCompleted:").append(this.dQN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AvgSpeed:").append(this.dQO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AvgConnectCost:").append(this.dQP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstConnectCostTime:").append(this.dQQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetConnectTimes:").append(this.dQR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovReqTimes:").append(this.dQS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovCostTime:").append(this.dQT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovSize:").append(this.dQU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovCompleted:").append(this.dQV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovFailReason:").append(this.dQW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UiStayTime:").append(this.dQX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayErrorCode:").append(this.dQY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoBitrate:").append(this.dGp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.dGu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MessageCreateTime:").append(this.dQZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMsgId:").append(this.dRa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InitialDownloadLength:").append(this.dRb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoFormat:").append(this.dRc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("XClientIp:").append(this.dRd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsCrossNet:").append(this.dRe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovPosition:").append(this.dRf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadSize:").append(this.dGw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadCompletion:").append(this.dGx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransportProtocol:").append(this.dRg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransportProtocolError:").append(this.dRh);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(126686);
    return localObject;
  }
  
  public final int getId()
  {
    return 13570;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cs
 * JD-Core Version:    0.7.0.1
 */