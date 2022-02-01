package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hi
  extends a
{
  public long eeh = 0L;
  public long etC = 0L;
  public long etD = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(149940);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eeh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etD);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(149940);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(149941);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickScene:").append(this.eeh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportValue:").append(this.etC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EntryScene:").append(this.etD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149941);
    return localObject;
  }
  
  public final int getId()
  {
    return 15661;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hi
 * JD-Core Version:    0.7.0.1
 */