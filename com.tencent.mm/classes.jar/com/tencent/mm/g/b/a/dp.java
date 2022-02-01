package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dp
  extends a
{
  public long dPH;
  public String egP = "";
  public String egQ = "";
  
  public final String RD()
  {
    AppMethodBeat.i(213373);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.egP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPH);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(213373);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(213374);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomID:").append(this.egP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("oldRoomID:").append(this.egQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dPH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(213374);
    return localObject;
  }
  
  public final int getId()
  {
    return 20246;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dp
 * JD-Core Version:    0.7.0.1
 */