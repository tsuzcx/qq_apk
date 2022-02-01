package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gd
  extends a
{
  public long dNx = 0L;
  public long ebp = 0L;
  public long ebq = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(149940);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dNx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebq);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(149940);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(149941);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickScene:").append(this.dNx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportValue:").append(this.ebp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EntryScene:").append(this.ebq);
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
 * Qualified Name:     com.tencent.mm.g.b.a.gd
 * JD-Core Version:    0.7.0.1
 */