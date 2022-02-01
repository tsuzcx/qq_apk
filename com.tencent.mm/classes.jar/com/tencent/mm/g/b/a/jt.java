package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jt
  extends a
{
  public long dPH = 0L;
  public long eCo = 0L;
  private String eif = "";
  
  public final String RD()
  {
    AppMethodBeat.i(111808);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eCo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eif);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(111808);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(111809);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("actionScene:").append(this.eCo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dPH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.eif);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(111809);
    return localObject;
  }
  
  public final int getId()
  {
    return 15776;
  }
  
  public final jt sn(String paramString)
  {
    AppMethodBeat.i(111807);
    this.eif = t("query", paramString, true);
    AppMethodBeat.o(111807);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jt
 * JD-Core Version:    0.7.0.1
 */