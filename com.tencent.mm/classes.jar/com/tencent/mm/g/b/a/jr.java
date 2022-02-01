package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jr
  extends a
{
  public long eDF = 0L;
  public long eDG = 0L;
  public long eDH = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(121783);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eDF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDH);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(121783);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(121784);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExptId:").append(this.eDF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GroupId:").append(this.eDG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptSeq:").append(this.eDH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121784);
    return localObject;
  }
  
  public final int getId()
  {
    return 16909;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jr
 * JD-Core Version:    0.7.0.1
 */