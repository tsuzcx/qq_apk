package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ex
  extends a
{
  private String dTK;
  private String eag;
  private String eav;
  public long eaw;
  public long eax;
  
  public final String PV()
  {
    AppMethodBeat.i(174645);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eav);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eax);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(174645);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(174646);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PagePath:").append(this.eav);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoUrl:").append(this.dTK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventId:").append(this.eaw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventNote:").append(this.eax);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(174646);
    return localObject;
  }
  
  public final int getId()
  {
    return 18837;
  }
  
  public final ex kU(String paramString)
  {
    AppMethodBeat.i(174642);
    this.eag = t("AppId", paramString, true);
    AppMethodBeat.o(174642);
    return this;
  }
  
  public final ex kV(String paramString)
  {
    AppMethodBeat.i(174643);
    this.eav = t("PagePath", paramString, true);
    AppMethodBeat.o(174643);
    return this;
  }
  
  public final ex kW(String paramString)
  {
    AppMethodBeat.i(174644);
    this.dTK = t("VideoUrl", paramString, true);
    AppMethodBeat.o(174644);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ex
 * JD-Core Version:    0.7.0.1
 */