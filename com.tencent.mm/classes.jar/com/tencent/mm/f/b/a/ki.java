package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ki
  extends a
{
  public String gMR = "";
  public long gMS;
  public long gMT = 0L;
  
  public final String agH()
  {
    AppMethodBeat.i(255212);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gMR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMT);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(255212);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(255215);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RoomId:").append(this.gMR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserRole:").append(this.gMS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HistoryID:").append(this.gMT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(255215);
    return localObject;
  }
  
  public final int getId()
  {
    return 20543;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ki
 * JD-Core Version:    0.7.0.1
 */