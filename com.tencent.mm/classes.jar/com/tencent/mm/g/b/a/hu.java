package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hu
  extends a
{
  private long dFd;
  private String dHr;
  private String dKt;
  private String dLe;
  private String dMw;
  private long dkQ;
  private String kyH;
  
  public final String PV()
  {
    AppMethodBeat.i(203781);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.kyH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dkQ);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(203781);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(203782);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.dFd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.dKt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Feedid:").append(this.kyH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dLe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dMw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.dkQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(203782);
    return localObject;
  }
  
  public final hu aSk(String paramString)
  {
    AppMethodBeat.i(203776);
    this.dKt = t("Username", paramString, true);
    AppMethodBeat.o(203776);
    return this;
  }
  
  public final hu aSl(String paramString)
  {
    AppMethodBeat.i(203777);
    this.kyH = t("Feedid", paramString, true);
    AppMethodBeat.o(203777);
    return this;
  }
  
  public final hu aSm(String paramString)
  {
    AppMethodBeat.i(203778);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(203778);
    return this;
  }
  
  public final hu aSn(String paramString)
  {
    AppMethodBeat.i(203779);
    this.dLe = t("ContextId", paramString, true);
    AppMethodBeat.o(203779);
    return this;
  }
  
  public final hu aSo(String paramString)
  {
    AppMethodBeat.i(203780);
    this.dMw = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(203780);
    return this;
  }
  
  public final int getId()
  {
    return 19956;
  }
  
  public final hu zf(long paramLong)
  {
    this.dFd = paramLong;
    return this;
  }
  
  public final hu zg(long paramLong)
  {
    this.dkQ = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hu
 * JD-Core Version:    0.7.0.1
 */