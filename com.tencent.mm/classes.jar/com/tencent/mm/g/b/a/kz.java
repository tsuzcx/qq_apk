package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kz
  extends a
{
  public long eEH = 0L;
  public long eXI = 0L;
  public long eXJ = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(149940);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eEH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXJ);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(149940);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(149941);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickScene:").append(this.eEH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportValue:").append(this.eXI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EntryScene:").append(this.eXJ);
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
 * Qualified Name:     com.tencent.mm.g.b.a.kz
 * JD-Core Version:    0.7.0.1
 */