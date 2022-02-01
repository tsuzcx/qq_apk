package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class he
  extends a
{
  public long dPl = 0L;
  public long dVd = 0L;
  private String erS = "";
  
  public final String RD()
  {
    AppMethodBeat.i(149938);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dVd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erS);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(149938);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(149939);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dVd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dPl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OrderId:").append(this.erS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149939);
    return localObject;
  }
  
  public final int getId()
  {
    return 17072;
  }
  
  public final he qa(String paramString)
  {
    AppMethodBeat.i(149937);
    this.erS = t("OrderId", paramString, true);
    AppMethodBeat.o(149937);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.he
 * JD-Core Version:    0.7.0.1
 */