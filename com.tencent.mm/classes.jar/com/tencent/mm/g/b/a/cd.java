package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cd
  extends a
{
  private String dKw = "";
  private String dQK = "";
  public long dQL = 0L;
  private String dQM = "";
  private String dQN = "";
  
  public final String PV()
  {
    AppMethodBeat.i(116490);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQN);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(116490);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(116491);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("query:").append(this.dQK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionId:").append(this.dKw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isChange:").append(this.dQL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appidBefore:").append(this.dQM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appidAfter:").append(this.dQN);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116491);
    return localObject;
  }
  
  public final int getId()
  {
    return 15960;
  }
  
  public final cd iO(String paramString)
  {
    AppMethodBeat.i(116486);
    this.dQK = t("query", paramString, true);
    AppMethodBeat.o(116486);
    return this;
  }
  
  public final cd iP(String paramString)
  {
    AppMethodBeat.i(116487);
    this.dKw = t("sessionId", paramString, true);
    AppMethodBeat.o(116487);
    return this;
  }
  
  public final cd iQ(String paramString)
  {
    AppMethodBeat.i(116488);
    this.dQM = t("appidBefore", paramString, true);
    AppMethodBeat.o(116488);
    return this;
  }
  
  public final cd iR(String paramString)
  {
    AppMethodBeat.i(116489);
    this.dQN = t("appidAfter", paramString, true);
    AppMethodBeat.o(116489);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cd
 * JD-Core Version:    0.7.0.1
 */