package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cg
  extends a
{
  public long dWt = 0L;
  public long dXf = 0L;
  public String edN = "";
  public long edO = 0L;
  public long edP = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(184550);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.edN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWt);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(184550);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(184551);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Query:").append(this.edN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasWebSearchEntryShown:").append(this.edO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickType:").append(this.dXf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Style:").append(this.edP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dWt);
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
 * Qualified Name:     com.tencent.mm.g.b.a.cg
 * JD-Core Version:    0.7.0.1
 */