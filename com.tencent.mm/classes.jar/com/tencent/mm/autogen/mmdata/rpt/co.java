package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class co
  extends a
{
  public long ikE;
  public String ipU = "";
  public long iqr;
  public String iwI = "";
  public String ixm = "";
  public long ixn;
  
  public final String aIE()
  {
    AppMethodBeat.i(368150);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ixm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixn);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368150);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368155);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Sessionid:").append(this.ixm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.iwI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.ipU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ikE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasWording:").append(this.ixn);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368155);
    return localObject;
  }
  
  public final int getId()
  {
    return 19995;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.co
 * JD-Core Version:    0.7.0.1
 */