package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class de
  extends a
{
  private String dIi = "";
  public long dIj = 0L;
  public long dIk = 0L;
  public long dIl = 0L;
  public long dIm = 0L;
  public long dIn = 0L;
  public long dIo = 0L;
  public long dIp = 0L;
  public long dIq = 0L;
  public long dIr = 0L;
  private String dIs = "";
  public long dIt = 0L;
  public long dIu = 0L;
  public long dIv = 0L;
  private String dTJ = "";
  private String dTK = "";
  
  public final String PV()
  {
    AppMethodBeat.i(126699);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIv);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(126699);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(126700);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Tid:").append(this.dTJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoUrl:").append(this.dTK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMd5:").append(this.dIi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadStartTime:").append(this.dIj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadEndTime:").append(this.dIk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoSize:").append(this.dIl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoDuration:").append(this.dIm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoBitrate:").append(this.dIn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AudioBitrate:").append(this.dIo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoFps:").append(this.dIp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoWidth:").append(this.dIq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoHeight:").append(this.dIr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.dIs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalAudioChannel:").append(this.dIt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadSize:").append(this.dIu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadCompletion:").append(this.dIv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(126700);
    return localObject;
  }
  
  public final de fB(long paramLong)
  {
    this.dIj = paramLong;
    return this;
  }
  
  public final de fC(long paramLong)
  {
    this.dIk = paramLong;
    return this;
  }
  
  public final de fD(long paramLong)
  {
    this.dIl = paramLong;
    return this;
  }
  
  public final de fE(long paramLong)
  {
    this.dIm = paramLong;
    return this;
  }
  
  public final de fF(long paramLong)
  {
    this.dIn = paramLong;
    return this;
  }
  
  public final de fG(long paramLong)
  {
    this.dIo = paramLong;
    return this;
  }
  
  public final de fH(long paramLong)
  {
    this.dIp = paramLong;
    return this;
  }
  
  public final de fI(long paramLong)
  {
    this.dIq = paramLong;
    return this;
  }
  
  public final de fJ(long paramLong)
  {
    this.dIr = paramLong;
    return this;
  }
  
  public final de fK(long paramLong)
  {
    this.dIt = paramLong;
    return this;
  }
  
  public final de fL(long paramLong)
  {
    this.dIu = paramLong;
    return this;
  }
  
  public final de fM(long paramLong)
  {
    this.dIv = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 16665;
  }
  
  public final de jD(String paramString)
  {
    AppMethodBeat.i(126696);
    this.dTK = t("VideoUrl", paramString, true);
    AppMethodBeat.o(126696);
    return this;
  }
  
  public final de jE(String paramString)
  {
    AppMethodBeat.i(126697);
    this.dIi = t("NewMd5", paramString, true);
    AppMethodBeat.o(126697);
    return this;
  }
  
  public final de jF(String paramString)
  {
    AppMethodBeat.i(126698);
    this.dIs = t("CDNIp", paramString, true);
    AppMethodBeat.o(126698);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.de
 * JD-Core Version:    0.7.0.1
 */