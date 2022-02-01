package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class aj
  extends a
{
  public String gdI = "";
  public String giD = "";
  public int giG = 0;
  public long giH = 0L;
  public long giI = 0L;
  public long giJ = 0L;
  private long giK = 0L;
  public long giL = 0L;
  
  public final String agH()
  {
    AppMethodBeat.i(121747);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.giD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdI);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(121747);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(121748);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatroomName:").append(this.giD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatroomMute:").append(this.giG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadCount:").append(this.giH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DisRedDotCount:").append(this.giI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterCount:").append(this.giJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTimeMs:").append(this.giK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SendCount:").append(this.giL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Score:").append(this.gdI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121748);
    return localObject;
  }
  
  public final aj cr(long paramLong)
  {
    AppMethodBeat.i(121746);
    this.giK = paramLong;
    super.bk("StayTimeMs", this.giK);
    AppMethodBeat.o(121746);
    return this;
  }
  
  public final int getId()
  {
    return 15460;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.aj
 * JD-Core Version:    0.7.0.1
 */