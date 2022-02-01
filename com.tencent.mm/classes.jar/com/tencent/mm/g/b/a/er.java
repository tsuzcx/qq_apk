package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class er
  extends a
{
  public String eir;
  public long eis;
  public long eit = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(207378);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eir);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eis);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eit);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(207378);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(207379);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RoomId:").append(this.eir);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserRole:").append(this.eis);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HistoryID:").append(this.eit);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(207379);
    return localObject;
  }
  
  public final int getId()
  {
    return 20543;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.er
 * JD-Core Version:    0.7.0.1
 */