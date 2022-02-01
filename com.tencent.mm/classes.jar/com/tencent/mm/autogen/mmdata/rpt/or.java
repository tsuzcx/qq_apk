package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class or
  extends a
{
  public long jdp = 0L;
  public long jjV = 0L;
  public long jjW = 0L;
  public long jjX = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(118488);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jjV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jdp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjX);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(118488);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(118489);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExposeViewId:").append(this.jjV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickClearCount:").append(this.jdp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickRenewCount:").append(this.jjW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IfDeleteVideo:").append(this.jjX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118489);
    return localObject;
  }
  
  public final int getId()
  {
    return 16913;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.or
 * JD-Core Version:    0.7.0.1
 */