package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ic
  extends a
{
  public long ebn = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(192589);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ebn);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(192589);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(192590);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReportScene:").append(this.ebn);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(192590);
    return localObject;
  }
  
  public final int getId()
  {
    return 19540;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ic
 * JD-Core Version:    0.7.0.1
 */