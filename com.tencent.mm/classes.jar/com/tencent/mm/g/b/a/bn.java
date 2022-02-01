package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bn
  extends a
{
  private String dTr = "";
  private String dUt = "";
  private String dWh = "";
  private long dWo;
  private String dWs = "";
  private String ebh = "";
  private String ebi = "";
  private long ebj;
  
  public final String RC()
  {
    AppMethodBeat.i(189242);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebj);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189242);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189243);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dUt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dWs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddUsername:").append(this.ebh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeleteUsername:").append(this.ebi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dWh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.dWo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("refuseLastCount:").append(this.ebj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189243);
    return localObject;
  }
  
  public final bn gb(long paramLong)
  {
    this.dWo = paramLong;
    return this;
  }
  
  public final bn gc(long paramLong)
  {
    this.ebj = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19957;
  }
  
  public final bn kA(String paramString)
  {
    AppMethodBeat.i(189241);
    this.dWh = t("FeedId", paramString, true);
    AppMethodBeat.o(189241);
    return this;
  }
  
  public final bn kv(String paramString)
  {
    AppMethodBeat.i(189236);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(189236);
    return this;
  }
  
  public final bn kw(String paramString)
  {
    AppMethodBeat.i(189237);
    this.dUt = t("ContextId", paramString, true);
    AppMethodBeat.o(189237);
    return this;
  }
  
  public final bn kx(String paramString)
  {
    AppMethodBeat.i(189238);
    this.dWs = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(189238);
    return this;
  }
  
  public final bn ky(String paramString)
  {
    AppMethodBeat.i(189239);
    this.ebh = t("AddUsername", paramString, true);
    AppMethodBeat.o(189239);
    return this;
  }
  
  public final bn kz(String paramString)
  {
    AppMethodBeat.i(189240);
    this.ebi = t("DeleteUsername", paramString, true);
    AppMethodBeat.o(189240);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bn
 * JD-Core Version:    0.7.0.1
 */