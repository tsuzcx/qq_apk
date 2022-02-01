package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ha
  extends a
{
  public String ejt = "";
  public String eju = "";
  public String ejv = "";
  
  public final String PV()
  {
    AppMethodBeat.i(76373);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ejt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eju);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejv);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(76373);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(76374);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("WidgetAppid:").append(this.ejt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SrcAppid:").append(this.eju);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DrawData:").append(this.ejv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(76374);
    return localObject;
  }
  
  public final int getId()
  {
    return 16358;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ha
 * JD-Core Version:    0.7.0.1
 */