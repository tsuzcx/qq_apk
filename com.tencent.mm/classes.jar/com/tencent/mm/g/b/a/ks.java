package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ks
  extends a
{
  public long eXj = 0L;
  public long elF = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(223493);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.elF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXj);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(223493);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(223494);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("OpType:").append(this.elF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Success:").append(this.eXj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(223494);
    return localObject;
  }
  
  public final int getId()
  {
    return 13071;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ks
 * JD-Core Version:    0.7.0.1
 */