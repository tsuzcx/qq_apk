package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class iy
  extends a
{
  public String gKy = "";
  public String gKz = "";
  public long geB;
  
  public final String agH()
  {
    AppMethodBeat.i(190819);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gKy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geB);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(190819);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(190825);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomID:").append(this.gKy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("oldRoomID:").append(this.gKz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.geB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(190825);
    return localObject;
  }
  
  public final int getId()
  {
    return 20246;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.iy
 * JD-Core Version:    0.7.0.1
 */