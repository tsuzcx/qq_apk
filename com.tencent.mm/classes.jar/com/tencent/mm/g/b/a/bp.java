package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bp
  extends a
{
  public long dHY = 0L;
  public long dIi = 0L;
  public String dNd = "";
  public long dNe = 0L;
  public long dNf = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(184550);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dNd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHY);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(184550);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(184551);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Query:").append(this.dNd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasWebSearchEntryShown:").append(this.dNe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickType:").append(this.dIi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Style:").append(this.dNf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dHY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184551);
    return localObject;
  }
  
  public final int getId()
  {
    return 12639;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bp
 * JD-Core Version:    0.7.0.1
 */