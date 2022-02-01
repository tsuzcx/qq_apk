package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cu
  extends a
{
  private String dJi = "";
  public long dNZ = 0L;
  public long dRj = 0L;
  public long dRk = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(149916);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dJi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRk);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(149916);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(149917);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionID:").append(this.dJi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionCode:").append(this.dNZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionCodeResult:").append(this.dRj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickAddContact:").append(this.dRk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149917);
    return localObject;
  }
  
  public final int getId()
  {
    return 15850;
  }
  
  public final cu kQ(String paramString)
  {
    AppMethodBeat.i(149915);
    this.dJi = t("sessionID", paramString, true);
    AppMethodBeat.o(149915);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cu
 * JD-Core Version:    0.7.0.1
 */