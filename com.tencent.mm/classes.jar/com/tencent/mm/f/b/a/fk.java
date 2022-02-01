package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fk
  extends a
{
  private String gcV = "";
  private long geB;
  private String gjm = "";
  private String gnO = "";
  private long gnP;
  private long gnQ;
  private String gnp = "";
  private long gzC;
  private long gzD;
  private long gzE;
  
  public final String agH()
  {
    AppMethodBeat.i(210353);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gnP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzE);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(210353);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(210355);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.gnO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.gnp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.gcV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.gjm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.geB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasWording:").append(this.gnQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAction:").append(this.gzC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionStatus:").append(this.gzD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("wordingtype:").append(this.gzE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(210355);
    return localObject;
  }
  
  public final int getId()
  {
    return 20044;
  }
  
  public final fk nr(long paramLong)
  {
    this.gnP = paramLong;
    return this;
  }
  
  public final fk ns(long paramLong)
  {
    this.geB = paramLong;
    return this;
  }
  
  public final fk nt(long paramLong)
  {
    this.gzC = paramLong;
    return this;
  }
  
  public final fk nu(long paramLong)
  {
    this.gzD = paramLong;
    return this;
  }
  
  public final fk nv(long paramLong)
  {
    this.gzE = paramLong;
    return this;
  }
  
  public final fk up(String paramString)
  {
    AppMethodBeat.i(210347);
    this.gnO = z("Sessionid", paramString, true);
    AppMethodBeat.o(210347);
    return this;
  }
  
  public final fk uq(String paramString)
  {
    AppMethodBeat.i(210348);
    this.gnp = z("Contextid", paramString, true);
    AppMethodBeat.o(210348);
    return this;
  }
  
  public final fk ur(String paramString)
  {
    AppMethodBeat.i(210349);
    this.gcV = z("ClickTabContextid", paramString, true);
    AppMethodBeat.o(210349);
    return this;
  }
  
  public final fk us(String paramString)
  {
    AppMethodBeat.i(210350);
    this.gjm = z("feedid", paramString, true);
    AppMethodBeat.o(210350);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.fk
 * JD-Core Version:    0.7.0.1
 */