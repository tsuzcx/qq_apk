package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lq
  extends a
{
  private String gRx = "";
  private String gRy = "";
  private String gke = "";
  public long gkf = 0L;
  public long gkg = 0L;
  public long gkh = 0L;
  public long gki = 0L;
  public long gkj = 0L;
  public long gkk = 0L;
  public long gkl = 0L;
  public long gkm = 0L;
  public long gkn = 0L;
  private String gko = "";
  public long gkp = 0L;
  public long gkq = 0L;
  public long gkr = 0L;
  
  public final lq Cl(String paramString)
  {
    AppMethodBeat.i(126696);
    this.gRy = z("VideoUrl", paramString, true);
    AppMethodBeat.o(126696);
    return this;
  }
  
  public final lq Cm(String paramString)
  {
    AppMethodBeat.i(126697);
    this.gke = z("NewMd5", paramString, true);
    AppMethodBeat.o(126697);
    return this;
  }
  
  public final lq Cn(String paramString)
  {
    AppMethodBeat.i(126698);
    this.gko = z("CDNIp", paramString, true);
    AppMethodBeat.o(126698);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(126699);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gRx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gRy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gke);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gki);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gko);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkr);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(126699);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(126700);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Tid:").append(this.gRx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoUrl:").append(this.gRy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMd5:").append(this.gke);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadStartTime:").append(this.gkf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadEndTime:").append(this.gkg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoSize:").append(this.gkh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoDuration:").append(this.gki);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoBitrate:").append(this.gkj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AudioBitrate:").append(this.gkk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoFps:").append(this.gkl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoWidth:").append(this.gkm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoHeight:").append(this.gkn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.gko);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalAudioChannel:").append(this.gkp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadSize:").append(this.gkq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadCompletion:").append(this.gkr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(126700);
    return localObject;
  }
  
  public final int getId()
  {
    return 16665;
  }
  
  public final lq vP(long paramLong)
  {
    this.gkf = paramLong;
    return this;
  }
  
  public final lq vQ(long paramLong)
  {
    this.gkg = paramLong;
    return this;
  }
  
  public final lq vR(long paramLong)
  {
    this.gkh = paramLong;
    return this;
  }
  
  public final lq vS(long paramLong)
  {
    this.gki = paramLong;
    return this;
  }
  
  public final lq vT(long paramLong)
  {
    this.gkj = paramLong;
    return this;
  }
  
  public final lq vU(long paramLong)
  {
    this.gkk = paramLong;
    return this;
  }
  
  public final lq vV(long paramLong)
  {
    this.gkl = paramLong;
    return this;
  }
  
  public final lq vW(long paramLong)
  {
    this.gkm = paramLong;
    return this;
  }
  
  public final lq vX(long paramLong)
  {
    this.gkn = paramLong;
    return this;
  }
  
  public final lq vY(long paramLong)
  {
    this.gkp = paramLong;
    return this;
  }
  
  public final lq vZ(long paramLong)
  {
    this.gkq = paramLong;
    return this;
  }
  
  public final lq wa(long paramLong)
  {
    this.gkr = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.lq
 * JD-Core Version:    0.7.0.1
 */