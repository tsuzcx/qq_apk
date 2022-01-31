package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Arrays;

public final class k
  extends a
{
  private String cQA;
  private String cQB;
  private int cQC;
  private String cQD;
  private long cQE;
  private long cQF;
  private long cQG;
  private long cQH;
  private long cQI;
  private long cQJ;
  private long cQK;
  private long cQL;
  private long cQM;
  private String cQN;
  private long cQO;
  private long cQP;
  private long cQQ;
  private String cQR;
  private String cQx;
  private String cQy;
  private long cQz;
  
  public k()
  {
    this.cQx = "";
    this.cQy = "";
    this.cQz = 0L;
    this.cQA = "";
    this.cQB = "";
    this.cQC = 0;
    this.cQD = "";
    this.cQE = 0L;
    this.cQF = 0L;
    this.cQG = 0L;
    this.cQH = 0L;
    this.cQI = 0L;
    this.cQJ = 0L;
    this.cQK = 0L;
    this.cQL = 0L;
    this.cQM = 0L;
    this.cQN = "";
    this.cQO = 0L;
    this.cQP = 0L;
    this.cQQ = 0L;
    this.cQR = "";
  }
  
  public k(String paramString)
  {
    AppMethodBeat.i(50531);
    this.cQx = "";
    this.cQy = "";
    this.cQz = 0L;
    this.cQA = "";
    this.cQB = "";
    this.cQC = 0;
    this.cQD = "";
    this.cQE = 0L;
    this.cQF = 0L;
    this.cQG = 0L;
    this.cQH = 0L;
    this.cQI = 0L;
    this.cQJ = 0L;
    this.cQK = 0L;
    this.cQL = 0L;
    this.cQM = 0L;
    this.cQN = "";
    this.cQO = 0L;
    this.cQP = 0L;
    this.cQQ = 0L;
    this.cQR = "";
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 21) {
          break label442;
        }
        String[] arrayOfString = new String[21];
        Arrays.fill(arrayOfString, 0, 21, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label442:
    for (;;)
    {
      this.cQx = t("FromUser", paramString[0], true);
      this.cQy = t("Session", paramString[1], true);
      this.cQz = bo.getLong(paramString[2], 0L);
      this.cQA = t("FileId", paramString[3], true);
      this.cQB = t("SnsUrl", paramString[4], true);
      this.cQC = bo.getInt(paramString[5], 0);
      this.cQD = t("NewMd5", paramString[6], true);
      this.cQE = bo.getLong(paramString[7], 0L);
      this.cQF = bo.getLong(paramString[8], 0L);
      this.cQG = bo.getLong(paramString[9], 0L);
      this.cQH = bo.getLong(paramString[10], 0L);
      this.cQI = bo.getLong(paramString[11], 0L);
      this.cQJ = bo.getLong(paramString[12], 0L);
      this.cQK = bo.getLong(paramString[13], 0L);
      this.cQL = bo.getLong(paramString[14], 0L);
      this.cQM = bo.getLong(paramString[15], 0L);
      this.cQN = t("CDNIp", paramString[16], true);
      this.cQO = bo.getLong(paramString[17], 0L);
      this.cQP = bo.getLong(paramString[18], 0L);
      this.cQQ = bo.getLong(paramString[19], 0L);
      this.cQR = t("Publishid", paramString[20], true);
      AppMethodBeat.o(50531);
      return;
    }
  }
  
  public final String Ff()
  {
    AppMethodBeat.i(50532);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cQx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQR);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(50532);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(50533);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FromUser:").append(this.cQx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Session:").append(this.cQy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatNum:").append(this.cQz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileId:").append(this.cQA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsUrl:").append(this.cQB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetType:").append(this.cQC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMd5:").append(this.cQD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadStartTime:").append(this.cQE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadEndTime:").append(this.cQF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoSize:").append(this.cQG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoDuration:").append(this.cQH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoBitrate:").append(this.cQI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AudioBitrate:").append(this.cQJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoFps:").append(this.cQK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoWidth:").append(this.cQL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoHeight:").append(this.cQM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.cQN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalAudioChannel:").append(this.cQO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadSize:").append(this.cQP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadCompletion:").append(this.cQQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Publishid:").append(this.cQR);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(50533);
    return localObject;
  }
  
  public final int getId()
  {
    return 13795;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.k
 * JD-Core Version:    0.7.0.1
 */