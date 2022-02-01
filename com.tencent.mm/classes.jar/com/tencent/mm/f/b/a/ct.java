package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ct
  extends a
{
  private String gcU = "";
  private String gjB = "";
  private String gjj = "";
  private String gjk = "";
  private long gnP;
  private String gpA = "";
  private long gpB;
  private String gpD = "";
  private String gqP = "";
  private String gqQ = "";
  private long gqR;
  private long gqS;
  private String gqT = "";
  private long gqU;
  private String gqV = "";
  private long gqW;
  private String gqX = "";
  private long gqY;
  
  public final String agH()
  {
    AppMethodBeat.i(210058);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gnP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqY);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(210058);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(210059);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.gjj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.gjk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickFeedid:").append(this.gqP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AllFeedInfo:").append(this.gqQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RefreshTime:").append(this.gqR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTimeStamp:").append(this.gqS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageTag:").append(this.gqT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionBuffer:").append(this.gjB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MediaType:").append(this.gqU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ScreenInfo:").append(this.gqV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecommendType:").append(this.gqW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecommendWording:").append(this.gqX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GroupID:").append(this.gpA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TrackType:").append(this.gpB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActivityID:").append(this.gpD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActivitySortType:").append(this.gqY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(210059);
    return localObject;
  }
  
  public final int getId()
  {
    return 19993;
  }
  
  public final ct gf(long paramLong)
  {
    this.gnP = paramLong;
    return this;
  }
  
  public final ct gg(long paramLong)
  {
    this.gqR = paramLong;
    return this;
  }
  
  public final ct gh(long paramLong)
  {
    this.gqS = paramLong;
    return this;
  }
  
  public final ct gi(long paramLong)
  {
    this.gqU = paramLong;
    return this;
  }
  
  public final ct gj(long paramLong)
  {
    this.gqW = paramLong;
    return this;
  }
  
  public final ct gk(long paramLong)
  {
    this.gpB = paramLong;
    return this;
  }
  
  public final ct gl(long paramLong)
  {
    this.gqY = paramLong;
    return this;
  }
  
  public final ct ng(String paramString)
  {
    AppMethodBeat.i(210043);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(210043);
    return this;
  }
  
  public final ct nh(String paramString)
  {
    AppMethodBeat.i(210044);
    this.gjj = z("ContextId", paramString, true);
    AppMethodBeat.o(210044);
    return this;
  }
  
  public final ct ni(String paramString)
  {
    AppMethodBeat.i(210045);
    this.gjk = z("ClickTabContextId", paramString, true);
    AppMethodBeat.o(210045);
    return this;
  }
  
  public final ct nj(String paramString)
  {
    AppMethodBeat.i(210047);
    this.gqP = z("ClickFeedid", paramString, true);
    AppMethodBeat.o(210047);
    return this;
  }
  
  public final ct nk(String paramString)
  {
    AppMethodBeat.i(210048);
    this.gqQ = z("AllFeedInfo", paramString, true);
    AppMethodBeat.o(210048);
    return this;
  }
  
  public final ct nl(String paramString)
  {
    AppMethodBeat.i(210050);
    this.gqT = z("PageTag", paramString, true);
    AppMethodBeat.o(210050);
    return this;
  }
  
  public final ct nm(String paramString)
  {
    AppMethodBeat.i(210051);
    this.gjB = z("SessionBuffer", paramString, true);
    AppMethodBeat.o(210051);
    return this;
  }
  
  public final ct nn(String paramString)
  {
    AppMethodBeat.i(210052);
    this.gqV = z("ScreenInfo", paramString, true);
    AppMethodBeat.o(210052);
    return this;
  }
  
  public final ct no(String paramString)
  {
    AppMethodBeat.i(210054);
    this.gqX = z("RecommendWording", paramString, true);
    AppMethodBeat.o(210054);
    return this;
  }
  
  public final ct np(String paramString)
  {
    AppMethodBeat.i(210055);
    this.gpA = z("GroupID", paramString, true);
    AppMethodBeat.o(210055);
    return this;
  }
  
  public final ct nq(String paramString)
  {
    AppMethodBeat.i(210056);
    this.gpD = z("ActivityID", paramString, true);
    AppMethodBeat.o(210056);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ct
 * JD-Core Version:    0.7.0.1
 */