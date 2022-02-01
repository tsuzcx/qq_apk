package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class no
  extends a
{
  public long gZO = 0L;
  public long ggN = 0L;
  
  public final String agH()
  {
    AppMethodBeat.i(228940);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gZO);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(228940);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(228942);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("OpType:").append(this.ggN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Success:").append(this.gZO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(228942);
    return localObject;
  }
  
  public final int getId()
  {
    return 13071;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.b.a.no
 * JD-Core Version:    0.7.0.1
 */