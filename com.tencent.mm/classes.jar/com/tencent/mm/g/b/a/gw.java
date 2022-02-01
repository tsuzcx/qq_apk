package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gw
  extends a
{
  public long dFf = 0L;
  private String dQK = "";
  public long eji = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(111808);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eji);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQK);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(111808);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(111809);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("actionScene:").append(this.eji);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dFf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.dQK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(111809);
    return localObject;
  }
  
  public final int getId()
  {
    return 15776;
  }
  
  public final gw mB(String paramString)
  {
    AppMethodBeat.i(111807);
    this.dQK = t("query", paramString, true);
    AppMethodBeat.o(111807);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gw
 * JD-Core Version:    0.7.0.1
 */