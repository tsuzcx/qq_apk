package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hw
  extends a
{
  public long gAN;
  private long gGU;
  public String gGV = "";
  public long gef;
  
  public final String agH()
  {
    AppMethodBeat.i(287603);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gGU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gAN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gef);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gGV);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(287603);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(287604);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.gGU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatType:").append(this.gAN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.gef);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatNameStr:").append(this.gGV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(287604);
    return localObject;
  }
  
  public final int getId()
  {
    return 22336;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.hw
 * JD-Core Version:    0.7.0.1
 */