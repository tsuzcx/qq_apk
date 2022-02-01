package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bo
  extends a
{
  private String gcU = "";
  private String gcV = "";
  private String gcW = "";
  private long gcX;
  private long gda;
  private String gdb = "";
  private long gns;
  private String gnt = "";
  
  public final String agH()
  {
    AppMethodBeat.i(208236);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gns);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gda);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdb);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(208236);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(208242);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("IfSelf:").append(this.gns);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.gnt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.gcV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderContexId:").append(this.gcW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentScene:").append(this.gcX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventTarget:").append(this.gda);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActivityId:").append(this.gdb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208242);
    return localObject;
  }
  
  public final bo dM(long paramLong)
  {
    this.gns = paramLong;
    return this;
  }
  
  public final bo dN(long paramLong)
  {
    this.gcX = paramLong;
    return this;
  }
  
  public final bo dO(long paramLong)
  {
    this.gda = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 21206;
  }
  
  public final bo kb(String paramString)
  {
    AppMethodBeat.i(208215);
    this.gnt = z("Action", paramString, true);
    AppMethodBeat.o(208215);
    return this;
  }
  
  public final bo kc(String paramString)
  {
    AppMethodBeat.i(208217);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(208217);
    return this;
  }
  
  public final bo kd(String paramString)
  {
    AppMethodBeat.i(208219);
    this.gcV = z("ClickTabContextid", paramString, true);
    AppMethodBeat.o(208219);
    return this;
  }
  
  public final bo ke(String paramString)
  {
    AppMethodBeat.i(208222);
    this.gcW = z("FinderContexId", paramString, true);
    AppMethodBeat.o(208222);
    return this;
  }
  
  public final bo kf(String paramString)
  {
    AppMethodBeat.i(208231);
    this.gdb = z("ActivityId", paramString, true);
    AppMethodBeat.o(208231);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.bo
 * JD-Core Version:    0.7.0.1
 */