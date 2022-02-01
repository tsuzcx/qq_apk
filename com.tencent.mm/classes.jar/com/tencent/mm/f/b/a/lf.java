package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lf
  extends a
{
  private String gQA = "";
  private String gQF = "";
  private String gQH = "";
  public long gQI = 0L;
  public long gQJ = 0L;
  public long gQK = 0L;
  public long gQL = 0L;
  public long gQM = 0L;
  private String ggg = "";
  
  public final lf BU(String paramString)
  {
    AppMethodBeat.i(110278);
    this.ggg = z("ChatName", paramString, true);
    AppMethodBeat.o(110278);
    return this;
  }
  
  public final lf BV(String paramString)
  {
    AppMethodBeat.i(110279);
    this.gQA = z("LaunchUserName", paramString, true);
    AppMethodBeat.o(110279);
    return this;
  }
  
  public final lf BW(String paramString)
  {
    AppMethodBeat.i(110280);
    this.gQH = z("MsgUserName", paramString, true);
    AppMethodBeat.o(110280);
    return this;
  }
  
  public final lf BX(String paramString)
  {
    AppMethodBeat.i(110281);
    this.gQF = z("Identifier", paramString, true);
    AppMethodBeat.o(110281);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(110282);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQF);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(110282);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(110283);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.ggg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LaunchUserName:").append(this.gQA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgUserName:").append(this.gQH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionSvrId:").append(this.gQI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasHeader:").append(this.gQJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasTail:").append(this.gQK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasExample:").append(this.gQL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActiveScene:").append(this.gQM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.gQF);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110283);
    return localObject;
  }
  
  public final int getId()
  {
    return 18244;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.b.a.lf
 * JD-Core Version:    0.7.0.1
 */