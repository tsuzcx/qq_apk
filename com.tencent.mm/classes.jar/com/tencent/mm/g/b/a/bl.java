package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Arrays;

public final class bl
  extends a
{
  private String cQB;
  private int cQC;
  private String cQD;
  private String cQN;
  private long cQO;
  private long cTZ;
  private String cXA;
  private String cXB;
  private long cXC;
  private long cXD;
  private long cXE;
  private long cXF;
  private long cXG;
  private long cXH;
  private long cXI;
  private int cXJ;
  private long cXK;
  private long cXL;
  private long cXM;
  private long cXN;
  private long cXO;
  private long cXP;
  private long cXQ;
  private long cXd;
  private long cXe;
  private String cXy;
  private String cXz;
  
  public bl()
  {
    this.cXy = "";
    this.cXz = "";
    this.cQC = 0;
    this.cXA = "";
    this.cQD = "";
    this.cXB = "";
    this.cXd = 0L;
    this.cXe = 0L;
    this.cXC = 0L;
    this.cXD = 0L;
    this.cXE = 0L;
    this.cXF = 0L;
    this.cXG = 0L;
    this.cXH = 0L;
    this.cXI = 0L;
    this.cXJ = 0;
    this.cXK = 0L;
    this.cXL = 0L;
    this.cXM = 0L;
    this.cXN = 0L;
    this.cXO = 0L;
    this.cXP = 0L;
    this.cXQ = 0L;
    this.cTZ = 0L;
    this.cQN = "";
    this.cQO = 0L;
    this.cQB = "";
  }
  
  public bl(String paramString)
  {
    AppMethodBeat.i(50548);
    this.cXy = "";
    this.cXz = "";
    this.cQC = 0;
    this.cXA = "";
    this.cQD = "";
    this.cXB = "";
    this.cXd = 0L;
    this.cXe = 0L;
    this.cXC = 0L;
    this.cXD = 0L;
    this.cXE = 0L;
    this.cXF = 0L;
    this.cXG = 0L;
    this.cXH = 0L;
    this.cXI = 0L;
    this.cXJ = 0;
    this.cXK = 0L;
    this.cXL = 0L;
    this.cXM = 0L;
    this.cXN = 0L;
    this.cXO = 0L;
    this.cXP = 0L;
    this.cXQ = 0L;
    this.cTZ = 0L;
    this.cQN = "";
    this.cQO = 0L;
    this.cQB = "";
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
      this.cXy = t("ToUser", paramString[0], true);
      this.cXz = t("MsgSource", paramString[1], true);
      this.cQC = bo.getInt(paramString[2], 0);
      this.cXA = t("FieldId", paramString[3], true);
      this.cQD = t("NewMd5", paramString[4], true);
      this.cXB = t("SnsInfoId", paramString[5], true);
      this.cXd = bo.getLong(paramString[6], 0L);
      this.cXe = bo.getLong(paramString[7], 0L);
      this.cXC = bo.getLong(paramString[8], 0L);
      this.cXD = bo.getLong(paramString[9], 0L);
      this.cXE = bo.getLong(paramString[10], 0L);
      this.cXF = bo.getLong(paramString[11], 0L);
      this.cXG = bo.getLong(paramString[12], 0L);
      this.cXH = bo.getLong(paramString[13], 0L);
      this.cXI = bo.getLong(paramString[14], 0L);
      this.cXJ = bo.getInt(paramString[15], 0);
      this.cXK = bo.getLong(paramString[16], 0L);
      this.cXL = bo.getLong(paramString[17], 0L);
      this.cXM = bo.getLong(paramString[18], 0L);
      this.cXN = bo.getLong(paramString[19], 0L);
      this.cXO = bo.getLong(paramString[20], 0L);
      this.cXP = bo.getLong(paramString[21], 0L);
      this.cXQ = bo.getLong(paramString[22], 0L);
      this.cTZ = bo.getLong(paramString[23], 0L);
      this.cQN = t("CDNIp", paramString[24], true);
      this.cQO = bo.getLong(paramString[25], 0L);
      this.cQB = t("SnsUrl", paramString[26], true);
      AppMethodBeat.o(50548);
      return;
    }
  }
  
  public final String Ff()
  {
    AppMethodBeat.i(50549);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cXy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cXz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cXA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cXB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cXd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cXe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cXC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cXD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cXE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cXF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cXG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cXH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cXI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cXJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cXK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cXL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cXM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cXN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cXO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cXP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cXQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQB);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(50549);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(50550);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ToUser:").append(this.cXy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgSource:").append(this.cXz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetType:").append(this.cQC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FieldId:").append(this.cXA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMd5:").append(this.cQD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsInfoId:").append(this.cXB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadStartTime:").append(this.cXd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadEndTime:").append(this.cXe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalSize:").append(this.cXC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalDuration:").append(this.cXD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalVideoBitrate:").append(this.cXE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalAudioBitrate:").append(this.cXF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalFps:").append(this.cXG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalWidth:").append(this.cXH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalHeight:").append(this.cXI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpStatus:").append(this.cXJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpSize:").append(this.cXK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpDuration:").append(this.cXL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpVideoBitrate:").append(this.cXM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpAudioiBitrate:").append(this.cXN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpFps:").append(this.cXO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpWidth:").append(this.cXP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpHeight:").append(this.cXQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SendScene:").append(this.cTZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.cQN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalAudioChannel:").append(this.cQO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsUrl:").append(this.cQB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(50550);
    return localObject;
  }
  
  public final int getId()
  {
    return 13794;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bl
 * JD-Core Version:    0.7.0.1
 */