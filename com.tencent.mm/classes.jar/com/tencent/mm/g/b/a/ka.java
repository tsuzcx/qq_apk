package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ka
  extends a
{
  public long eTd = 0L;
  public long ejA = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(155377);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eTd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejA);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(155377);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(155378);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ThirdAppType:").append(this.eTd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ejA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(155378);
    return localObject;
  }
  
  public final int getId()
  {
    return 16996;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ka
 * JD-Core Version:    0.7.0.1
 */