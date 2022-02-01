package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cs
  extends a
{
  private String inx = "";
  private String iny = "";
  public long ixo;
  private String ixq = "";
  private String ixr = "";
  private String ixs = "";
  private String ixt = "";
  private String ixu = "";
  private String ixv = "";
  private String ixz = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368163);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ixo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iny);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixs);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368163);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368168);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("client_time:").append(this.ixo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pag_id:").append(this.ixz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("tab_id:").append(this.ixq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sub_tab_id:").append(this.ixr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.inx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextid:").append(this.iny);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TabContextID:").append(this.ixt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubTabContextID:").append(this.ixu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pg_udf_kv:").append(this.ixv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentscene:").append(this.ixs);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368168);
    return localObject;
  }
  
  public final int getId()
  {
    return 22947;
  }
  
  public final cs mE(String paramString)
  {
    AppMethodBeat.i(368117);
    this.ixz = F("pag_id", paramString, true);
    AppMethodBeat.o(368117);
    return this;
  }
  
  public final cs mF(String paramString)
  {
    AppMethodBeat.i(368123);
    this.ixq = F("tab_id", paramString, true);
    AppMethodBeat.o(368123);
    return this;
  }
  
  public final cs mG(String paramString)
  {
    AppMethodBeat.i(368128);
    this.ixr = F("sub_tab_id", paramString, true);
    AppMethodBeat.o(368128);
    return this;
  }
  
  public final cs mH(String paramString)
  {
    AppMethodBeat.i(368134);
    this.inx = F("sessionid", paramString, true);
    AppMethodBeat.o(368134);
    return this;
  }
  
  public final cs mI(String paramString)
  {
    AppMethodBeat.i(368140);
    this.iny = F("contextid", paramString, true);
    AppMethodBeat.o(368140);
    return this;
  }
  
  public final cs mJ(String paramString)
  {
    AppMethodBeat.i(368146);
    this.ixt = F("TabContextID", paramString, true);
    AppMethodBeat.o(368146);
    return this;
  }
  
  public final cs mK(String paramString)
  {
    AppMethodBeat.i(368149);
    this.ixu = F("SubTabContextID", paramString, true);
    AppMethodBeat.o(368149);
    return this;
  }
  
  public final cs mL(String paramString)
  {
    AppMethodBeat.i(368154);
    this.ixv = F("pg_udf_kv", paramString, true);
    AppMethodBeat.o(368154);
    return this;
  }
  
  public final cs mM(String paramString)
  {
    AppMethodBeat.i(368158);
    this.ixs = F("commentscene", paramString, true);
    AppMethodBeat.o(368158);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.cs
 * JD-Core Version:    0.7.0.1
 */