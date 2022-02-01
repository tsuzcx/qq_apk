package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cr
  extends a
{
  private String inx = "";
  private String iny = "";
  private String ixA = "";
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
    AppMethodBeat.i(368224);
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
    ((StringBuffer)localObject).append(this.ixA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixs);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368224);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368230);
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
    ((StringBuffer)localObject).append("ref_page_id:").append(this.ixA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentscene:").append(this.ixs);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368230);
    return localObject;
  }
  
  public final int getId()
  {
    return 22946;
  }
  
  public final cr mA(String paramString)
  {
    AppMethodBeat.i(368197);
    this.ixu = F("SubTabContextID", paramString, true);
    AppMethodBeat.o(368197);
    return this;
  }
  
  public final cr mB(String paramString)
  {
    AppMethodBeat.i(368201);
    this.ixv = F("pg_udf_kv", paramString, true);
    AppMethodBeat.o(368201);
    return this;
  }
  
  public final cr mC(String paramString)
  {
    AppMethodBeat.i(368209);
    this.ixA = F("ref_page_id", paramString, true);
    AppMethodBeat.o(368209);
    return this;
  }
  
  public final cr mD(String paramString)
  {
    AppMethodBeat.i(368215);
    this.ixs = F("commentscene", paramString, true);
    AppMethodBeat.o(368215);
    return this;
  }
  
  public final cr mu(String paramString)
  {
    AppMethodBeat.i(368166);
    this.ixz = F("pag_id", paramString, true);
    AppMethodBeat.o(368166);
    return this;
  }
  
  public final cr mv(String paramString)
  {
    AppMethodBeat.i(368172);
    this.ixq = F("tab_id", paramString, true);
    AppMethodBeat.o(368172);
    return this;
  }
  
  public final cr mw(String paramString)
  {
    AppMethodBeat.i(368177);
    this.ixr = F("sub_tab_id", paramString, true);
    AppMethodBeat.o(368177);
    return this;
  }
  
  public final cr mx(String paramString)
  {
    AppMethodBeat.i(368182);
    this.inx = F("sessionid", paramString, true);
    AppMethodBeat.o(368182);
    return this;
  }
  
  public final cr my(String paramString)
  {
    AppMethodBeat.i(368187);
    this.iny = F("contextid", paramString, true);
    AppMethodBeat.o(368187);
    return this;
  }
  
  public final cr mz(String paramString)
  {
    AppMethodBeat.i(368191);
    this.ixt = F("TabContextID", paramString, true);
    AppMethodBeat.o(368191);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.cr
 * JD-Core Version:    0.7.0.1
 */