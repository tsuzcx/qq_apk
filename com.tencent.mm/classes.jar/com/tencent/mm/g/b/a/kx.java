package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kx
  extends a
{
  private String eXF = "";
  public long ejA = 0L;
  public long erW = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(149938);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXF);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(149938);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(149939);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ejA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OrderId:").append(this.eXF);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149939);
    return localObject;
  }
  
  public final int getId()
  {
    return 17072;
  }
  
  public final kx yp(String paramString)
  {
    AppMethodBeat.i(149937);
    this.eXF = x("OrderId", paramString, true);
    AppMethodBeat.o(149937);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.kx
 * JD-Core Version:    0.7.0.1
 */