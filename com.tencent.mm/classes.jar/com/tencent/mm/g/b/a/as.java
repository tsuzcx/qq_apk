package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class as
  extends a
{
  private long dCQ;
  private String dFe;
  
  public final String PR()
  {
    AppMethodBeat.i(194975);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dCQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFe);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(194975);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(194976);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.dCQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(194976);
    return localObject;
  }
  
  public final as ee(long paramLong)
  {
    this.dCQ = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19954;
  }
  
  public final as hY(String paramString)
  {
    AppMethodBeat.i(194974);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(194974);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.as
 * JD-Core Version:    0.7.0.1
 */