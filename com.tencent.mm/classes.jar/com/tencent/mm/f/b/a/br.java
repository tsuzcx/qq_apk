package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class br
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
  
  public final String agH()
  {
    AppMethodBeat.i(272241);
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
    ((StringBuffer)localObject).append(this.gnZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goa);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(272241);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(272242);
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
    ((StringBuffer)localObject).append("eid:").append(this.gnZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("eld_udf_kv:").append(this.goa);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(272242);
    return localObject;
  }
  
  public final br ee(long paramLong)
  {
    this.gnR = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 23059;
  }
  
  public final br kA(String paramString)
  {
    AppMethodBeat.i(272232);
    this.gnU = z("sub_tab_id", paramString, true);
    AppMethodBeat.o(272232);
    return this;
  }
  
  public final br kB(String paramString)
  {
    AppMethodBeat.i(272233);
    this.ggA = z("sessionid", paramString, true);
    AppMethodBeat.o(272233);
    return this;
  }
  
  public final br kC(String paramString)
  {
    AppMethodBeat.i(272234);
    this.ggB = z("contextid", paramString, true);
    AppMethodBeat.o(272234);
    return this;
  }
  
  public final br kD(String paramString)
  {
    AppMethodBeat.i(272235);
    this.gnV = z("commentscene", paramString, true);
    AppMethodBeat.o(272235);
    return this;
  }
  
  public final br kE(String paramString)
  {
    AppMethodBeat.i(272236);
    this.gnW = z("TabContextID", paramString, true);
    AppMethodBeat.o(272236);
    return this;
  }
  
  public final br kF(String paramString)
  {
    AppMethodBeat.i(272237);
    this.gnX = z("SubTabContextID", paramString, true);
    AppMethodBeat.o(272237);
    return this;
  }
  
  public final br kG(String paramString)
  {
    AppMethodBeat.i(272238);
    this.gnY = z("pg_udf_kv", paramString, true);
    AppMethodBeat.o(272238);
    return this;
  }
  
  public final br kH(String paramString)
  {
    AppMethodBeat.i(272239);
    this.gnZ = z("eid", paramString, true);
    AppMethodBeat.o(272239);
    return this;
  }
  
  public final br kI(String paramString)
  {
    AppMethodBeat.i(272240);
    this.goa = z("eld_udf_kv", paramString, true);
    AppMethodBeat.o(272240);
    return this;
  }
  
  public final br kx(String paramString)
  {
    AppMethodBeat.i(272229);
    this.gnS = z("finderusername", paramString, true);
    AppMethodBeat.o(272229);
    return this;
  }
  
  public final br ky(String paramString)
  {
    AppMethodBeat.i(272230);
    this.gnM = z("chnl_extra", paramString, true);
    AppMethodBeat.o(272230);
    return this;
  }
  
  public final br kz(String paramString)
  {
    AppMethodBeat.i(272231);
    this.gnT = z("tab_id", paramString, true);
    AppMethodBeat.o(272231);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.br
 * JD-Core Version:    0.7.0.1
 */