package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class da
  extends a
{
  public long dRB = 0L;
  private String dRC;
  private String dRD = "";
  
  public final String PR()
  {
    AppMethodBeat.i(195931);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRC);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(195931);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(195932);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RoomName:").append(this.dRD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsRedDot:").append(this.dRB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppList:").append(this.dRC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(195932);
    return localObject;
  }
  
  public final int getId()
  {
    return 19959;
  }
  
  public final da lc(String paramString)
  {
    AppMethodBeat.i(195929);
    this.dRD = t("RoomName", paramString, true);
    AppMethodBeat.o(195929);
    return this;
  }
  
  public final da ld(String paramString)
  {
    AppMethodBeat.i(195930);
    this.dRC = t("AppList", paramString, true);
    AppMethodBeat.o(195930);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.da
 * JD-Core Version:    0.7.0.1
 */