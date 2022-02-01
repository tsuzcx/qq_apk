package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nb
  extends a
{
  public long irf;
  public String jda = "";
  public long jdb = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(367897);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jda);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jdb);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367897);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367906);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RoomId:").append(this.jda);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserRole:").append(this.irf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HistoryID:").append(this.jdb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367906);
    return localObject;
  }
  
  public final int getId()
  {
    return 20543;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.nb
 * JD-Core Version:    0.7.0.1
 */