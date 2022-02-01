package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dp
  extends a
{
  private String dYj = "";
  public long eeJ = 0L;
  public long eiq = 0L;
  public long eir = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(149916);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eir);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(149916);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(149917);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionID:").append(this.dYj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionCode:").append(this.eeJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionCodeResult:").append(this.eiq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickAddContact:").append(this.eir);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149917);
    return localObject;
  }
  
  public final int getId()
  {
    return 15850;
  }
  
  public final dp nm(String paramString)
  {
    AppMethodBeat.i(149915);
    this.dYj = t("sessionID", paramString, true);
    AppMethodBeat.o(149915);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dp
 * JD-Core Version:    0.7.0.1
 */