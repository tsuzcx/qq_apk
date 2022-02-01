package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.plugin.report.a
{
  public long gcQ;
  public long gcR;
  private String gcS = "";
  private String gcT = "";
  
  public final String agH()
  {
    AppMethodBeat.i(270658);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gcQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcT);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(270658);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(270659);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("errType:").append(this.gcQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errCode:").append(this.gcR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errMsg:").append(this.gcS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lastKickReason:").append(this.gcT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(270659);
    return localObject;
  }
  
  public final int getId()
  {
    return 22500;
  }
  
  public final a io(String paramString)
  {
    AppMethodBeat.i(270656);
    this.gcS = z("errMsg", paramString, true);
    AppMethodBeat.o(270656);
    return this;
  }
  
  public final a ip(String paramString)
  {
    AppMethodBeat.i(270657);
    this.gcT = z("lastKickReason", paramString, true);
    AppMethodBeat.o(270657);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.b.a.a
 * JD-Core Version:    0.7.0.1
 */