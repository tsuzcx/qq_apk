package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class au
  extends a
{
  private String cQD = "";
  public long cQE = 0L;
  public long cQF = 0L;
  public long cQG = 0L;
  public long cQH = 0L;
  public long cQI = 0L;
  public long cQJ = 0L;
  public long cQK = 0L;
  public long cQL = 0L;
  public long cQM = 0L;
  private String cQN = "";
  public long cQO = 0L;
  public long cQP = 0L;
  public long cQQ = 0L;
  private String cVI = "";
  private String cVJ = "";
  
  public final String Ff()
  {
    AppMethodBeat.i(50546);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cVI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQQ);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(50546);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(50547);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Tid:").append(this.cVI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoUrl:").append(this.cVJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMd5:").append(this.cQD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadStartTime:").append(this.cQE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadEndTime:").append(this.cQF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoSize:").append(this.cQG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoDuration:").append(this.cQH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoBitrate:").append(this.cQI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AudioBitrate:").append(this.cQJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoFps:").append(this.cQK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoWidth:").append(this.cQL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoHeight:").append(this.cQM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.cQN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalAudioChannel:").append(this.cQO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadSize:").append(this.cQP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadCompletion:").append(this.cQQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(50547);
    return localObject;
  }
  
  public final au bY(long paramLong)
  {
    this.cQE = paramLong;
    return this;
  }
  
  public final au bZ(long paramLong)
  {
    this.cQF = paramLong;
    return this;
  }
  
  public final au ca(long paramLong)
  {
    this.cQG = paramLong;
    return this;
  }
  
  public final au cb(long paramLong)
  {
    this.cQH = paramLong;
    return this;
  }
  
  public final au cc(long paramLong)
  {
    this.cQI = paramLong;
    return this;
  }
  
  public final au cd(long paramLong)
  {
    this.cQJ = paramLong;
    return this;
  }
  
  public final au ce(long paramLong)
  {
    this.cQK = paramLong;
    return this;
  }
  
  public final au cf(long paramLong)
  {
    this.cQL = paramLong;
    return this;
  }
  
  public final au cg(long paramLong)
  {
    this.cQM = paramLong;
    return this;
  }
  
  public final au ch(long paramLong)
  {
    this.cQO = paramLong;
    return this;
  }
  
  public final au ci(long paramLong)
  {
    this.cQP = paramLong;
    return this;
  }
  
  public final au cj(long paramLong)
  {
    this.cQQ = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 16665;
  }
  
  public final au gg(String paramString)
  {
    AppMethodBeat.i(50543);
    this.cVJ = t("VideoUrl", paramString, true);
    AppMethodBeat.o(50543);
    return this;
  }
  
  public final au gh(String paramString)
  {
    AppMethodBeat.i(50544);
    this.cQD = t("NewMd5", paramString, true);
    AppMethodBeat.o(50544);
    return this;
  }
  
  public final au gi(String paramString)
  {
    AppMethodBeat.i(50545);
    this.cQN = t("CDNIp", paramString, true);
    AppMethodBeat.o(50545);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.au
 * JD-Core Version:    0.7.0.1
 */