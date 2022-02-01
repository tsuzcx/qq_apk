package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class ny
  extends a
{
  public String iMV;
  public long iRV;
  private long iVP;
  public long iVU;
  private long iVl;
  public long iXC;
  public long iYT;
  private long iYU;
  public long iYV;
  public long iYW;
  public long iYX;
  private long iYY;
  private long iYZ;
  private int iZA;
  public long iZB;
  public String iZC;
  public int iZD;
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
  public long iZq;
  public int iZr;
  private String iZw;
  private int iZx;
  private long iZy;
  private int iZz;
  private String irB;
  private long irD;
  private long irE;
  public long irv;
  public long irw;
  private String jgJ;
  private String jgK;
  private int jgL;
  private String jgM;
  private String jgN;
  public int jgO;
  private String jgP;
  public int jgQ;
  public long jgR;
  public long jgS;
  public long jgT;
  public long jgU;
  public long jgV;
  public long jgW;
  public int jgX;
  public long jgY;
  private String jgZ;
  private String jha;
  private String jhb;
  
  public ny()
  {
    this.jgJ = "";
    this.jgK = "";
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
    this.iVl = 0L;
    this.jgL = 0;
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
    this.jgM = "";
    this.irB = "";
    this.jgN = "";
    this.iZw = "";
    this.iZx = 0;
    this.iZy = 0L;
    this.irD = 0L;
    this.irE = 0L;
    this.iZz = 0;
    this.iZA = 0;
    this.jgP = "";
    this.iZB = 0L;
    this.iZC = "";
    this.iMV = "";
    this.iZD = 0;
    this.jgZ = "";
    this.jha = "";
    this.jhb = "";
  }
  
  public ny(String paramString)
  {
    AppMethodBeat.i(126690);
    this.jgJ = "";
    this.jgK = "";
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
    this.iVl = 0L;
    this.jgL = 0;
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
    this.jgM = "";
    this.irB = "";
    this.jgN = "";
    this.iZw = "";
    this.iZx = 0;
    this.iZy = 0L;
    this.irD = 0L;
    this.irE = 0L;
    this.iZz = 0;
    this.iZA = 0;
    this.jgP = "";
    this.iZB = 0L;
    this.iZC = "";
    this.iMV = "";
    this.iZD = 0;
    this.jgZ = "";
    this.jha = "";
    this.jhb = "";
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 63) {
          break label1087;
        }
        String[] arrayOfString = new String[63];
        Arrays.fill(arrayOfString, 0, 63, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label1087:
    for (;;)
    {
      vV(paramString[0]);
      this.jgK = F("SnsReserved1", paramString[1], true);
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
      this.iVl = Util.getLong(paramString[14], 0L);
      this.jgL = Util.getInt(paramString[15], 0);
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
      this.jgM = F("postname", paramString[34], true);
      this.irB = F("CDNIp", paramString[35], true);
      vW(paramString[36]);
      this.iZw = F("XClientIp", paramString[37], true);
      this.iZx = Util.getInt(paramString[38], 0);
      this.iZy = Util.getLong(paramString[39], 0L);
      this.irD = Util.getLong(paramString[40], 0L);
      this.irE = Util.getLong(paramString[41], 0L);
      this.iZz = Util.getInt(paramString[42], 0);
      this.iZA = Util.getInt(paramString[43], 0);
      this.jgO = Util.getInt(paramString[44], 0);
      vX(paramString[45]);
      this.jgQ = Util.getInt(paramString[46], 0);
      this.iVP = Util.getLong(paramString[47], 0L);
      this.iZB = Util.getLong(paramString[48], 0L);
      vY(paramString[49]);
      vZ(paramString[50]);
      this.iZD = Util.getInt(paramString[51], 0);
      this.jgR = Util.getLong(paramString[52], 0L);
      this.jgS = Util.getLong(paramString[53], 0L);
      this.jgT = Util.getLong(paramString[54], 0L);
      this.jgU = Util.getLong(paramString[55], 0L);
      this.jgV = Util.getLong(paramString[56], 0L);
      this.jgW = Util.getLong(paramString[57], 0L);
      this.jgX = Util.getInt(paramString[58], 0);
      this.jgY = Util.getLong(paramString[59], 0L);
      this.jgZ = F("cdn_master_ap_id", paramString[60], true);
      this.jha = F("cdn_slave_ap_id", paramString[61], true);
      wa(paramString[62]);
      AppMethodBeat.o(126690);
      return;
    }
  }
  
  public final String aIE()
  {
    AppMethodBeat.i(126694);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jgJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jgK);
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
    ((StringBuffer)localObject).append(this.iVl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jgL);
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
    ((StringBuffer)localObject).append(this.jgM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jgN);
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
    ((StringBuffer)localObject).append(this.jgO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jgP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jgQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iVP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iMV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jgR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jgS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jgT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jgU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jgV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jgW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jgX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jgY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jgZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jha);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jhb);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(126694);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(126695);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SnsVideoUrl:").append(this.jgJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsReserved1:").append(this.jgK);
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
    ((StringBuffer)localObject).append("ChatName:").append(this.iVl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HttpStatusCode:").append(this.jgL);
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
    ((StringBuffer)localObject).append("postname:").append(this.jgM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.irB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsPublishid:").append(this.jgN);
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
    ((StringBuffer)localObject).append("AutoPlayScene:").append(this.jgO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AutoPlaySessionID:").append(this.jgP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AutoPlayReportTimstamp:").append(this.jgQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceType:").append(this.iVP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TraceId:").append(this.iZB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsVideoFlag:").append(this.iZC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoCdnMsg:").append(this.iMV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BackSrcNum:").append(this.iZD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("width:").append(this.jgR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("height:").append(this.jgS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("frame_rate:").append(this.jgT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("load_time_before_play:").append(this.jgU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lagging_count:").append(this.jgV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("avg_lagging_time:").append(this.jgW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProgressBar_operation:").append(this.jgX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("max_progress:").append(this.jgY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cdn_master_ap_id:").append(this.jgZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cdn_slave_ap_id:").append(this.jha);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("widthxheight:").append(this.jhb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(126695);
    return localObject;
  }
  
  public final int getId()
  {
    return 13790;
  }
  
  public final ny vV(String paramString)
  {
    AppMethodBeat.i(126691);
    this.jgJ = F("SnsVideoUrl", paramString, true);
    AppMethodBeat.o(126691);
    return this;
  }
  
  public final ny vW(String paramString)
  {
    AppMethodBeat.i(126692);
    this.jgN = F("SnsPublishid", paramString, true);
    AppMethodBeat.o(126692);
    return this;
  }
  
  public final ny vX(String paramString)
  {
    AppMethodBeat.i(126693);
    this.jgP = F("AutoPlaySessionID", paramString, true);
    AppMethodBeat.o(126693);
    return this;
  }
  
  public final ny vY(String paramString)
  {
    AppMethodBeat.i(367814);
    this.iZC = F("SnsVideoFlag", paramString, true);
    AppMethodBeat.o(367814);
    return this;
  }
  
  public final ny vZ(String paramString)
  {
    AppMethodBeat.i(367820);
    this.iMV = F("VideoCdnMsg", paramString, true);
    AppMethodBeat.o(367820);
    return this;
  }
  
  public final ny wa(String paramString)
  {
    AppMethodBeat.i(367831);
    this.jhb = F("widthxheight", paramString, true);
    AppMethodBeat.o(367831);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ny
 * JD-Core Version:    0.7.0.1
 */