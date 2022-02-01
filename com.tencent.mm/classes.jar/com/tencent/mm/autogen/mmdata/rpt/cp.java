package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cp
  extends a
{
  private String inx = "";
  private String iny = "";
  private String ixf = "";
  public long ixo;
  private String ixp = "";
  private String ixq = "";
  private String ixr = "";
  private String ixs = "";
  private String ixt = "";
  private String ixu = "";
  private String ixv = "";
  private String ixw = "";
  private String ixx = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368223);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ixo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iny);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixx);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368223);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368233);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("client_time:").append(this.ixo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("finderusername:").append(this.ixp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("chnl_extra:").append(this.ixf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("tab_id:").append(this.ixq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sub_tab_id:").append(this.ixr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.inx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextid:").append(this.iny);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentscene:").append(this.ixs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TabContextID:").append(this.ixt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubTabContextID:").append(this.ixu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pg_udf_kv:").append(this.ixv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("eid:").append(this.ixw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("eld_udf_kv:").append(this.ixx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368233);
    return localObject;
  }
  
  public final int getId()
  {
    return 23059;
  }
  
  public final cp lV(String paramString)
  {
    AppMethodBeat.i(368159);
    this.ixp = F("finderusername", paramString, true);
    AppMethodBeat.o(368159);
    return this;
  }
  
  public final cp lW(String paramString)
  {
    AppMethodBeat.i(368162);
    this.ixf = F("chnl_extra", paramString, true);
    AppMethodBeat.o(368162);
    return this;
  }
  
  public final cp lX(String paramString)
  {
    AppMethodBeat.i(368167);
    this.ixq = F("tab_id", paramString, true);
    AppMethodBeat.o(368167);
    return this;
  }
  
  public final cp lY(String paramString)
  {
    AppMethodBeat.i(368173);
    this.ixr = F("sub_tab_id", paramString, true);
    AppMethodBeat.o(368173);
    return this;
  }
  
  public final cp lZ(String paramString)
  {
    AppMethodBeat.i(368178);
    this.inx = F("sessionid", paramString, true);
    AppMethodBeat.o(368178);
    return this;
  }
  
  public final cp ma(String paramString)
  {
    AppMethodBeat.i(368183);
    this.iny = F("contextid", paramString, true);
    AppMethodBeat.o(368183);
    return this;
  }
  
  public final cp mb(String paramString)
  {
    AppMethodBeat.i(368188);
    this.ixs = F("commentscene", paramString, true);
    AppMethodBeat.o(368188);
    return this;
  }
  
  public final cp mc(String paramString)
  {
    AppMethodBeat.i(368192);
    this.ixt = F("TabContextID", paramString, true);
    AppMethodBeat.o(368192);
    return this;
  }
  
  public final cp md(String paramString)
  {
    AppMethodBeat.i(368196);
    this.ixu = F("SubTabContextID", paramString, true);
    AppMethodBeat.o(368196);
    return this;
  }
  
  public final cp me(String paramString)
  {
    AppMethodBeat.i(368202);
    this.ixv = F("pg_udf_kv", paramString, true);
    AppMethodBeat.o(368202);
    return this;
  }
  
  public final cp mf(String paramString)
  {
    AppMethodBeat.i(368208);
    this.ixw = F("eid", paramString, true);
    AppMethodBeat.o(368208);
    return this;
  }
  
  public final cp mg(String paramString)
  {
    AppMethodBeat.i(368214);
    this.ixx = F("eld_udf_kv", paramString, true);
    AppMethodBeat.o(368214);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.cp
 * JD-Core Version:    0.7.0.1
 */