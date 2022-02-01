package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ft
  extends a
{
  private String dUF = "";
  public long dUG = 0L;
  public long dUH = 0L;
  public long dUI = 0L;
  public long dUJ = 0L;
  public long dUK = 0L;
  public long dUL = 0L;
  public long dUM = 0L;
  public long dUN = 0L;
  public long dUO = 0L;
  private String dUP = "";
  public long dUQ = 0L;
  public long dUR = 0L;
  public long dUS = 0L;
  private String env = "";
  private String enw = "";
  
  public final String RC()
  {
    AppMethodBeat.i(126699);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.env);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUS);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(126699);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(126700);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Tid:").append(this.env);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoUrl:").append(this.enw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMd5:").append(this.dUF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadStartTime:").append(this.dUG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadEndTime:").append(this.dUH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoSize:").append(this.dUI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoDuration:").append(this.dUJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoBitrate:").append(this.dUK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AudioBitrate:").append(this.dUL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoFps:").append(this.dUM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoWidth:").append(this.dUN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoHeight:").append(this.dUO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.dUP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalAudioChannel:").append(this.dUQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadSize:").append(this.dUR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadCompletion:").append(this.dUS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(126700);
    return localObject;
  }
  
  public final int getId()
  {
    return 16665;
  }
  
  public final ft kL(long paramLong)
  {
    this.dUG = paramLong;
    return this;
  }
  
  public final ft kM(long paramLong)
  {
    this.dUH = paramLong;
    return this;
  }
  
  public final ft kN(long paramLong)
  {
    this.dUI = paramLong;
    return this;
  }
  
  public final ft kO(long paramLong)
  {
    this.dUJ = paramLong;
    return this;
  }
  
  public final ft kP(long paramLong)
  {
    this.dUK = paramLong;
    return this;
  }
  
  public final ft kQ(long paramLong)
  {
    this.dUL = paramLong;
    return this;
  }
  
  public final ft kR(long paramLong)
  {
    this.dUM = paramLong;
    return this;
  }
  
  public final ft kS(long paramLong)
  {
    this.dUN = paramLong;
    return this;
  }
  
  public final ft kT(long paramLong)
  {
    this.dUO = paramLong;
    return this;
  }
  
  public final ft kU(long paramLong)
  {
    this.dUQ = paramLong;
    return this;
  }
  
  public final ft kV(long paramLong)
  {
    this.dUR = paramLong;
    return this;
  }
  
  public final ft kW(long paramLong)
  {
    this.dUS = paramLong;
    return this;
  }
  
  public final ft pb(String paramString)
  {
    AppMethodBeat.i(126696);
    this.enw = t("VideoUrl", paramString, true);
    AppMethodBeat.o(126696);
    return this;
  }
  
  public final ft pc(String paramString)
  {
    AppMethodBeat.i(126697);
    this.dUF = t("NewMd5", paramString, true);
    AppMethodBeat.o(126697);
    return this;
  }
  
  public final ft pd(String paramString)
  {
    AppMethodBeat.i(126698);
    this.dUP = t("CDNIp", paramString, true);
    AppMethodBeat.o(126698);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ft
 * JD-Core Version:    0.7.0.1
 */