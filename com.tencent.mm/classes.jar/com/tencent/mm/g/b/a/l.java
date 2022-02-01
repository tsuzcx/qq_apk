package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class l
  extends a
{
  public String dFh = "";
  public int dFk = 0;
  public long dFl = 0L;
  public long dFm = 0L;
  public long dFn = 0L;
  private long dFo = 0L;
  public long dFp = 0L;
  public String dFq = "";
  
  public final String PR()
  {
    AppMethodBeat.i(121747);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFq);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(121747);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(121748);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatroomName:").append(this.dFh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatroomMute:").append(this.dFk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadCount:").append(this.dFl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DisRedDotCount:").append(this.dFm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterCount:").append(this.dFn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTimeMs:").append(this.dFo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SendCount:").append(this.dFp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Score:").append(this.dFq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121748);
    return localObject;
  }
  
  public final l bp(long paramLong)
  {
    AppMethodBeat.i(121746);
    this.dFo = paramLong;
    super.bc("StayTimeMs", this.dFo);
    AppMethodBeat.o(121746);
    return this;
  }
  
  public final int getId()
  {
    return 15460;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.l
 * JD-Core Version:    0.7.0.1
 */