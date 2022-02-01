package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class un
  extends a
{
  private String iAN = "";
  private String iGJ = "";
  public int iGK;
  private String iGL = "";
  public long iGM;
  private String inx = "";
  private String ixK = "";
  private String ixp = "";
  private String ixs = "";
  private String ixy = "";
  
  public final un Ak(String paramString)
  {
    AppMethodBeat.i(368107);
    this.inx = F("sessionid", paramString, true);
    AppMethodBeat.o(368107);
    return this;
  }
  
  public final un Al(String paramString)
  {
    AppMethodBeat.i(368110);
    this.iGJ = F("findercontextid", paramString, true);
    AppMethodBeat.o(368110);
    return this;
  }
  
  public final un Am(String paramString)
  {
    AppMethodBeat.i(368113);
    this.ixs = F("commentscene", paramString, true);
    AppMethodBeat.o(368113);
    return this;
  }
  
  public final un An(String paramString)
  {
    AppMethodBeat.i(368114);
    this.iGL = F("event_time", paramString, true);
    AppMethodBeat.o(368114);
    return this;
  }
  
  public final un Ao(String paramString)
  {
    AppMethodBeat.i(368118);
    this.iAN = F("udf_kv", paramString, true);
    AppMethodBeat.o(368118);
    return this;
  }
  
  public final un Ap(String paramString)
  {
    AppMethodBeat.i(368125);
    this.ixK = F("clicktabcontextid", paramString, true);
    AppMethodBeat.o(368125);
    return this;
  }
  
  public final un Aq(String paramString)
  {
    AppMethodBeat.i(368130);
    this.ixy = F("ref_commentscene", paramString, true);
    AppMethodBeat.o(368130);
    return this;
  }
  
  public final String aIE()
  {
    AppMethodBeat.i(368138);
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
    ((StringBuffer)localObject).append(this.ixp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGM);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368138);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368145);
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
    ((StringBuffer)localObject).append("finderusername:").append(this.ixp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("udf_kv:").append(this.iAN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clicktabcontextid:").append(this.ixK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ref_commentscene:").append(this.ixy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("stayTime:").append(this.iGM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368145);
    return localObject;
  }
  
  public final int getId()
  {
    return 21874;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.un
 * JD-Core Version:    0.7.0.1
 */