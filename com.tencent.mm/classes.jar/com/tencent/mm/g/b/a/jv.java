package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jv
  extends a
{
  private String dQt = "";
  private long dUW = 0L;
  private String eCp = "";
  private String eCv = "";
  private String eCw = "";
  private String eif = "";
  private String erH = "";
  
  public final String RD()
  {
    AppMethodBeat.i(116504);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dUW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eif);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCw);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(116504);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(116505);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.dUW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("content:").append(this.erH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchid:").append(this.eCp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.dQt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.eif);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("resulttype:").append(this.eCv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("resultsubtypelist:").append(this.eCw);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116505);
    return localObject;
  }
  
  public final jv Vt()
  {
    this.dUW = 47L;
    return this;
  }
  
  public final int getId()
  {
    return 16032;
  }
  
  public final jv so(String paramString)
  {
    AppMethodBeat.i(116498);
    this.erH = t("content", paramString, true);
    AppMethodBeat.o(116498);
    return this;
  }
  
  public final jv sp(String paramString)
  {
    AppMethodBeat.i(116499);
    this.eCp = t("searchid", paramString, true);
    AppMethodBeat.o(116499);
    return this;
  }
  
  public final jv sq(String paramString)
  {
    AppMethodBeat.i(116500);
    this.dQt = t("sessionid", paramString, true);
    AppMethodBeat.o(116500);
    return this;
  }
  
  public final jv sr(String paramString)
  {
    AppMethodBeat.i(116501);
    this.eif = t("query", paramString, true);
    AppMethodBeat.o(116501);
    return this;
  }
  
  public final jv ss(String paramString)
  {
    AppMethodBeat.i(116502);
    this.eCv = t("resulttype", paramString, true);
    AppMethodBeat.o(116502);
    return this;
  }
  
  public final jv st(String paramString)
  {
    AppMethodBeat.i(116503);
    this.eCw = t("resultsubtypelist", paramString, true);
    AppMethodBeat.o(116503);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jv
 * JD-Core Version:    0.7.0.1
 */