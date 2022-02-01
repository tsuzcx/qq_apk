package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class l
  extends a
{
  public long dHA = 0L;
  private long dHB = 0L;
  public long dHC = 0L;
  public String dHD = "";
  public String dHu = "";
  public int dHx = 0;
  public long dHy = 0L;
  public long dHz = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(121747);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHD);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(121747);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(121748);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatroomName:").append(this.dHu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatroomMute:").append(this.dHx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadCount:").append(this.dHy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DisRedDotCount:").append(this.dHz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterCount:").append(this.dHA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTimeMs:").append(this.dHB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SendCount:").append(this.dHC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Score:").append(this.dHD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121748);
    return localObject;
  }
  
  public final l bs(long paramLong)
  {
    AppMethodBeat.i(121746);
    this.dHB = paramLong;
    super.ba("StayTimeMs", this.dHB);
    AppMethodBeat.o(121746);
    return this;
  }
  
  public final int getId()
  {
    return 15460;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.l
 * JD-Core Version:    0.7.0.1
 */