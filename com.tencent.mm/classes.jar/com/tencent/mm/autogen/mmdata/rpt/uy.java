package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class uy
  extends a
{
  public String jIi = "";
  public String jIj = "";
  public String jIk = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(76373);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jIi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jIj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jIk);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(76373);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(76374);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("WidgetAppid:").append(this.jIi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SrcAppid:").append(this.jIj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DrawData:").append(this.jIk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(76374);
    return localObject;
  }
  
  public final int getId()
  {
    return 16358;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.uy
 * JD-Core Version:    0.7.0.1
 */