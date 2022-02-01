package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gb
  extends a
{
  public long eIs;
  public long eIt;
  
  public final String abV()
  {
    AppMethodBeat.i(231485);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eIs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eIt);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(231485);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(231486);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("OperationObject:").append(this.eIs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OperationType:").append(this.eIt);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(231486);
    return localObject;
  }
  
  public final int getId()
  {
    return 21626;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gb
 * JD-Core Version:    0.7.0.1
 */