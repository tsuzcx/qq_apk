package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ad
  extends a
{
  public String enA = "";
  public int enD = 0;
  public long enE = 0L;
  public long enF = 0L;
  public long enG = 0L;
  private long enH = 0L;
  public long enI = 0L;
  public String enJ = "";
  
  public final String abV()
  {
    AppMethodBeat.i(121747);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.enA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enJ);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(121747);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(121748);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatroomName:").append(this.enA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatroomMute:").append(this.enD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadCount:").append(this.enE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DisRedDotCount:").append(this.enF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterCount:").append(this.enG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTimeMs:").append(this.enH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SendCount:").append(this.enI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Score:").append(this.enJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121748);
    return localObject;
  }
  
  public final ad bX(long paramLong)
  {
    AppMethodBeat.i(121746);
    this.enH = paramLong;
    super.bi("StayTimeMs", this.enH);
    AppMethodBeat.o(121746);
    return this;
  }
  
  public final int getId()
  {
    return 15460;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ad
 * JD-Core Version:    0.7.0.1
 */