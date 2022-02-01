package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ip
  extends a
{
  private long gAa;
  private String gIO = "";
  private String gIP = "";
  private String gJg = "";
  private String gJn = "";
  private long gJo;
  private long gmT;
  private long gzG;
  private long gzY;
  
  public final String agH()
  {
    AppMethodBeat.i(243376);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gmT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gAa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJo);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(243376);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(243377);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.gmT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextId:").append(this.gJg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mvObjectId:").append(this.gIO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mvNonceId:").append(this.gIP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstFrameTime:").append(this.gzY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaittingCount:").append(this.gAa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayTime:").append(this.gzG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoPlayInfo:").append(this.gJn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoErrCount:").append(this.gJo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(243377);
    return localObject;
  }
  
  public final int getId()
  {
    return 22222;
  }
  
  public final ip tR(long paramLong)
  {
    this.gmT = paramLong;
    return this;
  }
  
  public final ip tS(long paramLong)
  {
    this.gzY = paramLong;
    return this;
  }
  
  public final ip tT(long paramLong)
  {
    this.gAa = paramLong;
    return this;
  }
  
  public final ip tU(long paramLong)
  {
    this.gzG = paramLong;
    return this;
  }
  
  public final ip tV(long paramLong)
  {
    this.gJo = paramLong;
    return this;
  }
  
  public final ip zA(String paramString)
  {
    AppMethodBeat.i(243366);
    this.gJg = z("contextId", paramString, true);
    AppMethodBeat.o(243366);
    return this;
  }
  
  public final ip zB(String paramString)
  {
    AppMethodBeat.i(243370);
    this.gIO = z("mvObjectId", paramString, true);
    AppMethodBeat.o(243370);
    return this;
  }
  
  public final ip zC(String paramString)
  {
    AppMethodBeat.i(243372);
    this.gIP = z("mvNonceId", paramString, true);
    AppMethodBeat.o(243372);
    return this;
  }
  
  public final ip zD(String paramString)
  {
    AppMethodBeat.i(243375);
    this.gJn = z("VideoPlayInfo", paramString, true);
    AppMethodBeat.o(243375);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ip
 * JD-Core Version:    0.7.0.1
 */