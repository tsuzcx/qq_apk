package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ek
  extends a
{
  private String dEE;
  private String dUC;
  public long dUL = 0L;
  private String dUx;
  public long dUy = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(110289);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dEE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUC);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(110289);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(110290);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.dEE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LaunchUserName:").append(this.dUx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.dUy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reason:").append(this.dUL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.dUC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110290);
    return localObject;
  }
  
  public final int getId()
  {
    return 18252;
  }
  
  public final ek mg(String paramString)
  {
    AppMethodBeat.i(110286);
    this.dEE = t("ChatName", paramString, true);
    AppMethodBeat.o(110286);
    return this;
  }
  
  public final ek mh(String paramString)
  {
    AppMethodBeat.i(110287);
    this.dUx = t("LaunchUserName", paramString, true);
    AppMethodBeat.o(110287);
    return this;
  }
  
  public final ek mi(String paramString)
  {
    AppMethodBeat.i(110288);
    this.dUC = t("Identifier", paramString, true);
    AppMethodBeat.o(110288);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ek
 * JD-Core Version:    0.7.0.1
 */