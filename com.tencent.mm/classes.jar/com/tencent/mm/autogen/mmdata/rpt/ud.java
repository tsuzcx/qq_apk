package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ud
  extends a
{
  public String iEy = "";
  public long iFA = 0L;
  public String iKB = "";
  public String ipx = "";
  public long jBN = 0L;
  public long jFA = 0L;
  public int jFB = 0;
  private String jFC = "";
  public String jFD = "";
  public String jFE = "";
  public String jFF = "";
  public long jFG = 0L;
  public String jFH = "";
  public String jFI = "";
  private long jFJ = 0L;
  private String jFK = "";
  private long jFL = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(43769);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ipx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jBN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEy);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(43769);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(43770);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appid:").append(this.ipx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appversion:").append(this.iFA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appstate:").append(this.jFA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorType:").append(this.jFB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorName:").append(this.jFC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorMessage:").append(this.jFD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorStack:").append(this.jFE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sdkversion:").append(this.jFF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("apptype:").append(this.jFG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("route:").append(this.jFH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.iKB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sdkupdatetime:").append(this.jFI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sceneId:").append(this.jBN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isUnhandledRejection:").append(this.jFJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("source:").append(this.jFK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pluginversion:").append(this.jFL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.iEy);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43770);
    return localObject;
  }
  
  public final int getId()
  {
    return 13582;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ud
 * JD-Core Version:    0.7.0.1
 */