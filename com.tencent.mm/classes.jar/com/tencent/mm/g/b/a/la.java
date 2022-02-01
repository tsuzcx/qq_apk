package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class la
  extends a
{
  public long eiR = 0L;
  public long erW = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(118318);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiR);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(118318);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(118319);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTime:").append(this.eiR);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118319);
    return localObject;
  }
  
  public final int getId()
  {
    return 15509;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.la
 * JD-Core Version:    0.7.0.1
 */