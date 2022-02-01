package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ct
  extends a
{
  public String iqk = "";
  public long iqr;
  public long ixB;
  public long ixC;
  
  public final String aIE()
  {
    AppMethodBeat.i(368124);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iqk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixC);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368124);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368129);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Feedid:").append(this.iqk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.ixB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Followcount:").append(this.ixC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368129);
    return localObject;
  }
  
  public final int getId()
  {
    return 21345;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ct
 * JD-Core Version:    0.7.0.1
 */