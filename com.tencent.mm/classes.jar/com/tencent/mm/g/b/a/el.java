package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class el
  extends a
{
  public long dFd = 0L;
  public long dKe = 0L;
  private String dZu = "";
  
  public final String PV()
  {
    AppMethodBeat.i(149938);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dKe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZu);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(149938);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(149939);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dKe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dFd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OrderId:").append(this.dZu);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149939);
    return localObject;
  }
  
  public final int getId()
  {
    return 17072;
  }
  
  public final el kJ(String paramString)
  {
    AppMethodBeat.i(149937);
    this.dZu = t("OrderId", paramString, true);
    AppMethodBeat.o(149937);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.el
 * JD-Core Version:    0.7.0.1
 */