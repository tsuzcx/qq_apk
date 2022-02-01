package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jb
  extends a
{
  public long eQr = 0L;
  public String emL = "";
  
  public final String abV()
  {
    AppMethodBeat.i(110295);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.emL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQr);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(110295);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(110296);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.emL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OperateType:").append(this.eQr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110296);
    return localObject;
  }
  
  public final int getId()
  {
    return 18257;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jb
 * JD-Core Version:    0.7.0.1
 */