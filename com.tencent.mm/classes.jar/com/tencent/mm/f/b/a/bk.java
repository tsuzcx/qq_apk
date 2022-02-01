package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bk
  extends a
{
  public long gmJ;
  public long gmK;
  public long gmL;
  public long gmM = 0L;
  public long gmN = 0L;
  
  public final String agH()
  {
    AppMethodBeat.i(73526);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gmJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmN);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(73526);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(73527);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("favid:").append(this.gmJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("favsize:").append(this.gmK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cachecnt:").append(this.gmL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cachelsize:").append(this.gmM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cachesuccess:").append(this.gmN);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(73527);
    return localObject;
  }
  
  public final int getId()
  {
    return 18053;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.bk
 * JD-Core Version:    0.7.0.1
 */