package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class eo
  extends a
{
  private String dYE = "";
  private String ejP = "";
  public long ejQ = 0L;
  private String ejR = "";
  private String ejS = "";
  
  public final String RC()
  {
    AppMethodBeat.i(116490);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ejP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejS);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(116490);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(116491);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("query:").append(this.ejP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionId:").append(this.dYE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isChange:").append(this.ejQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appidBefore:").append(this.ejR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appidAfter:").append(this.ejS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116491);
    return localObject;
  }
  
  public final int getId()
  {
    return 15960;
  }
  
  public final eo oh(String paramString)
  {
    AppMethodBeat.i(116486);
    this.ejP = t("query", paramString, true);
    AppMethodBeat.o(116486);
    return this;
  }
  
  public final eo oi(String paramString)
  {
    AppMethodBeat.i(116487);
    this.dYE = t("sessionId", paramString, true);
    AppMethodBeat.o(116487);
    return this;
  }
  
  public final eo oj(String paramString)
  {
    AppMethodBeat.i(116488);
    this.ejR = t("appidBefore", paramString, true);
    AppMethodBeat.o(116488);
    return this;
  }
  
  public final eo ok(String paramString)
  {
    AppMethodBeat.i(116489);
    this.ejS = t("appidAfter", paramString, true);
    AppMethodBeat.o(116489);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.eo
 * JD-Core Version:    0.7.0.1
 */