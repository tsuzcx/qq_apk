package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ft
  extends a
{
  public String ijk = "";
  public String ijl = "";
  public String ijm = "";
  public long ijo;
  public String ijp = "";
  public long ijq;
  public long ipV;
  
  public final String aIE()
  {
    AppMethodBeat.i(368018);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijq);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368018);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368020);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.ijl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderContexId:").append(this.ijm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.ipV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventCode:").append(this.ijo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventTime:").append(this.ijp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventTarget:").append(this.ijq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368020);
    return localObject;
  }
  
  public final int getId()
  {
    return 21923;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ft
 * JD-Core Version:    0.7.0.1
 */