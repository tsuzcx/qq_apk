package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jd
  extends a
{
  public String iGf = "";
  public String iQR = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368585);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iQR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGf);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368585);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368594);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Event:").append(this.iQR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Params:").append(this.iGf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368594);
    return localObject;
  }
  
  public final int getId()
  {
    return 24671;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.jd
 * JD-Core Version:    0.7.0.1
 */