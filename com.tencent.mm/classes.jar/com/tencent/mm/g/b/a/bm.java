package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bm
  extends a
{
  public long dPK = 0L;
  private String dPL;
  private String dPM = "";
  
  public final String PV()
  {
    AppMethodBeat.i(191124);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dPM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPL);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(191124);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(191125);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RoomName:").append(this.dPM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsRedDot:").append(this.dPK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppList:").append(this.dPL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(191125);
    return localObject;
  }
  
  public final int getId()
  {
    return 19959;
  }
  
  public final bm in(String paramString)
  {
    AppMethodBeat.i(191122);
    this.dPM = t("RoomName", paramString, true);
    AppMethodBeat.o(191122);
    return this;
  }
  
  public final bm io(String paramString)
  {
    AppMethodBeat.i(191123);
    this.dPL = t("AppList", paramString, true);
    AppMethodBeat.o(191123);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bm
 * JD-Core Version:    0.7.0.1
 */