package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ev
  extends a
{
  public String eEA = "";
  public long eEv;
  public long eEw = 0L;
  public long eEx = 0L;
  public long eEy = 0L;
  public String eEz = "";
  
  public final String abV()
  {
    AppMethodBeat.i(194514);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eEv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEA);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(194514);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(194515);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RecomdSuccess:").append(this.eEv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecomdFail:").append(this.eEw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("otherSuccess:").append(this.eEx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("otherFail:").append(this.eEy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sucRoomList:").append(this.eEz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ticketId:").append(this.eEA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(194515);
    return localObject;
  }
  
  public final int getId()
  {
    return 19451;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ev
 * JD-Core Version:    0.7.0.1
 */