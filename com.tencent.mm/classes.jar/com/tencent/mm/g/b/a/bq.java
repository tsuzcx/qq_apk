package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bq
  extends a
{
  public long dNg = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(63299);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dNg);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(63299);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(63300);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("reportScene:").append(this.dNg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(63300);
    return localObject;
  }
  
  public final int getId()
  {
    return 18526;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bq
 * JD-Core Version:    0.7.0.1
 */