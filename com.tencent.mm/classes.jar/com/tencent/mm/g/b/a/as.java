package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class as
  extends a
{
  private long dWo;
  private long dWp;
  private String dWq = "";
  private String dXu = "";
  private String dYp = "";
  private long dYq;
  private long dYr;
  private long dYs;
  private long dYt;
  private long dYu;
  private long dYv;
  
  public final String RC()
  {
    AppMethodBeat.i(189131);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYv);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189131);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189132);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Sessionid:").append(this.dWq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.dYp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.dWo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CgiType:").append(this.dYq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LoadingTime:").append(this.dYr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartCgiTimestamp:").append(this.dYs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("status:").append(this.dYt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtraInfo:").append(this.dXu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerVersion:").append(this.dWp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pullType:").append(this.dYu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndCgiTimestamp:").append(this.dYv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189132);
    return localObject;
  }
  
  public final as dE(long paramLong)
  {
    this.dWo = paramLong;
    return this;
  }
  
  public final as dF(long paramLong)
  {
    this.dYq = paramLong;
    return this;
  }
  
  public final as dG(long paramLong)
  {
    this.dYr = paramLong;
    return this;
  }
  
  public final as dH(long paramLong)
  {
    this.dYs = paramLong;
    return this;
  }
  
  public final as dI(long paramLong)
  {
    this.dYt = paramLong;
    return this;
  }
  
  public final as dJ(long paramLong)
  {
    this.dWp = paramLong;
    return this;
  }
  
  public final as dK(long paramLong)
  {
    this.dYu = paramLong;
    return this;
  }
  
  public final as dL(long paramLong)
  {
    this.dYv = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20713;
  }
  
  public final as ir(String paramString)
  {
    AppMethodBeat.i(189128);
    this.dWq = t("Sessionid", paramString, true);
    AppMethodBeat.o(189128);
    return this;
  }
  
  public final as is(String paramString)
  {
    AppMethodBeat.i(189129);
    this.dYp = t("ClickTabContextid", paramString, true);
    AppMethodBeat.o(189129);
    return this;
  }
  
  public final as it(String paramString)
  {
    AppMethodBeat.i(189130);
    this.dXu = t("ExtraInfo", paramString, true);
    AppMethodBeat.o(189130);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.as
 * JD-Core Version:    0.7.0.1
 */