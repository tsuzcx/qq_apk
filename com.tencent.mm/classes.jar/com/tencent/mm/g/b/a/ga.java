package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ga
  extends a
{
  public long ebf = 0L;
  public long ebg = 0L;
  public String ebh = "";
  public String ebi = "";
  public String ebj = "";
  public String ebk = "";
  public String ebl = "";
  
  public final String PR()
  {
    AppMethodBeat.i(91243);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ebf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebl);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(91243);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(91244);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PayType:").append(this.ebf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CallbackType:").append(this.ebg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceH5Url:").append(this.ebh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceAppUsername:").append(this.ebi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceAppPath:").append(this.ebj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TargetAppUsername:").append(this.ebk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TargetAppPath:").append(this.ebl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91244);
    return localObject;
  }
  
  public final int getId()
  {
    return 16310;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ga
 * JD-Core Version:    0.7.0.1
 */