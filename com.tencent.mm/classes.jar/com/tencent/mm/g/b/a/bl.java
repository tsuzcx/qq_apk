package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bl
  extends a
{
  private long dPl;
  private String dSb;
  private String dTd;
  private long dUY;
  private String dVc;
  private String dWK;
  private String dXL;
  
  public final String RD()
  {
    AppMethodBeat.i(209191);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dPl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUY);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(209191);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209192);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.dPl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.dWK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Feedid:").append(this.dXL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dTd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dVc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.dUY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209192);
    return localObject;
  }
  
  public final bl fT(long paramLong)
  {
    this.dPl = paramLong;
    return this;
  }
  
  public final bl fU(long paramLong)
  {
    this.dUY = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19956;
  }
  
  public final bl jX(String paramString)
  {
    AppMethodBeat.i(209186);
    this.dWK = t("Username", paramString, true);
    AppMethodBeat.o(209186);
    return this;
  }
  
  public final bl jY(String paramString)
  {
    AppMethodBeat.i(209187);
    this.dXL = t("Feedid", paramString, true);
    AppMethodBeat.o(209187);
    return this;
  }
  
  public final bl jZ(String paramString)
  {
    AppMethodBeat.i(209188);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(209188);
    return this;
  }
  
  public final bl ka(String paramString)
  {
    AppMethodBeat.i(209189);
    this.dTd = t("ContextId", paramString, true);
    AppMethodBeat.o(209189);
    return this;
  }
  
  public final bl kb(String paramString)
  {
    AppMethodBeat.i(209190);
    this.dVc = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(209190);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bl
 * JD-Core Version:    0.7.0.1
 */