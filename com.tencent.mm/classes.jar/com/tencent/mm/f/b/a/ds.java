package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ds
  extends a
{
  private String gcU = "";
  private String gjm = "";
  private long goe;
  private long guC;
  private long guD;
  private long guE;
  
  public final String agH()
  {
    AppMethodBeat.i(208956);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guE);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(208956);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(208957);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.goe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsOverlap:").append(this.guC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OverlapCount:").append(this.guD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.gjm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TabType:").append(this.guE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208957);
    return localObject;
  }
  
  public final int getId()
  {
    return 19946;
  }
  
  public final ds jB(long paramLong)
  {
    this.goe = paramLong;
    return this;
  }
  
  public final ds jC(long paramLong)
  {
    this.guC = paramLong;
    return this;
  }
  
  public final ds jD(long paramLong)
  {
    this.guD = paramLong;
    return this;
  }
  
  public final ds jE(long paramLong)
  {
    this.guE = paramLong;
    return this;
  }
  
  public final ds qL(String paramString)
  {
    AppMethodBeat.i(208952);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(208952);
    return this;
  }
  
  public final ds qM(String paramString)
  {
    AppMethodBeat.i(208955);
    this.gjm = z("feedid", paramString, true);
    AppMethodBeat.o(208955);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ds
 * JD-Core Version:    0.7.0.1
 */