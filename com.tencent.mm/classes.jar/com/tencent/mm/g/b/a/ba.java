package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ba
  extends a
{
  public long erm;
  public long ern;
  public long ero;
  public long erp = 0L;
  public long erq = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(73526);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ern);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ero);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erq);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(73526);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(73527);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("favid:").append(this.erm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("favsize:").append(this.ern);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cachecnt:").append(this.ero);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cachelsize:").append(this.erp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cachesuccess:").append(this.erq);
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
 * Qualified Name:     com.tencent.mm.g.b.a.ba
 * JD-Core Version:    0.7.0.1
 */