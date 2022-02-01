package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class f
  extends a
{
  public long ijX;
  public long ijY;
  public int ijZ;
  
  public final String aIE()
  {
    AppMethodBeat.i(368631);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ijX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijZ);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368631);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368641);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("LastFinderSyncMs:").append(this.ijX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NowMs:").append(this.ijY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderSyncScene:").append(this.ijZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368641);
    return localObject;
  }
  
  public final int getId()
  {
    return 24081;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.f
 * JD-Core Version:    0.7.0.1
 */