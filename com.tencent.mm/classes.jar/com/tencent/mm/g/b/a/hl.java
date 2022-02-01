package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hl
  extends a
{
  public String ecm;
  public long eco;
  public String eex;
  public long efG;
  public long efH;
  public long efI;
  public String efJ;
  
  public final String PR()
  {
    AppMethodBeat.i(43631);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.efG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eco);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eex);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efJ);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(43631);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43632);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("visitScene:").append(this.efG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("businessScene:").append(this.efH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("innerScene:").append(this.efI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eco);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("path:").append(this.eex);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openRate:").append(this.efJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43632);
    return localObject;
  }
  
  public final int getId()
  {
    return 18852;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hl
 * JD-Core Version:    0.7.0.1
 */