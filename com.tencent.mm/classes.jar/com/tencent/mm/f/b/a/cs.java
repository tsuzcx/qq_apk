package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cs
  extends a
{
  private String gcV = "";
  private long geB;
  private String gjm = "";
  private String gnO = "";
  private long gnj;
  private String gnp = "";
  private long gqO;
  
  public final String agH()
  {
    AppMethodBeat.i(210153);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gjm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcV);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(210153);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(210157);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("feedid:").append(this.gjm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mediaType:").append(this.gqO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentscene:").append(this.gnj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.geB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.gnO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.gnp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.gcV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(210157);
    return localObject;
  }
  
  public final cs gc(long paramLong)
  {
    this.gqO = paramLong;
    return this;
  }
  
  public final cs gd(long paramLong)
  {
    this.gnj = paramLong;
    return this;
  }
  
  public final cs ge(long paramLong)
  {
    this.geB = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20353;
  }
  
  public final cs nc(String paramString)
  {
    AppMethodBeat.i(210128);
    this.gjm = z("feedid", paramString, true);
    AppMethodBeat.o(210128);
    return this;
  }
  
  public final cs nd(String paramString)
  {
    AppMethodBeat.i(210139);
    this.gnO = z("Sessionid", paramString, true);
    AppMethodBeat.o(210139);
    return this;
  }
  
  public final cs ne(String paramString)
  {
    AppMethodBeat.i(210142);
    this.gnp = z("Contextid", paramString, true);
    AppMethodBeat.o(210142);
    return this;
  }
  
  public final cs nf(String paramString)
  {
    AppMethodBeat.i(210147);
    this.gcV = z("ClickTabContextid", paramString, true);
    AppMethodBeat.o(210147);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.cs
 * JD-Core Version:    0.7.0.1
 */