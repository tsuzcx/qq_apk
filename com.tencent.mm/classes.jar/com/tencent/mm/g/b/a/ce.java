package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ce
  extends a
{
  public long dQB = 0L;
  public long dWt = 0L;
  public long edv = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(120834);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edv);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(120834);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(120835);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dQB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Source:").append(this.edv);
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
 * Qualified Name:     com.tencent.mm.g.b.a.ce
 * JD-Core Version:    0.7.0.1
 */