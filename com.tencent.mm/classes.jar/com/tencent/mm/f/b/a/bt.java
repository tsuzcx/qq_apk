package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bt
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
  private String god = "";
  
  public final String agH()
  {
    AppMethodBeat.i(208762);
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
    ((StringBuffer)localObject).append(this.god);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnV);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(208762);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(208763);
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
    ((StringBuffer)localObject).append("ref_page_id:").append(this.god);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentscene:").append(this.gnV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208763);
    return localObject;
  }
  
  public final bt eg(long paramLong)
  {
    this.gnR = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 22946;
  }
  
  public final bt kW(String paramString)
  {
    AppMethodBeat.i(208752);
    this.goc = z("pag_id", paramString, true);
    AppMethodBeat.o(208752);
    return this;
  }
  
  public final bt kX(String paramString)
  {
    AppMethodBeat.i(208753);
    this.gnT = z("tab_id", paramString, true);
    AppMethodBeat.o(208753);
    return this;
  }
  
  public final bt kY(String paramString)
  {
    AppMethodBeat.i(208754);
    this.gnU = z("sub_tab_id", paramString, true);
    AppMethodBeat.o(208754);
    return this;
  }
  
  public final bt kZ(String paramString)
  {
    AppMethodBeat.i(208755);
    this.ggA = z("sessionid", paramString, true);
    AppMethodBeat.o(208755);
    return this;
  }
  
  public final bt la(String paramString)
  {
    AppMethodBeat.i(208756);
    this.ggB = z("contextid", paramString, true);
    AppMethodBeat.o(208756);
    return this;
  }
  
  public final bt lb(String paramString)
  {
    AppMethodBeat.i(208757);
    this.gnW = z("TabContextID", paramString, true);
    AppMethodBeat.o(208757);
    return this;
  }
  
  public final bt lc(String paramString)
  {
    AppMethodBeat.i(208758);
    this.gnX = z("SubTabContextID", paramString, true);
    AppMethodBeat.o(208758);
    return this;
  }
  
  public final bt ld(String paramString)
  {
    AppMethodBeat.i(208759);
    this.gnY = z("pg_udf_kv", paramString, true);
    AppMethodBeat.o(208759);
    return this;
  }
  
  public final bt le(String paramString)
  {
    AppMethodBeat.i(208760);
    this.god = z("ref_page_id", paramString, true);
    AppMethodBeat.o(208760);
    return this;
  }
  
  public final bt lf(String paramString)
  {
    AppMethodBeat.i(208761);
    this.gnV = z("commentscene", paramString, true);
    AppMethodBeat.o(208761);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.bt
 * JD-Core Version:    0.7.0.1
 */