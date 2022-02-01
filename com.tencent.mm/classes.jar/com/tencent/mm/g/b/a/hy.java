package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hy
  extends a
{
  private String dHr;
  private long dLJ;
  
  public final String PV()
  {
    AppMethodBeat.i(203803);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLJ);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(203803);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(203804);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotCount:").append(this.dLJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(203804);
    return localObject;
  }
  
  public final hy aSC(String paramString)
  {
    AppMethodBeat.i(203802);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(203802);
    return this;
  }
  
  public final int getId()
  {
    return 19947;
  }
  
  public final hy zq(long paramLong)
  {
    this.dLJ = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hy
 * JD-Core Version:    0.7.0.1
 */