package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Arrays;

public final class eb
  extends a
{
  private String dIg;
  private int dIh;
  private String dIi;
  private String dIs;
  private long dIt;
  private long dPU;
  private long dVi;
  private long dVj;
  private String dXA;
  private String dXB;
  private String dXC;
  private long dXD;
  private long dXE;
  private long dXF;
  private long dXG;
  private long dXH;
  private long dXI;
  private long dXJ;
  private int dXK;
  private long dXL;
  private long dXM;
  private long dXN;
  private long dXO;
  private long dXP;
  private long dXQ;
  private long dXR;
  private String dXz;
  
  public eb()
  {
    this.dXz = "";
    this.dXA = "";
    this.dIh = 0;
    this.dXB = "";
    this.dIi = "";
    this.dXC = "";
    this.dVi = 0L;
    this.dVj = 0L;
    this.dXD = 0L;
    this.dXE = 0L;
    this.dXF = 0L;
    this.dXG = 0L;
    this.dXH = 0L;
    this.dXI = 0L;
    this.dXJ = 0L;
    this.dXK = 0;
    this.dXL = 0L;
    this.dXM = 0L;
    this.dXN = 0L;
    this.dXO = 0L;
    this.dXP = 0L;
    this.dXQ = 0L;
    this.dXR = 0L;
    this.dPU = 0L;
    this.dIs = "";
    this.dIt = 0L;
    this.dIg = "";
  }
  
  public eb(String paramString)
  {
    AppMethodBeat.i(126701);
    this.dXz = "";
    this.dXA = "";
    this.dIh = 0;
    this.dXB = "";
    this.dIi = "";
    this.dXC = "";
    this.dVi = 0L;
    this.dVj = 0L;
    this.dXD = 0L;
    this.dXE = 0L;
    this.dXF = 0L;
    this.dXG = 0L;
    this.dXH = 0L;
    this.dXI = 0L;
    this.dXJ = 0L;
    this.dXK = 0;
    this.dXL = 0L;
    this.dXM = 0L;
    this.dXN = 0L;
    this.dXO = 0L;
    this.dXP = 0L;
    this.dXQ = 0L;
    this.dXR = 0L;
    this.dPU = 0L;
    this.dIs = "";
    this.dIt = 0L;
    this.dIg = "";
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
      this.dXz = t("ToUser", paramString[0], true);
      this.dXA = t("MsgSource", paramString[1], true);
      this.dIh = bt.getInt(paramString[2], 0);
      this.dXB = t("FieldId", paramString[3], true);
      this.dIi = t("NewMd5", paramString[4], true);
      this.dXC = t("SnsInfoId", paramString[5], true);
      this.dVi = bt.getLong(paramString[6], 0L);
      this.dVj = bt.getLong(paramString[7], 0L);
      this.dXD = bt.getLong(paramString[8], 0L);
      this.dXE = bt.getLong(paramString[9], 0L);
      this.dXF = bt.getLong(paramString[10], 0L);
      this.dXG = bt.getLong(paramString[11], 0L);
      this.dXH = bt.getLong(paramString[12], 0L);
      this.dXI = bt.getLong(paramString[13], 0L);
      this.dXJ = bt.getLong(paramString[14], 0L);
      this.dXK = bt.getInt(paramString[15], 0);
      this.dXL = bt.getLong(paramString[16], 0L);
      this.dXM = bt.getLong(paramString[17], 0L);
      this.dXN = bt.getLong(paramString[18], 0L);
      this.dXO = bt.getLong(paramString[19], 0L);
      this.dXP = bt.getLong(paramString[20], 0L);
      this.dXQ = bt.getLong(paramString[21], 0L);
      this.dXR = bt.getLong(paramString[22], 0L);
      this.dPU = bt.getLong(paramString[23], 0L);
      this.dIs = t("CDNIp", paramString[24], true);
      this.dIt = bt.getLong(paramString[25], 0L);
      this.dIg = t("SnsUrl", paramString[26], true);
      AppMethodBeat.o(126701);
      return;
    }
  }
  
  public final String PV()
  {
    AppMethodBeat.i(126702);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dXz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIg);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(126702);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(126703);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ToUser:").append(this.dXz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgSource:").append(this.dXA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetType:").append(this.dIh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FieldId:").append(this.dXB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMd5:").append(this.dIi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsInfoId:").append(this.dXC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadStartTime:").append(this.dVi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadEndTime:").append(this.dVj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalSize:").append(this.dXD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalDuration:").append(this.dXE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalVideoBitrate:").append(this.dXF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalAudioBitrate:").append(this.dXG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalFps:").append(this.dXH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalWidth:").append(this.dXI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalHeight:").append(this.dXJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpStatus:").append(this.dXK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpSize:").append(this.dXL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpDuration:").append(this.dXM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpVideoBitrate:").append(this.dXN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpAudioiBitrate:").append(this.dXO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpFps:").append(this.dXP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpWidth:").append(this.dXQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpHeight:").append(this.dXR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SendScene:").append(this.dPU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.dIs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalAudioChannel:").append(this.dIt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsUrl:").append(this.dIg);
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
 * Qualified Name:     com.tencent.mm.g.b.a.eb
 * JD-Core Version:    0.7.0.1
 */