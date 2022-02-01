package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bu
  extends a
{
  private String ggA = "";
  private String ggB = "";
  private long gnR;
  private String gnT = "";
  private String gnU = "";
  private String gnV = "";
  private String gnW = "";
  private String gnX = "";
  private String gnY = "";
  private String goc = "";
  
  public final String agH()
  {
    AppMethodBeat.i(209747);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gnR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnV);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209747);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209749);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("client_time:").append(this.gnR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pag_id:").append(this.goc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("tab_id:").append(this.gnT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sub_tab_id:").append(this.gnU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.ggA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextid:").append(this.ggB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TabContextID:").append(this.gnW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubTabContextID:").append(this.gnX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pg_udf_kv:").append(this.gnY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentscene:").append(this.gnV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209749);
    return localObject;
  }
  
  public final bu eh(long paramLong)
  {
    this.gnR = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 22947;
  }
  
  public final bu lg(String paramString)
  {
    AppMethodBeat.i(209730);
    this.goc = z("pag_id", paramString, true);
    AppMethodBeat.o(209730);
    return this;
  }
  
  public final bu lh(String paramString)
  {
    AppMethodBeat.i(209733);
    this.gnT = z("tab_id", paramString, true);
    AppMethodBeat.o(209733);
    return this;
  }
  
  public final bu li(String paramString)
  {
    AppMethodBeat.i(209735);
    this.gnU = z("sub_tab_id", paramString, true);
    AppMethodBeat.o(209735);
    return this;
  }
  
  public final bu lj(String paramString)
  {
    AppMethodBeat.i(209737);
    this.ggA = z("sessionid", paramString, true);
    AppMethodBeat.o(209737);
    return this;
  }
  
  public final bu lk(String paramString)
  {
    AppMethodBeat.i(209738);
    this.ggB = z("contextid", paramString, true);
    AppMethodBeat.o(209738);
    return this;
  }
  
  public final bu ll(String paramString)
  {
    AppMethodBeat.i(209740);
    this.gnW = z("TabContextID", paramString, true);
    AppMethodBeat.o(209740);
    return this;
  }
  
  public final bu lm(String paramString)
  {
    AppMethodBeat.i(209741);
    this.gnX = z("SubTabContextID", paramString, true);
    AppMethodBeat.o(209741);
    return this;
  }
  
  public final bu ln(String paramString)
  {
    AppMethodBeat.i(209743);
    this.gnY = z("pg_udf_kv", paramString, true);
    AppMethodBeat.o(209743);
    return this;
  }
  
  public final bu lo(String paramString)
  {
    AppMethodBeat.i(209745);
    this.gnV = z("commentscene", paramString, true);
    AppMethodBeat.o(209745);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.bu
 * JD-Core Version:    0.7.0.1
 */