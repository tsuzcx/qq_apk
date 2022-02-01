package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dv
  extends a
{
  public long eiI = 0L;
  private String eiJ = "";
  private String eiK = "";
  
  public final String RC()
  {
    AppMethodBeat.i(186332);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiJ);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(186332);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(186333);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RoomName:").append(this.eiK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsRedDot:").append(this.eiI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppList:").append(this.eiJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(186333);
    return localObject;
  }
  
  public final int getId()
  {
    return 19959;
  }
  
  public final dv nA(String paramString)
  {
    AppMethodBeat.i(186330);
    this.eiK = t("RoomName", paramString, true);
    AppMethodBeat.o(186330);
    return this;
  }
  
  public final dv nB(String paramString)
  {
    AppMethodBeat.i(186331);
    this.eiJ = t("AppList", paramString, true);
    AppMethodBeat.o(186331);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dv
 * JD-Core Version:    0.7.0.1
 */