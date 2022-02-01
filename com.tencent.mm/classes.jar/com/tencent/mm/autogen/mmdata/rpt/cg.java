package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cg
  extends a
{
  public long ivM;
  public long ivN;
  public long ivO;
  public long ivP = 0L;
  public long ivQ = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(73526);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ivM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivQ);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(73526);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(73527);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("favid:").append(this.ivM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("favsize:").append(this.ivN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cachecnt:").append(this.ivO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cachelsize:").append(this.ivP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cachesuccess:").append(this.ivQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(73527);
    return localObject;
  }
  
  public final int getId()
  {
    return 18053;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.cg
 * JD-Core Version:    0.7.0.1
 */