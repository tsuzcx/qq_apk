package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class aa
  extends a
{
  public int dSI = 0;
  public int dUH = 0;
  public int dUI = 0;
  
  public final String RD()
  {
    AppMethodBeat.i(210149);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dUH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSI);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(210149);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(210150);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExptAppId:").append(this.dUH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptSeq:").append(this.dUI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.dSI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(210150);
    return localObject;
  }
  
  public final int getId()
  {
    return 19988;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.aa
 * JD-Core Version:    0.7.0.1
 */