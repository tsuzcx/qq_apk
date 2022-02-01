package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ei
  extends a
{
  private String dEE;
  private String dUC;
  private String dUE;
  public long dUF = 0L;
  public long dUG = 0L;
  public long dUH = 0L;
  public long dUI = 0L;
  public long dUJ = 0L;
  private String dUx;
  
  public final String PR()
  {
    AppMethodBeat.i(110282);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dEE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUC);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(110282);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(110283);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.dEE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LaunchUserName:").append(this.dUx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgUserName:").append(this.dUE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionSvrId:").append(this.dUF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasHeader:").append(this.dUG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasTail:").append(this.dUH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasExample:").append(this.dUI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActiveScene:").append(this.dUJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.dUC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110283);
    return localObject;
  }
  
  public final int getId()
  {
    return 18244;
  }
  
  public final ei mc(String paramString)
  {
    AppMethodBeat.i(110278);
    this.dEE = t("ChatName", paramString, true);
    AppMethodBeat.o(110278);
    return this;
  }
  
  public final ei md(String paramString)
  {
    AppMethodBeat.i(110279);
    this.dUx = t("LaunchUserName", paramString, true);
    AppMethodBeat.o(110279);
    return this;
  }
  
  public final ei me(String paramString)
  {
    AppMethodBeat.i(110280);
    this.dUE = t("MsgUserName", paramString, true);
    AppMethodBeat.o(110280);
    return this;
  }
  
  public final ei mf(String paramString)
  {
    AppMethodBeat.i(110281);
    this.dUC = t("Identifier", paramString, true);
    AppMethodBeat.o(110281);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ei
 * JD-Core Version:    0.7.0.1
 */