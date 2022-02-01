package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jm
  extends a
{
  public long dYD;
  public long eAx;
  public long ebY;
  
  public final String RD()
  {
    AppMethodBeat.i(217632);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eAx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYD);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(217632);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(217633);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("WordCount:").append(this.eAx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTime:").append(this.ebY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.dYD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(217633);
    return localObject;
  }
  
  public final int getId()
  {
    return 20734;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jm
 * JD-Core Version:    0.7.0.1
 */