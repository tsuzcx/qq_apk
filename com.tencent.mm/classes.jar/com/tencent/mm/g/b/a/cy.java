package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cy
  extends a
{
  public String dGR;
  public long dSK = 0L;
  public String dSO;
  public long dTa = 0L;
  public long dTb = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(192521);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dGR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTb);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(192521);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(192522);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.dGR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.dSK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.dSO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DisplayCount:").append(this.dTa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HideCount:").append(this.dTb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(192522);
    return localObject;
  }
  
  public final int getId()
  {
    return 19964;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cy
 * JD-Core Version:    0.7.0.1
 */