package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gk
  extends a
{
  private String iAN = "";
  private String iAa = "";
  private String iGJ = "";
  public int iGK;
  private String iGL = "";
  private String inx = "";
  private String ixK = "";
  private String ixs = "";
  private String ixw = "";
  private String ixy = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(369200);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.inx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAa);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369200);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369205);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.inx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("findercontextid:").append(this.iGJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentscene:").append(this.ixs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("event_code:").append(this.iGK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("event_time:").append(this.iGL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("eid:").append(this.ixw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("udf_kv:").append(this.iAN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clicktabcontextid:").append(this.ixK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ref_commentscene:").append(this.ixy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("jump_id:").append(this.iAa);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369205);
    return localObject;
  }
  
  public final int getId()
  {
    return 21875;
  }
  
  public final gk qU(String paramString)
  {
    AppMethodBeat.i(369150);
    this.inx = F("sessionid", paramString, true);
    AppMethodBeat.o(369150);
    return this;
  }
  
  public final gk qV(String paramString)
  {
    AppMethodBeat.i(369154);
    this.iGJ = F("findercontextid", paramString, true);
    AppMethodBeat.o(369154);
    return this;
  }
  
  public final gk qW(String paramString)
  {
    AppMethodBeat.i(369161);
    this.ixs = F("commentscene", paramString, true);
    AppMethodBeat.o(369161);
    return this;
  }
  
  public final gk qX(String paramString)
  {
    AppMethodBeat.i(369167);
    this.iGL = F("event_time", paramString, true);
    AppMethodBeat.o(369167);
    return this;
  }
  
  public final gk qY(String paramString)
  {
    AppMethodBeat.i(369172);
    this.ixw = F("eid", paramString, true);
    AppMethodBeat.o(369172);
    return this;
  }
  
  public final gk qZ(String paramString)
  {
    AppMethodBeat.i(369176);
    this.iAN = F("udf_kv", paramString, true);
    AppMethodBeat.o(369176);
    return this;
  }
  
  public final gk ra(String paramString)
  {
    AppMethodBeat.i(369181);
    this.ixK = F("clicktabcontextid", paramString, true);
    AppMethodBeat.o(369181);
    return this;
  }
  
  public final gk rb(String paramString)
  {
    AppMethodBeat.i(369185);
    this.ixy = F("ref_commentscene", paramString, true);
    AppMethodBeat.o(369185);
    return this;
  }
  
  public final gk rc(String paramString)
  {
    AppMethodBeat.i(369193);
    this.iAa = F("jump_id", paramString, true);
    AppMethodBeat.o(369193);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.gk
 * JD-Core Version:    0.7.0.1
 */