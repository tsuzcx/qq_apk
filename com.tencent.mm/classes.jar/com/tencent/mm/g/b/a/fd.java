package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Arrays;

public final class fd
  extends a
{
  private long dTB;
  private long dTC;
  public long dTt;
  public long dTu;
  private String dTz;
  public long efT;
  private long efU;
  public long efV;
  public long efW;
  public long efX;
  public long efY;
  public long efZ;
  private String egA;
  private int egB;
  private long egC;
  private int egD;
  private int egE;
  public long ega;
  private long egb;
  private long egc;
  private long egd;
  private int ege;
  private long egf;
  private long egg;
  private long egh;
  private long egi;
  private int egj;
  private long egk;
  private long egm;
  private long egn;
  private long ego;
  private long egp;
  private long egq;
  private long egr;
  private int egs;
  private int egt;
  public long egu;
  public int egv;
  private String ekk;
  private String ekl;
  private long ekm;
  private int ekn;
  private String eko;
  private String ekp;
  public int ekq;
  private String ekr;
  public int eks;
  
  public fd()
  {
    this.ekk = "";
    this.ekl = "";
    this.efT = 0L;
    this.dTt = 0L;
    this.efU = 0L;
    this.efV = 0L;
    this.efW = 0L;
    this.efX = 0L;
    this.efY = 0L;
    this.efZ = 0L;
    this.ega = 0L;
    this.egb = 0L;
    this.egc = 0L;
    this.egd = 0L;
    this.ekm = 0L;
    this.ekn = 0;
    this.ege = 0;
    this.egf = 0L;
    this.egg = 0L;
    this.egh = 0L;
    this.egi = 0L;
    this.egj = 0;
    this.egk = 0L;
    this.egm = 0L;
    this.egn = 0L;
    this.ego = 0L;
    this.egp = 0L;
    this.egq = 0L;
    this.egr = 0L;
    this.egs = 0;
    this.egt = 0;
    this.egu = 0L;
    this.egv = 0;
    this.dTu = 0L;
    this.eko = "";
    this.dTz = "";
    this.ekp = "";
    this.egA = "";
    this.egB = 0;
    this.egC = 0L;
    this.dTB = 0L;
    this.dTC = 0L;
    this.egD = 0;
    this.egE = 0;
  }
  
  public fd(String paramString)
  {
    AppMethodBeat.i(126690);
    this.ekk = "";
    this.ekl = "";
    this.efT = 0L;
    this.dTt = 0L;
    this.efU = 0L;
    this.efV = 0L;
    this.efW = 0L;
    this.efX = 0L;
    this.efY = 0L;
    this.efZ = 0L;
    this.ega = 0L;
    this.egb = 0L;
    this.egc = 0L;
    this.egd = 0L;
    this.ekm = 0L;
    this.ekn = 0;
    this.ege = 0;
    this.egf = 0L;
    this.egg = 0L;
    this.egh = 0L;
    this.egi = 0L;
    this.egj = 0;
    this.egk = 0L;
    this.egm = 0L;
    this.egn = 0L;
    this.ego = 0L;
    this.egp = 0L;
    this.egq = 0L;
    this.egr = 0L;
    this.egs = 0;
    this.egt = 0;
    this.egu = 0L;
    this.egv = 0;
    this.dTu = 0L;
    this.eko = "";
    this.dTz = "";
    this.ekp = "";
    this.egA = "";
    this.egB = 0;
    this.egC = 0L;
    this.dTB = 0L;
    this.dTC = 0L;
    this.egD = 0;
    this.egE = 0;
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
      ok(paramString[0]);
      this.ekl = t("SnsReserved1", paramString[1], true);
      this.efT = bt.getLong(paramString[2], 0L);
      this.dTt = bt.getLong(paramString[3], 0L);
      this.efU = bt.getLong(paramString[4], 0L);
      this.efV = bt.getLong(paramString[5], 0L);
      this.efW = bt.getLong(paramString[6], 0L);
      this.efX = bt.getLong(paramString[7], 0L);
      this.efY = bt.getLong(paramString[8], 0L);
      this.efZ = bt.getLong(paramString[9], 0L);
      this.ega = bt.getLong(paramString[10], 0L);
      this.egb = bt.getLong(paramString[11], 0L);
      this.egc = bt.getLong(paramString[12], 0L);
      this.egd = bt.getLong(paramString[13], 0L);
      this.ekm = bt.getLong(paramString[14], 0L);
      this.ekn = bt.getInt(paramString[15], 0);
      this.ege = bt.getInt(paramString[16], 0);
      this.egf = bt.getLong(paramString[17], 0L);
      this.egg = bt.getLong(paramString[18], 0L);
      this.egh = bt.getLong(paramString[19], 0L);
      this.egi = bt.getLong(paramString[20], 0L);
      this.egj = bt.getInt(paramString[21], 0);
      this.egk = bt.getLong(paramString[22], 0L);
      this.egm = bt.getLong(paramString[23], 0L);
      this.egn = bt.getLong(paramString[24], 0L);
      this.ego = bt.getLong(paramString[25], 0L);
      this.egp = bt.getLong(paramString[26], 0L);
      this.egq = bt.getLong(paramString[27], 0L);
      this.egr = bt.getLong(paramString[28], 0L);
      this.egs = bt.getInt(paramString[29], 0);
      this.egt = bt.getInt(paramString[30], 0);
      this.egu = bt.getLong(paramString[31], 0L);
      this.egv = bt.getInt(paramString[32], 0);
      this.dTu = bt.getLong(paramString[33], 0L);
      this.eko = t("postname", paramString[34], true);
      this.dTz = t("CDNIp", paramString[35], true);
      ol(paramString[36]);
      this.egA = t("XClientIp", paramString[37], true);
      this.egB = bt.getInt(paramString[38], 0);
      this.egC = bt.getLong(paramString[39], 0L);
      this.dTB = bt.getLong(paramString[40], 0L);
      this.dTC = bt.getLong(paramString[41], 0L);
      this.egD = bt.getInt(paramString[42], 0);
      this.egE = bt.getInt(paramString[43], 0);
      this.ekq = bt.getInt(paramString[44], 0);
      om(paramString[45]);
      this.eks = bt.getInt(paramString[46], 0);
      AppMethodBeat.o(126690);
      return;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(126694);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ekk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ega);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ege);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ego);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eko);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eks);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(126694);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(126695);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SnsVideoUrl:").append(this.ekk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsReserved1:").append(this.ekl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileLength:").append(this.efT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoDuration:").append(this.dTt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadLength:").append(this.efU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayDuration:").append(this.efV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstPlayWaitTime:").append(this.efW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovWaitTime:").append(this.efX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BlockCount:").append(this.efY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RegainAvgTime:").append(this.efZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.ega);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadType:").append(this.egb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartDownloadTime:").append(this.egc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndDownloadTime:").append(this.egd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatName:").append(this.ekm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HttpStatusCode:").append(this.ekn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RetCode:").append(this.ege);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterQueueTime:").append(this.egf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstReqCostTime:").append(this.egg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstReqSize:").append(this.egh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstReqDownloadSize:").append(this.egi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstReqCompleted:").append(this.egj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AvgSpeed:").append(this.egk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AvgConnectCost:").append(this.egm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstConnectCostTime:").append(this.egn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetConnectTimes:").append(this.ego);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovReqTimes:").append(this.egp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovCostTime:").append(this.egq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovSize:").append(this.egr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovCompleted:").append(this.egs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovFailReason:").append(this.egt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UiStayTime:").append(this.egu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayErrorCode:").append(this.egv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoBitrate:").append(this.dTu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("postname:").append(this.eko);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.dTz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsPublishid:").append(this.ekp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("XClientIp:").append(this.egA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsCrossNet:").append(this.egB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovPosition:").append(this.egC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadSize:").append(this.dTB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadCompletion:").append(this.dTC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransportProtocol:").append(this.egD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransportProtocolError:").append(this.egE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AutoPlayScene:").append(this.ekq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AutoPlaySessionID:").append(this.ekr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AutoPlayReportTimstamp:").append(this.eks);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(126695);
    return localObject;
  }
  
  public final int getId()
  {
    return 13790;
  }
  
  public final fd ok(String paramString)
  {
    AppMethodBeat.i(126691);
    this.ekk = t("SnsVideoUrl", paramString, true);
    AppMethodBeat.o(126691);
    return this;
  }
  
  public final fd ol(String paramString)
  {
    AppMethodBeat.i(126692);
    this.ekp = t("SnsPublishid", paramString, true);
    AppMethodBeat.o(126692);
    return this;
  }
  
  public final fd om(String paramString)
  {
    AppMethodBeat.i(126693);
    this.ekr = t("AutoPlaySessionID", paramString, true);
    AppMethodBeat.o(126693);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fd
 * JD-Core Version:    0.7.0.1
 */