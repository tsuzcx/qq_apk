package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fm
  extends a
{
  public String dRB;
  public long ele = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(110295);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ele);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(110295);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(110296);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.dRB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OperateType:").append(this.ele);
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
 * Qualified Name:     com.tencent.mm.g.b.a.fm
 * JD-Core Version:    0.7.0.1
 */