package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gm
  extends a
{
  public long dQB = 0L;
  public long epA = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(155377);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.epA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQB);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(155377);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(155378);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ThirdAppType:").append(this.epA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dQB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(155378);
    return localObject;
  }
  
  public final int getId()
  {
    return 16996;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gm
 * JD-Core Version:    0.7.0.1
 */