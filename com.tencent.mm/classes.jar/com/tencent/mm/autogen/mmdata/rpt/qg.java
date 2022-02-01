package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qg
  extends a
{
  public long jrk;
  public long jrl;
  public long jrm;
  public long jrn;
  
  public final String aIE()
  {
    AppMethodBeat.i(369282);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jrk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrn);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369282);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369291);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("BootType:").append(this.jrk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BootScene:").append(this.jrl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MergeCode:").append(this.jrm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MergeStayTime:").append(this.jrn);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369291);
    return localObject;
  }
  
  public final int getId()
  {
    return 23550;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.qg
 * JD-Core Version:    0.7.0.1
 */