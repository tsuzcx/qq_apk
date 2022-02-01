package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gr
  extends a
{
  public long eCt = 0L;
  public long eKL = 0L;
  public long eKM = 0L;
  private String euc = "";
  
  public final String abV()
  {
    AppMethodBeat.i(149916);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.euc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKM);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(149916);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(149917);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionID:").append(this.euc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionCode:").append(this.eCt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionCodeResult:").append(this.eKL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickAddContact:").append(this.eKM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149917);
    return localObject;
  }
  
  public final int getId()
  {
    return 15850;
  }
  
  public final gr ut(String paramString)
  {
    AppMethodBeat.i(149915);
    this.euc = x("sessionID", paramString, true);
    AppMethodBeat.o(149915);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gr
 * JD-Core Version:    0.7.0.1
 */