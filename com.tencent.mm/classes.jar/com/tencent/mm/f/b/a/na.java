package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class na
  extends a
{
  private String gBa;
  private long gKZ;
  private long gSS;
  private long gST;
  private long gXA;
  private long gXB;
  private long gXC;
  private int gXD;
  private long gXE;
  private long gXF;
  private long gXG;
  private long gXH;
  private long gXI;
  private long gXJ;
  private long gXK;
  private String gXt;
  private String gXu;
  private String gXv;
  private long gXw;
  private long gXx;
  private long gXy;
  private long gXz;
  private String gkc;
  private int gkd;
  private String gke;
  private String gko;
  private long gkp;
  
  public na()
  {
    this.gBa = "";
    this.gXt = "";
    this.gkd = 0;
    this.gXu = "";
    this.gke = "";
    this.gXv = "";
    this.gSS = 0L;
    this.gST = 0L;
    this.gXw = 0L;
    this.gXx = 0L;
    this.gXy = 0L;
    this.gXz = 0L;
    this.gXA = 0L;
    this.gXB = 0L;
    this.gXC = 0L;
    this.gXD = 0;
    this.gXE = 0L;
    this.gXF = 0L;
    this.gXG = 0L;
    this.gXH = 0L;
    this.gXI = 0L;
    this.gXJ = 0L;
    this.gXK = 0L;
    this.gKZ = 0L;
    this.gko = "";
    this.gkp = 0L;
    this.gkc = "";
  }
  
  public na(String paramString)
  {
    AppMethodBeat.i(126701);
    this.gBa = "";
    this.gXt = "";
    this.gkd = 0;
    this.gXu = "";
    this.gke = "";
    this.gXv = "";
    this.gSS = 0L;
    this.gST = 0L;
    this.gXw = 0L;
    this.gXx = 0L;
    this.gXy = 0L;
    this.gXz = 0L;
    this.gXA = 0L;
    this.gXB = 0L;
    this.gXC = 0L;
    this.gXD = 0;
    this.gXE = 0L;
    this.gXF = 0L;
    this.gXG = 0L;
    this.gXH = 0L;
    this.gXI = 0L;
    this.gXJ = 0L;
    this.gXK = 0L;
    this.gKZ = 0L;
    this.gko = "";
    this.gkp = 0L;
    this.gkc = "";
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
      this.gBa = z("ToUser", paramString[0], true);
      this.gXt = z("MsgSource", paramString[1], true);
      this.gkd = Util.getInt(paramString[2], 0);
      this.gXu = z("FieldId", paramString[3], true);
      this.gke = z("NewMd5", paramString[4], true);
      this.gXv = z("SnsInfoId", paramString[5], true);
      this.gSS = Util.getLong(paramString[6], 0L);
      this.gST = Util.getLong(paramString[7], 0L);
      this.gXw = Util.getLong(paramString[8], 0L);
      this.gXx = Util.getLong(paramString[9], 0L);
      this.gXy = Util.getLong(paramString[10], 0L);
      this.gXz = Util.getLong(paramString[11], 0L);
      this.gXA = Util.getLong(paramString[12], 0L);
      this.gXB = Util.getLong(paramString[13], 0L);
      this.gXC = Util.getLong(paramString[14], 0L);
      this.gXD = Util.getInt(paramString[15], 0);
      this.gXE = Util.getLong(paramString[16], 0L);
      this.gXF = Util.getLong(paramString[17], 0L);
      this.gXG = Util.getLong(paramString[18], 0L);
      this.gXH = Util.getLong(paramString[19], 0L);
      this.gXI = Util.getLong(paramString[20], 0L);
      this.gXJ = Util.getLong(paramString[21], 0L);
      this.gXK = Util.getLong(paramString[22], 0L);
      this.gKZ = Util.getLong(paramString[23], 0L);
      this.gko = z("CDNIp", paramString[24], true);
      this.gkp = Util.getLong(paramString[25], 0L);
      this.gkc = z("SnsUrl", paramString[26], true);
      AppMethodBeat.o(126701);
      return;
    }
  }
  
  public final String agH()
  {
    AppMethodBeat.i(126702);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gBa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gXt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gXu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gke);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gXv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gST);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gXw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gXx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gXy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gXz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gXA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gXB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gXC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gXD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gXE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gXF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gXG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gXH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gXI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gXJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gXK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gko);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkc);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(126702);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(126703);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ToUser:").append(this.gBa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgSource:").append(this.gXt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetType:").append(this.gkd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FieldId:").append(this.gXu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMd5:").append(this.gke);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsInfoId:").append(this.gXv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadStartTime:").append(this.gSS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadEndTime:").append(this.gST);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalSize:").append(this.gXw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalDuration:").append(this.gXx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalVideoBitrate:").append(this.gXy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalAudioBitrate:").append(this.gXz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalFps:").append(this.gXA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalWidth:").append(this.gXB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalHeight:").append(this.gXC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpStatus:").append(this.gXD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpSize:").append(this.gXE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpDuration:").append(this.gXF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpVideoBitrate:").append(this.gXG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpAudioiBitrate:").append(this.gXH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpFps:").append(this.gXI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpWidth:").append(this.gXJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpHeight:").append(this.gXK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SendScene:").append(this.gKZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.gko);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalAudioChannel:").append(this.gkp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsUrl:").append(this.gkc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(126703);
    return localObject;
  }
  
  public final int getId()
  {
    return 13794;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.na
 * JD-Core Version:    0.7.0.1
 */