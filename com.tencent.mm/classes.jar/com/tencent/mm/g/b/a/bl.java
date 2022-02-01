package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bl
  extends a
{
  public long dFd = 0L;
  public long dPK = 0L;
  private String dPL;
  
  public final String PV()
  {
    AppMethodBeat.i(163177);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPL);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(163177);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(163178);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.dFd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsRedDot:").append(this.dPK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppList:").append(this.dPL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(163178);
    return localObject;
  }
  
  public final int getId()
  {
    return 19194;
  }
  
  public final bl im(String paramString)
  {
    AppMethodBeat.i(163176);
    this.dPL = t("AppList", paramString, true);
    AppMethodBeat.o(163176);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bl
 * JD-Core Version:    0.7.0.1
 */