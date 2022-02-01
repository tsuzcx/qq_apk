package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bq
  extends a
{
  private long gef;
  private String gjk = "";
  private String gnO = "";
  private long gnP;
  private long gnQ;
  private String gnp = "";
  
  public final String agH()
  {
    AppMethodBeat.i(208871);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gnO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gef);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnQ);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(208871);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(208873);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Sessionid:").append(this.gnO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.gnp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.gjk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.gef);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasWording:").append(this.gnQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208873);
    return localObject;
  }
  
  public final bq eb(long paramLong)
  {
    this.gnP = paramLong;
    return this;
  }
  
  public final bq ec(long paramLong)
  {
    this.gef = paramLong;
    return this;
  }
  
  public final bq ed(long paramLong)
  {
    this.gnQ = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19995;
  }
  
  public final bq ku(String paramString)
  {
    AppMethodBeat.i(208866);
    this.gnO = z("Sessionid", paramString, true);
    AppMethodBeat.o(208866);
    return this;
  }
  
  public final bq kv(String paramString)
  {
    AppMethodBeat.i(208867);
    this.gnp = z("Contextid", paramString, true);
    AppMethodBeat.o(208867);
    return this;
  }
  
  public final bq kw(String paramString)
  {
    AppMethodBeat.i(208869);
    this.gjk = z("ClickTabContextId", paramString, true);
    AppMethodBeat.o(208869);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.bq
 * JD-Core Version:    0.7.0.1
 */