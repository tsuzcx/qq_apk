package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class lq
  extends a
{
  private long iUM;
  private String irB;
  private String irF;
  private String irk;
  private String irl;
  private String irn;
  private String iro;
  private String irq;
  private long irs;
  private long irt;
  private long jag;
  private int jah;
  private long jai;
  private long jaj;
  
  public lq()
  {
    this.irs = 0L;
    this.irt = 0L;
    this.jag = 0L;
    this.irq = "";
    this.iUM = 0L;
    this.jah = 0;
    this.jai = 0L;
    this.irB = "";
    this.irk = "";
    this.irl = "";
    this.jaj = 0L;
    this.irn = "";
    this.iro = "";
    this.irF = "";
  }
  
  public lq(String paramString)
  {
    AppMethodBeat.i(126687);
    this.irs = 0L;
    this.irt = 0L;
    this.jag = 0L;
    this.irq = "";
    this.iUM = 0L;
    this.jah = 0;
    this.jai = 0L;
    this.irB = "";
    this.irk = "";
    this.irl = "";
    this.jaj = 0L;
    this.irn = "";
    this.iro = "";
    this.irF = "";
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 14) {
          break label323;
        }
        String[] arrayOfString = new String[14];
        Arrays.fill(arrayOfString, 0, 14, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label323:
    for (;;)
    {
      this.irs = Util.getLong(paramString[0], 0L);
      this.irt = Util.getLong(paramString[1], 0L);
      this.jag = Util.getLong(paramString[2], 0L);
      this.irq = F("NewMd5", paramString[3], true);
      this.iUM = Util.getLong(paramString[4], 0L);
      this.jah = Util.getInt(paramString[5], 0);
      this.jai = Util.getLong(paramString[6], 0L);
      this.irB = F("CDNIp", paramString[7], true);
      this.irk = F("FromUser", paramString[8], true);
      this.irl = F("Session", paramString[9], true);
      this.jaj = Util.getLong(paramString[10], 0L);
      this.irn = F("FileId", paramString[11], true);
      this.iro = F("SnsUrl", paramString[12], true);
      this.irF = F("Publishid", paramString[13], true);
      AppMethodBeat.o(126687);
      return;
    }
  }
  
  public final String aIE()
  {
    AppMethodBeat.i(126688);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.irs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jah);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jai);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iro);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irF);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(126688);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(126689);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("DownloadStartTime:").append(this.irs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadEndTime:").append(this.irt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadSize:").append(this.jag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMd5:").append(this.irq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgType:").append(this.iUM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadSpeed:").append(this.jah);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadFinishSize:").append(this.jai);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.irB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FromUser:").append(this.irk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Session:").append(this.irl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatroomNum:").append(this.jaj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileId:").append(this.irn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsUrl:").append(this.iro);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Publishid:").append(this.irF);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(126689);
    return localObject;
  }
  
  public final int getId()
  {
    return 14499;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.lq
 * JD-Core Version:    0.7.0.1
 */