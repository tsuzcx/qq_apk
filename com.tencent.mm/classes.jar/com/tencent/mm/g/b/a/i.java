package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class i
  extends a
{
  private String cQc = "";
  public int cQf = 0;
  public long cQg = 0L;
  public long cQh = 0L;
  public long cQi = 0L;
  private long cQj = 0L;
  public long cQk = 0L;
  private String cQl = "";
  
  public final String Ff()
  {
    AppMethodBeat.i(73285);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cQc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQl);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(73285);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(73286);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatroomName:").append(this.cQc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatroomMute:").append(this.cQf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadCount:").append(this.cQg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DisRedDotCount:").append(this.cQh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterCount:").append(this.cQi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTimeMs:").append(this.cQj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SendCount:").append(this.cQk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Score:").append(this.cQl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(73286);
    return localObject;
  }
  
  public final i aK(long paramLong)
  {
    AppMethodBeat.i(73283);
    this.cQj = paramLong;
    super.ay("StayTimeMs", this.cQj);
    AppMethodBeat.o(73283);
    return this;
  }
  
  public final i eV(String paramString)
  {
    AppMethodBeat.i(73282);
    this.cQc = t("ChatroomName", paramString, true);
    AppMethodBeat.o(73282);
    return this;
  }
  
  public final i eW(String paramString)
  {
    AppMethodBeat.i(73284);
    this.cQl = t("Score", paramString, true);
    AppMethodBeat.o(73284);
    return this;
  }
  
  public final int getId()
  {
    return 15460;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.i
 * JD-Core Version:    0.7.0.1
 */