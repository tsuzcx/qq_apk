package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bs
  extends a
{
  private String ggA = "";
  private String ggB = "";
  private String gnM = "";
  private long gnR;
  private String gnS = "";
  private String gnT = "";
  private String gnU = "";
  private String gnV = "";
  private String gnW = "";
  private String gnX = "";
  private String gnY = "";
  private String gnZ = "";
  private String goa = "";
  private String gob = "";
  
  public final String agH()
  {
    AppMethodBeat.i(279685);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gnR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gob);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goa);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(279685);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(279686);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("client_time:").append(this.gnR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("finderusername:").append(this.gnS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("chnl_extra:").append(this.gnM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("tab_id:").append(this.gnT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sub_tab_id:").append(this.gnU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.ggA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextid:").append(this.ggB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentscene:").append(this.gnV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TabContextID:").append(this.gnW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubTabContextID:").append(this.gnX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pg_udf_kv:").append(this.gnY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ref_commentscene:").append(this.gob);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("eid:").append(this.gnZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("eld_udf_kv:").append(this.goa);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(279686);
    return localObject;
  }
  
  public final bs ef(long paramLong)
  {
    this.gnR = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 23057;
  }
  
  public final bs kJ(String paramString)
  {
    AppMethodBeat.i(279667);
    this.gnS = z("finderusername", paramString, true);
    AppMethodBeat.o(279667);
    return this;
  }
  
  public final bs kK(String paramString)
  {
    AppMethodBeat.i(279668);
    this.gnM = z("chnl_extra", paramString, true);
    AppMethodBeat.o(279668);
    return this;
  }
  
  public final bs kL(String paramString)
  {
    AppMethodBeat.i(279670);
    this.gnT = z("tab_id", paramString, true);
    AppMethodBeat.o(279670);
    return this;
  }
  
  public final bs kM(String paramString)
  {
    AppMethodBeat.i(279672);
    this.gnU = z("sub_tab_id", paramString, true);
    AppMethodBeat.o(279672);
    return this;
  }
  
  public final bs kN(String paramString)
  {
    AppMethodBeat.i(279674);
    this.ggA = z("sessionid", paramString, true);
    AppMethodBeat.o(279674);
    return this;
  }
  
  public final bs kO(String paramString)
  {
    AppMethodBeat.i(279677);
    this.ggB = z("contextid", paramString, true);
    AppMethodBeat.o(279677);
    return this;
  }
  
  public final bs kP(String paramString)
  {
    AppMethodBeat.i(279678);
    this.gnV = z("commentscene", paramString, true);
    AppMethodBeat.o(279678);
    return this;
  }
  
  public final bs kQ(String paramString)
  {
    AppMethodBeat.i(279679);
    this.gnW = z("TabContextID", paramString, true);
    AppMethodBeat.o(279679);
    return this;
  }
  
  public final bs kR(String paramString)
  {
    AppMethodBeat.i(279680);
    this.gnX = z("SubTabContextID", paramString, true);
    AppMethodBeat.o(279680);
    return this;
  }
  
  public final bs kS(String paramString)
  {
    AppMethodBeat.i(279681);
    this.gnY = z("pg_udf_kv", paramString, true);
    AppMethodBeat.o(279681);
    return this;
  }
  
  public final bs kT(String paramString)
  {
    AppMethodBeat.i(279682);
    this.gob = z("ref_commentscene", paramString, true);
    AppMethodBeat.o(279682);
    return this;
  }
  
  public final bs kU(String paramString)
  {
    AppMethodBeat.i(279683);
    this.gnZ = z("eid", paramString, true);
    AppMethodBeat.o(279683);
    return this;
  }
  
  public final bs kV(String paramString)
  {
    AppMethodBeat.i(279684);
    this.goa = z("eld_udf_kv", paramString, true);
    AppMethodBeat.o(279684);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.bs
 * JD-Core Version:    0.7.0.1
 */