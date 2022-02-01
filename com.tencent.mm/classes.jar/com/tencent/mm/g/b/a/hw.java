package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hw
  extends a
{
  private String dHr;
  private String dJL;
  private String dLe;
  private String dMw;
  private long dkQ;
  private String lZc;
  private String lZd;
  
  public final String PV()
  {
    AppMethodBeat.i(203797);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lZc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lZd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dkQ);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(203797);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(203798);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dLe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dMw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddUsername:").append(this.lZc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeleteUsername:").append(this.lZd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dJL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.dkQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(203798);
    return localObject;
  }
  
  public final hw aSA(String paramString)
  {
    AppMethodBeat.i(203796);
    this.dJL = t("FeedId", paramString, true);
    AppMethodBeat.o(203796);
    return this;
  }
  
  public final hw aSv(String paramString)
  {
    AppMethodBeat.i(203791);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(203791);
    return this;
  }
  
  public final hw aSw(String paramString)
  {
    AppMethodBeat.i(203792);
    this.dLe = t("ContextId", paramString, true);
    AppMethodBeat.o(203792);
    return this;
  }
  
  public final hw aSx(String paramString)
  {
    AppMethodBeat.i(203793);
    this.dMw = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(203793);
    return this;
  }
  
  public final hw aSy(String paramString)
  {
    AppMethodBeat.i(203794);
    this.lZc = t("AddUsername", paramString, true);
    AppMethodBeat.o(203794);
    return this;
  }
  
  public final hw aSz(String paramString)
  {
    AppMethodBeat.i(203795);
    this.lZd = t("DeleteUsername", paramString, true);
    AppMethodBeat.o(203795);
    return this;
  }
  
  public final int getId()
  {
    return 19957;
  }
  
  public final hw zk(long paramLong)
  {
    this.dkQ = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hw
 * JD-Core Version:    0.7.0.1
 */