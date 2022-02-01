package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ok
  extends a
{
  private long giq;
  private String gjj = "";
  private long gjl;
  private String gqj = "";
  private String hbF = "";
  private String hbG = "";
  private String hbH = "";
  
  public final ok AQ(long paramLong)
  {
    this.giq = paramLong;
    return this;
  }
  
  public final ok AR(long paramLong)
  {
    this.gjl = paramLong;
    return this;
  }
  
  public final ok Fu(String paramString)
  {
    AppMethodBeat.i(207686);
    this.hbF = z("AppID", paramString, true);
    AppMethodBeat.o(207686);
    return this;
  }
  
  public final ok Fv(String paramString)
  {
    AppMethodBeat.i(207689);
    this.gqj = z("sessionID", paramString, true);
    AppMethodBeat.o(207689);
    return this;
  }
  
  public final ok Fw(String paramString)
  {
    AppMethodBeat.i(207691);
    this.gjj = z("ContextId", paramString, true);
    AppMethodBeat.o(207691);
    return this;
  }
  
  public final ok Fx(String paramString)
  {
    AppMethodBeat.i(207692);
    this.hbG = z("click_tab_context_id", paramString, true);
    AppMethodBeat.o(207692);
    return this;
  }
  
  public final ok Fy(String paramString)
  {
    AppMethodBeat.i(207696);
    this.hbH = z("pageResrouceID", paramString, true);
    AppMethodBeat.o(207696);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(207699);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.hbF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbH);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(207699);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(207702);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppID:").append(this.hbF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.giq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionID:").append(this.gqj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.gjj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("click_tab_context_id:").append(this.hbG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.gjl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pageResrouceID:").append(this.hbH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(207702);
    return localObject;
  }
  
  public final int getId()
  {
    return 22265;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ok
 * JD-Core Version:    0.7.0.1
 */