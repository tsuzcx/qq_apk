package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class is
  extends a
{
  public String elx = "";
  public String ely = "";
  public String elz = "";
  
  public final String PR()
  {
    AppMethodBeat.i(76373);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.elx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ely);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elz);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(76373);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(76374);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("WidgetAppid:").append(this.elx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SrcAppid:").append(this.ely);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DrawData:").append(this.elz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(76374);
    return localObject;
  }
  
  public final int getId()
  {
    return 16358;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.is
 * JD-Core Version:    0.7.0.1
 */