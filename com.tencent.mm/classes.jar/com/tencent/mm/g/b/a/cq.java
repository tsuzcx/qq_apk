package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Arrays;

public final class cq
  extends a
{
  public long dIm;
  public long dIn;
  private String dIs;
  private long dIu;
  private long dIv;
  public long dOG;
  private long dOH;
  public long dOI;
  public long dOJ;
  public long dOK;
  public long dOL;
  public long dOM;
  public long dON;
  private long dOO;
  private long dOP;
  private long dOQ;
  private int dOR;
  private long dOS;
  private long dOT;
  private long dOU;
  private long dOV;
  private int dOW;
  private long dOX;
  private long dOY;
  private long dOZ;
  private long dPa;
  private long dPb;
  private long dPc;
  private long dPd;
  private int dPe;
  private int dPf;
  public long dPg;
  public int dPh;
  private String dPm;
  private int dPn;
  private long dPo;
  private int dPp;
  private int dPq;
  private String dSe;
  private String dSf;
  private long dSg;
  private int dSh;
  private String dSi;
  private String dSj;
  public int dSk;
  private String dSl;
  public int dSm;
  
  public cq()
  {
    this.dSe = "";
    this.dSf = "";
    this.dOG = 0L;
    this.dIm = 0L;
    this.dOH = 0L;
    this.dOI = 0L;
    this.dOJ = 0L;
    this.dOK = 0L;
    this.dOL = 0L;
    this.dOM = 0L;
    this.dON = 0L;
    this.dOO = 0L;
    this.dOP = 0L;
    this.dOQ = 0L;
    this.dSg = 0L;
    this.dSh = 0;
    this.dOR = 0;
    this.dOS = 0L;
    this.dOT = 0L;
    this.dOU = 0L;
    this.dOV = 0L;
    this.dOW = 0;
    this.dOX = 0L;
    this.dOY = 0L;
    this.dOZ = 0L;
    this.dPa = 0L;
    this.dPb = 0L;
    this.dPc = 0L;
    this.dPd = 0L;
    this.dPe = 0;
    this.dPf = 0;
    this.dPg = 0L;
    this.dPh = 0;
    this.dIn = 0L;
    this.dSi = "";
    this.dIs = "";
    this.dSj = "";
    this.dPm = "";
    this.dPn = 0;
    this.dPo = 0L;
    this.dIu = 0L;
    this.dIv = 0L;
    this.dPp = 0;
    this.dPq = 0;
  }
  
  public cq(String paramString)
  {
    AppMethodBeat.i(126690);
    this.dSe = "";
    this.dSf = "";
    this.dOG = 0L;
    this.dIm = 0L;
    this.dOH = 0L;
    this.dOI = 0L;
    this.dOJ = 0L;
    this.dOK = 0L;
    this.dOL = 0L;
    this.dOM = 0L;
    this.dON = 0L;
    this.dOO = 0L;
    this.dOP = 0L;
    this.dOQ = 0L;
    this.dSg = 0L;
    this.dSh = 0;
    this.dOR = 0;
    this.dOS = 0L;
    this.dOT = 0L;
    this.dOU = 0L;
    this.dOV = 0L;
    this.dOW = 0;
    this.dOX = 0L;
    this.dOY = 0L;
    this.dOZ = 0L;
    this.dPa = 0L;
    this.dPb = 0L;
    this.dPc = 0L;
    this.dPd = 0L;
    this.dPe = 0;
    this.dPf = 0;
    this.dPg = 0L;
    this.dPh = 0;
    this.dIn = 0L;
    this.dSi = "";
    this.dIs = "";
    this.dSj = "";
    this.dPm = "";
    this.dPn = 0;
    this.dPo = 0L;
    this.dIu = 0L;
    this.dIv = 0L;
    this.dPp = 0;
    this.dPq = 0;
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 47) {
          break label850;
        }
        String[] arrayOfString = new String[47];
        Arrays.fill(arrayOfString, 0, 47, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label850:
    for (;;)
    {
      jh(paramString[0]);
      this.dSf = t("SnsReserved1", paramString[1], true);
      this.dOG = bt.getLong(paramString[2], 0L);
      this.dIm = bt.getLong(paramString[3], 0L);
      this.dOH = bt.getLong(paramString[4], 0L);
      this.dOI = bt.getLong(paramString[5], 0L);
      this.dOJ = bt.getLong(paramString[6], 0L);
      this.dOK = bt.getLong(paramString[7], 0L);
      this.dOL = bt.getLong(paramString[8], 0L);
      this.dOM = bt.getLong(paramString[9], 0L);
      this.dON = bt.getLong(paramString[10], 0L);
      this.dOO = bt.getLong(paramString[11], 0L);
      this.dOP = bt.getLong(paramString[12], 0L);
      this.dOQ = bt.getLong(paramString[13], 0L);
      this.dSg = bt.getLong(paramString[14], 0L);
      this.dSh = bt.getInt(paramString[15], 0);
      this.dOR = bt.getInt(paramString[16], 0);
      this.dOS = bt.getLong(paramString[17], 0L);
      this.dOT = bt.getLong(paramString[18], 0L);
      this.dOU = bt.getLong(paramString[19], 0L);
      this.dOV = bt.getLong(paramString[20], 0L);
      this.dOW = bt.getInt(paramString[21], 0);
      this.dOX = bt.getLong(paramString[22], 0L);
      this.dOY = bt.getLong(paramString[23], 0L);
      this.dOZ = bt.getLong(paramString[24], 0L);
      this.dPa = bt.getLong(paramString[25], 0L);
      this.dPb = bt.getLong(paramString[26], 0L);
      this.dPc = bt.getLong(paramString[27], 0L);
      this.dPd = bt.getLong(paramString[28], 0L);
      this.dPe = bt.getInt(paramString[29], 0);
      this.dPf = bt.getInt(paramString[30], 0);
      this.dPg = bt.getLong(paramString[31], 0L);
      this.dPh = bt.getInt(paramString[32], 0);
      this.dIn = bt.getLong(paramString[33], 0L);
      this.dSi = t("postname", paramString[34], true);
      this.dIs = t("CDNIp", paramString[35], true);
      ji(paramString[36]);
      this.dPm = t("XClientIp", paramString[37], true);
      this.dPn = bt.getInt(paramString[38], 0);
      this.dPo = bt.getLong(paramString[39], 0L);
      this.dIu = bt.getLong(paramString[40], 0L);
      this.dIv = bt.getLong(paramString[41], 0L);
      this.dPp = bt.getInt(paramString[42], 0);
      this.dPq = bt.getInt(paramString[43], 0);
      this.dSk = bt.getInt(paramString[44], 0);
      jj(paramString[45]);
      this.dSm = bt.getInt(paramString[46], 0);
      AppMethodBeat.o(126690);
      return;
    }
  }
  
  public final String PV()
  {
    AppMethodBeat.i(126694);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dON);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSm);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(126694);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(126695);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SnsVideoUrl:").append(this.dSe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsReserved1:").append(this.dSf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileLength:").append(this.dOG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoDuration:").append(this.dIm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadLength:").append(this.dOH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayDuration:").append(this.dOI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstPlayWaitTime:").append(this.dOJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovWaitTime:").append(this.dOK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BlockCount:").append(this.dOL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RegainAvgTime:").append(this.dOM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.dON);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadType:").append(this.dOO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartDownloadTime:").append(this.dOP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndDownloadTime:").append(this.dOQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatName:").append(this.dSg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HttpStatusCode:").append(this.dSh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RetCode:").append(this.dOR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterQueueTime:").append(this.dOS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstReqCostTime:").append(this.dOT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstReqSize:").append(this.dOU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstReqDownloadSize:").append(this.dOV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstReqCompleted:").append(this.dOW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AvgSpeed:").append(this.dOX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AvgConnectCost:").append(this.dOY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstConnectCostTime:").append(this.dOZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetConnectTimes:").append(this.dPa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovReqTimes:").append(this.dPb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovCostTime:").append(this.dPc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovSize:").append(this.dPd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovCompleted:").append(this.dPe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovFailReason:").append(this.dPf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UiStayTime:").append(this.dPg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayErrorCode:").append(this.dPh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoBitrate:").append(this.dIn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("postname:").append(this.dSi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.dIs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsPublishid:").append(this.dSj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("XClientIp:").append(this.dPm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsCrossNet:").append(this.dPn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovPosition:").append(this.dPo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadSize:").append(this.dIu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadCompletion:").append(this.dIv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransportProtocol:").append(this.dPp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransportProtocolError:").append(this.dPq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AutoPlayScene:").append(this.dSk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AutoPlaySessionID:").append(this.dSl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AutoPlayReportTimstamp:").append(this.dSm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(126695);
    return localObject;
  }
  
  public final int getId()
  {
    return 13790;
  }
  
  public final cq jh(String paramString)
  {
    AppMethodBeat.i(126691);
    this.dSe = t("SnsVideoUrl", paramString, true);
    AppMethodBeat.o(126691);
    return this;
  }
  
  public final cq ji(String paramString)
  {
    AppMethodBeat.i(126692);
    this.dSj = t("SnsPublishid", paramString, true);
    AppMethodBeat.o(126692);
    return this;
  }
  
  public final cq jj(String paramString)
  {
    AppMethodBeat.i(126693);
    this.dSl = t("AutoPlaySessionID", paramString, true);
    AppMethodBeat.o(126693);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cq
 * JD-Core Version:    0.7.0.1
 */