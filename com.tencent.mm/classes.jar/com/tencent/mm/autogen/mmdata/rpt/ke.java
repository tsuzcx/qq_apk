package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ke
  extends a
{
  public String iWb = "";
  public long iWc = 0L;
  public long iWd = 2L;
  public long iWe = 0L;
  public String iWf = "";
  public long iWg;
  public String iWh = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368850);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iWb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWh);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368850);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368859);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("HasConfirmed:").append(this.iWb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Oper:").append(this.iWc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSideNote:").append(this.iWd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinalShareCount:").append(this.iWe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinalShareCountByType:").append(this.iWf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ForwardScene:").append(this.iWg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToUsername:").append(this.iWh);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368859);
    return localObject;
  }
  
  public final int getId()
  {
    return 20559;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ke
 * JD-Core Version:    0.7.0.1
 */