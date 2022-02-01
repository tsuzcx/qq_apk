package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ck
  extends a
{
  public long edU;
  public long edV = 0L;
  public long edW = 0L;
  public long edX = 0L;
  public String edY = "";
  public String edZ = "";
  
  public final String RC()
  {
    AppMethodBeat.i(209878);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.edU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edZ);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(209878);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(209879);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RecomdSuccess:").append(this.edU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecomdFail:").append(this.edV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("otherSuccess:").append(this.edW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("otherFail:").append(this.edX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sucRoomList:").append(this.edY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ticketId:").append(this.edZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209879);
    return localObject;
  }
  
  public final int getId()
  {
    return 19451;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ck
 * JD-Core Version:    0.7.0.1
 */