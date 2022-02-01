package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bt
  extends a
{
  public long dNk;
  public long dNl = 0L;
  public long dNm = 0L;
  public long dNn = 0L;
  public String dNo = "";
  public String dNp = "";
  
  public final String PR()
  {
    AppMethodBeat.i(209953);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dNk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNp);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(209953);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(209954);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RecomdSuccess:").append(this.dNk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecomdFail:").append(this.dNl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("otherSuccess:").append(this.dNm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("otherFail:").append(this.dNn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sucRoomList:").append(this.dNo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ticketId:").append(this.dNp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209954);
    return localObject;
  }
  
  public final int getId()
  {
    return 19451;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bt
 * JD-Core Version:    0.7.0.1
 */