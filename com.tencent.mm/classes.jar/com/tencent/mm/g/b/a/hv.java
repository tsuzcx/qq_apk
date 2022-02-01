package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hv
  extends a
{
  private String dHr;
  private String dJL;
  private String dLe;
  private String dMw;
  private long dkQ;
  private long hoM;
  private String lYU;
  private long lYW;
  private String lZb;
  
  public final String PV()
  {
    AppMethodBeat.i(203789);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lYU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hoM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dkQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lYW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lZb);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(203789);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(203790);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dLe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dMw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeItems:").append(this.lYU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsCgiEnd:").append(this.hoM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dJL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.dkQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalFriendLikeCnt:").append(this.lYW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterContextId:").append(this.lZb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(203790);
    return localObject;
  }
  
  public final hv aSp(String paramString)
  {
    AppMethodBeat.i(203783);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(203783);
    return this;
  }
  
  public final hv aSq(String paramString)
  {
    AppMethodBeat.i(203784);
    this.dLe = t("ContextId", paramString, true);
    AppMethodBeat.o(203784);
    return this;
  }
  
  public final hv aSr(String paramString)
  {
    AppMethodBeat.i(203785);
    this.dMw = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(203785);
    return this;
  }
  
  public final hv aSs(String paramString)
  {
    AppMethodBeat.i(203786);
    this.lYU = t("ExposeItems", paramString, true);
    AppMethodBeat.o(203786);
    return this;
  }
  
  public final hv aSt(String paramString)
  {
    AppMethodBeat.i(203787);
    this.dJL = t("FeedId", paramString, true);
    AppMethodBeat.o(203787);
    return this;
  }
  
  public final hv aSu(String paramString)
  {
    AppMethodBeat.i(203788);
    this.lZb = t("EnterContextId", paramString, true);
    AppMethodBeat.o(203788);
    return this;
  }
  
  public final int getId()
  {
    return 19955;
  }
  
  public final hv zh(long paramLong)
  {
    this.hoM = paramLong;
    return this;
  }
  
  public final hv zi(long paramLong)
  {
    this.dkQ = paramLong;
    return this;
  }
  
  public final hv zj(long paramLong)
  {
    this.lYW = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hv
 * JD-Core Version:    0.7.0.1
 */