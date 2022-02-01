package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ff
  extends a
{
  private String iAN = "";
  private String iAa = "";
  private String iGJ = "";
  public int iGK;
  private String iGL = "";
  public long iGM;
  private String inx = "";
  private String ixK = "";
  private String ixp = "";
  private String ixs = "";
  private String ixy = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(367813);
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
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAa);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367813);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367823);
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
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("jump_id:").append(this.iAa);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367823);
    return localObject;
  }
  
  public final int getId()
  {
    return 21874;
  }
  
  public final ff pF(String paramString)
  {
    AppMethodBeat.i(367777);
    this.inx = F("sessionid", paramString, true);
    AppMethodBeat.o(367777);
    return this;
  }
  
  public final ff pG(String paramString)
  {
    AppMethodBeat.i(367780);
    this.iGJ = F("findercontextid", paramString, true);
    AppMethodBeat.o(367780);
    return this;
  }
  
  public final ff pH(String paramString)
  {
    AppMethodBeat.i(367783);
    this.ixs = F("commentscene", paramString, true);
    AppMethodBeat.o(367783);
    return this;
  }
  
  public final ff pI(String paramString)
  {
    AppMethodBeat.i(367789);
    this.iGL = F("event_time", paramString, true);
    AppMethodBeat.o(367789);
    return this;
  }
  
  public final ff pJ(String paramString)
  {
    AppMethodBeat.i(367793);
    this.ixp = F("finderusername", paramString, true);
    AppMethodBeat.o(367793);
    return this;
  }
  
  public final ff pK(String paramString)
  {
    AppMethodBeat.i(367800);
    this.iAN = F("udf_kv", paramString, true);
    AppMethodBeat.o(367800);
    return this;
  }
  
  public final ff pL(String paramString)
  {
    AppMethodBeat.i(367803);
    this.ixK = F("clicktabcontextid", paramString, true);
    AppMethodBeat.o(367803);
    return this;
  }
  
  public final ff pM(String paramString)
  {
    AppMethodBeat.i(367806);
    this.ixy = F("ref_commentscene", paramString, true);
    AppMethodBeat.o(367806);
    return this;
  }
  
  public final ff pN(String paramString)
  {
    AppMethodBeat.i(367808);
    this.iAa = F("jump_id", paramString, true);
    AppMethodBeat.o(367808);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ff
 * JD-Core Version:    0.7.0.1
 */