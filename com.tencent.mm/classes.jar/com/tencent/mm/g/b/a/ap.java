package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Arrays;

public final class ap
  extends a
{
  public long cQH;
  public long cQI;
  private String cQN;
  private long cQP;
  private long cQQ;
  public long cSU;
  private long cSV;
  public long cSW;
  public long cSX;
  public long cSY;
  public long cSZ;
  private String cTA;
  private int cTB;
  private long cTC;
  public long cTa;
  public long cTb;
  private long cTc;
  private long cTd;
  private long cTe;
  private int cTf;
  private long cTg;
  private long cTh;
  private long cTi;
  private long cTj;
  private int cTk;
  private long cTl;
  private long cTm;
  private long cTn;
  private long cTo;
  private long cTp;
  private long cTq;
  private long cTr;
  private int cTs;
  private int cTt;
  public long cTu;
  public int cTv;
  private String cUO;
  private String cUP;
  private long cUQ;
  private int cUR;
  private String cUS;
  private String cUT;
  private int cUU;
  private int cUV;
  public int cUW;
  private String cUX;
  public int cUY;
  
  public ap()
  {
    this.cUO = "";
    this.cUP = "";
    this.cSU = 0L;
    this.cQH = 0L;
    this.cSV = 0L;
    this.cSW = 0L;
    this.cSX = 0L;
    this.cSY = 0L;
    this.cSZ = 0L;
    this.cTa = 0L;
    this.cTb = 0L;
    this.cTc = 0L;
    this.cTd = 0L;
    this.cTe = 0L;
    this.cUQ = 0L;
    this.cUR = 0;
    this.cTf = 0;
    this.cTg = 0L;
    this.cTh = 0L;
    this.cTi = 0L;
    this.cTj = 0L;
    this.cTk = 0;
    this.cTl = 0L;
    this.cTm = 0L;
    this.cTn = 0L;
    this.cTo = 0L;
    this.cTp = 0L;
    this.cTq = 0L;
    this.cTr = 0L;
    this.cTs = 0;
    this.cTt = 0;
    this.cTu = 0L;
    this.cTv = 0;
    this.cQI = 0L;
    this.cUS = "";
    this.cQN = "";
    this.cUT = "";
    this.cTA = "";
    this.cTB = 0;
    this.cTC = 0L;
    this.cQP = 0L;
    this.cQQ = 0L;
    this.cUU = 0;
    this.cUV = 0;
  }
  
  public ap(String paramString)
  {
    AppMethodBeat.i(50540);
    this.cUO = "";
    this.cUP = "";
    this.cSU = 0L;
    this.cQH = 0L;
    this.cSV = 0L;
    this.cSW = 0L;
    this.cSX = 0L;
    this.cSY = 0L;
    this.cSZ = 0L;
    this.cTa = 0L;
    this.cTb = 0L;
    this.cTc = 0L;
    this.cTd = 0L;
    this.cTe = 0L;
    this.cUQ = 0L;
    this.cUR = 0;
    this.cTf = 0;
    this.cTg = 0L;
    this.cTh = 0L;
    this.cTi = 0L;
    this.cTj = 0L;
    this.cTk = 0;
    this.cTl = 0L;
    this.cTm = 0L;
    this.cTn = 0L;
    this.cTo = 0L;
    this.cTp = 0L;
    this.cTq = 0L;
    this.cTr = 0L;
    this.cTs = 0;
    this.cTt = 0;
    this.cTu = 0L;
    this.cTv = 0;
    this.cQI = 0L;
    this.cUS = "";
    this.cQN = "";
    this.cUT = "";
    this.cTA = "";
    this.cTB = 0;
    this.cTC = 0L;
    this.cQP = 0L;
    this.cQQ = 0L;
    this.cUU = 0;
    this.cUV = 0;
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
      fU(paramString[0]);
      this.cUP = t("SnsReserved1", paramString[1], true);
      this.cSU = bo.getLong(paramString[2], 0L);
      this.cQH = bo.getLong(paramString[3], 0L);
      this.cSV = bo.getLong(paramString[4], 0L);
      this.cSW = bo.getLong(paramString[5], 0L);
      this.cSX = bo.getLong(paramString[6], 0L);
      this.cSY = bo.getLong(paramString[7], 0L);
      this.cSZ = bo.getLong(paramString[8], 0L);
      this.cTa = bo.getLong(paramString[9], 0L);
      this.cTb = bo.getLong(paramString[10], 0L);
      this.cTc = bo.getLong(paramString[11], 0L);
      this.cTd = bo.getLong(paramString[12], 0L);
      this.cTe = bo.getLong(paramString[13], 0L);
      this.cUQ = bo.getLong(paramString[14], 0L);
      this.cUR = bo.getInt(paramString[15], 0);
      this.cTf = bo.getInt(paramString[16], 0);
      this.cTg = bo.getLong(paramString[17], 0L);
      this.cTh = bo.getLong(paramString[18], 0L);
      this.cTi = bo.getLong(paramString[19], 0L);
      this.cTj = bo.getLong(paramString[20], 0L);
      this.cTk = bo.getInt(paramString[21], 0);
      this.cTl = bo.getLong(paramString[22], 0L);
      this.cTm = bo.getLong(paramString[23], 0L);
      this.cTn = bo.getLong(paramString[24], 0L);
      this.cTo = bo.getLong(paramString[25], 0L);
      this.cTp = bo.getLong(paramString[26], 0L);
      this.cTq = bo.getLong(paramString[27], 0L);
      this.cTr = bo.getLong(paramString[28], 0L);
      this.cTs = bo.getInt(paramString[29], 0);
      this.cTt = bo.getInt(paramString[30], 0);
      this.cTu = bo.getLong(paramString[31], 0L);
      this.cTv = bo.getInt(paramString[32], 0);
      this.cQI = bo.getLong(paramString[33], 0L);
      this.cUS = t("postname", paramString[34], true);
      this.cQN = t("CDNIp", paramString[35], true);
      fV(paramString[36]);
      this.cTA = t("XClientIp", paramString[37], true);
      this.cTB = bo.getInt(paramString[38], 0);
      this.cTC = bo.getLong(paramString[39], 0L);
      this.cQP = bo.getLong(paramString[40], 0L);
      this.cQQ = bo.getLong(paramString[41], 0L);
      this.cUU = bo.getInt(paramString[42], 0);
      this.cUV = bo.getInt(paramString[43], 0);
      this.cUW = bo.getInt(paramString[44], 0);
      fW(paramString[45]);
      this.cUY = bo.getInt(paramString[46], 0);
      AppMethodBeat.o(50540);
      return;
    }
  }
  
  public final String Ff()
  {
    AppMethodBeat.i(50541);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cUO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUY);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(50541);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(50542);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SnsVideoUrl:").append(this.cUO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsReserved1:").append(this.cUP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileLength:").append(this.cSU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoDuration:").append(this.cQH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadLength:").append(this.cSV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayDuration:").append(this.cSW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstPlayWaitTime:").append(this.cSX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovWaitTime:").append(this.cSY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BlockCount:").append(this.cSZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RegainAvgTime:").append(this.cTa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.cTb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadType:").append(this.cTc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartDownloadTime:").append(this.cTd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndDownloadTime:").append(this.cTe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatName:").append(this.cUQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HttpStatusCode:").append(this.cUR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RetCode:").append(this.cTf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterQueueTime:").append(this.cTg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstReqCostTime:").append(this.cTh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstReqSize:").append(this.cTi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstReqDownloadSize:").append(this.cTj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstReqCompleted:").append(this.cTk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AvgSpeed:").append(this.cTl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AvgConnectCost:").append(this.cTm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstConnectCostTime:").append(this.cTn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetConnectTimes:").append(this.cTo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovReqTimes:").append(this.cTp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovCostTime:").append(this.cTq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovSize:").append(this.cTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovCompleted:").append(this.cTs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovFailReason:").append(this.cTt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UiStayTime:").append(this.cTu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayErrorCode:").append(this.cTv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoBitrate:").append(this.cQI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("postname:").append(this.cUS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.cQN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsPublishid:").append(this.cUT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("XClientIp:").append(this.cTA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsCrossNet:").append(this.cTB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovPosition:").append(this.cTC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadSize:").append(this.cQP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadCompletion:").append(this.cQQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransportProtocol:").append(this.cUU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransportProtocolError:").append(this.cUV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AutoPlayScene:").append(this.cUW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AutoPlaySessionID:").append(this.cUX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AutoPlayReportTimstamp:").append(this.cUY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(50542);
    return localObject;
  }
  
  public final ap fU(String paramString)
  {
    AppMethodBeat.i(139633);
    this.cUO = t("SnsVideoUrl", paramString, true);
    AppMethodBeat.o(139633);
    return this;
  }
  
  public final ap fV(String paramString)
  {
    AppMethodBeat.i(139634);
    this.cUT = t("SnsPublishid", paramString, true);
    AppMethodBeat.o(139634);
    return this;
  }
  
  public final ap fW(String paramString)
  {
    AppMethodBeat.i(139635);
    this.cUX = t("AutoPlaySessionID", paramString, true);
    AppMethodBeat.o(139635);
    return this;
  }
  
  public final int getId()
  {
    return 13790;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ap
 * JD-Core Version:    0.7.0.1
 */