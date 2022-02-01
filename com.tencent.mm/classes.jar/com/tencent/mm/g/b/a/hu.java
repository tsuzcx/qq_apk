package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hu
  extends a
{
  private String enw = "";
  private String euN = "";
  public long euO;
  public long euP;
  private String euy = "";
  
  public final String RC()
  {
    AppMethodBeat.i(174645);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.euy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euP);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(174645);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(174646);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.euy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PagePath:").append(this.euN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoUrl:").append(this.enw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventId:").append(this.euO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventNote:").append(this.euP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(174646);
    return localObject;
  }
  
  public final int getId()
  {
    return 18837;
  }
  
  public final hu qT(String paramString)
  {
    AppMethodBeat.i(174642);
    this.euy = t("AppId", paramString, true);
    AppMethodBeat.o(174642);
    return this;
  }
  
  public final hu qU(String paramString)
  {
    AppMethodBeat.i(174643);
    this.euN = t("PagePath", paramString, true);
    AppMethodBeat.o(174643);
    return this;
  }
  
  public final hu qV(String paramString)
  {
    AppMethodBeat.i(174644);
    this.enw = t("VideoUrl", paramString, true);
    AppMethodBeat.o(174644);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hu
 * JD-Core Version:    0.7.0.1
 */