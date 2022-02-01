package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Arrays;

public final class v
  extends a
{
  private String dUA;
  private long dUB;
  private String dUC;
  private String dUD;
  private int dUE;
  private String dUF;
  private long dUG;
  private long dUH;
  private long dUI;
  private long dUJ;
  private long dUK;
  private long dUL;
  private long dUM;
  private long dUN;
  private long dUO;
  private String dUP;
  private long dUQ;
  private long dUR;
  private long dUS;
  private String dUT;
  private String dUz;
  
  public v()
  {
    this.dUz = "";
    this.dUA = "";
    this.dUB = 0L;
    this.dUC = "";
    this.dUD = "";
    this.dUE = 0;
    this.dUF = "";
    this.dUG = 0L;
    this.dUH = 0L;
    this.dUI = 0L;
    this.dUJ = 0L;
    this.dUK = 0L;
    this.dUL = 0L;
    this.dUM = 0L;
    this.dUN = 0L;
    this.dUO = 0L;
    this.dUP = "";
    this.dUQ = 0L;
    this.dUR = 0L;
    this.dUS = 0L;
    this.dUT = "";
  }
  
  public v(String paramString)
  {
    AppMethodBeat.i(126681);
    this.dUz = "";
    this.dUA = "";
    this.dUB = 0L;
    this.dUC = "";
    this.dUD = "";
    this.dUE = 0;
    this.dUF = "";
    this.dUG = 0L;
    this.dUH = 0L;
    this.dUI = 0L;
    this.dUJ = 0L;
    this.dUK = 0L;
    this.dUL = 0L;
    this.dUM = 0L;
    this.dUN = 0L;
    this.dUO = 0L;
    this.dUP = "";
    this.dUQ = 0L;
    this.dUR = 0L;
    this.dUS = 0L;
    this.dUT = "";
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
      this.dUz = t("FromUser", paramString[0], true);
      this.dUA = t("Session", paramString[1], true);
      this.dUB = bu.getLong(paramString[2], 0L);
      this.dUC = t("FileId", paramString[3], true);
      this.dUD = t("SnsUrl", paramString[4], true);
      this.dUE = bu.getInt(paramString[5], 0);
      this.dUF = t("NewMd5", paramString[6], true);
      this.dUG = bu.getLong(paramString[7], 0L);
      this.dUH = bu.getLong(paramString[8], 0L);
      this.dUI = bu.getLong(paramString[9], 0L);
      this.dUJ = bu.getLong(paramString[10], 0L);
      this.dUK = bu.getLong(paramString[11], 0L);
      this.dUL = bu.getLong(paramString[12], 0L);
      this.dUM = bu.getLong(paramString[13], 0L);
      this.dUN = bu.getLong(paramString[14], 0L);
      this.dUO = bu.getLong(paramString[15], 0L);
      this.dUP = t("CDNIp", paramString[16], true);
      this.dUQ = bu.getLong(paramString[17], 0L);
      this.dUR = bu.getLong(paramString[18], 0L);
      this.dUS = bu.getLong(paramString[19], 0L);
      this.dUT = t("Publishid", paramString[20], true);
      AppMethodBeat.o(126681);
      return;
    }
  }
  
  public final String RC()
  {
    AppMethodBeat.i(126682);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dUz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUT);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(126682);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(126683);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FromUser:").append(this.dUz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Session:").append(this.dUA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatNum:").append(this.dUB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileId:").append(this.dUC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsUrl:").append(this.dUD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetType:").append(this.dUE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMd5:").append(this.dUF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadStartTime:").append(this.dUG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadEndTime:").append(this.dUH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoSize:").append(this.dUI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoDuration:").append(this.dUJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoBitrate:").append(this.dUK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AudioBitrate:").append(this.dUL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoFps:").append(this.dUM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoWidth:").append(this.dUN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoHeight:").append(this.dUO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.dUP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalAudioChannel:").append(this.dUQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadSize:").append(this.dUR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadCompletion:").append(this.dUS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Publishid:").append(this.dUT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(126683);
    return localObject;
  }
  
  public final int getId()
  {
    return 13795;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.v
 * JD-Core Version:    0.7.0.1
 */