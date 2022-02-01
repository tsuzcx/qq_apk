package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ir
  extends a
{
  private long gJp;
  private long gJq;
  private String gJr = "";
  private String gJs = "";
  private String gJt = "";
  private long geB;
  private long ggH;
  private String gnO = "";
  private String gnS = "";
  private String gnp = "";
  
  public final String agH()
  {
    AppMethodBeat.i(210448);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.geB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJt);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(210448);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(210449);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.geB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionTS:").append(this.ggH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("duration:").append(this.gJp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DynamicState:").append(this.gJq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.gnp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.gnO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("POIID:").append(this.gJr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("POIDetail:").append(this.gJs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("finderusername:").append(this.gnS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sourceid:").append(this.gJt);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(210449);
    return localObject;
  }
  
  public final int getId()
  {
    return 22116;
  }
  
  public final ir ua(long paramLong)
  {
    this.geB = paramLong;
    return this;
  }
  
  public final ir ub(long paramLong)
  {
    this.ggH = paramLong;
    return this;
  }
  
  public final ir uc(long paramLong)
  {
    this.gJp = paramLong;
    return this;
  }
  
  public final ir ud(long paramLong)
  {
    this.gJq = paramLong;
    return this;
  }
  
  public final ir zJ(String paramString)
  {
    AppMethodBeat.i(210442);
    this.gnp = z("Contextid", paramString, true);
    AppMethodBeat.o(210442);
    return this;
  }
  
  public final ir zK(String paramString)
  {
    AppMethodBeat.i(210443);
    this.gnO = z("Sessionid", paramString, true);
    AppMethodBeat.o(210443);
    return this;
  }
  
  public final ir zL(String paramString)
  {
    AppMethodBeat.i(210444);
    this.gJr = z("POIID", paramString, true);
    AppMethodBeat.o(210444);
    return this;
  }
  
  public final ir zM(String paramString)
  {
    AppMethodBeat.i(210445);
    this.gJs = z("POIDetail", paramString, true);
    AppMethodBeat.o(210445);
    return this;
  }
  
  public final ir zN(String paramString)
  {
    AppMethodBeat.i(210446);
    this.gJt = z("sourceid", paramString, true);
    AppMethodBeat.o(210446);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ir
 * JD-Core Version:    0.7.0.1
 */