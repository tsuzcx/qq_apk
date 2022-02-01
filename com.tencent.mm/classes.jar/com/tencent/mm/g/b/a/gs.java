package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Arrays;

public final class gs
  extends a
{
  private long dTA;
  private String dTn;
  private int dTo;
  private String dTp;
  private String dTz;
  private long ehi;
  private long enl;
  private long enm;
  private String epR;
  private String epS;
  private String epT;
  private String epU;
  private long epV;
  private long epW;
  private long epX;
  private long epY;
  private long epZ;
  private long eqa;
  private long eqb;
  private int eqc;
  private long eqd;
  private long eqe;
  private long eqf;
  private long eqg;
  private long eqh;
  private long eqi;
  private long eqj;
  
  public gs()
  {
    this.epR = "";
    this.epS = "";
    this.dTo = 0;
    this.epT = "";
    this.dTp = "";
    this.epU = "";
    this.enl = 0L;
    this.enm = 0L;
    this.epV = 0L;
    this.epW = 0L;
    this.epX = 0L;
    this.epY = 0L;
    this.epZ = 0L;
    this.eqa = 0L;
    this.eqb = 0L;
    this.eqc = 0;
    this.eqd = 0L;
    this.eqe = 0L;
    this.eqf = 0L;
    this.eqg = 0L;
    this.eqh = 0L;
    this.eqi = 0L;
    this.eqj = 0L;
    this.ehi = 0L;
    this.dTz = "";
    this.dTA = 0L;
    this.dTn = "";
  }
  
  public gs(String paramString)
  {
    AppMethodBeat.i(126701);
    this.epR = "";
    this.epS = "";
    this.dTo = 0;
    this.epT = "";
    this.dTp = "";
    this.epU = "";
    this.enl = 0L;
    this.enm = 0L;
    this.epV = 0L;
    this.epW = 0L;
    this.epX = 0L;
    this.epY = 0L;
    this.epZ = 0L;
    this.eqa = 0L;
    this.eqb = 0L;
    this.eqc = 0;
    this.eqd = 0L;
    this.eqe = 0L;
    this.eqf = 0L;
    this.eqg = 0L;
    this.eqh = 0L;
    this.eqi = 0L;
    this.eqj = 0L;
    this.ehi = 0L;
    this.dTz = "";
    this.dTA = 0L;
    this.dTn = "";
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
      this.epR = t("ToUser", paramString[0], true);
      this.epS = t("MsgSource", paramString[1], true);
      this.dTo = bt.getInt(paramString[2], 0);
      this.epT = t("FieldId", paramString[3], true);
      this.dTp = t("NewMd5", paramString[4], true);
      this.epU = t("SnsInfoId", paramString[5], true);
      this.enl = bt.getLong(paramString[6], 0L);
      this.enm = bt.getLong(paramString[7], 0L);
      this.epV = bt.getLong(paramString[8], 0L);
      this.epW = bt.getLong(paramString[9], 0L);
      this.epX = bt.getLong(paramString[10], 0L);
      this.epY = bt.getLong(paramString[11], 0L);
      this.epZ = bt.getLong(paramString[12], 0L);
      this.eqa = bt.getLong(paramString[13], 0L);
      this.eqb = bt.getLong(paramString[14], 0L);
      this.eqc = bt.getInt(paramString[15], 0);
      this.eqd = bt.getLong(paramString[16], 0L);
      this.eqe = bt.getLong(paramString[17], 0L);
      this.eqf = bt.getLong(paramString[18], 0L);
      this.eqg = bt.getLong(paramString[19], 0L);
      this.eqh = bt.getLong(paramString[20], 0L);
      this.eqi = bt.getLong(paramString[21], 0L);
      this.eqj = bt.getLong(paramString[22], 0L);
      this.ehi = bt.getLong(paramString[23], 0L);
      this.dTz = t("CDNIp", paramString[24], true);
      this.dTA = bt.getLong(paramString[25], 0L);
      this.dTn = t("SnsUrl", paramString[26], true);
      AppMethodBeat.o(126701);
      return;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(126702);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.epR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTn);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(126702);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(126703);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ToUser:").append(this.epR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgSource:").append(this.epS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetType:").append(this.dTo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FieldId:").append(this.epT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMd5:").append(this.dTp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsInfoId:").append(this.epU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadStartTime:").append(this.enl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadEndTime:").append(this.enm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalSize:").append(this.epV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalDuration:").append(this.epW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalVideoBitrate:").append(this.epX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalAudioBitrate:").append(this.epY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalFps:").append(this.epZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalWidth:").append(this.eqa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalHeight:").append(this.eqb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpStatus:").append(this.eqc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpSize:").append(this.eqd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpDuration:").append(this.eqe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpVideoBitrate:").append(this.eqf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpAudioiBitrate:").append(this.eqg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpFps:").append(this.eqh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpWidth:").append(this.eqi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpHeight:").append(this.eqj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SendScene:").append(this.ehi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.dTz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalAudioChannel:").append(this.dTA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsUrl:").append(this.dTn);
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
 * Qualified Name:     com.tencent.mm.g.b.a.gs
 * JD-Core Version:    0.7.0.1
 */