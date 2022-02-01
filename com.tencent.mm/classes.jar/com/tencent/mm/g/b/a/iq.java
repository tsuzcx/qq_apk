package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class iq
  extends a
{
  private String dDw = "";
  private long dHR = 0L;
  private String dSz = "";
  private String eba = "";
  private String eln = "";
  private String elt = "";
  private String elu = "";
  
  public final String PR()
  {
    AppMethodBeat.i(116504);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eba);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eln);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dDw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elu);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(116504);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(116505);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.dHR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("content:").append(this.eba);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchid:").append(this.eln);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.dDw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.dSz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("resulttype:").append(this.elt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("resultsubtypelist:").append(this.elu);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116505);
    return localObject;
  }
  
  public final iq Tg()
  {
    this.dHR = 47L;
    return this;
  }
  
  public final int getId()
  {
    return 16032;
  }
  
  public final iq pI(String paramString)
  {
    AppMethodBeat.i(116498);
    this.eba = t("content", paramString, true);
    AppMethodBeat.o(116498);
    return this;
  }
  
  public final iq pJ(String paramString)
  {
    AppMethodBeat.i(116499);
    this.eln = t("searchid", paramString, true);
    AppMethodBeat.o(116499);
    return this;
  }
  
  public final iq pK(String paramString)
  {
    AppMethodBeat.i(116500);
    this.dDw = t("sessionid", paramString, true);
    AppMethodBeat.o(116500);
    return this;
  }
  
  public final iq pL(String paramString)
  {
    AppMethodBeat.i(116501);
    this.dSz = t("query", paramString, true);
    AppMethodBeat.o(116501);
    return this;
  }
  
  public final iq pM(String paramString)
  {
    AppMethodBeat.i(116502);
    this.elt = t("resulttype", paramString, true);
    AppMethodBeat.o(116502);
    return this;
  }
  
  public final iq pN(String paramString)
  {
    AppMethodBeat.i(116503);
    this.elu = t("resultsubtypelist", paramString, true);
    AppMethodBeat.o(116503);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.iq
 * JD-Core Version:    0.7.0.1
 */