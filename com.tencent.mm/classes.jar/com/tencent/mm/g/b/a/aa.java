package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class aa
  extends a
{
  public int dTY = 0;
  public int dVX = 0;
  public int dVY = 0;
  
  public final String RC()
  {
    AppMethodBeat.i(195787);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dVX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTY);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(195787);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(195788);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExptAppId:").append(this.dVX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptSeq:").append(this.dVY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.dTY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(195788);
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