package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dr
  extends a
{
  private String dJw = "";
  public long dSA = 0L;
  private String dSB = "";
  private String dSC = "";
  private String dSz = "";
  
  public final String PR()
  {
    AppMethodBeat.i(116490);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSC);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(116490);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(116491);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("query:").append(this.dSz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionId:").append(this.dJw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isChange:").append(this.dSA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appidBefore:").append(this.dSB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appidAfter:").append(this.dSC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116491);
    return localObject;
  }
  
  public final int getId()
  {
    return 15960;
  }
  
  public final dr lE(String paramString)
  {
    AppMethodBeat.i(116486);
    this.dSz = t("query", paramString, true);
    AppMethodBeat.o(116486);
    return this;
  }
  
  public final dr lF(String paramString)
  {
    AppMethodBeat.i(116487);
    this.dJw = t("sessionId", paramString, true);
    AppMethodBeat.o(116487);
    return this;
  }
  
  public final dr lG(String paramString)
  {
    AppMethodBeat.i(116488);
    this.dSB = t("appidBefore", paramString, true);
    AppMethodBeat.o(116488);
    return this;
  }
  
  public final dr lH(String paramString)
  {
    AppMethodBeat.i(116489);
    this.dSC = t("appidAfter", paramString, true);
    AppMethodBeat.o(116489);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dr
 * JD-Core Version:    0.7.0.1
 */