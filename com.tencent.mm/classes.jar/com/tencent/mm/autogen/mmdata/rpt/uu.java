package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class uu
  extends a
{
  public String jGI = "";
  public String jHW = "";
  public String jHX = "";
  public int jHY = -1;
  public long jHZ = 0L;
  public String jIa = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(184287);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jHW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jGI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jIa);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(184287);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(184288);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ViewId:").append(this.jHW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageId:").append(this.jGI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LayoutId:").append(this.jHX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpEvent:").append(this.jHY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timeConsuming:").append(this.jHZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("resName:").append(this.jIa);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184288);
    return localObject;
  }
  
  public final int getId()
  {
    return 19316;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.uu
 * JD-Core Version:    0.7.0.1
 */