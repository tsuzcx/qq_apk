package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gy
  extends a
{
  private String dFJ = "";
  private long dKc = 0L;
  private String dQK = "";
  private String dZi = "";
  private String ejj = "";
  private String ejp = "";
  private String ejq = "";
  
  public final String PV()
  {
    AppMethodBeat.i(116504);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dKc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejq);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(116504);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(116505);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.dKc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("content:").append(this.dZi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchid:").append(this.ejj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.dFJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.dQK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("resulttype:").append(this.ejp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("resultsubtypelist:").append(this.ejq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116505);
    return localObject;
  }
  
  public final gy Sn()
  {
    this.dKc = 47L;
    return this;
  }
  
  public final int getId()
  {
    return 16032;
  }
  
  public final gy mC(String paramString)
  {
    AppMethodBeat.i(116498);
    this.dZi = t("content", paramString, true);
    AppMethodBeat.o(116498);
    return this;
  }
  
  public final gy mD(String paramString)
  {
    AppMethodBeat.i(116499);
    this.ejj = t("searchid", paramString, true);
    AppMethodBeat.o(116499);
    return this;
  }
  
  public final gy mE(String paramString)
  {
    AppMethodBeat.i(116500);
    this.dFJ = t("sessionid", paramString, true);
    AppMethodBeat.o(116500);
    return this;
  }
  
  public final gy mF(String paramString)
  {
    AppMethodBeat.i(116501);
    this.dQK = t("query", paramString, true);
    AppMethodBeat.o(116501);
    return this;
  }
  
  public final gy mG(String paramString)
  {
    AppMethodBeat.i(116502);
    this.ejp = t("resulttype", paramString, true);
    AppMethodBeat.o(116502);
    return this;
  }
  
  public final gy mH(String paramString)
  {
    AppMethodBeat.i(116503);
    this.ejq = t("resultsubtypelist", paramString, true);
    AppMethodBeat.o(116503);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gy
 * JD-Core Version:    0.7.0.1
 */