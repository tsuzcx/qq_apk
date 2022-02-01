package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fo
  extends a
{
  public String dSR = "";
  public long emL = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(110295);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emL);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(110295);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(110296);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.dSR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OperateType:").append(this.emL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110296);
    return localObject;
  }
  
  public final int getId()
  {
    return 18257;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fo
 * JD-Core Version:    0.7.0.1
 */