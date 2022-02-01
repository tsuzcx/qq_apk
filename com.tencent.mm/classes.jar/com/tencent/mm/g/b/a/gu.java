package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Arrays;

public final class gu
  extends a
{
  private String dUD;
  private int dUE;
  private String dUF;
  private String dUP;
  private long dUQ;
  private long eiS;
  private long eoT;
  private long eoU;
  private String erA;
  private String erB;
  private long erC;
  private long erD;
  private long erE;
  private long erF;
  private long erG;
  private long erH;
  private long erI;
  private int erJ;
  private long erK;
  private long erL;
  private long erM;
  private long erN;
  private long erO;
  private long erP;
  private long erQ;
  private String ery;
  private String erz;
  
  public gu()
  {
    this.ery = "";
    this.erz = "";
    this.dUE = 0;
    this.erA = "";
    this.dUF = "";
    this.erB = "";
    this.eoT = 0L;
    this.eoU = 0L;
    this.erC = 0L;
    this.erD = 0L;
    this.erE = 0L;
    this.erF = 0L;
    this.erG = 0L;
    this.erH = 0L;
    this.erI = 0L;
    this.erJ = 0;
    this.erK = 0L;
    this.erL = 0L;
    this.erM = 0L;
    this.erN = 0L;
    this.erO = 0L;
    this.erP = 0L;
    this.erQ = 0L;
    this.eiS = 0L;
    this.dUP = "";
    this.dUQ = 0L;
    this.dUD = "";
  }
  
  public gu(String paramString)
  {
    AppMethodBeat.i(126701);
    this.ery = "";
    this.erz = "";
    this.dUE = 0;
    this.erA = "";
    this.dUF = "";
    this.erB = "";
    this.eoT = 0L;
    this.eoU = 0L;
    this.erC = 0L;
    this.erD = 0L;
    this.erE = 0L;
    this.erF = 0L;
    this.erG = 0L;
    this.erH = 0L;
    this.erI = 0L;
    this.erJ = 0;
    this.erK = 0L;
    this.erL = 0L;
    this.erM = 0L;
    this.erN = 0L;
    this.erO = 0L;
    this.erP = 0L;
    this.erQ = 0L;
    this.eiS = 0L;
    this.dUP = "";
    this.dUQ = 0L;
    this.dUD = "";
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
      this.ery = t("ToUser", paramString[0], true);
      this.erz = t("MsgSource", paramString[1], true);
      this.dUE = bu.getInt(paramString[2], 0);
      this.erA = t("FieldId", paramString[3], true);
      this.dUF = t("NewMd5", paramString[4], true);
      this.erB = t("SnsInfoId", paramString[5], true);
      this.eoT = bu.getLong(paramString[6], 0L);
      this.eoU = bu.getLong(paramString[7], 0L);
      this.erC = bu.getLong(paramString[8], 0L);
      this.erD = bu.getLong(paramString[9], 0L);
      this.erE = bu.getLong(paramString[10], 0L);
      this.erF = bu.getLong(paramString[11], 0L);
      this.erG = bu.getLong(paramString[12], 0L);
      this.erH = bu.getLong(paramString[13], 0L);
      this.erI = bu.getLong(paramString[14], 0L);
      this.erJ = bu.getInt(paramString[15], 0);
      this.erK = bu.getLong(paramString[16], 0L);
      this.erL = bu.getLong(paramString[17], 0L);
      this.erM = bu.getLong(paramString[18], 0L);
      this.erN = bu.getLong(paramString[19], 0L);
      this.erO = bu.getLong(paramString[20], 0L);
      this.erP = bu.getLong(paramString[21], 0L);
      this.erQ = bu.getLong(paramString[22], 0L);
      this.eiS = bu.getLong(paramString[23], 0L);
      this.dUP = t("CDNIp", paramString[24], true);
      this.dUQ = bu.getLong(paramString[25], 0L);
      this.dUD = t("SnsUrl", paramString[26], true);
      AppMethodBeat.o(126701);
      return;
    }
  }
  
  public final String RC()
  {
    AppMethodBeat.i(126702);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ery);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUD);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(126702);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(126703);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ToUser:").append(this.ery);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgSource:").append(this.erz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetType:").append(this.dUE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FieldId:").append(this.erA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMd5:").append(this.dUF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsInfoId:").append(this.erB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadStartTime:").append(this.eoT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadEndTime:").append(this.eoU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalSize:").append(this.erC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalDuration:").append(this.erD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalVideoBitrate:").append(this.erE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalAudioBitrate:").append(this.erF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalFps:").append(this.erG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalWidth:").append(this.erH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalHeight:").append(this.erI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpStatus:").append(this.erJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpSize:").append(this.erK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpDuration:").append(this.erL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpVideoBitrate:").append(this.erM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpAudioiBitrate:").append(this.erN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpFps:").append(this.erO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpWidth:").append(this.erP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpHeight:").append(this.erQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SendScene:").append(this.eiS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.dUP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalAudioChannel:").append(this.dUQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsUrl:").append(this.dUD);
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
 * Qualified Name:     com.tencent.mm.g.b.a.gu
 * JD-Core Version:    0.7.0.1
 */