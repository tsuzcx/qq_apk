package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nh
  extends a
{
  public long erY = 0L;
  public long fgr = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(187819);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgr);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(187819);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(187820);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Type:").append(this.erY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TemplateVersion:").append(this.fgr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(187820);
    return localObject;
  }
  
  public final int getId()
  {
    return 17040;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.nh
 * JD-Core Version:    0.7.0.1
 */