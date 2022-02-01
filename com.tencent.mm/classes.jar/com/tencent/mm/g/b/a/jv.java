package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jv
  extends a
{
  public long dQX = 0L;
  public long eDX = 0L;
  private String ejP = "";
  
  public final String RC()
  {
    AppMethodBeat.i(111808);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eDX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejP);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(111808);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(111809);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("actionScene:").append(this.eDX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dQX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.ejP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(111809);
    return localObject;
  }
  
  public final int getId()
  {
    return 15776;
  }
  
  public final jv sI(String paramString)
  {
    AppMethodBeat.i(111807);
    this.ejP = t("query", paramString, true);
    AppMethodBeat.o(111807);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jv
 * JD-Core Version:    0.7.0.1
 */