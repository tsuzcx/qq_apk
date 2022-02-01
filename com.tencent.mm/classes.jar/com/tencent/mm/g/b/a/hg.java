package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hg
  extends a
{
  public long dQB = 0L;
  public long dWt = 0L;
  private String etz = "";
  
  public final String RC()
  {
    AppMethodBeat.i(149938);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etz);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(149938);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(149939);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dQB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OrderId:").append(this.etz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149939);
    return localObject;
  }
  
  public final int getId()
  {
    return 17072;
  }
  
  public final hg qv(String paramString)
  {
    AppMethodBeat.i(149937);
    this.etz = t("OrderId", paramString, true);
    AppMethodBeat.o(149937);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hg
 * JD-Core Version:    0.7.0.1
 */