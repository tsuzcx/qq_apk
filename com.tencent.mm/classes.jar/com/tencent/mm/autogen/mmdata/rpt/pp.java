package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class pp
  extends a
{
  private long iOH;
  public long iOd;
  public String iWh = "";
  public long ikE;
  public String iqO = "";
  public String jmR = "";
  public String jnl = "";
  public int jnp;
  public String jnq = "";
  public long jnr;
  public long jns;
  
  public final String aIE()
  {
    AppMethodBeat.i(369064);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iqO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jmR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jnp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jnq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jnr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jnl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jns);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369064);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369069);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionID:").append(this.iqO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ikE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IconID:").append(this.jmR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToUsername:").append(this.iWh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SameStatusUsersCount:").append(this.jnp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UvPerIcon:").append(this.jnq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Source:").append(this.iOd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReddotType:").append(this.iOH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSameTopic:").append(this.jnr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SceneSessionID:").append(this.jnl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SceneStaytime:").append(this.jns);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369069);
    return localObject;
  }
  
  public final int getId()
  {
    return 22663;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.pp
 * JD-Core Version:    0.7.0.1
 */