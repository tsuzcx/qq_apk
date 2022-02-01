package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ik
  extends a
{
  public long ekU = 0L;
  public long ekV = 0L;
  public long ekW = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(121783);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ekU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekW);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(121783);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(121784);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExptId:").append(this.ekU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GroupId:").append(this.ekV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptSeq:").append(this.ekW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121784);
    return localObject;
  }
  
  public final int getId()
  {
    return 16909;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ik
 * JD-Core Version:    0.7.0.1
 */