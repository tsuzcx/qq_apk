package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class aj
  extends a
{
  private int dFD;
  private String dFY;
  private long dHT;
  private String dHX;
  private int dHw;
  private String dJd;
  private String dJe;
  private int dJf;
  private long dJg;
  private long dJh;
  private String dJi;
  private int dJj;
  private String dJk;
  private long dJl;
  private String dJm;
  private String dJn;
  
  public final String PR()
  {
    AppMethodBeat.i(194924);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dJd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFY);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(194924);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(194925);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FeedID:").append(this.dJd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dHw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.dFD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionValue:").append(this.dJe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionCurrentVersion:").append(this.dJf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStamp:").append(this.dJg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStampMs:").append(this.dJh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionID:").append(this.dJi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mediaType:").append(this.dJj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionBuffer:").append(this.dJk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("videoDurationTime:").append(this.dJl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.dHT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickFeedId:").append(this.dJm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickFeedContextId:").append(this.dJn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dHX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dFY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(194925);
    return localObject;
  }
  
  public final aj de(long paramLong)
  {
    AppMethodBeat.i(194917);
    this.dJh = paramLong;
    super.bd("ActionTimeStampMs", this.dJh);
    AppMethodBeat.o(194917);
    return this;
  }
  
  public final aj df(long paramLong)
  {
    this.dJl = paramLong;
    return this;
  }
  
  public final aj dg(long paramLong)
  {
    this.dHT = paramLong;
    return this;
  }
  
  public final aj gO(String paramString)
  {
    AppMethodBeat.i(194915);
    this.dJd = t("FeedID", paramString, true);
    AppMethodBeat.o(194915);
    return this;
  }
  
  public final aj gP(String paramString)
  {
    AppMethodBeat.i(194916);
    this.dJe = t("ActionValue", paramString, true);
    AppMethodBeat.o(194916);
    return this;
  }
  
  public final aj gQ(String paramString)
  {
    AppMethodBeat.i(194918);
    this.dJi = t("sessionID", paramString, true);
    AppMethodBeat.o(194918);
    return this;
  }
  
  public final aj gR(String paramString)
  {
    AppMethodBeat.i(194919);
    this.dJk = t("sessionBuffer", paramString, true);
    AppMethodBeat.o(194919);
    return this;
  }
  
  public final aj gS(String paramString)
  {
    AppMethodBeat.i(194920);
    this.dJm = t("ClickFeedId", paramString, true);
    AppMethodBeat.o(194920);
    return this;
  }
  
  public final aj gT(String paramString)
  {
    AppMethodBeat.i(194921);
    this.dJn = t("ClickFeedContextId", paramString, true);
    AppMethodBeat.o(194921);
    return this;
  }
  
  public final aj gU(String paramString)
  {
    AppMethodBeat.i(194922);
    this.dHX = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(194922);
    return this;
  }
  
  public final aj gV(String paramString)
  {
    AppMethodBeat.i(194923);
    this.dFY = t("ContextId", paramString, true);
    AppMethodBeat.o(194923);
    return this;
  }
  
  public final int getId()
  {
    return 18054;
  }
  
  public final aj id(int paramInt)
  {
    this.dFD = paramInt;
    return this;
  }
  
  public final aj ie(int paramInt)
  {
    this.dJf = paramInt;
    return this;
  }
  
  public final aj jdMethod_if(int paramInt)
  {
    this.dJj = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.aj
 * JD-Core Version:    0.7.0.1
 */