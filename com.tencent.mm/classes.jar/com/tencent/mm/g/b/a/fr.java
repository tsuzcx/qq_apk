package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Arrays;

public final class fr
  extends a
{
  private String dGi;
  private int dGj;
  private String dGk;
  private String dGu;
  private long dGv;
  private long dRL;
  private long dWU;
  private long dWV;
  private long dZA;
  private long dZB;
  private long dZC;
  private int dZD;
  private long dZE;
  private long dZF;
  private long dZG;
  private long dZH;
  private long dZI;
  private long dZJ;
  private long dZK;
  private String dZs;
  private String dZt;
  private String dZu;
  private String dZv;
  private long dZw;
  private long dZx;
  private long dZy;
  private long dZz;
  
  public fr()
  {
    this.dZs = "";
    this.dZt = "";
    this.dGj = 0;
    this.dZu = "";
    this.dGk = "";
    this.dZv = "";
    this.dWU = 0L;
    this.dWV = 0L;
    this.dZw = 0L;
    this.dZx = 0L;
    this.dZy = 0L;
    this.dZz = 0L;
    this.dZA = 0L;
    this.dZB = 0L;
    this.dZC = 0L;
    this.dZD = 0;
    this.dZE = 0L;
    this.dZF = 0L;
    this.dZG = 0L;
    this.dZH = 0L;
    this.dZI = 0L;
    this.dZJ = 0L;
    this.dZK = 0L;
    this.dRL = 0L;
    this.dGu = "";
    this.dGv = 0L;
    this.dGi = "";
  }
  
  public fr(String paramString)
  {
    AppMethodBeat.i(126701);
    this.dZs = "";
    this.dZt = "";
    this.dGj = 0;
    this.dZu = "";
    this.dGk = "";
    this.dZv = "";
    this.dWU = 0L;
    this.dWV = 0L;
    this.dZw = 0L;
    this.dZx = 0L;
    this.dZy = 0L;
    this.dZz = 0L;
    this.dZA = 0L;
    this.dZB = 0L;
    this.dZC = 0L;
    this.dZD = 0;
    this.dZE = 0L;
    this.dZF = 0L;
    this.dZG = 0L;
    this.dZH = 0L;
    this.dZI = 0L;
    this.dZJ = 0L;
    this.dZK = 0L;
    this.dRL = 0L;
    this.dGu = "";
    this.dGv = 0L;
    this.dGi = "";
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 27) {
          break label544;
        }
        String[] arrayOfString = new String[27];
        Arrays.fill(arrayOfString, 0, 27, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label544:
    for (;;)
    {
      this.dZs = t("ToUser", paramString[0], true);
      this.dZt = t("MsgSource", paramString[1], true);
      this.dGj = bs.getInt(paramString[2], 0);
      this.dZu = t("FieldId", paramString[3], true);
      this.dGk = t("NewMd5", paramString[4], true);
      this.dZv = t("SnsInfoId", paramString[5], true);
      this.dWU = bs.getLong(paramString[6], 0L);
      this.dWV = bs.getLong(paramString[7], 0L);
      this.dZw = bs.getLong(paramString[8], 0L);
      this.dZx = bs.getLong(paramString[9], 0L);
      this.dZy = bs.getLong(paramString[10], 0L);
      this.dZz = bs.getLong(paramString[11], 0L);
      this.dZA = bs.getLong(paramString[12], 0L);
      this.dZB = bs.getLong(paramString[13], 0L);
      this.dZC = bs.getLong(paramString[14], 0L);
      this.dZD = bs.getInt(paramString[15], 0);
      this.dZE = bs.getLong(paramString[16], 0L);
      this.dZF = bs.getLong(paramString[17], 0L);
      this.dZG = bs.getLong(paramString[18], 0L);
      this.dZH = bs.getLong(paramString[19], 0L);
      this.dZI = bs.getLong(paramString[20], 0L);
      this.dZJ = bs.getLong(paramString[21], 0L);
      this.dZK = bs.getLong(paramString[22], 0L);
      this.dRL = bs.getLong(paramString[23], 0L);
      this.dGu = t("CDNIp", paramString[24], true);
      this.dGv = bs.getLong(paramString[25], 0L);
      this.dGi = t("SnsUrl", paramString[26], true);
      AppMethodBeat.o(126701);
      return;
    }
  }
  
  public final String PR()
  {
    AppMethodBeat.i(126702);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGi);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(126702);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(126703);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ToUser:").append(this.dZs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgSource:").append(this.dZt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetType:").append(this.dGj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FieldId:").append(this.dZu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMd5:").append(this.dGk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsInfoId:").append(this.dZv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadStartTime:").append(this.dWU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadEndTime:").append(this.dWV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalSize:").append(this.dZw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalDuration:").append(this.dZx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalVideoBitrate:").append(this.dZy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalAudioBitrate:").append(this.dZz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalFps:").append(this.dZA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalWidth:").append(this.dZB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalHeight:").append(this.dZC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpStatus:").append(this.dZD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpSize:").append(this.dZE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpDuration:").append(this.dZF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpVideoBitrate:").append(this.dZG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpAudioiBitrate:").append(this.dZH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpFps:").append(this.dZI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpWidth:").append(this.dZJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpHeight:").append(this.dZK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SendScene:").append(this.dRL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.dGu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalAudioChannel:").append(this.dGv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsUrl:").append(this.dGi);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(126703);
    return localObject;
  }
  
  public final int getId()
  {
    return 13794;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fr
 * JD-Core Version:    0.7.0.1
 */