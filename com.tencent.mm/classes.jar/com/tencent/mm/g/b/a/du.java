package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class du
  extends a
{
  public long dQB = 0L;
  public long eiI = 0L;
  private String eiJ = "";
  
  public final String RC()
  {
    AppMethodBeat.i(163177);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiJ);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(163177);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(163178);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.dQB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsRedDot:").append(this.eiI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppList:").append(this.eiJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(163178);
    return localObject;
  }
  
  public final int getId()
  {
    return 19194;
  }
  
  public final du nz(String paramString)
  {
    AppMethodBeat.i(163176);
    this.eiJ = t("AppList", paramString, true);
    AppMethodBeat.o(163176);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.du
 * JD-Core Version:    0.7.0.1
 */