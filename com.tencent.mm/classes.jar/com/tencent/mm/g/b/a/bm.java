package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bm
  extends a
{
  private String dTr = "";
  private String dUt = "";
  private String dWh = "";
  private long dWo;
  private String dWs = "";
  private long dXM;
  private String ebe = "";
  private long ebf;
  private String ebg = "";
  
  public final String RC()
  {
    AppMethodBeat.i(189234);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebg);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189234);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189235);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dUt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dWs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeItems:").append(this.ebe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsCgiEnd:").append(this.dXM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dWh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.dWo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalFriendLikeCnt:").append(this.ebf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterContextId:").append(this.ebg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189235);
    return localObject;
  }
  
  public final bm fY(long paramLong)
  {
    this.dXM = paramLong;
    return this;
  }
  
  public final bm fZ(long paramLong)
  {
    this.dWo = paramLong;
    return this;
  }
  
  public final bm ga(long paramLong)
  {
    this.ebf = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19955;
  }
  
  public final bm kp(String paramString)
  {
    AppMethodBeat.i(189228);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(189228);
    return this;
  }
  
  public final bm kq(String paramString)
  {
    AppMethodBeat.i(189229);
    this.dUt = t("ContextId", paramString, true);
    AppMethodBeat.o(189229);
    return this;
  }
  
  public final bm kr(String paramString)
  {
    AppMethodBeat.i(189230);
    this.dWs = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(189230);
    return this;
  }
  
  public final bm ks(String paramString)
  {
    AppMethodBeat.i(189231);
    this.ebe = t("ExposeItems", paramString, true);
    AppMethodBeat.o(189231);
    return this;
  }
  
  public final bm kt(String paramString)
  {
    AppMethodBeat.i(189232);
    this.dWh = t("FeedId", paramString, true);
    AppMethodBeat.o(189232);
    return this;
  }
  
  public final bm ku(String paramString)
  {
    AppMethodBeat.i(189233);
    this.ebg = t("EnterContextId", paramString, true);
    AppMethodBeat.o(189233);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bm
 * JD-Core Version:    0.7.0.1
 */