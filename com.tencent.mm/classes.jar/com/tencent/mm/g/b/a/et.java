package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class et
  extends a
{
  public String ekb = "";
  public long ekc;
  public long ekd = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(193971);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ekb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekd);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(193971);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(193972);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RoomId:").append(this.ekb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserRole:").append(this.ekc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HistoryID:").append(this.ekd);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(193972);
    return localObject;
  }
  
  public final int getId()
  {
    return 20543;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.b.a.et
 * JD-Core Version:    0.7.0.1
 */