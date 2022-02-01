package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class oa
  extends a
{
  public String fiO = "";
  public String fiP = "";
  public String fiQ = "";
  
  public final String abV()
  {
    AppMethodBeat.i(76373);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.fiO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fiP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fiQ);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(76373);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(76374);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("WidgetAppid:").append(this.fiO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SrcAppid:").append(this.fiP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DrawData:").append(this.fiQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(76374);
    return localObject;
  }
  
  public final int getId()
  {
    return 16358;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.oa
 * JD-Core Version:    0.7.0.1
 */