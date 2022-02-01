package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fr
  extends a
{
  public long gBF = 0L;
  public long gBG = 0L;
  public String glM = "";
  public long gnP = 0L;
  public long goP = 0L;
  
  public final String agH()
  {
    AppMethodBeat.i(184550);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.glM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnP);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(184550);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(184551);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Query:").append(this.glM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasWebSearchEntryShown:").append(this.gBF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickType:").append(this.goP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Style:").append(this.gBG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184551);
    return localObject;
  }
  
  public final int getId()
  {
    return 12639;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.fr
 * JD-Core Version:    0.7.0.1
 */