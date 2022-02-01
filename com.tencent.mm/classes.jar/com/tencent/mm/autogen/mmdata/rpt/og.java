package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class og
  extends a
{
  public long iVP = 0L;
  public String imN = "";
  public long iyq = 0L;
  public long jiX = 0L;
  public String jjb = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(110284);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jiX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iVP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjb);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(110284);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(110285);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.imN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.jiX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickType:").append(this.iyq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceType:").append(this.iVP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.jjb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110285);
    return localObject;
  }
  
  public final int getId()
  {
    return 18258;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.og
 * JD-Core Version:    0.7.0.1
 */