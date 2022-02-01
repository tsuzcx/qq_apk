package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dt
  extends a
{
  public String dVA = "";
  public long dVy = 0L;
  public String dVz = "";
  
  public final String PV()
  {
    AppMethodBeat.i(19868);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dVy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVA);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(19868);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(19869);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("LogType:").append(this.dVy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WechatLanguage:").append(this.dVz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InputLanguage:").append(this.dVA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(19869);
    return localObject;
  }
  
  public final int getId()
  {
    return 15493;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dt
 * JD-Core Version:    0.7.0.1
 */