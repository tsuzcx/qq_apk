package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cw
  extends a
{
  public long dCS;
  public String dRs = "";
  public String dRt = "";
  
  public final String PR()
  {
    AppMethodBeat.i(197010);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dCS);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(197010);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(197011);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomID:").append(this.dRs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("oldRoomID:").append(this.dRt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dCS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(197011);
    return localObject;
  }
  
  public final int getId()
  {
    return 20246;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cw
 * JD-Core Version:    0.7.0.1
 */