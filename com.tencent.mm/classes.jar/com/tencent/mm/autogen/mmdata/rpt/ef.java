package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ef
  extends a
{
  public long iBT;
  public long iCA;
  public long iCB;
  public long iCC;
  private String iCD = "";
  public long iCE;
  private String iCF = "";
  private String iCz = "";
  private String iny = "";
  private String ipW = "";
  private String iqp = "";
  private String ixm = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(367976);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ixm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iny);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iBT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqp);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367976);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367981);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Sessionid:").append(this.ixm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextid:").append(this.iny);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickTabContextId:").append(this.iCz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("refreshTime:").append(this.iCA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickType:").append(this.iCB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickTime:").append(this.iCC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardid:").append(this.iCD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardIcon:").append(this.iCE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardTag:").append(this.iCF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.ipW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedIndex:").append(this.iBT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionBuffer:").append(this.iqp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367981);
    return localObject;
  }
  
  public final int getId()
  {
    return 21564;
  }
  
  public final ef ok(String paramString)
  {
    AppMethodBeat.i(367943);
    this.ixm = F("Sessionid", paramString, true);
    AppMethodBeat.o(367943);
    return this;
  }
  
  public final ef ol(String paramString)
  {
    AppMethodBeat.i(367948);
    this.iny = F("contextid", paramString, true);
    AppMethodBeat.o(367948);
    return this;
  }
  
  public final ef om(String paramString)
  {
    AppMethodBeat.i(367954);
    this.iCz = F("clickTabContextId", paramString, true);
    AppMethodBeat.o(367954);
    return this;
  }
  
  public final ef on(String paramString)
  {
    AppMethodBeat.i(367957);
    this.iCD = F("cardid", paramString, true);
    AppMethodBeat.o(367957);
    return this;
  }
  
  public final ef oo(String paramString)
  {
    AppMethodBeat.i(367961);
    this.iCF = F("cardTag", paramString, true);
    AppMethodBeat.o(367961);
    return this;
  }
  
  public final ef op(String paramString)
  {
    AppMethodBeat.i(367965);
    this.ipW = F("feedid", paramString, true);
    AppMethodBeat.o(367965);
    return this;
  }
  
  public final ef oq(String paramString)
  {
    AppMethodBeat.i(367972);
    this.iqp = F("SessionBuffer", paramString, true);
    AppMethodBeat.o(367972);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ef
 * JD-Core Version:    0.7.0.1
 */