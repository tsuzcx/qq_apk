package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class en
  extends a
{
  public String dEE;
  public long dUM = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(110295);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dEE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUM);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(110295);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(110296);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.dEE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OperateType:").append(this.dUM);
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
 * Qualified Name:     com.tencent.mm.g.b.a.en
 * JD-Core Version:    0.7.0.1
 */