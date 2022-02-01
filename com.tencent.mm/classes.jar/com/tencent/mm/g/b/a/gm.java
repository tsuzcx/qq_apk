package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gm
  extends a
{
  private long eJL;
  private long eJM;
  private String eJN = "";
  private String eJO = "";
  private String eJP = "";
  private String eJQ = "";
  private long ejW;
  private long elz;
  private String erU = "";
  private String erV = "";
  
  public final String abV()
  {
    AppMethodBeat.i(209297);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ejW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJQ);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209297);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209298);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.ejW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionTS:").append(this.elz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("duration:").append(this.eJL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DynamicState:").append(this.eJM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.erV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.erU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("POIID:").append(this.eJN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("POIDetail:").append(this.eJO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("finderusername:").append(this.eJP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sourceid:").append(this.eJQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209298);
    return localObject;
  }
  
  public final int getId()
  {
    return 22116;
  }
  
  public final gm qt(long paramLong)
  {
    this.ejW = paramLong;
    return this;
  }
  
  public final gm qu(long paramLong)
  {
    this.elz = paramLong;
    return this;
  }
  
  public final gm qv(long paramLong)
  {
    this.eJL = paramLong;
    return this;
  }
  
  public final gm qw(long paramLong)
  {
    this.eJM = paramLong;
    return this;
  }
  
  public final gm uk(String paramString)
  {
    AppMethodBeat.i(209292);
    this.erV = x("Contextid", paramString, true);
    AppMethodBeat.o(209292);
    return this;
  }
  
  public final gm ul(String paramString)
  {
    AppMethodBeat.i(209293);
    this.erU = x("Sessionid", paramString, true);
    AppMethodBeat.o(209293);
    return this;
  }
  
  public final gm um(String paramString)
  {
    AppMethodBeat.i(209294);
    this.eJN = x("POIID", paramString, true);
    AppMethodBeat.o(209294);
    return this;
  }
  
  public final gm un(String paramString)
  {
    AppMethodBeat.i(209295);
    this.eJO = x("POIDetail", paramString, true);
    AppMethodBeat.o(209295);
    return this;
  }
  
  public final gm uo(String paramString)
  {
    AppMethodBeat.i(209296);
    this.eJQ = x("sourceid", paramString, true);
    AppMethodBeat.o(209296);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gm
 * JD-Core Version:    0.7.0.1
 */