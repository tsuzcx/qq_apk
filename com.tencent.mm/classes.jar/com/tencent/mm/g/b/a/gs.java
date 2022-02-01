package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gs
  extends a
{
  public long eiQ = 0L;
  public long eiR = 0L;
  public long eiS = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(121783);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiS);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(121783);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(121784);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExptId:").append(this.eiQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GroupId:").append(this.eiR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptSeq:").append(this.eiS);
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
 * Qualified Name:     com.tencent.mm.g.b.a.gs
 * JD-Core Version:    0.7.0.1
 */