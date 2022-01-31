package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class br
  extends a
{
  public long cRG = 0L;
  public long cRH = 0L;
  private String cYQ = "";
  
  public final String Ff()
  {
    AppMethodBeat.i(77614);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cRG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cRH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cYQ);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(77614);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(77615);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.cRG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.cRH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OrderId:").append(this.cYQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(77615);
    return localObject;
  }
  
  public final br gQ(String paramString)
  {
    AppMethodBeat.i(138575);
    this.cYQ = t("OrderId", paramString, true);
    AppMethodBeat.o(138575);
    return this;
  }
  
  public final int getId()
  {
    return 17072;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.br
 * JD-Core Version:    0.7.0.1
 */