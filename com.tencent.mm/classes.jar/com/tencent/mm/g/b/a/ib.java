package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ib
  extends a
{
  public String eMN = "";
  public long eMO;
  public long eMP = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(187893);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eMN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMP);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(187893);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(187894);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RoomId:").append(this.eMN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserRole:").append(this.eMO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HistoryID:").append(this.eMP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(187894);
    return localObject;
  }
  
  public final int getId()
  {
    return 20543;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ib
 * JD-Core Version:    0.7.0.1
 */