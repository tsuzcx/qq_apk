package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lb
  extends a
{
  public long iNh;
  public long iYG;
  public String iYH = "";
  public String iYI = "";
  public String iYJ = "";
  public long ila;
  public long inE;
  public String iwI = "";
  public String ixm = "";
  private String ixp = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368244);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ila);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYJ);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368244);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368252);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.ila);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionTS:").append(this.inE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("duration:").append(this.iNh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DynamicState:").append(this.iYG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.iwI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.ixm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("POIID:").append(this.iYH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("POIDetail:").append(this.iYI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("finderusername:").append(this.ixp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sourceid:").append(this.iYJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368252);
    return localObject;
  }
  
  public final int getId()
  {
    return 22116;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.lb
 * JD-Core Version:    0.7.0.1
 */