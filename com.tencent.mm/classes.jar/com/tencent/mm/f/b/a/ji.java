package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ji
  extends a
{
  public long gCd = 0L;
  
  public final String agH()
  {
    AppMethodBeat.i(149922);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gCd);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(149922);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(149923);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickScene:").append(this.gCd);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149923);
    return localObject;
  }
  
  public final int getId()
  {
    return 16871;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ji
 * JD-Core Version:    0.7.0.1
 */