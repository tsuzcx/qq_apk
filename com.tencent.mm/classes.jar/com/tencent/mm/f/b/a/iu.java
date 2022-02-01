package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class iu
  extends a
{
  private String gAG;
  private long gEV;
  private long gHC;
  private long gIH;
  private String gJC;
  private long gJD;
  private long gJE;
  private long gJF;
  private long gJG;
  private long gJH;
  private long gJI;
  private long gJJ;
  private long gJK;
  private int gJL;
  private long gJM;
  private long gJN;
  private long gJO;
  private long gJP;
  private int gJQ;
  private long gJR;
  private long gJS;
  private long gJT;
  private long gJU;
  private long gJV;
  private long gJW;
  private long gJX;
  private int gJY;
  private int gJZ;
  private long gKa;
  private int gKb;
  private long gKc;
  private long gKd;
  private long gKe;
  private int gKf;
  private String gKg;
  private int gKh;
  private long gKi;
  private int gKj;
  private int gKk;
  private long gKl;
  private String gKm;
  private int gKn;
  private String ggg;
  private long ggi;
  private String gkb;
  private long gki;
  private long gkj;
  private String gko;
  private long gkq;
  private long gkr;
  
  public iu()
  {
    this.gkb = "";
    this.gJC = "";
    this.gJD = 0L;
    this.gki = 0L;
    this.gJE = 0L;
    this.gIH = 0L;
    this.gJF = 0L;
    this.gJG = 0L;
    this.gJH = 0L;
    this.gEV = 0L;
    this.gHC = 0L;
    this.gJI = 0L;
    this.gJJ = 0L;
    this.gJK = 0L;
    this.ggg = "";
    this.ggi = 0L;
    this.gJL = 0;
    this.gJM = 0L;
    this.gJN = 0L;
    this.gJO = 0L;
    this.gJP = 0L;
    this.gJQ = 0;
    this.gJR = 0L;
    this.gJS = 0L;
    this.gJT = 0L;
    this.gJU = 0L;
    this.gJV = 0L;
    this.gJW = 0L;
    this.gJX = 0L;
    this.gJY = 0;
    this.gJZ = 0;
    this.gKa = 0L;
    this.gKb = 0;
    this.gkj = 0L;
    this.gko = "";
    this.gKc = 0L;
    this.gKd = 0L;
    this.gKe = 0L;
    this.gKf = 0;
    this.gKg = "";
    this.gKh = 0;
    this.gKi = 0L;
    this.gkq = 0L;
    this.gkr = 0L;
    this.gKj = 0;
    this.gKk = 0;
    this.gKl = 0L;
    this.gKm = "";
    this.gAG = "";
    this.gKn = 0;
  }
  
  public iu(String paramString)
  {
    AppMethodBeat.i(126684);
    this.gkb = "";
    this.gJC = "";
    this.gJD = 0L;
    this.gki = 0L;
    this.gJE = 0L;
    this.gIH = 0L;
    this.gJF = 0L;
    this.gJG = 0L;
    this.gJH = 0L;
    this.gEV = 0L;
    this.gHC = 0L;
    this.gJI = 0L;
    this.gJJ = 0L;
    this.gJK = 0L;
    this.ggg = "";
    this.ggi = 0L;
    this.gJL = 0;
    this.gJM = 0L;
    this.gJN = 0L;
    this.gJO = 0L;
    this.gJP = 0L;
    this.gJQ = 0;
    this.gJR = 0L;
    this.gJS = 0L;
    this.gJT = 0L;
    this.gJU = 0L;
    this.gJV = 0L;
    this.gJW = 0L;
    this.gJX = 0L;
    this.gJY = 0;
    this.gJZ = 0;
    this.gKa = 0L;
    this.gKb = 0;
    this.gkj = 0L;
    this.gko = "";
    this.gKc = 0L;
    this.gKd = 0L;
    this.gKe = 0L;
    this.gKf = 0;
    this.gKg = "";
    this.gKh = 0;
    this.gKi = 0L;
    this.gkq = 0L;
    this.gkr = 0L;
    this.gKj = 0;
    this.gKk = 0;
    this.gKl = 0L;
    this.gKm = "";
    this.gAG = "";
    this.gKn = 0;
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
      this.gkb = z("FileId", paramString[0], true);
      this.gJC = z("FileAesKey", paramString[1], true);
      this.gJD = Util.getLong(paramString[2], 0L);
      this.gki = Util.getLong(paramString[3], 0L);
      this.gJE = Util.getLong(paramString[4], 0L);
      this.gIH = Util.getLong(paramString[5], 0L);
      this.gJF = Util.getLong(paramString[6], 0L);
      this.gJG = Util.getLong(paramString[7], 0L);
      this.gJH = Util.getLong(paramString[8], 0L);
      this.gEV = Util.getLong(paramString[9], 0L);
      this.gHC = Util.getLong(paramString[10], 0L);
      this.gJI = Util.getLong(paramString[11], 0L);
      this.gJJ = Util.getLong(paramString[12], 0L);
      this.gJK = Util.getLong(paramString[13], 0L);
      this.ggg = z("ChatName", paramString[14], true);
      this.ggi = Util.getLong(paramString[15], 0L);
      this.gJL = Util.getInt(paramString[16], 0);
      this.gJM = Util.getLong(paramString[17], 0L);
      this.gJN = Util.getLong(paramString[18], 0L);
      this.gJO = Util.getLong(paramString[19], 0L);
      this.gJP = Util.getLong(paramString[20], 0L);
      this.gJQ = Util.getInt(paramString[21], 0);
      this.gJR = Util.getLong(paramString[22], 0L);
      this.gJS = Util.getLong(paramString[23], 0L);
      this.gJT = Util.getLong(paramString[24], 0L);
      this.gJU = Util.getLong(paramString[25], 0L);
      this.gJV = Util.getLong(paramString[26], 0L);
      this.gJW = Util.getLong(paramString[27], 0L);
      this.gJX = Util.getLong(paramString[28], 0L);
      this.gJY = Util.getInt(paramString[29], 0);
      this.gJZ = Util.getInt(paramString[30], 0);
      this.gKa = Util.getLong(paramString[31], 0L);
      this.gKb = Util.getInt(paramString[32], 0);
      this.gkj = Util.getLong(paramString[33], 0L);
      this.gko = z("CDNIp", paramString[34], true);
      this.gKc = Util.getLong(paramString[35], 0L);
      this.gKd = Util.getLong(paramString[36], 0L);
      this.gKe = Util.getLong(paramString[37], 0L);
      this.gKf = Util.getInt(paramString[38], 0);
      this.gKg = z("XClientIp", paramString[39], true);
      this.gKh = Util.getInt(paramString[40], 0);
      this.gKi = Util.getLong(paramString[41], 0L);
      this.gkq = Util.getLong(paramString[42], 0L);
      this.gkr = Util.getLong(paramString[43], 0L);
      this.gKj = Util.getInt(paramString[44], 0);
      this.gKk = Util.getInt(paramString[45], 0);
      this.gKl = Util.getLong(paramString[46], 0L);
      this.gKm = z("SnsVideoFlag", paramString[47], true);
      this.gAG = z("VideoCdnMsg", paramString[48], true);
      this.gKn = Util.getInt(paramString[49], 0);
      AppMethodBeat.o(126684);
      return;
    }
  }
  
  public final String agH()
  {
    AppMethodBeat.i(126685);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gkb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gki);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gEV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gko);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gAG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKn);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(126685);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(126686);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FileId:").append(this.gkb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileAesKey:").append(this.gJC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileLength:").append(this.gJD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoDuration:").append(this.gki);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadLength:").append(this.gJE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayDuration:").append(this.gIH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstPlayWaitTime:").append(this.gJF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovWaitTime:").append(this.gJG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BlockCount:").append(this.gJH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RegainAvgTime:").append(this.gEV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.gHC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadType:").append(this.gJI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartDownloadTime:").append(this.gJJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndDownloadTime:").append(this.gJK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatName:").append(this.ggg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MemberCount:").append(this.ggi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RetCode:").append(this.gJL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterQueueTime:").append(this.gJM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstReqCostTime:").append(this.gJN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstReqSize:").append(this.gJO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstReqDownloadSize:").append(this.gJP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstReqCompleted:").append(this.gJQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AvgSpeed:").append(this.gJR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AvgConnectCost:").append(this.gJS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstConnectCostTime:").append(this.gJT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetConnectTimes:").append(this.gJU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovReqTimes:").append(this.gJV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovCostTime:").append(this.gJW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovSize:").append(this.gJX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovCompleted:").append(this.gJY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovFailReason:").append(this.gJZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UiStayTime:").append(this.gKa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayErrorCode:").append(this.gKb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoBitrate:").append(this.gkj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.gko);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MessageCreateTime:").append(this.gKc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMsgId:").append(this.gKd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InitialDownloadLength:").append(this.gKe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoFormat:").append(this.gKf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("XClientIp:").append(this.gKg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsCrossNet:").append(this.gKh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovPosition:").append(this.gKi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadSize:").append(this.gkq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadCompletion:").append(this.gkr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransportProtocol:").append(this.gKj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransportProtocolError:").append(this.gKk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TraceId:").append(this.gKl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsVideoFlag:").append(this.gKm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoCdnMsg:").append(this.gAG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BackSrcNum:").append(this.gKn);
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
 * Qualified Name:     com.tencent.mm.f.b.a.iu
 * JD-Core Version:    0.7.0.1
 */