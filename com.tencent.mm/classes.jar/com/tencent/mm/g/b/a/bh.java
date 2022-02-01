package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bh
  extends a
{
  private String dPs = "";
  public long dPt = 0L;
  public long dPu = 0L;
  public long dPv = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(149916);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dPs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPv);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(149916);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(149917);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionID:").append(this.dPs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionCode:").append(this.dPt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionCodeResult:").append(this.dPu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickAddContact:").append(this.dPv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149917);
    return localObject;
  }
  
  public final int getId()
  {
    return 15850;
  }
  
  public final bh ia(String paramString)
  {
    AppMethodBeat.i(149915);
    this.dPs = t("sessionID", paramString, true);
    AppMethodBeat.o(149915);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bh
 * JD-Core Version:    0.7.0.1
 */