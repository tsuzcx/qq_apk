package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class f
  extends a
{
  public String ejs = "";
  public String ejt = "";
  public String eju = "";
  public long ejv;
  public long ejw;
  public long ejx;
  
  public final String abV()
  {
    AppMethodBeat.i(238845);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ejs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eju);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejx);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(238845);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(238846);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("lastSessionId:").append(this.ejs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("currSessionId:").append(this.ejt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("nextSessionId:").append(this.eju);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("currSessionEnterMs:").append(this.ejv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("currSessionQuitMs:").append(this.ejw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("currSessionStayTime:").append(this.ejx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(238846);
    return localObject;
  }
  
  public final int getId()
  {
    return 21948;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.f
 * JD-Core Version:    0.7.0.1
 */