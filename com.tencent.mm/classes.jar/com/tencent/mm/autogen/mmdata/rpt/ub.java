package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ub
  extends a
{
  public long ixB = 0L;
  public long jFz = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(368144);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ixB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFz);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368144);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368147);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Type:").append(this.ixB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TemplateVersion:").append(this.jFz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368147);
    return localObject;
  }
  
  public final int getId()
  {
    return 17040;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ub
 * JD-Core Version:    0.7.0.1
 */