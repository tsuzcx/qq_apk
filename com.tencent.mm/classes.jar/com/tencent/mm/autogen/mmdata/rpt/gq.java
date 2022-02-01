package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gq
  extends a
{
  public int iLy;
  public int ijZ;
  public String ikf = "";
  public String iki = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(369138);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ikf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iki);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369138);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369144);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("TipsId:").append(this.ikf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderSyncScene:").append(this.ijZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CmdId:").append(this.iLy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CtrlType:").append(this.iki);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369144);
    return localObject;
  }
  
  public final int getId()
  {
    return 21611;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.gq
 * JD-Core Version:    0.7.0.1
 */