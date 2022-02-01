package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bb
  extends a
{
  private String dFY;
  private String dFe;
  private String dHM;
  private long dHT;
  private String dHX;
  private String dLE;
  private String dLF;
  
  public final String PR()
  {
    AppMethodBeat.i(195014);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHT);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(195014);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(195015);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dFY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dHX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddUsername:").append(this.dLE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeleteUsername:").append(this.dLF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dHM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.dHT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(195015);
    return localObject;
  }
  
  public final bb eV(long paramLong)
  {
    this.dHT = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19957;
  }
  
  public final bb iK(String paramString)
  {
    AppMethodBeat.i(195008);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(195008);
    return this;
  }
  
  public final bb iL(String paramString)
  {
    AppMethodBeat.i(195009);
    this.dFY = t("ContextId", paramString, true);
    AppMethodBeat.o(195009);
    return this;
  }
  
  public final bb iM(String paramString)
  {
    AppMethodBeat.i(195010);
    this.dHX = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(195010);
    return this;
  }
  
  public final bb iN(String paramString)
  {
    AppMethodBeat.i(195011);
    this.dLE = t("AddUsername", paramString, true);
    AppMethodBeat.o(195011);
    return this;
  }
  
  public final bb iO(String paramString)
  {
    AppMethodBeat.i(195012);
    this.dLF = t("DeleteUsername", paramString, true);
    AppMethodBeat.o(195012);
    return this;
  }
  
  public final bb iP(String paramString)
  {
    AppMethodBeat.i(195013);
    this.dHM = t("FeedId", paramString, true);
    AppMethodBeat.o(195013);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bb
 * JD-Core Version:    0.7.0.1
 */