package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gp
  extends a
{
  public int ijZ;
  public String ikf = "";
  public String iki = "";
  public int ilm;
  
  public final String aIE()
  {
    AppMethodBeat.i(369132);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ikf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iki);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilm);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369132);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369140);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("TipsId:").append(this.ikf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CtrlType:").append(this.iki);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderSyncScene:").append(this.ijZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ilm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369140);
    return localObject;
  }
  
  public final int getId()
  {
    return 22823;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.gp
 * JD-Core Version:    0.7.0.1
 */