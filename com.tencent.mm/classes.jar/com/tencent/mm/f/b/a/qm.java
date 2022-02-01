package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qm
  extends a
{
  public long gdk;
  public long goe;
  public long hjS;
  
  public final String agH()
  {
    AppMethodBeat.i(211524);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.hjS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goe);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(211524);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(211527);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("WordCount:").append(this.hjS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTime:").append(this.gdk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.goe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(211527);
    return localObject;
  }
  
  public final int getId()
  {
    return 20734;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.qm
 * JD-Core Version:    0.7.0.1
 */