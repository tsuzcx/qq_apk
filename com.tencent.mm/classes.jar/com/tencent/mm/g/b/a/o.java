package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class o
  extends a
{
  public String dSm = "";
  public int dSp = 0;
  public long dSq = 0L;
  public long dSr = 0L;
  public long dSs = 0L;
  private long dSt = 0L;
  public long dSu = 0L;
  public String dSv = "";
  
  public final String RD()
  {
    AppMethodBeat.i(121747);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSv);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(121747);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(121748);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatroomName:").append(this.dSm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatroomMute:").append(this.dSp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadCount:").append(this.dSq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DisRedDotCount:").append(this.dSr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterCount:").append(this.dSs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTimeMs:").append(this.dSt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SendCount:").append(this.dSu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Score:").append(this.dSv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121748);
    return localObject;
  }
  
  public final o bu(long paramLong)
  {
    AppMethodBeat.i(121746);
    this.dSt = paramLong;
    super.bf("StayTimeMs", this.dSt);
    AppMethodBeat.o(121746);
    return this;
  }
  
  public final int getId()
  {
    return 15460;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.o
 * JD-Core Version:    0.7.0.1
 */