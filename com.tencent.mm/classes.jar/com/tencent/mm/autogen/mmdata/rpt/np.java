package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class np
  extends a
{
  public int jfr;
  public String jft = "";
  public int jfu;
  public String jfv = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(367815);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jfu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jft);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367815);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367824);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ContentSource:").append(this.jfu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContentType:").append(this.jfr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PublishID:").append(this.jfv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderFeedID:").append(this.jft);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367824);
    return localObject;
  }
  
  public final int getId()
  {
    return 23664;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.np
 * JD-Core Version:    0.7.0.1
 */