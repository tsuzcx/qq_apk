package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class es
  extends a
{
  private String dGk = "";
  public long dGl = 0L;
  public long dGm = 0L;
  public long dGn = 0L;
  public long dGo = 0L;
  public long dGp = 0L;
  public long dGq = 0L;
  public long dGr = 0L;
  public long dGs = 0L;
  public long dGt = 0L;
  private String dGu = "";
  public long dGv = 0L;
  public long dGw = 0L;
  public long dGx = 0L;
  private String dVv = "";
  private String dVw = "";
  
  public final String PR()
  {
    AppMethodBeat.i(126699);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dVv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGx);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(126699);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(126700);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Tid:").append(this.dVv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoUrl:").append(this.dVw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMd5:").append(this.dGk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadStartTime:").append(this.dGl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadEndTime:").append(this.dGm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoSize:").append(this.dGn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoDuration:").append(this.dGo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoBitrate:").append(this.dGp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AudioBitrate:").append(this.dGq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoFps:").append(this.dGr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoWidth:").append(this.dGs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoHeight:").append(this.dGt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.dGu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalAudioChannel:").append(this.dGv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadSize:").append(this.dGw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadCompletion:").append(this.dGx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(126700);
    return localObject;
  }
  
  public final int getId()
  {
    return 16665;
  }
  
  public final es iO(long paramLong)
  {
    this.dGl = paramLong;
    return this;
  }
  
  public final es iP(long paramLong)
  {
    this.dGm = paramLong;
    return this;
  }
  
  public final es iQ(long paramLong)
  {
    this.dGn = paramLong;
    return this;
  }
  
  public final es iR(long paramLong)
  {
    this.dGo = paramLong;
    return this;
  }
  
  public final es iS(long paramLong)
  {
    this.dGp = paramLong;
    return this;
  }
  
  public final es iT(long paramLong)
  {
    this.dGq = paramLong;
    return this;
  }
  
  public final es iU(long paramLong)
  {
    this.dGr = paramLong;
    return this;
  }
  
  public final es iV(long paramLong)
  {
    this.dGs = paramLong;
    return this;
  }
  
  public final es iW(long paramLong)
  {
    this.dGt = paramLong;
    return this;
  }
  
  public final es iX(long paramLong)
  {
    this.dGv = paramLong;
    return this;
  }
  
  public final es iY(long paramLong)
  {
    this.dGw = paramLong;
    return this;
  }
  
  public final es iZ(long paramLong)
  {
    this.dGx = paramLong;
    return this;
  }
  
  public final es mt(String paramString)
  {
    AppMethodBeat.i(126696);
    this.dVw = t("VideoUrl", paramString, true);
    AppMethodBeat.o(126696);
    return this;
  }
  
  public final es mu(String paramString)
  {
    AppMethodBeat.i(126697);
    this.dGk = t("NewMd5", paramString, true);
    AppMethodBeat.o(126697);
    return this;
  }
  
  public final es mv(String paramString)
  {
    AppMethodBeat.i(126698);
    this.dGu = t("CDNIp", paramString, true);
    AppMethodBeat.o(126698);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.es
 * JD-Core Version:    0.7.0.1
 */