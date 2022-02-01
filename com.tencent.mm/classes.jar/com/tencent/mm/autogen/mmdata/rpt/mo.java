package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mo
  extends a
{
  public long ila = 0L;
  public long jbO = 0L;
  public long jbP = 0L;
  public long jbQ = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(368381);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jbO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ila);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbQ);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368381);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368386);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("biz:").append(this.jbO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ila);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timecost:").append(this.jbP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isUseSysWebview:").append(this.jbQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368386);
    return localObject;
  }
  
  public final int getId()
  {
    return 15005;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.mo
 * JD-Core Version:    0.7.0.1
 */