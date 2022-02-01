package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fj
  extends a
{
  private String dSR = "";
  private String emB = "";
  private String emD = "";
  public long emE = 0L;
  public long emF = 0L;
  public long emG = 0L;
  public long emH = 0L;
  public long emI = 0L;
  private String emw = "";
  
  public final String RC()
  {
    AppMethodBeat.i(110282);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emB);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(110282);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(110283);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.dSR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LaunchUserName:").append(this.emw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgUserName:").append(this.emD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionSvrId:").append(this.emE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasHeader:").append(this.emF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasTail:").append(this.emG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasExample:").append(this.emH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActiveScene:").append(this.emI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.emB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110283);
    return localObject;
  }
  
  public final int getId()
  {
    return 18244;
  }
  
  public final fj oK(String paramString)
  {
    AppMethodBeat.i(110278);
    this.dSR = t("ChatName", paramString, true);
    AppMethodBeat.o(110278);
    return this;
  }
  
  public final fj oL(String paramString)
  {
    AppMethodBeat.i(110279);
    this.emw = t("LaunchUserName", paramString, true);
    AppMethodBeat.o(110279);
    return this;
  }
  
  public final fj oM(String paramString)
  {
    AppMethodBeat.i(110280);
    this.emD = t("MsgUserName", paramString, true);
    AppMethodBeat.o(110280);
    return this;
  }
  
  public final fj oN(String paramString)
  {
    AppMethodBeat.i(110281);
    this.emB = t("Identifier", paramString, true);
    AppMethodBeat.o(110281);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fj
 * JD-Core Version:    0.7.0.1
 */