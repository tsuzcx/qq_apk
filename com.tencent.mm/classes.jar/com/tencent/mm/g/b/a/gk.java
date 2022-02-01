package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gk
  extends a
{
  public long dPl = 0L;
  public long enS = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(155377);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.enS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPl);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(155377);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(155378);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ThirdAppType:").append(this.enS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dPl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(155378);
    return localObject;
  }
  
  public final int getId()
  {
    return 16996;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gk
 * JD-Core Version:    0.7.0.1
 */