package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dn
  extends a
{
  private String dWR = "";
  public long edo = 0L;
  public long egG = 0L;
  public long egH = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(149916);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egH);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(149916);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(149917);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionID:").append(this.dWR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionCode:").append(this.edo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionCodeResult:").append(this.egG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickAddContact:").append(this.egH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149917);
    return localObject;
  }
  
  public final int getId()
  {
    return 15850;
  }
  
  public final dn mT(String paramString)
  {
    AppMethodBeat.i(149915);
    this.dWR = t("sessionID", paramString, true);
    AppMethodBeat.o(149915);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dn
 * JD-Core Version:    0.7.0.1
 */