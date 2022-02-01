package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hc
  extends a
{
  private String gDR = "";
  private String gDS = "";
  private String gDw = "";
  private long gDx;
  private long gEf = 0L;
  private long gEg;
  private long gEh;
  private String gEi = "";
  private long gEj;
  private long gEk;
  private long gEl;
  private long gEm;
  private long gea;
  
  public final String agH()
  {
    AppMethodBeat.i(195005);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gDw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gEf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gea);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gEg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gEh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gEi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gEj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gEk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gEl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gEm);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(195005);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(195013);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.gDw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.gDx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("micid:").append(this.gEf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveuin:").append(this.gDR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lastTime:").append(this.gea);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("closeRole:").append(this.gEg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasVideo:").append(this.gEh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.gDS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("livemicid:").append(this.gEi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStamp:").append(this.gEj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStamp:").append(this.gEk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartAudienceUV:").append(this.gEl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndAudienceUV:").append(this.gEm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(195013);
    return localObject;
  }
  
  public final int getId()
  {
    return 19895;
  }
  
  public final hc qe(long paramLong)
  {
    this.gDx = paramLong;
    return this;
  }
  
  public final hc qf(long paramLong)
  {
    this.gea = paramLong;
    return this;
  }
  
  public final hc qg(long paramLong)
  {
    this.gEg = paramLong;
    return this;
  }
  
  public final hc qh(long paramLong)
  {
    this.gEh = paramLong;
    return this;
  }
  
  public final hc qi(long paramLong)
  {
    this.gEj = paramLong;
    return this;
  }
  
  public final hc qj(long paramLong)
  {
    this.gEk = paramLong;
    return this;
  }
  
  public final hc qk(long paramLong)
  {
    this.gEl = paramLong;
    return this;
  }
  
  public final hc ql(long paramLong)
  {
    this.gEm = paramLong;
    return this;
  }
  
  public final hc vZ(String paramString)
  {
    AppMethodBeat.i(194985);
    this.gDw = z("roomid", paramString, true);
    AppMethodBeat.o(194985);
    return this;
  }
  
  public final hc wa(String paramString)
  {
    AppMethodBeat.i(194994);
    this.gDS = z("liveusername", paramString, true);
    AppMethodBeat.o(194994);
    return this;
  }
  
  public final hc wb(String paramString)
  {
    AppMethodBeat.i(194995);
    this.gEi = z("livemicid", paramString, true);
    AppMethodBeat.o(194995);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.hc
 * JD-Core Version:    0.7.0.1
 */