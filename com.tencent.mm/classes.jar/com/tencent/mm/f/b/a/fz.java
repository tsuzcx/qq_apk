package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fz
  extends a
{
  public long gBX;
  public long gBY = 0L;
  public long gBZ = 0L;
  public long gCa = 0L;
  private String gCb = "";
  public long gCc;
  public long gsS;
  
  public final String agH()
  {
    AppMethodBeat.i(259043);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gBX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCc);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(259043);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(259044);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RecomdCount:").append(this.gBX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickMore:").append(this.gBY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecomdSelect:").append(this.gBZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OtherSelect:").append(this.gCa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitType:").append(this.gsS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TicketId:").append(this.gCb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OtherCount:").append(this.gCc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(259044);
    return localObject;
  }
  
  public final int getId()
  {
    return 19450;
  }
  
  public final fz vn(String paramString)
  {
    AppMethodBeat.i(259040);
    this.gCb = z("TicketId", paramString, true);
    AppMethodBeat.o(259040);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.fz
 * JD-Core Version:    0.7.0.1
 */