package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ka
  extends a
{
  public String eEn = "";
  public String eEo = "";
  public String eEp = "";
  
  public final String RC()
  {
    AppMethodBeat.i(76373);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eEn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEp);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(76373);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(76374);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("WidgetAppid:").append(this.eEn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SrcAppid:").append(this.eEo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DrawData:").append(this.eEp);
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
 * Qualified Name:     com.tencent.mm.g.b.a.ka
 * JD-Core Version:    0.7.0.1
 */