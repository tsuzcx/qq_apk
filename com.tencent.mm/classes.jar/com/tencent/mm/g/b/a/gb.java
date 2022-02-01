package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gb
  extends a
{
  public long dCQ = 0L;
  public long dHY = 0L;
  private String ebm = "";
  
  public final String PR()
  {
    AppMethodBeat.i(149938);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dCQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebm);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(149938);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(149939);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dHY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dCQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OrderId:").append(this.ebm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149939);
    return localObject;
  }
  
  public final int getId()
  {
    return 17072;
  }
  
  public final gb nB(String paramString)
  {
    AppMethodBeat.i(149937);
    this.ebm = t("OrderId", paramString, true);
    AppMethodBeat.o(149937);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gb
 * JD-Core Version:    0.7.0.1
 */