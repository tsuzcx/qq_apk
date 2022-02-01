package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mp
  extends a
{
  private long gef;
  
  public final String agH()
  {
    AppMethodBeat.i(238573);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gef);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(238573);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(238574);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.gef);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(238574);
    return localObject;
  }
  
  public final int getId()
  {
    return 22895;
  }
  
  public final mp yi(long paramLong)
  {
    this.gef = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.b.a.mp
 * JD-Core Version:    0.7.0.1
 */