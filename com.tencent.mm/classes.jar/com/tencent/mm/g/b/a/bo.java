package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bo
  extends a
{
  public long dCQ = 0L;
  public long dHY = 0L;
  public long dNc = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(120834);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dCQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNc);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(120834);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(120835);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dHY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dCQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Source:").append(this.dNc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(120835);
    return localObject;
  }
  
  public final int getId()
  {
    return 17055;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bo
 * JD-Core Version:    0.7.0.1
 */