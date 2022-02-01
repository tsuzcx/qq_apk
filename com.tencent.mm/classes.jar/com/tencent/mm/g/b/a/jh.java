package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jh
  extends a
{
  private String eRb = "";
  private String eRc = "";
  private String eoR = "";
  public long eoS = 0L;
  public long eoT = 0L;
  public long eoU = 0L;
  public long eoV = 0L;
  public long eoW = 0L;
  public long eoX = 0L;
  public long eoY = 0L;
  public long eoZ = 0L;
  public long epa = 0L;
  private String epb = "";
  public long epc = 0L;
  public long epd = 0L;
  public long epe = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(126699);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eRb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epe);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(126699);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(126700);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Tid:").append(this.eRb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoUrl:").append(this.eRc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMd5:").append(this.eoR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadStartTime:").append(this.eoS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadEndTime:").append(this.eoT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoSize:").append(this.eoU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoDuration:").append(this.eoV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoBitrate:").append(this.eoW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AudioBitrate:").append(this.eoX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoFps:").append(this.eoY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoWidth:").append(this.eoZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoHeight:").append(this.epa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.epb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalAudioChannel:").append(this.epc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadSize:").append(this.epd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadCompletion:").append(this.epe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(126700);
    return localObject;
  }
  
  public final int getId()
  {
    return 16665;
  }
  
  public final jh rN(long paramLong)
  {
    this.eoS = paramLong;
    return this;
  }
  
  public final jh rO(long paramLong)
  {
    this.eoT = paramLong;
    return this;
  }
  
  public final jh rP(long paramLong)
  {
    this.eoU = paramLong;
    return this;
  }
  
  public final jh rQ(long paramLong)
  {
    this.eoV = paramLong;
    return this;
  }
  
  public final jh rR(long paramLong)
  {
    this.eoW = paramLong;
    return this;
  }
  
  public final jh rS(long paramLong)
  {
    this.eoX = paramLong;
    return this;
  }
  
  public final jh rT(long paramLong)
  {
    this.eoY = paramLong;
    return this;
  }
  
  public final jh rU(long paramLong)
  {
    this.eoZ = paramLong;
    return this;
  }
  
  public final jh rV(long paramLong)
  {
    this.epa = paramLong;
    return this;
  }
  
  public final jh rW(long paramLong)
  {
    this.epc = paramLong;
    return this;
  }
  
  public final jh rX(long paramLong)
  {
    this.epd = paramLong;
    return this;
  }
  
  public final jh rY(long paramLong)
  {
    this.epe = paramLong;
    return this;
  }
  
  public final jh wK(String paramString)
  {
    AppMethodBeat.i(126696);
    this.eRc = x("VideoUrl", paramString, true);
    AppMethodBeat.o(126696);
    return this;
  }
  
  public final jh wL(String paramString)
  {
    AppMethodBeat.i(126697);
    this.eoR = x("NewMd5", paramString, true);
    AppMethodBeat.o(126697);
    return this;
  }
  
  public final jh wM(String paramString)
  {
    AppMethodBeat.i(126698);
    this.epb = x("CDNIp", paramString, true);
    AppMethodBeat.o(126698);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jh
 * JD-Core Version:    0.7.0.1
 */