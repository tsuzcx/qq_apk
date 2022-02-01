package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ek
  extends a
{
  public long dZn = 0L;
  public long dZo = 0L;
  public String dZp = "";
  public String dZq = "";
  public String dZr = "";
  public String dZs = "";
  public String dZt = "";
  
  public final String PV()
  {
    AppMethodBeat.i(91243);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZt);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(91243);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(91244);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PayType:").append(this.dZn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CallbackType:").append(this.dZo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceH5Url:").append(this.dZp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceAppUsername:").append(this.dZq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceAppPath:").append(this.dZr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TargetAppUsername:").append(this.dZs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TargetAppPath:").append(this.dZt);
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
 * Qualified Name:     com.tencent.mm.g.b.a.ek
 * JD-Core Version:    0.7.0.1
 */