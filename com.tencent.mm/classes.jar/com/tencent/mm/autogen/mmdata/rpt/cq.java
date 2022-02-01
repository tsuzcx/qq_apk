package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cq
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
  private String ixy = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368238);
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
    ((StringBuffer)localObject).append(this.ixy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixx);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368238);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368246);
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
    ((StringBuffer)localObject).append("ref_commentscene:").append(this.ixy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("eid:").append(this.ixw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("eld_udf_kv:").append(this.ixx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368246);
    return localObject;
  }
  
  public final int getId()
  {
    return 23057;
  }
  
  public final cq mh(String paramString)
  {
    AppMethodBeat.i(368160);
    this.ixp = F("finderusername", paramString, true);
    AppMethodBeat.o(368160);
    return this;
  }
  
  public final cq mi(String paramString)
  {
    AppMethodBeat.i(368164);
    this.ixf = F("chnl_extra", paramString, true);
    AppMethodBeat.o(368164);
    return this;
  }
  
  public final cq mj(String paramString)
  {
    AppMethodBeat.i(368170);
    this.ixq = F("tab_id", paramString, true);
    AppMethodBeat.o(368170);
    return this;
  }
  
  public final cq mk(String paramString)
  {
    AppMethodBeat.i(368175);
    this.ixr = F("sub_tab_id", paramString, true);
    AppMethodBeat.o(368175);
    return this;
  }
  
  public final cq ml(String paramString)
  {
    AppMethodBeat.i(368180);
    this.inx = F("sessionid", paramString, true);
    AppMethodBeat.o(368180);
    return this;
  }
  
  public final cq mm(String paramString)
  {
    AppMethodBeat.i(368186);
    this.iny = F("contextid", paramString, true);
    AppMethodBeat.o(368186);
    return this;
  }
  
  public final cq mn(String paramString)
  {
    AppMethodBeat.i(368190);
    this.ixs = F("commentscene", paramString, true);
    AppMethodBeat.o(368190);
    return this;
  }
  
  public final cq mo(String paramString)
  {
    AppMethodBeat.i(368195);
    this.ixt = F("TabContextID", paramString, true);
    AppMethodBeat.o(368195);
    return this;
  }
  
  public final cq mp(String paramString)
  {
    AppMethodBeat.i(368200);
    this.ixu = F("SubTabContextID", paramString, true);
    AppMethodBeat.o(368200);
    return this;
  }
  
  public final cq mq(String paramString)
  {
    AppMethodBeat.i(368206);
    this.ixv = F("pg_udf_kv", paramString, true);
    AppMethodBeat.o(368206);
    return this;
  }
  
  public final cq mr(String paramString)
  {
    AppMethodBeat.i(368212);
    this.ixy = F("ref_commentscene", paramString, true);
    AppMethodBeat.o(368212);
    return this;
  }
  
  public final cq ms(String paramString)
  {
    AppMethodBeat.i(368218);
    this.ixw = F("eid", paramString, true);
    AppMethodBeat.o(368218);
    return this;
  }
  
  public final cq mt(String paramString)
  {
    AppMethodBeat.i(368226);
    this.ixx = F("eld_udf_kv", paramString, true);
    AppMethodBeat.o(368226);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.cq
 * JD-Core Version:    0.7.0.1
 */