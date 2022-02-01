package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Arrays;

public final class ff
  extends a
{
  public long dUJ;
  public long dUK;
  private String dUP;
  private long dUR;
  private long dUS;
  public long ehE;
  private long ehF;
  public long ehG;
  public long ehH;
  public long ehI;
  public long ehJ;
  public long ehK;
  public long ehL;
  private long ehM;
  private long ehN;
  private long ehO;
  private int ehP;
  private long ehQ;
  private long ehR;
  private long ehS;
  private long ehT;
  private int ehU;
  private long ehV;
  private long ehW;
  private long ehX;
  private long ehY;
  private long ehZ;
  private long eia;
  private long eib;
  private int eic;
  private int eid;
  public long eie;
  public int eif;
  private String eik;
  private int eil;
  private long eim;
  private int ein;
  private int eio;
  private String elR;
  private String elS;
  private long elT;
  private int elU;
  private String elV;
  private String elW;
  public int elX;
  private String elY;
  public int elZ;
  
  public ff()
  {
    this.elR = "";
    this.elS = "";
    this.ehE = 0L;
    this.dUJ = 0L;
    this.ehF = 0L;
    this.ehG = 0L;
    this.ehH = 0L;
    this.ehI = 0L;
    this.ehJ = 0L;
    this.ehK = 0L;
    this.ehL = 0L;
    this.ehM = 0L;
    this.ehN = 0L;
    this.ehO = 0L;
    this.elT = 0L;
    this.elU = 0;
    this.ehP = 0;
    this.ehQ = 0L;
    this.ehR = 0L;
    this.ehS = 0L;
    this.ehT = 0L;
    this.ehU = 0;
    this.ehV = 0L;
    this.ehW = 0L;
    this.ehX = 0L;
    this.ehY = 0L;
    this.ehZ = 0L;
    this.eia = 0L;
    this.eib = 0L;
    this.eic = 0;
    this.eid = 0;
    this.eie = 0L;
    this.eif = 0;
    this.dUK = 0L;
    this.elV = "";
    this.dUP = "";
    this.elW = "";
    this.eik = "";
    this.eil = 0;
    this.eim = 0L;
    this.dUR = 0L;
    this.dUS = 0L;
    this.ein = 0;
    this.eio = 0;
    this.elY = "";
  }
  
  public ff(String paramString)
  {
    AppMethodBeat.i(126690);
    this.elR = "";
    this.elS = "";
    this.ehE = 0L;
    this.dUJ = 0L;
    this.ehF = 0L;
    this.ehG = 0L;
    this.ehH = 0L;
    this.ehI = 0L;
    this.ehJ = 0L;
    this.ehK = 0L;
    this.ehL = 0L;
    this.ehM = 0L;
    this.ehN = 0L;
    this.ehO = 0L;
    this.elT = 0L;
    this.elU = 0;
    this.ehP = 0;
    this.ehQ = 0L;
    this.ehR = 0L;
    this.ehS = 0L;
    this.ehT = 0L;
    this.ehU = 0;
    this.ehV = 0L;
    this.ehW = 0L;
    this.ehX = 0L;
    this.ehY = 0L;
    this.ehZ = 0L;
    this.eia = 0L;
    this.eib = 0L;
    this.eic = 0;
    this.eid = 0;
    this.eie = 0L;
    this.eif = 0;
    this.dUK = 0L;
    this.elV = "";
    this.dUP = "";
    this.elW = "";
    this.eik = "";
    this.eil = 0;
    this.eim = 0L;
    this.dUR = 0L;
    this.dUS = 0L;
    this.ein = 0;
    this.eio = 0;
    this.elY = "";
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 47) {
          break label856;
        }
        String[] arrayOfString = new String[47];
        Arrays.fill(arrayOfString, 0, 47, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label856:
    for (;;)
    {
      oF(paramString[0]);
      this.elS = t("SnsReserved1", paramString[1], true);
      this.ehE = bu.getLong(paramString[2], 0L);
      this.dUJ = bu.getLong(paramString[3], 0L);
      this.ehF = bu.getLong(paramString[4], 0L);
      this.ehG = bu.getLong(paramString[5], 0L);
      this.ehH = bu.getLong(paramString[6], 0L);
      this.ehI = bu.getLong(paramString[7], 0L);
      this.ehJ = bu.getLong(paramString[8], 0L);
      this.ehK = bu.getLong(paramString[9], 0L);
      this.ehL = bu.getLong(paramString[10], 0L);
      this.ehM = bu.getLong(paramString[11], 0L);
      this.ehN = bu.getLong(paramString[12], 0L);
      this.ehO = bu.getLong(paramString[13], 0L);
      this.elT = bu.getLong(paramString[14], 0L);
      this.elU = bu.getInt(paramString[15], 0);
      this.ehP = bu.getInt(paramString[16], 0);
      this.ehQ = bu.getLong(paramString[17], 0L);
      this.ehR = bu.getLong(paramString[18], 0L);
      this.ehS = bu.getLong(paramString[19], 0L);
      this.ehT = bu.getLong(paramString[20], 0L);
      this.ehU = bu.getInt(paramString[21], 0);
      this.ehV = bu.getLong(paramString[22], 0L);
      this.ehW = bu.getLong(paramString[23], 0L);
      this.ehX = bu.getLong(paramString[24], 0L);
      this.ehY = bu.getLong(paramString[25], 0L);
      this.ehZ = bu.getLong(paramString[26], 0L);
      this.eia = bu.getLong(paramString[27], 0L);
      this.eib = bu.getLong(paramString[28], 0L);
      this.eic = bu.getInt(paramString[29], 0);
      this.eid = bu.getInt(paramString[30], 0);
      this.eie = bu.getLong(paramString[31], 0L);
      this.eif = bu.getInt(paramString[32], 0);
      this.dUK = bu.getLong(paramString[33], 0L);
      this.elV = t("postname", paramString[34], true);
      this.dUP = t("CDNIp", paramString[35], true);
      oG(paramString[36]);
      this.eik = t("XClientIp", paramString[37], true);
      this.eil = bu.getInt(paramString[38], 0);
      this.eim = bu.getLong(paramString[39], 0L);
      this.dUR = bu.getLong(paramString[40], 0L);
      this.dUS = bu.getLong(paramString[41], 0L);
      this.ein = bu.getInt(paramString[42], 0);
      this.eio = bu.getInt(paramString[43], 0);
      this.elX = bu.getInt(paramString[44], 0);
      oH(paramString[45]);
      this.elZ = bu.getInt(paramString[46], 0);
      AppMethodBeat.o(126690);
      return;
    }
  }
  
  public final String RC()
  {
    AppMethodBeat.i(126694);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.elR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eia);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eib);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eic);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eid);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eie);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eif);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eik);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eil);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eim);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ein);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eio);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elZ);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(126694);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(126695);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SnsVideoUrl:").append(this.elR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsReserved1:").append(this.elS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileLength:").append(this.ehE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoDuration:").append(this.dUJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadLength:").append(this.ehF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayDuration:").append(this.ehG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstPlayWaitTime:").append(this.ehH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovWaitTime:").append(this.ehI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BlockCount:").append(this.ehJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RegainAvgTime:").append(this.ehK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.ehL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadType:").append(this.ehM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartDownloadTime:").append(this.ehN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndDownloadTime:").append(this.ehO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatName:").append(this.elT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HttpStatusCode:").append(this.elU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RetCode:").append(this.ehP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterQueueTime:").append(this.ehQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstReqCostTime:").append(this.ehR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstReqSize:").append(this.ehS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstReqDownloadSize:").append(this.ehT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstReqCompleted:").append(this.ehU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AvgSpeed:").append(this.ehV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AvgConnectCost:").append(this.ehW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstConnectCostTime:").append(this.ehX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetConnectTimes:").append(this.ehY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovReqTimes:").append(this.ehZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovCostTime:").append(this.eia);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovSize:").append(this.eib);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovCompleted:").append(this.eic);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovFailReason:").append(this.eid);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UiStayTime:").append(this.eie);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayErrorCode:").append(this.eif);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoBitrate:").append(this.dUK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("postname:").append(this.elV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.dUP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsPublishid:").append(this.elW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("XClientIp:").append(this.eik);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsCrossNet:").append(this.eil);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovPosition:").append(this.eim);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadSize:").append(this.dUR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadCompletion:").append(this.dUS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransportProtocol:").append(this.ein);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransportProtocolError:").append(this.eio);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AutoPlayScene:").append(this.elX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AutoPlaySessionID:").append(this.elY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AutoPlayReportTimstamp:").append(this.elZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(126695);
    return localObject;
  }
  
  public final int getId()
  {
    return 13790;
  }
  
  public final ff oF(String paramString)
  {
    AppMethodBeat.i(126691);
    this.elR = t("SnsVideoUrl", paramString, true);
    AppMethodBeat.o(126691);
    return this;
  }
  
  public final ff oG(String paramString)
  {
    AppMethodBeat.i(126692);
    this.elW = t("SnsPublishid", paramString, true);
    AppMethodBeat.o(126692);
    return this;
  }
  
  public final ff oH(String paramString)
  {
    AppMethodBeat.i(126693);
    this.elY = t("AutoPlaySessionID", paramString, true);
    AppMethodBeat.o(126693);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ff
 * JD-Core Version:    0.7.0.1
 */