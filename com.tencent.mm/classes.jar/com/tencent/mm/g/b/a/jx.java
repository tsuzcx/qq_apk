package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jx
  extends a
{
  private String dRJ = "";
  private long dWm = 0L;
  private String eDY = "";
  private String eEe = "";
  private String eEf = "";
  private String ejP = "";
  private String eto = "";
  
  public final String RC()
  {
    AppMethodBeat.i(116504);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eto);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEf);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(116504);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(116505);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.dWm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("content:").append(this.eto);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchid:").append(this.eDY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.dRJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.ejP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("resulttype:").append(this.eEe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("resultsubtypelist:").append(this.eEf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116505);
    return localObject;
  }
  
  public final jx VB()
  {
    this.dWm = 47L;
    return this;
  }
  
  public final int getId()
  {
    return 16032;
  }
  
  public final jx sJ(String paramString)
  {
    AppMethodBeat.i(116498);
    this.eto = t("content", paramString, true);
    AppMethodBeat.o(116498);
    return this;
  }
  
  public final jx sK(String paramString)
  {
    AppMethodBeat.i(116499);
    this.eDY = t("searchid", paramString, true);
    AppMethodBeat.o(116499);
    return this;
  }
  
  public final jx sL(String paramString)
  {
    AppMethodBeat.i(116500);
    this.dRJ = t("sessionid", paramString, true);
    AppMethodBeat.o(116500);
    return this;
  }
  
  public final jx sM(String paramString)
  {
    AppMethodBeat.i(116501);
    this.ejP = t("query", paramString, true);
    AppMethodBeat.o(116501);
    return this;
  }
  
  public final jx sN(String paramString)
  {
    AppMethodBeat.i(116502);
    this.eEe = t("resulttype", paramString, true);
    AppMethodBeat.o(116502);
    return this;
  }
  
  public final jx sO(String paramString)
  {
    AppMethodBeat.i(116503);
    this.eEf = t("resultsubtypelist", paramString, true);
    AppMethodBeat.o(116503);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jx
 * JD-Core Version:    0.7.0.1
 */