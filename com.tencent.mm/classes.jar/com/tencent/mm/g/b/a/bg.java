package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bg
  extends a
{
  private String dFe;
  private long dLQ;
  
  public final String PR()
  {
    AppMethodBeat.i(195026);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLQ);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(195026);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(195027);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotCount:").append(this.dLQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(195027);
    return localObject;
  }
  
  public final bg fr(long paramLong)
  {
    this.dLQ = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19947;
  }
  
  public final bg jb(String paramString)
  {
    AppMethodBeat.i(195025);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(195025);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bg
 * JD-Core Version:    0.7.0.1
 */