package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cx
  extends a
{
  public long dCQ = 0L;
  private String dFe = "";
  private String dRu = "";
  private String dRv = "";
  private String dRw = "";
  private String dRx = "";
  
  public final String PR()
  {
    AppMethodBeat.i(198549);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dCQ);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(198549);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(198550);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ResignationWorkUsername:").append(this.dRu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TakeOverWorkUsername:").append(this.dRv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WorkEnterpriseDescId:").append(this.dRw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WorkEnterpriseName:").append(this.dRx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dCQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(198550);
    return localObject;
  }
  
  public final int getId()
  {
    return 19942;
  }
  
  public final cx kT(String paramString)
  {
    AppMethodBeat.i(198544);
    this.dRu = t("ResignationWorkUsername", paramString, true);
    AppMethodBeat.o(198544);
    return this;
  }
  
  public final cx kU(String paramString)
  {
    AppMethodBeat.i(198545);
    this.dRv = t("TakeOverWorkUsername", paramString, true);
    AppMethodBeat.o(198545);
    return this;
  }
  
  public final cx kV(String paramString)
  {
    AppMethodBeat.i(198546);
    this.dRw = t("WorkEnterpriseDescId", paramString, true);
    AppMethodBeat.o(198546);
    return this;
  }
  
  public final cx kW(String paramString)
  {
    AppMethodBeat.i(198547);
    this.dRx = t("WorkEnterpriseName", paramString, true);
    AppMethodBeat.o(198547);
    return this;
  }
  
  public final cx kX(String paramString)
  {
    AppMethodBeat.i(198548);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(198548);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cx
 * JD-Core Version:    0.7.0.1
 */