package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class er
  extends a
{
  public long eEp = 0L;
  public long eEq = 0L;
  public String eqv = "";
  public long erW = 0L;
  public long esI = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(184550);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erW);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(184550);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(184551);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Query:").append(this.eqv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasWebSearchEntryShown:").append(this.eEp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickType:").append(this.esI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Style:").append(this.eEq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184551);
    return localObject;
  }
  
  public final int getId()
  {
    return 12639;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.er
 * JD-Core Version:    0.7.0.1
 */