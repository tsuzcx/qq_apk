package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hs
  extends a
{
  private String elO;
  private String esR;
  private String etg;
  public long eth;
  public long eti;
  
  public final String RD()
  {
    AppMethodBeat.i(174645);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eth);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eti);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(174645);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(174646);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.esR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PagePath:").append(this.etg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoUrl:").append(this.elO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventId:").append(this.eth);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventNote:").append(this.eti);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(174646);
    return localObject;
  }
  
  public final int getId()
  {
    return 18837;
  }
  
  public final hs qA(String paramString)
  {
    AppMethodBeat.i(174644);
    this.elO = t("VideoUrl", paramString, true);
    AppMethodBeat.o(174644);
    return this;
  }
  
  public final hs qy(String paramString)
  {
    AppMethodBeat.i(174642);
    this.esR = t("AppId", paramString, true);
    AppMethodBeat.o(174642);
    return this;
  }
  
  public final hs qz(String paramString)
  {
    AppMethodBeat.i(174643);
    this.etg = t("PagePath", paramString, true);
    AppMethodBeat.o(174643);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hs
 * JD-Core Version:    0.7.0.1
 */