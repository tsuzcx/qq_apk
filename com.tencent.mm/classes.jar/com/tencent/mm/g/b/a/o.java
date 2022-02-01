package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class o
  extends a
{
  public String dTC = "";
  public int dTF = 0;
  public long dTG = 0L;
  public long dTH = 0L;
  public long dTI = 0L;
  private long dTJ = 0L;
  public long dTK = 0L;
  public String dTL = "";
  
  public final String RC()
  {
    AppMethodBeat.i(121747);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTL);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(121747);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(121748);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatroomName:").append(this.dTC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatroomMute:").append(this.dTF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadCount:").append(this.dTG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DisRedDotCount:").append(this.dTH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterCount:").append(this.dTI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTimeMs:").append(this.dTJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SendCount:").append(this.dTK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Score:").append(this.dTL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121748);
    return localObject;
  }
  
  public final o bu(long paramLong)
  {
    AppMethodBeat.i(121746);
    this.dTJ = paramLong;
    super.bg("StayTimeMs", this.dTJ);
    AppMethodBeat.o(121746);
    return this;
  }
  
  public final int getId()
  {
    return 15460;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.o
 * JD-Core Version:    0.7.0.1
 */