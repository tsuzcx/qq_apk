package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class em
  extends a
{
  public long iEi;
  private long iEj;
  public String iEk = "";
  public long ikE;
  public String ipU = "";
  public String iqP = "";
  public long iwW;
  public long iwZ;
  
  public final String aIE()
  {
    AppMethodBeat.i(367882);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iwZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEk);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367882);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367888);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PageType:").append(this.iwZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTS:").append(this.iwW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ikE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Clickid:").append(this.iEi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.iEj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextID:").append(this.iqP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.ipU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Session_Id:").append(this.iEk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367888);
    return localObject;
  }
  
  public final int getId()
  {
    return 21631;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.em
 * JD-Core Version:    0.7.0.1
 */