package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nt
  extends a
{
  private String eBQ = "";
  public long ejW = 0L;
  public long fiw = 0L;
  
  public final nt AT(String paramString)
  {
    AppMethodBeat.i(111807);
    this.eBQ = x("query", paramString, true);
    AppMethodBeat.o(111807);
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(111808);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.fiw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBQ);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(111808);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(111809);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("actionScene:").append(this.fiw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ejW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.eBQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(111809);
    return localObject;
  }
  
  public final int getId()
  {
    return 15776;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.nt
 * JD-Core Version:    0.7.0.1
 */