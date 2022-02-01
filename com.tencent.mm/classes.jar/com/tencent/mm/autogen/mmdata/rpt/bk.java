package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class bk
  extends a
{
  private long irA;
  private String irB;
  private long irC;
  private long irD;
  private long irE;
  private String irF;
  private String irk;
  private String irl;
  private long irm;
  private String irn;
  private String iro;
  private int irp;
  private String irq;
  private long irs;
  private long irt;
  private long iru;
  private long irv;
  private long irw;
  private long irx;
  private long iry;
  private long irz;
  
  public bk()
  {
    this.irk = "";
    this.irl = "";
    this.irm = 0L;
    this.irn = "";
    this.iro = "";
    this.irp = 0;
    this.irq = "";
    this.irs = 0L;
    this.irt = 0L;
    this.iru = 0L;
    this.irv = 0L;
    this.irw = 0L;
    this.irx = 0L;
    this.iry = 0L;
    this.irz = 0L;
    this.irA = 0L;
    this.irB = "";
    this.irC = 0L;
    this.irD = 0L;
    this.irE = 0L;
    this.irF = "";
  }
  
  public bk(String paramString)
  {
    AppMethodBeat.i(126681);
    this.irk = "";
    this.irl = "";
    this.irm = 0L;
    this.irn = "";
    this.iro = "";
    this.irp = 0;
    this.irq = "";
    this.irs = 0L;
    this.irt = 0L;
    this.iru = 0L;
    this.irv = 0L;
    this.irw = 0L;
    this.irx = 0L;
    this.iry = 0L;
    this.irz = 0L;
    this.irA = 0L;
    this.irB = "";
    this.irC = 0L;
    this.irD = 0L;
    this.irE = 0L;
    this.irF = "";
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
      this.irk = F("FromUser", paramString[0], true);
      this.irl = F("Session", paramString[1], true);
      this.irm = Util.getLong(paramString[2], 0L);
      this.irn = F("FileId", paramString[3], true);
      this.iro = F("SnsUrl", paramString[4], true);
      this.irp = Util.getInt(paramString[5], 0);
      this.irq = F("NewMd5", paramString[6], true);
      this.irs = Util.getLong(paramString[7], 0L);
      this.irt = Util.getLong(paramString[8], 0L);
      this.iru = Util.getLong(paramString[9], 0L);
      this.irv = Util.getLong(paramString[10], 0L);
      this.irw = Util.getLong(paramString[11], 0L);
      this.irx = Util.getLong(paramString[12], 0L);
      this.iry = Util.getLong(paramString[13], 0L);
      this.irz = Util.getLong(paramString[14], 0L);
      this.irA = Util.getLong(paramString[15], 0L);
      this.irB = F("CDNIp", paramString[16], true);
      this.irC = Util.getLong(paramString[17], 0L);
      this.irD = Util.getLong(paramString[18], 0L);
      this.irE = Util.getLong(paramString[19], 0L);
      this.irF = F("Publishid", paramString[20], true);
      AppMethodBeat.o(126681);
      return;
    }
  }
  
  public final String aIE()
  {
    AppMethodBeat.i(126682);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.irk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iro);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iru);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iry);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irF);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(126682);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(126683);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FromUser:").append(this.irk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Session:").append(this.irl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatNum:").append(this.irm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileId:").append(this.irn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsUrl:").append(this.iro);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetType:").append(this.irp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMd5:").append(this.irq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadStartTime:").append(this.irs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadEndTime:").append(this.irt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoSize:").append(this.iru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoDuration:").append(this.irv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoBitrate:").append(this.irw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AudioBitrate:").append(this.irx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoFps:").append(this.iry);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoWidth:").append(this.irz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoHeight:").append(this.irA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.irB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalAudioChannel:").append(this.irC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadSize:").append(this.irD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadCompletion:").append(this.irE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Publishid:").append(this.irF);
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
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.bk
 * JD-Core Version:    0.7.0.1
 */