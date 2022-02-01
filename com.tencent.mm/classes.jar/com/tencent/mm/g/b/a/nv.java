package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nv
  extends a
{
  private String eBQ = "";
  private String eXu = "";
  private String els = "";
  private long erw = 0L;
  private String fiD = "";
  private String fiE = "";
  private String fix = "";
  
  public final nv AU(String paramString)
  {
    AppMethodBeat.i(116498);
    this.eXu = x("content", paramString, true);
    AppMethodBeat.o(116498);
    return this;
  }
  
  public final nv AV(String paramString)
  {
    AppMethodBeat.i(116499);
    this.fix = x("searchid", paramString, true);
    AppMethodBeat.o(116499);
    return this;
  }
  
  public final nv AW(String paramString)
  {
    AppMethodBeat.i(116500);
    this.els = x("sessionid", paramString, true);
    AppMethodBeat.o(116500);
    return this;
  }
  
  public final nv AX(String paramString)
  {
    AppMethodBeat.i(116501);
    this.eBQ = x("query", paramString, true);
    AppMethodBeat.o(116501);
    return this;
  }
  
  public final nv AY(String paramString)
  {
    AppMethodBeat.i(116502);
    this.fiD = x("resulttype", paramString, true);
    AppMethodBeat.o(116502);
    return this;
  }
  
  public final nv AZ(String paramString)
  {
    AppMethodBeat.i(116503);
    this.fiE = x("resultsubtypelist", paramString, true);
    AppMethodBeat.o(116503);
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(116504);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fix);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.els);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fiD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fiE);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(116504);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(116505);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.erw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("content:").append(this.eXu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchid:").append(this.fix);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.els);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.eBQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("resulttype:").append(this.fiD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("resultsubtypelist:").append(this.fiE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116505);
    return localObject;
  }
  
  public final nv ajr()
  {
    this.erw = 47L;
    return this;
  }
  
  public final int getId()
  {
    return 16032;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.nv
 * JD-Core Version:    0.7.0.1
 */