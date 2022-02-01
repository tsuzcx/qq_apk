package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dt
  extends a
{
  public long egY = 0L;
  private String egZ;
  private String eha = "";
  
  public final String RD()
  {
    AppMethodBeat.i(193095);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eha);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egZ);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(193095);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(193096);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RoomName:").append(this.eha);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsRedDot:").append(this.egY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppList:").append(this.egZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(193096);
    return localObject;
  }
  
  public final int getId()
  {
    return 19959;
  }
  
  public final dt nf(String paramString)
  {
    AppMethodBeat.i(193093);
    this.eha = t("RoomName", paramString, true);
    AppMethodBeat.o(193093);
    return this;
  }
  
  public final dt ng(String paramString)
  {
    AppMethodBeat.i(193094);
    this.egZ = t("AppList", paramString, true);
    AppMethodBeat.o(193094);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dt
 * JD-Core Version:    0.7.0.1
 */