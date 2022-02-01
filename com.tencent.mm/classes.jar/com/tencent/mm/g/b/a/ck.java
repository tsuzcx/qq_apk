package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ck
  extends a
{
  public long ecA = 0L;
  public long ecB = 0L;
  public long ecC = 0L;
  public String ecD = "";
  public String ecE = "";
  public long ecz;
  
  public final String RD()
  {
    AppMethodBeat.i(219238);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ecz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecE);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(219238);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(219239);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RecomdSuccess:").append(this.ecz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecomdFail:").append(this.ecA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("otherSuccess:").append(this.ecB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("otherFail:").append(this.ecC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sucRoomList:").append(this.ecD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ticketId:").append(this.ecE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(219239);
    return localObject;
  }
  
  public final int getId()
  {
    return 19451;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ck
 * JD-Core Version:    0.7.0.1
 */