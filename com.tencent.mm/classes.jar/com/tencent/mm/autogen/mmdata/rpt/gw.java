package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gw
  extends a
{
  public String iLE = "";
  public String iLF = "";
  public long iLG;
  public long iLH;
  public long iLI;
  public String ijl = "";
  public long ipV;
  public long iqr;
  public String iwI = "";
  public String ixm = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(369070);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iqr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipV);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369070);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369075);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.ixm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.iwI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.ijl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PoiText:").append(this.iLE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FilterTextItems:").append(this.iLF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsUnflodtab:").append(this.iLG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsUnflodopen:").append(this.iLH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FliterPageType:").append(this.iLI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.ipV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369075);
    return localObject;
  }
  
  public final int getId()
  {
    return 19996;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.gw
 * JD-Core Version:    0.7.0.1
 */