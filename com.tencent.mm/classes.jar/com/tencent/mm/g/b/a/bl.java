package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bl
  extends a
{
  private long dQB;
  private String dTr = "";
  private String dUt = "";
  private long dWo;
  private String dWs = "";
  private String dYc = "";
  private String dZc = "";
  
  public final String RC()
  {
    AppMethodBeat.i(189226);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWo);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189226);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189227);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.dQB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.dYc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Feedid:").append(this.dZc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dUt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dWs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.dWo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189227);
    return localObject;
  }
  
  public final bl fW(long paramLong)
  {
    this.dQB = paramLong;
    return this;
  }
  
  public final bl fX(long paramLong)
  {
    this.dWo = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19956;
  }
  
  public final bl kk(String paramString)
  {
    AppMethodBeat.i(189221);
    this.dYc = t("Username", paramString, true);
    AppMethodBeat.o(189221);
    return this;
  }
  
  public final bl kl(String paramString)
  {
    AppMethodBeat.i(189222);
    this.dZc = t("Feedid", paramString, true);
    AppMethodBeat.o(189222);
    return this;
  }
  
  public final bl km(String paramString)
  {
    AppMethodBeat.i(189223);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(189223);
    return this;
  }
  
  public final bl kn(String paramString)
  {
    AppMethodBeat.i(189224);
    this.dUt = t("ContextId", paramString, true);
    AppMethodBeat.o(189224);
    return this;
  }
  
  public final bl ko(String paramString)
  {
    AppMethodBeat.i(189225);
    this.dWs = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(189225);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bl
 * JD-Core Version:    0.7.0.1
 */