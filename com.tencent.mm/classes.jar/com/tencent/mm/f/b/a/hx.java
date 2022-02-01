package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hx
  extends a
{
  public long gAN;
  private long gGU;
  public String gGV = "";
  
  public final String agH()
  {
    AppMethodBeat.i(288327);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gGU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gAN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gGV);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(288327);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(288328);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.gGU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatType:").append(this.gAN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatNameStr:").append(this.gGV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(288328);
    return localObject;
  }
  
  public final int getId()
  {
    return 22335;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.hx
 * JD-Core Version:    0.7.0.1
 */