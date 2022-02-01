package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ln
  extends a
{
  public long jaa = 0L;
  private String jab = "";
  private String jac = "";
  public int jad;
  
  public final String aIE()
  {
    AppMethodBeat.i(368133);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jac);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jab);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jad);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368133);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368141);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RoomName:").append(this.jac);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsRedDot:").append(this.jaa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppList:").append(this.jab);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PanelPage:").append(this.jad);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368141);
    return localObject;
  }
  
  public final int getId()
  {
    return 19959;
  }
  
  public final ln uv(String paramString)
  {
    AppMethodBeat.i(368120);
    this.jac = F("RoomName", paramString, true);
    AppMethodBeat.o(368120);
    return this;
  }
  
  public final ln uw(String paramString)
  {
    AppMethodBeat.i(368126);
    this.jab = F("AppList", paramString, true);
    AppMethodBeat.o(368126);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ln
 * JD-Core Version:    0.7.0.1
 */