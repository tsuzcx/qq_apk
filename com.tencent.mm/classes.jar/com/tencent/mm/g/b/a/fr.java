package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fr
  extends a
{
  public long dTA = 0L;
  public long dTB = 0L;
  public long dTC = 0L;
  private String dTp = "";
  public long dTq = 0L;
  public long dTr = 0L;
  public long dTs = 0L;
  public long dTt = 0L;
  public long dTu = 0L;
  public long dTv = 0L;
  public long dTw = 0L;
  public long dTx = 0L;
  public long dTy = 0L;
  private String dTz = "";
  private String elN = "";
  private String elO = "";
  
  public final String RD()
  {
    AppMethodBeat.i(126699);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.elN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTC);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(126699);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(126700);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Tid:").append(this.elN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoUrl:").append(this.elO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMd5:").append(this.dTp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadStartTime:").append(this.dTq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadEndTime:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoSize:").append(this.dTs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoDuration:").append(this.dTt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoBitrate:").append(this.dTu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AudioBitrate:").append(this.dTv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoFps:").append(this.dTw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoWidth:").append(this.dTx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoHeight:").append(this.dTy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.dTz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalAudioChannel:").append(this.dTA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadSize:").append(this.dTB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadCompletion:").append(this.dTC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(126700);
    return localObject;
  }
  
  public final int getId()
  {
    return 16665;
  }
  
  public final fr kA(long paramLong)
  {
    this.dTq = paramLong;
    return this;
  }
  
  public final fr kB(long paramLong)
  {
    this.dTr = paramLong;
    return this;
  }
  
  public final fr kC(long paramLong)
  {
    this.dTs = paramLong;
    return this;
  }
  
  public final fr kD(long paramLong)
  {
    this.dTt = paramLong;
    return this;
  }
  
  public final fr kE(long paramLong)
  {
    this.dTu = paramLong;
    return this;
  }
  
  public final fr kF(long paramLong)
  {
    this.dTv = paramLong;
    return this;
  }
  
  public final fr kG(long paramLong)
  {
    this.dTw = paramLong;
    return this;
  }
  
  public final fr kH(long paramLong)
  {
    this.dTx = paramLong;
    return this;
  }
  
  public final fr kI(long paramLong)
  {
    this.dTy = paramLong;
    return this;
  }
  
  public final fr kJ(long paramLong)
  {
    this.dTA = paramLong;
    return this;
  }
  
  public final fr kK(long paramLong)
  {
    this.dTB = paramLong;
    return this;
  }
  
  public final fr kL(long paramLong)
  {
    this.dTC = paramLong;
    return this;
  }
  
  public final fr oG(String paramString)
  {
    AppMethodBeat.i(126696);
    this.elO = t("VideoUrl", paramString, true);
    AppMethodBeat.o(126696);
    return this;
  }
  
  public final fr oH(String paramString)
  {
    AppMethodBeat.i(126697);
    this.dTp = t("NewMd5", paramString, true);
    AppMethodBeat.o(126697);
    return this;
  }
  
  public final fr oI(String paramString)
  {
    AppMethodBeat.i(126698);
    this.dTz = t("CDNIp", paramString, true);
    AppMethodBeat.o(126698);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fr
 * JD-Core Version:    0.7.0.1
 */