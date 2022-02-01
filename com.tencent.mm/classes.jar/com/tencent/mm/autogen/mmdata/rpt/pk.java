package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class pk
  extends a
{
  public long ikE;
  public long jlU;
  public long jlV;
  public String jlW = "";
  public String jlX = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(369134);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ikE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlX);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369134);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369141);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.ikE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PopupPrivacyType:").append(this.jlU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PopupBiz:").append(this.jlV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeviceID:").append(this.jlW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentPrivacyFullStatus:").append(this.jlX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369141);
    return localObject;
  }
  
  public final int getId()
  {
    return 24958;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.pk
 * JD-Core Version:    0.7.0.1
 */