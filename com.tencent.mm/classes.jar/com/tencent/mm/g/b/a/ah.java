package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ah
  extends a
{
  private String cRT = "";
  private String cUs = "";
  public long cUt = 0L;
  private String cUu = "";
  private String cUv = "";
  
  public final String Ff()
  {
    AppMethodBeat.i(91267);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cUs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cRT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUv);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(91267);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(91268);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("query:").append(this.cUs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionId:").append(this.cRT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isChange:").append(this.cUt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appidBefore:").append(this.cUu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appidAfter:").append(this.cUv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91268);
    return localObject;
  }
  
  public final ah fH(String paramString)
  {
    AppMethodBeat.i(91263);
    this.cUs = t("query", paramString, true);
    AppMethodBeat.o(91263);
    return this;
  }
  
  public final ah fI(String paramString)
  {
    AppMethodBeat.i(91264);
    this.cRT = t("sessionId", paramString, true);
    AppMethodBeat.o(91264);
    return this;
  }
  
  public final ah fJ(String paramString)
  {
    AppMethodBeat.i(91265);
    this.cUu = t("appidBefore", paramString, true);
    AppMethodBeat.o(91265);
    return this;
  }
  
  public final ah fK(String paramString)
  {
    AppMethodBeat.i(91266);
    this.cUv = t("appidAfter", paramString, true);
    AppMethodBeat.o(91266);
    return this;
  }
  
  public final int getId()
  {
    return 15960;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ah
 * JD-Core Version:    0.7.0.1
 */