package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jd
  extends a
{
  public long gKK = 0L;
  private String gKL = "";
  private String gKM = "";
  public int gKN;
  
  public final jd Ak(String paramString)
  {
    AppMethodBeat.i(275220);
    this.gKM = z("RoomName", paramString, true);
    AppMethodBeat.o(275220);
    return this;
  }
  
  public final jd Al(String paramString)
  {
    AppMethodBeat.i(275221);
    this.gKL = z("AppList", paramString, true);
    AppMethodBeat.o(275221);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(275222);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gKM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKN);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(275222);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(275223);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RoomName:").append(this.gKM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsRedDot:").append(this.gKK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppList:").append(this.gKL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PanelPage:").append(this.gKN);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(275223);
    return localObject;
  }
  
  public final int getId()
  {
    return 19959;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.jd
 * JD-Core Version:    0.7.0.1
 */