package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class qh
  extends a
{
  private String iNR;
  private String irB;
  private long irC;
  private String iro;
  private int irp;
  private String irq;
  private long jau;
  private long jhB;
  private long jlo;
  private long jlp;
  private long jrA;
  private long jrB;
  private long jrC;
  private long jrD;
  private long jrE;
  private long jrF;
  private long jrG;
  private String jro;
  private String jrp;
  private String jrq;
  private long jrr;
  private long jrs;
  private long jrt;
  private long jru;
  private long jrv;
  private long jrw;
  private long jrx;
  private int jry;
  private long jrz;
  
  public qh()
  {
    this.iNR = "";
    this.jro = "";
    this.irp = 0;
    this.jrp = "";
    this.irq = "";
    this.jrq = "";
    this.jlo = 0L;
    this.jlp = 0L;
    this.jrr = 0L;
    this.jrs = 0L;
    this.jrt = 0L;
    this.jru = 0L;
    this.jrv = 0L;
    this.jrw = 0L;
    this.jrx = 0L;
    this.jry = 0;
    this.jrz = 0L;
    this.jrA = 0L;
    this.jrB = 0L;
    this.jrC = 0L;
    this.jrD = 0L;
    this.jrE = 0L;
    this.jrF = 0L;
    this.jau = 0L;
    this.irB = "";
    this.irC = 0L;
    this.iro = "";
    this.jrG = 0L;
    this.jhB = 0L;
  }
  
  public qh(String paramString)
  {
    AppMethodBeat.i(126701);
    this.iNR = "";
    this.jro = "";
    this.irp = 0;
    this.jrp = "";
    this.irq = "";
    this.jrq = "";
    this.jlo = 0L;
    this.jlp = 0L;
    this.jrr = 0L;
    this.jrs = 0L;
    this.jrt = 0L;
    this.jru = 0L;
    this.jrv = 0L;
    this.jrw = 0L;
    this.jrx = 0L;
    this.jry = 0;
    this.jrz = 0L;
    this.jrA = 0L;
    this.jrB = 0L;
    this.jrC = 0L;
    this.jrD = 0L;
    this.jrE = 0L;
    this.jrF = 0L;
    this.jau = 0L;
    this.irB = "";
    this.irC = 0L;
    this.iro = "";
    this.jrG = 0L;
    this.jhB = 0L;
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 29) {
          break label578;
        }
        String[] arrayOfString = new String[29];
        Arrays.fill(arrayOfString, 0, 29, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label578:
    for (;;)
    {
      this.iNR = F("ToUser", paramString[0], true);
      this.jro = F("MsgSource", paramString[1], true);
      this.irp = Util.getInt(paramString[2], 0);
      this.jrp = F("FieldId", paramString[3], true);
      this.irq = F("NewMd5", paramString[4], true);
      this.jrq = F("SnsInfoId", paramString[5], true);
      this.jlo = Util.getLong(paramString[6], 0L);
      this.jlp = Util.getLong(paramString[7], 0L);
      this.jrr = Util.getLong(paramString[8], 0L);
      this.jrs = Util.getLong(paramString[9], 0L);
      this.jrt = Util.getLong(paramString[10], 0L);
      this.jru = Util.getLong(paramString[11], 0L);
      this.jrv = Util.getLong(paramString[12], 0L);
      this.jrw = Util.getLong(paramString[13], 0L);
      this.jrx = Util.getLong(paramString[14], 0L);
      this.jry = Util.getInt(paramString[15], 0);
      this.jrz = Util.getLong(paramString[16], 0L);
      this.jrA = Util.getLong(paramString[17], 0L);
      this.jrB = Util.getLong(paramString[18], 0L);
      this.jrC = Util.getLong(paramString[19], 0L);
      this.jrD = Util.getLong(paramString[20], 0L);
      this.jrE = Util.getLong(paramString[21], 0L);
      this.jrF = Util.getLong(paramString[22], 0L);
      this.jau = Util.getLong(paramString[23], 0L);
      this.irB = F("CDNIp", paramString[24], true);
      this.irC = Util.getLong(paramString[25], 0L);
      this.iro = F("SnsUrl", paramString[26], true);
      this.jrG = Util.getLong(paramString[27], 0L);
      this.jhB = Util.getLong(paramString[28], 0L);
      AppMethodBeat.o(126701);
      return;
    }
  }
  
  public final String aIE()
  {
    AppMethodBeat.i(126702);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iNR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jro);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jru);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jry);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jau);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iro);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jhB);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(126702);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(126703);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ToUser:").append(this.iNR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgSource:").append(this.jro);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetType:").append(this.irp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FieldId:").append(this.jrp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMd5:").append(this.irq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsInfoId:").append(this.jrq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadStartTime:").append(this.jlo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadEndTime:").append(this.jlp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalSize:").append(this.jrr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalDuration:").append(this.jrs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalVideoBitrate:").append(this.jrt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalAudioBitrate:").append(this.jru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalFps:").append(this.jrv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalWidth:").append(this.jrw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalHeight:").append(this.jrx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpStatus:").append(this.jry);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpSize:").append(this.jrz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpDuration:").append(this.jrA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpVideoBitrate:").append(this.jrB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpAudioiBitrate:").append(this.jrC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpFps:").append(this.jrD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpWidth:").append(this.jrE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpHeight:").append(this.jrF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SendScene:").append(this.jau);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.irB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalAudioChannel:").append(this.irC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsUrl:").append(this.iro);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("upload_speed:").append(this.jrG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("upload_time:").append(this.jhB);
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
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.qh
 * JD-Core Version:    0.7.0.1
 */