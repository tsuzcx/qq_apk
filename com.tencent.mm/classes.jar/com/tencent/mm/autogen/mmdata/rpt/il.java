package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class il
  extends a
{
  public long iQd;
  public long iQe;
  public long iQf;
  public String imN = "";
  public long iow;
  public long ioz;
  public long izg = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(369157);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.izg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iow);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQf);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369157);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369165);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterScene:").append(this.izg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatName:").append(this.imN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTimeStamp:").append(this.iow);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitTimeStamp:").append(this.ioz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterChatType:").append(this.iQd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitChatType:").append(this.iQe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitHiddenStatus:").append(this.iQf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369165);
    return localObject;
  }
  
  public final int getId()
  {
    return 21169;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.il
 * JD-Core Version:    0.7.0.1
 */