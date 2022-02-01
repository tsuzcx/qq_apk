package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class oj
  extends a
{
  public String imN = "";
  public long jiX = 0L;
  public String jjb = "";
  public long jjk = 0L;
  public long jjl = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(368041);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jiX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjl);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368041);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368045);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.imN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.jiX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.jjb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DisplayCount:").append(this.jjk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HideCount:").append(this.jjl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368045);
    return localObject;
  }
  
  public final int getId()
  {
    return 19964;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.oj
 * JD-Core Version:    0.7.0.1
 */