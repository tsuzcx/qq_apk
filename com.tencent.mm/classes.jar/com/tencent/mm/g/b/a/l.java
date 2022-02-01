package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class l
  extends a
{
  public long dTq;
  public String dTr = "";
  public long dTs;
  public long dTt;
  
  public final String RC()
  {
    AppMethodBeat.i(163174);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTt);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(163174);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(163175);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.dTq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WeShiCount:").append(this.dTs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTime:").append(this.dTt);
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