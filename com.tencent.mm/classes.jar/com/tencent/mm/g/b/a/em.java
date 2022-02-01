package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class em
  extends a
{
  public String dEE;
  public String dUC;
  public long dUN = 0L;
  public long dUO = 0L;
  public long dUy = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(192982);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dEE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUO);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(192982);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(192983);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.dEE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.dUy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.dUC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DisplayCount:").append(this.dUN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HideCount:").append(this.dUO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(192983);
    return localObject;
  }
  
  public final int getId()
  {
    return 19964;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.em
 * JD-Core Version:    0.7.0.1
 */