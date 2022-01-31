package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class de
  extends a
{
  public long deV = 0L;
  public long deW = 0L;
  public long deX = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(73309);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.deV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.deW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.deX);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(73309);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(73310);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExptId:").append(this.deV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GroupId:").append(this.deW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptSeq:").append(this.deX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(73310);
    return localObject;
  }
  
  public final int getId()
  {
    return 16909;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.de
 * JD-Core Version:    0.7.0.1
 */