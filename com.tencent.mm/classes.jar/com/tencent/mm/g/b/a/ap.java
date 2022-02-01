package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ap
  extends a
{
  public long dJN = 0L;
  public long dKe = 0L;
  public String dMC = "";
  public long dMD = 0L;
  public long dME = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(184550);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dMC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dME);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKe);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(184550);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(184551);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Query:").append(this.dMC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasWebSearchEntryShown:").append(this.dMD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickType:").append(this.dJN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Style:").append(this.dME);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dKe);
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
 * Qualified Name:     com.tencent.mm.g.b.a.ap
 * JD-Core Version:    0.7.0.1
 */