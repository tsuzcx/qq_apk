package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hw
  extends a
{
  private String eBQ = "";
  public long eMC = 0L;
  private String eMD = "";
  private String eME = "";
  private String ekG = "";
  
  public final String abV()
  {
    AppMethodBeat.i(116490);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eBQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eME);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(116490);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(116491);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("query:").append(this.eBQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionId:").append(this.ekG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isChange:").append(this.eMC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appidBefore:").append(this.eMD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appidAfter:").append(this.eME);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116491);
    return localObject;
  }
  
  public final int getId()
  {
    return 15960;
  }
  
  public final hw vB(String paramString)
  {
    AppMethodBeat.i(116486);
    this.eBQ = x("query", paramString, true);
    AppMethodBeat.o(116486);
    return this;
  }
  
  public final hw vC(String paramString)
  {
    AppMethodBeat.i(116487);
    this.ekG = x("sessionId", paramString, true);
    AppMethodBeat.o(116487);
    return this;
  }
  
  public final hw vD(String paramString)
  {
    AppMethodBeat.i(116488);
    this.eMD = x("appidBefore", paramString, true);
    AppMethodBeat.o(116488);
    return this;
  }
  
  public final hw vE(String paramString)
  {
    AppMethodBeat.i(116489);
    this.eME = x("appidAfter", paramString, true);
    AppMethodBeat.o(116489);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hw
 * JD-Core Version:    0.7.0.1
 */