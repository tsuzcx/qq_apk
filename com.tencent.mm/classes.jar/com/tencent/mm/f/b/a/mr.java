package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mr
  extends a
{
  private long gBI;
  private long gVq;
  private long gef;
  private String gjO = "";
  private String gnE = "";
  
  public final mr Du(String paramString)
  {
    AppMethodBeat.i(238650);
    this.gjO = z("SessionID", paramString, true);
    AppMethodBeat.o(238650);
    return this;
  }
  
  public final mr Dv(String paramString)
  {
    AppMethodBeat.i(238651);
    this.gnE = z("ActionResult", paramString, true);
    AppMethodBeat.o(238651);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(238655);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gjO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gef);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gVq);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(238655);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(238657);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionID:").append(this.gjO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.gef);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionResult:").append(this.gnE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTs:").append(this.gBI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AllFriendsStatusEntranceStyle:").append(this.gVq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(238657);
    return localObject;
  }
  
  public final int getId()
  {
    return 22208;
  }
  
  public final mr yM(long paramLong)
  {
    this.gef = paramLong;
    return this;
  }
  
  public final mr yN(long paramLong)
  {
    this.gBI = paramLong;
    return this;
  }
  
  public final mr yO(long paramLong)
  {
    this.gVq = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.mr
 * JD-Core Version:    0.7.0.1
 */