package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ng
  extends a
{
  private String ijk = "";
  public long ioV;
  private String ioY = "";
  public long iqr = 0L;
  private String iuU = "";
  public long ivT;
  public long iyE = 0L;
  public long jeA = 0L;
  public long jeB = 0L;
  private long jeC = 0L;
  private String jey = "";
  private String jez = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(367910);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jey);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jez);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jeA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jeB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jeC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyE);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367910);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367917);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SearchId:").append(this.iuU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickMD5:").append(this.jey);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QueryMD5:").append(this.jez);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Offset:").append(this.jeA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Pos:").append(this.jeB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClientTimestamp:").append(this.ivT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RequestId:").append(this.ioY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.ioV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tab:").append(this.jeC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSelf:").append(this.iyE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367917);
    return localObject;
  }
  
  public final int getId()
  {
    return 19651;
  }
  
  public final ng vA(String paramString)
  {
    AppMethodBeat.i(367877);
    this.ijk = F("SessionId", paramString, true);
    AppMethodBeat.o(367877);
    return this;
  }
  
  public final ng vB(String paramString)
  {
    AppMethodBeat.i(367880);
    this.iuU = F("SearchId", paramString, true);
    AppMethodBeat.o(367880);
    return this;
  }
  
  public final ng vC(String paramString)
  {
    AppMethodBeat.i(367885);
    this.jey = F("ClickMD5", paramString, true);
    AppMethodBeat.o(367885);
    return this;
  }
  
  public final ng vD(String paramString)
  {
    AppMethodBeat.i(367891);
    this.jez = F("QueryMD5", paramString, true);
    AppMethodBeat.o(367891);
    return this;
  }
  
  public final ng vE(String paramString)
  {
    AppMethodBeat.i(367899);
    this.ioY = F("RequestId", paramString, true);
    AppMethodBeat.o(367899);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ng
 * JD-Core Version:    0.7.0.1
 */