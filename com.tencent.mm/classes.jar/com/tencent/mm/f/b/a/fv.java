package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fv
  extends a
{
  public long gBN = 0L;
  
  public final String agH()
  {
    AppMethodBeat.i(63299);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gBN);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(63299);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(63300);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("reportScene:").append(this.gBN);
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
 * Qualified Name:     com.tencent.mm.f.b.a.fv
 * JD-Core Version:    0.7.0.1
 */