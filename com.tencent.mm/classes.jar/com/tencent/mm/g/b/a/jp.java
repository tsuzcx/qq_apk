package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jp
  extends a
{
  public long eBW = 0L;
  public long eBX = 0L;
  public long eBY = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(121783);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eBW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBY);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(121783);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(121784);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExptId:").append(this.eBW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GroupId:").append(this.eBX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptSeq:").append(this.eBY);
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
 * Qualified Name:     com.tencent.mm.g.b.a.jp
 * JD-Core Version:    0.7.0.1
 */