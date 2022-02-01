package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hu
  extends a
{
  public long gCA;
  public long gGR;
  
  public final String agH()
  {
    AppMethodBeat.i(264408);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gGR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCA);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(264408);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(264409);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("OperationObject:").append(this.gGR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OperationType:").append(this.gCA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(264409);
    return localObject;
  }
  
  public final int getId()
  {
    return 21626;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.hu
 * JD-Core Version:    0.7.0.1
 */