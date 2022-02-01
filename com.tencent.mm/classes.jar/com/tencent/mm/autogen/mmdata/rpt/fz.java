package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fz
  extends a
{
  public int iJL;
  public int ijZ;
  public String ikf = "";
  public String ikk = "";
  public String imE = "";
  public int iyT;
  
  public final String aIE()
  {
    AppMethodBeat.i(368007);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ikf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imE);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368007);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368013);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("TipsId:").append(this.ikf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderSyncScene:").append(this.ijZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CtrlType:").append(this.iyT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Path:").append(this.ikk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShowType:").append(this.iJL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Url:").append(this.imE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368013);
    return localObject;
  }
  
  public final int getId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.fz
 * JD-Core Version:    0.7.0.1
 */