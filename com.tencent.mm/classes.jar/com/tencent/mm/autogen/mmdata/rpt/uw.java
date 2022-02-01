package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class uw
  extends a
{
  public String jFi = "";
  public long jFk;
  public long jFl;
  public String jFn = "";
  public String jIg = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368445);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jFi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jIg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFn);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368445);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368458);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("session:").append(this.jFi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_sum:").append(this.jFk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_index:").append(this.jFl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_ID:").append(this.jIg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_name:").append(this.jFn);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368458);
    return localObject;
  }
  
  public final int getId()
  {
    return 21776;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.uw
 * JD-Core Version:    0.7.0.1
 */