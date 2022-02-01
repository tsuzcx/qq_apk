package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class oq
  extends a
{
  public long irA = 0L;
  private String irB = "";
  public long irC = 0L;
  public long irD = 0L;
  public long irE = 0L;
  private String irq = "";
  public long irs = 0L;
  public long irt = 0L;
  public long iru = 0L;
  public long irv = 0L;
  public long irw = 0L;
  public long irx = 0L;
  public long iry = 0L;
  public long irz = 0L;
  private String jjT = "";
  private String jjU = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(126699);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jjT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjU);
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
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(126699);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(126700);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Tid:").append(this.jjT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoUrl:").append(this.jjU);
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
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(126700);
    return localObject;
  }
  
  public final int getId()
  {
    return 16665;
  }
  
  public final oq wt(String paramString)
  {
    AppMethodBeat.i(126696);
    this.jjU = F("VideoUrl", paramString, true);
    AppMethodBeat.o(126696);
    return this;
  }
  
  public final oq wu(String paramString)
  {
    AppMethodBeat.i(126697);
    this.irq = F("NewMd5", paramString, true);
    AppMethodBeat.o(126697);
    return this;
  }
  
  public final oq wv(String paramString)
  {
    AppMethodBeat.i(126698);
    this.irB = F("CDNIp", paramString, true);
    AppMethodBeat.o(126698);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.oq
 * JD-Core Version:    0.7.0.1
 */