package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kv
  extends a
{
  public long eXx = 0L;
  public long esA = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(91241);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXx);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(91241);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(91242);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("clickScene:").append(this.esA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("switchWay:").append(this.eXx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91242);
    return localObject;
  }
  
  public final int getId()
  {
    return 17573;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.kv
 * JD-Core Version:    0.7.0.1
 */