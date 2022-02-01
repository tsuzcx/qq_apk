package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fy
  extends a
{
  public long gBR;
  public long gBS = 0L;
  public long gBT = 0L;
  public long gBU = 0L;
  public String gBV = "";
  public String gBW = "";
  
  public final String agH()
  {
    AppMethodBeat.i(259168);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gBR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBW);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(259168);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(259170);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RecomdSuccess:").append(this.gBR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecomdFail:").append(this.gBS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("otherSuccess:").append(this.gBT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("otherFail:").append(this.gBU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sucRoomList:").append(this.gBV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ticketId:").append(this.gBW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(259170);
    return localObject;
  }
  
  public final int getId()
  {
    return 19451;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.fy
 * JD-Core Version:    0.7.0.1
 */