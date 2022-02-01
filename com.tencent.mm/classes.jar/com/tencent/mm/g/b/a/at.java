package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class at
  extends a
{
  public int enW = 0;
  public int eqq = 0;
  public int eqr = 0;
  
  public final String abV()
  {
    AppMethodBeat.i(220079);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enW);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(220079);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(220080);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExptAppId:").append(this.eqq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptSeq:").append(this.eqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.enW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(220080);
    return localObject;
  }
  
  public final int getId()
  {
    return 19988;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.at
 * JD-Core Version:    0.7.0.1
 */