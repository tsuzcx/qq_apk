package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class eu
  extends a
{
  public long iFA;
  public String iFB = "";
  public long iFC;
  public String iFp = "";
  public int iFr;
  public String iFs = "";
  public String iFt = "";
  public String iFu = "";
  public int iFw;
  public int iFx;
  public String inx = "";
  public String ixk = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(367816);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iFp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFC);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367816);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367830);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appuin:").append(this.iFp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appversion:").append(this.iFA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("apptype:").append(this.iFr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networktype:").append(this.iFs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("prewarmpath:").append(this.iFB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ispresend:").append(this.iFw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ispreload:").append(this.iFx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.ixk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("finderid:").append(this.iFt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("shopwindowid:").append(this.iFu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.inx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("eventtime:").append(this.iFC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367830);
    return localObject;
  }
  
  public final int getId()
  {
    return 21248;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.eu
 * JD-Core Version:    0.7.0.1
 */