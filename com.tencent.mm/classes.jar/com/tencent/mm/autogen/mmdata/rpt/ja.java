package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ja
  extends a
{
  public long iRn;
  public long iRo;
  public String iRp = "";
  public String iRq = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368643);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iRn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iRo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iRp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iRq);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368643);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368649);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("NewMsgCount:").append(this.iRn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnReadLiveEndCount:").append(this.iRo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewTipsIDs:").append(this.iRp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeleteTipsIDs:").append(this.iRq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368649);
    return localObject;
  }
  
  public final int getId()
  {
    return 22623;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ja
 * JD-Core Version:    0.7.0.1
 */