package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class et
  extends a
{
  public String iFp = "";
  public String iFq = "";
  public int iFr;
  public String iFs = "";
  public String iFt = "";
  public String iFu = "";
  public long iFv;
  public int iFw;
  public int iFx;
  public long iFy;
  public long iFz;
  public String inx = "";
  public String ixk = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(367859);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iFp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFz);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367859);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367869);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appuin:").append(this.iFp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appversion:").append(this.iFq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("apptype:").append(this.iFr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networktype:").append(this.iFs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.ixk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("finderid:").append(this.iFt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("shopwindowid:").append(this.iFu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.inx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickid:").append(this.iFv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ispresend:").append(this.iFw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ispreload:").append(this.iFx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("prewarmstartime:").append(this.iFy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("prewarmendtime:").append(this.iFz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367869);
    return localObject;
  }
  
  public final int getId()
  {
    return 21249;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.et
 * JD-Core Version:    0.7.0.1
 */