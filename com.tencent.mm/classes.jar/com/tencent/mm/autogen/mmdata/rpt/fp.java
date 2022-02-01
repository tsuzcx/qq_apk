package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fp
  extends a
{
  public long iAh;
  public long iIW;
  public long iIX;
  public long iIY;
  public long iIZ;
  public long iJa;
  public long ila;
  
  public final String aIE()
  {
    AppMethodBeat.i(368032);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iAh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iIW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ila);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iIX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iIY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iIZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJa);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368032);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368034);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("pullType:").append(this.iAh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("curTabType:").append(this.iIW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ila);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("abandonReasonType:").append(this.iIX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("prefetchWithRedDot:").append(this.iIY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("rejectPrefetchReasonType:").append(this.iIZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("localHasPrefetchData:").append(this.iJa);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368034);
    return localObject;
  }
  
  public final int getId()
  {
    return 23105;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.fp
 * JD-Core Version:    0.7.0.1
 */