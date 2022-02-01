package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qh
  extends a
{
  public long goe = 0L;
  public long hjA = 0L;
  
  public final String agH()
  {
    AppMethodBeat.i(212016);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.goe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjA);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(212016);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(212021);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Type:").append(this.goe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TemplateVersion:").append(this.hjA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(212021);
    return localObject;
  }
  
  public final int getId()
  {
    return 17040;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.qh
 * JD-Core Version:    0.7.0.1
 */