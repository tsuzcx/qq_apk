package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class en
  extends a
{
  public long dMW = 0L;
  public long dZx = 0L;
  public long dZy = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(149940);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dMW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZy);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(149940);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(149941);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickScene:").append(this.dMW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportValue:").append(this.dZx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EntryScene:").append(this.dZy);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149941);
    return localObject;
  }
  
  public final int getId()
  {
    return 15661;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.en
 * JD-Core Version:    0.7.0.1
 */