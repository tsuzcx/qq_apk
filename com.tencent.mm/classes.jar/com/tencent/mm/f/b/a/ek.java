package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ek
  extends a
{
  private String gcU = "";
  private String gjj = "";
  private String gjk = "";
  private long gjl;
  private String gmO = "";
  private String gxk = "";
  private String gxl = "";
  private long gxm;
  
  public final String agH()
  {
    AppMethodBeat.i(208067);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gxk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gxl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gxm);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(208067);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(208069);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.gjj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.gjk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddUsername:").append(this.gxk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeleteUsername:").append(this.gxl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.gmO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.gjl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("refuseLastCount:").append(this.gxm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208069);
    return localObject;
  }
  
  public final int getId()
  {
    return 19957;
  }
  
  public final ek lw(long paramLong)
  {
    this.gjl = paramLong;
    return this;
  }
  
  public final ek lx(long paramLong)
  {
    this.gxm = paramLong;
    return this;
  }
  
  public final ek sl(String paramString)
  {
    AppMethodBeat.i(208055);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(208055);
    return this;
  }
  
  public final ek sm(String paramString)
  {
    AppMethodBeat.i(208056);
    this.gjj = z("ContextId", paramString, true);
    AppMethodBeat.o(208056);
    return this;
  }
  
  public final ek sn(String paramString)
  {
    AppMethodBeat.i(208057);
    this.gjk = z("ClickTabContextId", paramString, true);
    AppMethodBeat.o(208057);
    return this;
  }
  
  public final ek so(String paramString)
  {
    AppMethodBeat.i(208059);
    this.gxk = z("AddUsername", paramString, true);
    AppMethodBeat.o(208059);
    return this;
  }
  
  public final ek sp(String paramString)
  {
    AppMethodBeat.i(208062);
    this.gxl = z("DeleteUsername", paramString, true);
    AppMethodBeat.o(208062);
    return this;
  }
  
  public final ek sq(String paramString)
  {
    AppMethodBeat.i(208064);
    this.gmO = z("FeedId", paramString, true);
    AppMethodBeat.o(208064);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ek
 * JD-Core Version:    0.7.0.1
 */