package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ds
  extends a
{
  public long dPl = 0L;
  public long egY = 0L;
  private String egZ;
  
  public final String RD()
  {
    AppMethodBeat.i(163177);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dPl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egZ);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(163177);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(163178);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.dPl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsRedDot:").append(this.egY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppList:").append(this.egZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(163178);
    return localObject;
  }
  
  public final int getId()
  {
    return 19194;
  }
  
  public final ds ne(String paramString)
  {
    AppMethodBeat.i(163176);
    this.egZ = t("AppList", paramString, true);
    AppMethodBeat.o(163176);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ds
 * JD-Core Version:    0.7.0.1
 */