package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bd
  extends a
{
  private long dQB;
  private String dTr = "";
  
  public final String RC()
  {
    AppMethodBeat.i(189197);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTr);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189197);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189198);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.dQB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189198);
    return localObject;
  }
  
  public final bd fc(long paramLong)
  {
    this.dQB = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19954;
  }
  
  public final bd jH(String paramString)
  {
    AppMethodBeat.i(189196);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(189196);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bd
 * JD-Core Version:    0.7.0.1
 */