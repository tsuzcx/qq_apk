package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gz
  extends a
{
  public long iLN;
  public long iLO;
  public long iLP;
  public String ijl = "";
  public long ila;
  public String ipW = "";
  public long iqr;
  public String iwI = "";
  public String ixm = "";
  private long ixn;
  
  public final String aIE()
  {
    AppMethodBeat.i(369081);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iqr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ila);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLP);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369081);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369087);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.ixm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.iwI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.ijl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.ipW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ila);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasWording:").append(this.ixn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAction:").append(this.iLN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionStatus:").append(this.iLO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("wordingtype:").append(this.iLP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369087);
    return localObject;
  }
  
  public final int getId()
  {
    return 20044;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.gz
 * JD-Core Version:    0.7.0.1
 */