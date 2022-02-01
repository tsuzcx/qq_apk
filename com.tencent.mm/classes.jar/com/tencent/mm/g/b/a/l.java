package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class l
  extends a
{
  public long dSa;
  public String dSb;
  public long dSc;
  public long dSd;
  
  public final String RD()
  {
    AppMethodBeat.i(163174);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSd);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(163174);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(163175);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.dSa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WeShiCount:").append(this.dSc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTime:").append(this.dSd);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(163175);
    return localObject;
  }
  
  public final int getId()
  {
    return 18869;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.l
 * JD-Core Version:    0.7.0.1
 */