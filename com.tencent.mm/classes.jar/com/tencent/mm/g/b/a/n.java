package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class n
  extends a
{
  private String ekB = "";
  public long ekC;
  public long ekD;
  public long ekE;
  private String ekF = "";
  private String ekG = "";
  
  public final String abV()
  {
    AppMethodBeat.i(226040);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ekB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekG);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(226040);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(226041);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appId:").append(this.ekB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appType:").append(this.ekC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("aliveTime:").append(this.ekD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reason:").append(this.ekE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("flags:").append(this.ekF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionId:").append(this.ekG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(226041);
    return localObject;
  }
  
  public final int getId()
  {
    return 21804;
  }
  
  public final n hR(String paramString)
  {
    AppMethodBeat.i(226037);
    this.ekB = x("appId", paramString, true);
    AppMethodBeat.o(226037);
    return this;
  }
  
  public final n hS(String paramString)
  {
    AppMethodBeat.i(226038);
    this.ekF = x("flags", paramString, true);
    AppMethodBeat.o(226038);
    return this;
  }
  
  public final n hT(String paramString)
  {
    AppMethodBeat.i(226039);
    this.ekG = x("sessionId", paramString, true);
    AppMethodBeat.o(226039);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.n
 * JD-Core Version:    0.7.0.1
 */