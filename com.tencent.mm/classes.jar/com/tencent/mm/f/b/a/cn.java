package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cn
  extends a
{
  private int ggl;
  private int giX;
  private String gjj = "";
  private String gjk = "";
  private long gjl;
  private String glD = "";
  private String gnq = "";
  private String gnr = "";
  private String gpT = "";
  private String gqf = "";
  private int gqg;
  private long gqh;
  private long gqi;
  private String gqj = "";
  private int gqk;
  private long gql;
  private String gqm = "";
  private String gqn = "";
  private String gqo = "";
  private long gqp;
  
  public final String agH()
  {
    AppMethodBeat.i(209781);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.glD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gql);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqp);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209781);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209782);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FeedID:").append(this.glD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.ggl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.giX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionValue:").append(this.gqf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionCurrentVersion:").append(this.gqg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStamp:").append(this.gqh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStampMs:").append(this.gqi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionID:").append(this.gqj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mediaType:").append(this.gqk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionBuffer:").append(this.gpT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("videoDurationTime:").append(this.gql);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.gjl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickFeedId:").append(this.gqm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickFeedContextId:").append(this.gqn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.gjk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.gjj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtraInfo:").append(this.gnq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("enterSourceInfo:").append(this.gnr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LongVideoId:").append(this.gqo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedDisplayType:").append(this.gqp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209782);
    return localObject;
  }
  
  public final cn fF(long paramLong)
  {
    AppMethodBeat.i(209763);
    this.gqi = paramLong;
    super.bm("ActionTimeStampMs", this.gqi);
    AppMethodBeat.o(209763);
    return this;
  }
  
  public final cn fG(long paramLong)
  {
    this.gql = paramLong;
    return this;
  }
  
  public final cn fH(long paramLong)
  {
    this.gjl = paramLong;
    return this;
  }
  
  public final cn fI(long paramLong)
  {
    this.gqp = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 18054;
  }
  
  public final String getSessionBuffer()
  {
    return this.gpT;
  }
  
  public final cn ls(int paramInt)
  {
    this.giX = paramInt;
    return this;
  }
  
  public final cn lt(int paramInt)
  {
    this.gqg = paramInt;
    return this;
  }
  
  public final cn lu(int paramInt)
  {
    this.gqk = paramInt;
    return this;
  }
  
  public final cn mE(String paramString)
  {
    AppMethodBeat.i(209759);
    this.glD = z("FeedID", paramString, true);
    AppMethodBeat.o(209759);
    return this;
  }
  
  public final cn mF(String paramString)
  {
    AppMethodBeat.i(209762);
    this.gqf = z("ActionValue", paramString, true);
    AppMethodBeat.o(209762);
    return this;
  }
  
  public final cn mG(String paramString)
  {
    AppMethodBeat.i(209765);
    this.gqj = z("sessionID", paramString, true);
    AppMethodBeat.o(209765);
    return this;
  }
  
  public final cn mH(String paramString)
  {
    AppMethodBeat.i(209769);
    this.gpT = z("sessionBuffer", paramString, true);
    AppMethodBeat.o(209769);
    return this;
  }
  
  public final cn mI(String paramString)
  {
    AppMethodBeat.i(209772);
    this.gqm = z("ClickFeedId", paramString, true);
    AppMethodBeat.o(209772);
    return this;
  }
  
  public final cn mJ(String paramString)
  {
    AppMethodBeat.i(209774);
    this.gqn = z("ClickFeedContextId", paramString, true);
    AppMethodBeat.o(209774);
    return this;
  }
  
  public final cn mK(String paramString)
  {
    AppMethodBeat.i(209775);
    this.gjk = z("ClickTabContextId", paramString, true);
    AppMethodBeat.o(209775);
    return this;
  }
  
  public final cn mL(String paramString)
  {
    AppMethodBeat.i(209776);
    this.gjj = z("ContextId", paramString, true);
    AppMethodBeat.o(209776);
    return this;
  }
  
  public final cn mM(String paramString)
  {
    AppMethodBeat.i(209777);
    this.gnq = z("ExtraInfo", paramString, true);
    AppMethodBeat.o(209777);
    return this;
  }
  
  public final cn mN(String paramString)
  {
    AppMethodBeat.i(209779);
    this.gnr = z("enterSourceInfo", paramString, true);
    AppMethodBeat.o(209779);
    return this;
  }
  
  public final cn mO(String paramString)
  {
    AppMethodBeat.i(209780);
    this.gqo = z("LongVideoId", paramString, true);
    AppMethodBeat.o(209780);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.cn
 * JD-Core Version:    0.7.0.1
 */