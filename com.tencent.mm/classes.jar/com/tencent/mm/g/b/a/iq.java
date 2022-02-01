package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class iq
  extends a
{
  public long eGx;
  private long eIW;
  public long eJH;
  public long eJb;
  private String eKE;
  private int eKF;
  private long eKG;
  private int eKH;
  private int eKI;
  public long eKJ;
  public long eKb;
  private long eKc;
  public long eKd;
  public long eKe;
  public long eKf;
  private long eKg;
  private long eKh;
  private long eKi;
  private int eKj;
  private long eKk;
  private long eKl;
  private long eKm;
  private long eKn;
  private int eKo;
  private long eKp;
  private long eKq;
  private long eKr;
  private long eKs;
  private long eKt;
  private long eKu;
  private long eKv;
  private int eKw;
  private int eKx;
  public long eKy;
  public int eKz;
  private String ePp;
  private String ePq;
  private long ePr;
  private int ePs;
  private String ePt;
  private String ePu;
  public int ePv;
  private String ePw;
  public int ePx;
  public long eoV;
  public long eoW;
  private String epb;
  private long epd;
  private long epe;
  
  public iq()
  {
    this.ePp = "";
    this.ePq = "";
    this.eKb = 0L;
    this.eoV = 0L;
    this.eKc = 0L;
    this.eJH = 0L;
    this.eKd = 0L;
    this.eKe = 0L;
    this.eKf = 0L;
    this.eGx = 0L;
    this.eJb = 0L;
    this.eKg = 0L;
    this.eKh = 0L;
    this.eKi = 0L;
    this.ePr = 0L;
    this.ePs = 0;
    this.eKj = 0;
    this.eKk = 0L;
    this.eKl = 0L;
    this.eKm = 0L;
    this.eKn = 0L;
    this.eKo = 0;
    this.eKp = 0L;
    this.eKq = 0L;
    this.eKr = 0L;
    this.eKs = 0L;
    this.eKt = 0L;
    this.eKu = 0L;
    this.eKv = 0L;
    this.eKw = 0;
    this.eKx = 0;
    this.eKy = 0L;
    this.eKz = 0;
    this.eoW = 0L;
    this.ePt = "";
    this.epb = "";
    this.ePu = "";
    this.eKE = "";
    this.eKF = 0;
    this.eKG = 0L;
    this.epd = 0L;
    this.epe = 0L;
    this.eKH = 0;
    this.eKI = 0;
    this.ePw = "";
    this.eKJ = 0L;
  }
  
  public iq(String paramString)
  {
    AppMethodBeat.i(126690);
    this.ePp = "";
    this.ePq = "";
    this.eKb = 0L;
    this.eoV = 0L;
    this.eKc = 0L;
    this.eJH = 0L;
    this.eKd = 0L;
    this.eKe = 0L;
    this.eKf = 0L;
    this.eGx = 0L;
    this.eJb = 0L;
    this.eKg = 0L;
    this.eKh = 0L;
    this.eKi = 0L;
    this.ePr = 0L;
    this.ePs = 0;
    this.eKj = 0;
    this.eKk = 0L;
    this.eKl = 0L;
    this.eKm = 0L;
    this.eKn = 0L;
    this.eKo = 0;
    this.eKp = 0L;
    this.eKq = 0L;
    this.eKr = 0L;
    this.eKs = 0L;
    this.eKt = 0L;
    this.eKu = 0L;
    this.eKv = 0L;
    this.eKw = 0;
    this.eKx = 0;
    this.eKy = 0L;
    this.eKz = 0;
    this.eoW = 0L;
    this.ePt = "";
    this.epb = "";
    this.ePu = "";
    this.eKE = "";
    this.eKF = 0;
    this.eKG = 0L;
    this.epd = 0L;
    this.epe = 0L;
    this.eKH = 0;
    this.eKI = 0;
    this.ePw = "";
    this.eKJ = 0L;
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 49) {
          break label885;
        }
        String[] arrayOfString = new String[49];
        Arrays.fill(arrayOfString, 0, 49, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label885:
    for (;;)
    {
      wn(paramString[0]);
      this.ePq = x("SnsReserved1", paramString[1], true);
      this.eKb = Util.getLong(paramString[2], 0L);
      this.eoV = Util.getLong(paramString[3], 0L);
      this.eKc = Util.getLong(paramString[4], 0L);
      this.eJH = Util.getLong(paramString[5], 0L);
      this.eKd = Util.getLong(paramString[6], 0L);
      this.eKe = Util.getLong(paramString[7], 0L);
      this.eKf = Util.getLong(paramString[8], 0L);
      this.eGx = Util.getLong(paramString[9], 0L);
      this.eJb = Util.getLong(paramString[10], 0L);
      this.eKg = Util.getLong(paramString[11], 0L);
      this.eKh = Util.getLong(paramString[12], 0L);
      this.eKi = Util.getLong(paramString[13], 0L);
      this.ePr = Util.getLong(paramString[14], 0L);
      this.ePs = Util.getInt(paramString[15], 0);
      this.eKj = Util.getInt(paramString[16], 0);
      this.eKk = Util.getLong(paramString[17], 0L);
      this.eKl = Util.getLong(paramString[18], 0L);
      this.eKm = Util.getLong(paramString[19], 0L);
      this.eKn = Util.getLong(paramString[20], 0L);
      this.eKo = Util.getInt(paramString[21], 0);
      this.eKp = Util.getLong(paramString[22], 0L);
      this.eKq = Util.getLong(paramString[23], 0L);
      this.eKr = Util.getLong(paramString[24], 0L);
      this.eKs = Util.getLong(paramString[25], 0L);
      this.eKt = Util.getLong(paramString[26], 0L);
      this.eKu = Util.getLong(paramString[27], 0L);
      this.eKv = Util.getLong(paramString[28], 0L);
      this.eKw = Util.getInt(paramString[29], 0);
      this.eKx = Util.getInt(paramString[30], 0);
      this.eKy = Util.getLong(paramString[31], 0L);
      this.eKz = Util.getInt(paramString[32], 0);
      this.eoW = Util.getLong(paramString[33], 0L);
      this.ePt = x("postname", paramString[34], true);
      this.epb = x("CDNIp", paramString[35], true);
      wo(paramString[36]);
      this.eKE = x("XClientIp", paramString[37], true);
      this.eKF = Util.getInt(paramString[38], 0);
      this.eKG = Util.getLong(paramString[39], 0L);
      this.epd = Util.getLong(paramString[40], 0L);
      this.epe = Util.getLong(paramString[41], 0L);
      this.eKH = Util.getInt(paramString[42], 0);
      this.eKI = Util.getInt(paramString[43], 0);
      this.ePv = Util.getInt(paramString[44], 0);
      wp(paramString[45]);
      this.ePx = Util.getInt(paramString[46], 0);
      this.eIW = Util.getLong(paramString[47], 0L);
      this.eKJ = Util.getLong(paramString[48], 0L);
      AppMethodBeat.o(126690);
      return;
    }
  }
  
  public final String abV()
  {
    AppMethodBeat.i(126694);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ePp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ePq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eGx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ePr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ePs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ePt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ePu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ePv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ePw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ePx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eIW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKJ);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(126694);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(126695);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SnsVideoUrl:").append(this.ePp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsReserved1:").append(this.ePq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileLength:").append(this.eKb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoDuration:").append(this.eoV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadLength:").append(this.eKc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayDuration:").append(this.eJH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstPlayWaitTime:").append(this.eKd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovWaitTime:").append(this.eKe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BlockCount:").append(this.eKf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RegainAvgTime:").append(this.eGx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.eJb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadType:").append(this.eKg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartDownloadTime:").append(this.eKh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndDownloadTime:").append(this.eKi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatName:").append(this.ePr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HttpStatusCode:").append(this.ePs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RetCode:").append(this.eKj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterQueueTime:").append(this.eKk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstReqCostTime:").append(this.eKl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstReqSize:").append(this.eKm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstReqDownloadSize:").append(this.eKn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstReqCompleted:").append(this.eKo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AvgSpeed:").append(this.eKp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AvgConnectCost:").append(this.eKq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstConnectCostTime:").append(this.eKr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetConnectTimes:").append(this.eKs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovReqTimes:").append(this.eKt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovCostTime:").append(this.eKu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovSize:").append(this.eKv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovCompleted:").append(this.eKw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovFailReason:").append(this.eKx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UiStayTime:").append(this.eKy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayErrorCode:").append(this.eKz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoBitrate:").append(this.eoW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("postname:").append(this.ePt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.epb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsPublishid:").append(this.ePu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("XClientIp:").append(this.eKE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsCrossNet:").append(this.eKF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoovPosition:").append(this.eKG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadSize:").append(this.epd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadCompletion:").append(this.epe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransportProtocol:").append(this.eKH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransportProtocolError:").append(this.eKI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AutoPlayScene:").append(this.ePv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AutoPlaySessionID:").append(this.ePw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AutoPlayReportTimstamp:").append(this.ePx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceType:").append(this.eIW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TraceId:").append(this.eKJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(126695);
    return localObject;
  }
  
  public final int getId()
  {
    return 13790;
  }
  
  public final iq wn(String paramString)
  {
    AppMethodBeat.i(126691);
    this.ePp = x("SnsVideoUrl", paramString, true);
    AppMethodBeat.o(126691);
    return this;
  }
  
  public final iq wo(String paramString)
  {
    AppMethodBeat.i(126692);
    this.ePu = x("SnsPublishid", paramString, true);
    AppMethodBeat.o(126692);
    return this;
  }
  
  public final iq wp(String paramString)
  {
    AppMethodBeat.i(126693);
    this.ePw = x("AutoPlaySessionID", paramString, true);
    AppMethodBeat.o(126693);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.iq
 * JD-Core Version:    0.7.0.1
 */