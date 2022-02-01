package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Arrays;

public final class bf
  extends a
{
  private String dGR;
  private long dGS;
  private String dIf;
  private long dIm;
  private long dIn;
  private String dIs;
  private long dIu;
  private long dIv;
  private String dOF;
  private long dOG;
  private long dOH;
  private long dOI;
  private long dOJ;
  private long dOK;
  private long dOL;
  private long dOM;
  private long dON;
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
  private long dPg;
  private int dPh;
  private long dPi;
  private long dPj;
  private long dPk;
  private int dPl;
  private String dPm;
  private int dPn;
  private long dPo;
  private int dPp;
  private int dPq;
  
  public bf()
  {
    this.dIf = "";
    this.dOF = "";
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
    this.dGR = "";
    this.dGS = 0L;
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
    this.dIs = "";
    this.dPi = 0L;
    this.dPj = 0L;
    this.dPk = 0L;
    this.dPl = 0;
    this.dPm = "";
    this.dPn = 0;
    this.dPo = 0L;
    this.dIu = 0L;
    this.dIv = 0L;
    this.dPp = 0;
    this.dPq = 0;
  }
  
  public bf(String paramString)
  {
    AppMethodBeat.i(126684);
    this.dIf = "";
    this.dOF = "";
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
    this.dGR = "";
    this.dGS = 0L;
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
    this.dIs = "";
    this.dPi = 0L;
    this.dPj = 0L;
    this.dPk = 0L;
    this.dPl = 0;
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
      this.dIf = t("FileId", paramString[0], true);
      this.dOF = t("FileAesKey", paramString[1], true);
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
      this.dGR = t("ChatName", paramString[14], true);
      this.dGS = bt.getLong(paramString[15], 0L);
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
      this.dIs = t("CDNIp", paramString[34], true);
      this.dPi = bt.getLong(paramString[35], 0L);
      this.dPj = bt.getLong(paramString[36], 0L);
      this.dPk = bt.getLong(paramString[37], 0L);
      this.dPl = bt.getInt(paramString[38], 0);
      this.dPm = t("XClientIp", paramString[39], true);
      this.dPn = bt.getInt(paramString[40], 0);
      this.dPo = bt.getLong(paramString[41], 0L);
      this.dIu = bt.getLong(paramString[42], 0L);
      this.dIv = bt.getLong(paramString[43], 0L);
      this.dPp = bt.getInt(paramString[44], 0);
      this.dPq = bt.getInt(paramString[45], 0);
      AppMethodBeat.o(126684);
      return;
    }
  }
  
  public final String PV()
  {
    AppMethodBeat.i(126685);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dIf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOF);
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
    ((StringBuffer)localObject).append(this.dGR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGS);
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
    ((StringBuffer)localObject).append(this.dIs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPl);
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
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(126685);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(126686);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FileId:").append(this.dIf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileAesKey:").append(this.dOF);
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
    ((StringBuffer)localObject).append("ChatName:").append(this.dGR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MemberCount:").append(this.dGS);
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
    ((StringBuffer)localObject).append("CDNIp:").append(this.dIs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MessageCreateTime:").append(this.dPi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMsgId:").append(this.dPj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InitialDownloadLength:").append(this.dPk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoFormat:").append(this.dPl);
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
 * Qualified Name:     com.tencent.mm.g.b.a.bf
 * JD-Core Version:    0.7.0.1
 */