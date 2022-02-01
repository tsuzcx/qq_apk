package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class j
  extends a
{
  public long dHq;
  public String dHr;
  public long dHs;
  public long dHt;
  
  public final String PV()
  {
    AppMethodBeat.i(163174);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHt);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(163174);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(163175);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.dHq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WeShiCount:").append(this.dHs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTime:").append(this.dHt);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(163175);
    return localObject;
  }
  
  public final int getId()
  {
    return 18869;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.j
 * JD-Core Version:    0.7.0.1
 */