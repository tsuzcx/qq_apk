package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class io
  extends a
{
  public long dCS = 0L;
  private String dSz = "";
  public long elm = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(111808);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.elm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dCS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSz);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(111808);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(111809);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("actionScene:").append(this.elm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dCS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.dSz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(111809);
    return localObject;
  }
  
  public final int getId()
  {
    return 15776;
  }
  
  public final io pH(String paramString)
  {
    AppMethodBeat.i(111807);
    this.dSz = t("query", paramString, true);
    AppMethodBeat.o(111807);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.io
 * JD-Core Version:    0.7.0.1
 */