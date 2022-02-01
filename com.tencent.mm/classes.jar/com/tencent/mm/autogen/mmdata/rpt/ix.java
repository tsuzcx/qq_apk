package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ix
  extends a
{
  public String iNB = "";
  private long iQX = 0L;
  public long iQY;
  public long iQx;
  public long iuA;
  
  public final String aIE()
  {
    AppMethodBeat.i(368717);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iuA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQY);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368717);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368724);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.iuA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.iNB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reddot:").append(this.iQX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.iQx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PanelPage:").append(this.iQY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368724);
    return localObject;
  }
  
  public final int getId()
  {
    return 19887;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ix
 * JD-Core Version:    0.7.0.1
 */