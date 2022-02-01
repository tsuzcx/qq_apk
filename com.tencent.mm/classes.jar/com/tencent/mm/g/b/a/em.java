package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class em
  extends a
{
  private String dXn = "";
  private String eif = "";
  public long eig = 0L;
  private String eih = "";
  private String eii = "";
  
  public final String RD()
  {
    AppMethodBeat.i(116490);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eif);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eig);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eih);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eii);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(116490);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(116491);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("query:").append(this.eif);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionId:").append(this.dXn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isChange:").append(this.eig);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appidBefore:").append(this.eih);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appidAfter:").append(this.eii);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116491);
    return localObject;
  }
  
  public final int getId()
  {
    return 15960;
  }
  
  public final em nM(String paramString)
  {
    AppMethodBeat.i(116486);
    this.eif = t("query", paramString, true);
    AppMethodBeat.o(116486);
    return this;
  }
  
  public final em nN(String paramString)
  {
    AppMethodBeat.i(116487);
    this.dXn = t("sessionId", paramString, true);
    AppMethodBeat.o(116487);
    return this;
  }
  
  public final em nO(String paramString)
  {
    AppMethodBeat.i(116488);
    this.eih = t("appidBefore", paramString, true);
    AppMethodBeat.o(116488);
    return this;
  }
  
  public final em nP(String paramString)
  {
    AppMethodBeat.i(116489);
    this.eii = t("appidAfter", paramString, true);
    AppMethodBeat.o(116489);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.em
 * JD-Core Version:    0.7.0.1
 */