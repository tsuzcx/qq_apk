package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class r
  extends a
{
  public int dTY;
  
  public final String RC()
  {
    AppMethodBeat.i(63295);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTY);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(63295);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(63296);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.dTY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(63296);
    return localObject;
  }
  
  public final int getId()
  {
    return 18884;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.r
 * JD-Core Version:    0.7.0.1
 */