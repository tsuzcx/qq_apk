package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gp
  extends a
{
  private String dVw;
  private String ecB;
  public long ecC;
  public long ecD;
  private String ecm;
  
  public final String PR()
  {
    AppMethodBeat.i(174645);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecD);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(174645);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(174646);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PagePath:").append(this.ecB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoUrl:").append(this.dVw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventId:").append(this.ecC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventNote:").append(this.ecD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(174646);
    return localObject;
  }
  
  public final int getId()
  {
    return 18837;
  }
  
  public final gp nZ(String paramString)
  {
    AppMethodBeat.i(174642);
    this.ecm = t("AppId", paramString, true);
    AppMethodBeat.o(174642);
    return this;
  }
  
  public final gp oa(String paramString)
  {
    AppMethodBeat.i(174643);
    this.ecB = t("PagePath", paramString, true);
    AppMethodBeat.o(174643);
    return this;
  }
  
  public final gp ob(String paramString)
  {
    AppMethodBeat.i(174644);
    this.dVw = t("VideoUrl", paramString, true);
    AppMethodBeat.o(174644);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gp
 * JD-Core Version:    0.7.0.1
 */