package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class pt
  extends a
{
  private long iOH;
  public long iOI;
  public long ikE;
  public String iqO = "";
  public String iwX = "";
  public String jcv = "";
  public String jnl = "";
  public String jnm = "";
  private String joA = "";
  public long joM;
  
  public final String aIE()
  {
    AppMethodBeat.i(369078);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iqO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.joM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.joA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jnl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jnm);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369078);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369084);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionID:").append(this.iqO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ikE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionResult:").append(this.iwX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTs:").append(this.iOI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AllFriendsStatusEntranceStyle:").append(this.joM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToStatusID:").append(this.jcv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReddotType:").append(this.iOH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PostRecomIconID:").append(this.joA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SceneSessionID:").append(this.jnl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageID:").append(this.jnm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369084);
    return localObject;
  }
  
  public final int getId()
  {
    return 22208;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.pt
 * JD-Core Version:    0.7.0.1
 */