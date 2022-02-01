package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ur
  extends a
{
  public String iKB = "";
  public String inx = "";
  public long iuA = 0L;
  public String jHI = "";
  public String jHN = "";
  public String jHO = "";
  public String jvJ = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(116504);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iuA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jvJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHO);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(116504);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(116505);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.iuA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("content:").append(this.jvJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchid:").append(this.jHI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.inx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.iKB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("resulttype:").append(this.jHN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("resultsubtypelist:").append(this.jHO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116505);
    return localObject;
  }
  
  public final int getId()
  {
    return 16032;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ur
 * JD-Core Version:    0.7.0.1
 */