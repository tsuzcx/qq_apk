package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cz
  extends a
{
  public long dCQ = 0L;
  public long dRB = 0L;
  private String dRC;
  
  public final String PR()
  {
    AppMethodBeat.i(163177);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dCQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRC);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(163177);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(163178);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.dCQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsRedDot:").append(this.dRB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppList:").append(this.dRC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(163178);
    return localObject;
  }
  
  public final int getId()
  {
    return 19194;
  }
  
  public final cz lb(String paramString)
  {
    AppMethodBeat.i(163176);
    this.dRC = t("AppList", paramString, true);
    AppMethodBeat.o(163176);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cz
 * JD-Core Version:    0.7.0.1
 */