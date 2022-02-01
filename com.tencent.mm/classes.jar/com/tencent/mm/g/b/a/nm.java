package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nm
  extends a
{
  public long eiR;
  public long erY;
  public long fgG;
  
  public final String abV()
  {
    AppMethodBeat.i(187821);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.fgG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erY);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(187821);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(187822);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("WordCount:").append(this.fgG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTime:").append(this.eiR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.erY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(187822);
    return localObject;
  }
  
  public final int getId()
  {
    return 20734;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.nm
 * JD-Core Version:    0.7.0.1
 */