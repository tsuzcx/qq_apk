package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cl
  extends a
{
  public String ijk = "";
  public String ijl = "";
  public String ijm = "";
  public long ijn;
  public long ijq;
  public String ijr = "";
  public long iwL;
  public String iwM = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368198);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iwL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijr);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368198);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368203);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("IfSelf:").append(this.iwL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.iwM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.ijl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderContexId:").append(this.ijm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentScene:").append(this.ijn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventTarget:").append(this.ijq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActivityId:").append(this.ijr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368203);
    return localObject;
  }
  
  public final int getId()
  {
    return 21206;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.cl
 * JD-Core Version:    0.7.0.1
 */