package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ar
  extends a
{
  private int dTY;
  private int dTw;
  private String dUt = "";
  private long dWo;
  private String dWs = "";
  private String dXu = "";
  private String dXv = "";
  private String dYe = "";
  private String dYf = "";
  private int dYg;
  private long dYh;
  private long dYi;
  private String dYj = "";
  private int dYk;
  private String dYl = "";
  private long dYm;
  private String dYn = "";
  private String dYo = "";
  
  public final String RC()
  {
    AppMethodBeat.i(189126);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXv);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189126);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189127);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FeedID:").append(this.dYe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dTw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.dTY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionValue:").append(this.dYf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionCurrentVersion:").append(this.dYg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStamp:").append(this.dYh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStampMs:").append(this.dYi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionID:").append(this.dYj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mediaType:").append(this.dYk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionBuffer:").append(this.dYl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("videoDurationTime:").append(this.dYm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.dWo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickFeedId:").append(this.dYn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickFeedContextId:").append(this.dYo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dWs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dUt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtraInfo:").append(this.dXu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("enterSourceInfo:").append(this.dXv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189127);
    return localObject;
  }
  
  public final ar dB(long paramLong)
  {
    AppMethodBeat.i(189117);
    this.dYi = paramLong;
    super.bh("ActionTimeStampMs", this.dYi);
    AppMethodBeat.o(189117);
    return this;
  }
  
  public final ar dC(long paramLong)
  {
    this.dYm = paramLong;
    return this;
  }
  
  public final ar dD(long paramLong)
  {
    this.dWo = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 18054;
  }
  
  public final ar ih(String paramString)
  {
    AppMethodBeat.i(189115);
    this.dYe = t("FeedID", paramString, true);
    AppMethodBeat.o(189115);
    return this;
  }
  
  public final ar ii(String paramString)
  {
    AppMethodBeat.i(189116);
    this.dYf = t("ActionValue", paramString, true);
    AppMethodBeat.o(189116);
    return this;
  }
  
  public final ar ij(String paramString)
  {
    AppMethodBeat.i(189118);
    this.dYj = t("sessionID", paramString, true);
    AppMethodBeat.o(189118);
    return this;
  }
  
  public final ar ik(String paramString)
  {
    AppMethodBeat.i(189119);
    this.dYl = t("sessionBuffer", paramString, true);
    AppMethodBeat.o(189119);
    return this;
  }
  
  public final ar il(String paramString)
  {
    AppMethodBeat.i(189120);
    this.dYn = t("ClickFeedId", paramString, true);
    AppMethodBeat.o(189120);
    return this;
  }
  
  public final ar im(String paramString)
  {
    AppMethodBeat.i(189121);
    this.dYo = t("ClickFeedContextId", paramString, true);
    AppMethodBeat.o(189121);
    return this;
  }
  
  public final ar in(String paramString)
  {
    AppMethodBeat.i(189122);
    this.dWs = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(189122);
    return this;
  }
  
  public final ar io(String paramString)
  {
    AppMethodBeat.i(189123);
    this.dUt = t("ContextId", paramString, true);
    AppMethodBeat.o(189123);
    return this;
  }
  
  public final ar ip(String paramString)
  {
    AppMethodBeat.i(189124);
    this.dXu = t("ExtraInfo", paramString, true);
    AppMethodBeat.o(189124);
    return this;
  }
  
  public final ar iq(int paramInt)
  {
    this.dTY = paramInt;
    return this;
  }
  
  public final ar iq(String paramString)
  {
    AppMethodBeat.i(189125);
    this.dXv = t("enterSourceInfo", paramString, true);
    AppMethodBeat.o(189125);
    return this;
  }
  
  public final ar ir(int paramInt)
  {
    this.dYg = paramInt;
    return this;
  }
  
  public final ar is(int paramInt)
  {
    this.dYk = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ar
 * JD-Core Version:    0.7.0.1
 */