package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class eq
  extends a
{
  public long dFd = 0L;
  private String dZA;
  public long dZB = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(149944);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZB);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(149944);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(149945);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.dFd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReqKey:").append(this.dZA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterSettingScene:").append(this.dZB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149945);
    return localObject;
  }
  
  public final int getId()
  {
    return 18262;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.eq
 * JD-Core Version:    0.7.0.1
 */