package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ji
  extends a
{
  public long etA = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(218640);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.etA);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(218640);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(218641);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReportScene:").append(this.etA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(218641);
    return localObject;
  }
  
  public final int getId()
  {
    return 19540;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ji
 * JD-Core Version:    0.7.0.1
 */