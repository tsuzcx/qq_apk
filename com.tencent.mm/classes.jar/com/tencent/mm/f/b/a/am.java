package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class am
  extends a
{
  public int giX;
  
  public final String agH()
  {
    AppMethodBeat.i(63295);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.giX);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(63295);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(63296);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.giX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(63296);
    return localObject;
  }
  
  public final int getId()
  {
    return 18884;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.b.a.am
 * JD-Core Version:    0.7.0.1
 */