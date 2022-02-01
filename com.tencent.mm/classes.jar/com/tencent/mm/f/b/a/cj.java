package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cj
  extends a
{
  private String gcU = "";
  private String gfY = "";
  private long giq;
  private String gjw = "";
  private long gnj;
  private String gnp = "";
  private String goj = "";
  private long gpR;
  private String gpS = "";
  private String gpT = "";
  
  public final String agH()
  {
    AppMethodBeat.i(209439);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gjw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpT);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209439);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209440);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Feedid:").append(this.gjw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.gnp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Url:").append(this.gfY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UrlType:").append(this.gpR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.giq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MiniAppId:").append(this.gpS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clicktabcontextid:").append(this.goj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentscene:").append(this.gnj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionBuffer:").append(this.gpT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209440);
    return localObject;
  }
  
  public final cj ahw()
  {
    this.gpR = 1L;
    return this;
  }
  
  public final cj ft(long paramLong)
  {
    this.giq = paramLong;
    return this;
  }
  
  public final cj fu(long paramLong)
  {
    this.gnj = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 21464;
  }
  
  public final cj mo(String paramString)
  {
    AppMethodBeat.i(209429);
    this.gjw = z("Feedid", paramString, true);
    AppMethodBeat.o(209429);
    return this;
  }
  
  public final cj mp(String paramString)
  {
    AppMethodBeat.i(209431);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(209431);
    return this;
  }
  
  public final cj mq(String paramString)
  {
    AppMethodBeat.i(209433);
    this.gnp = z("Contextid", paramString, true);
    AppMethodBeat.o(209433);
    return this;
  }
  
  public final cj mr(String paramString)
  {
    AppMethodBeat.i(209434);
    this.gfY = z("Url", paramString, true);
    AppMethodBeat.o(209434);
    return this;
  }
  
  public final cj ms(String paramString)
  {
    AppMethodBeat.i(209436);
    this.goj = z("clicktabcontextid", paramString, true);
    AppMethodBeat.o(209436);
    return this;
  }
  
  public final cj mt(String paramString)
  {
    AppMethodBeat.i(209437);
    this.gpT = z("sessionBuffer", paramString, true);
    AppMethodBeat.o(209437);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.cj
 * JD-Core Version:    0.7.0.1
 */