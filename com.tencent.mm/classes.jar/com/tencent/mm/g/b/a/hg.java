package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hg
  extends a
{
  public long ecM = 0L;
  public long erV = 0L;
  public long erW = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(149940);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ecM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erW);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(149940);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(149941);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickScene:").append(this.ecM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportValue:").append(this.erV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EntryScene:").append(this.erW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149941);
    return localObject;
  }
  
  public final int getId()
  {
    return 15661;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hg
 * JD-Core Version:    0.7.0.1
 */