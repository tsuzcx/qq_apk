package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class iw
  extends a
{
  public long gKp = 0L;
  public long gKq = 0L;
  private String gqj = "";
  public long gzc = 0L;
  
  public final String agH()
  {
    AppMethodBeat.i(149916);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gqj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKq);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(149916);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(149917);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionID:").append(this.gqj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionCode:").append(this.gzc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionCodeResult:").append(this.gKp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickAddContact:").append(this.gKq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149917);
    return localObject;
  }
  
  public final int getId()
  {
    return 15850;
  }
  
  public final iw zS(String paramString)
  {
    AppMethodBeat.i(149915);
    this.gqj = z("sessionID", paramString, true);
    AppMethodBeat.o(149915);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.iw
 * JD-Core Version:    0.7.0.1
 */