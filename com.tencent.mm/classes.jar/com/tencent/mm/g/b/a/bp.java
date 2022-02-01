package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bp
  extends a
{
  public long dMW = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(149922);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dMW);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(149922);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(149923);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickScene:").append(this.dMW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149923);
    return localObject;
  }
  
  public final int getId()
  {
    return 16871;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bp
 * JD-Core Version:    0.7.0.1
 */