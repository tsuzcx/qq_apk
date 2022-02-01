package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fy
  extends a
{
  public long iGr;
  public long iJH;
  public long iJI;
  public String iJJ = "";
  public long iJK;
  public String ikf = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368015);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iJH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJK);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368015);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368022);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("CtrType:").append(this.iJH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TipsId:").append(this.ikf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecallTime:").append(this.iJI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TabType:").append(this.iGr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeId:").append(this.iJJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeStatus:").append(this.iJK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368022);
    return localObject;
  }
  
  public final int getId()
  {
    return 20223;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.fy
 * JD-Core Version:    0.7.0.1
 */