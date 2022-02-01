package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gv
  extends a
{
  private String eKZ = "";
  private String eLa = "";
  private String eLb = "";
  private String eLc = "";
  private String eiB = "";
  public long ejA = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(194456);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eKZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejA);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(194456);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(194457);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ResignationWorkUsername:").append(this.eKZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TakeOverWorkUsername:").append(this.eLa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WorkEnterpriseDescId:").append(this.eLb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WorkEnterpriseName:").append(this.eLc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ejA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(194457);
    return localObject;
  }
  
  public final int getId()
  {
    return 19942;
  }
  
  public final gv uE(String paramString)
  {
    AppMethodBeat.i(194451);
    this.eKZ = x("ResignationWorkUsername", paramString, true);
    AppMethodBeat.o(194451);
    return this;
  }
  
  public final gv uF(String paramString)
  {
    AppMethodBeat.i(194452);
    this.eLa = x("TakeOverWorkUsername", paramString, true);
    AppMethodBeat.o(194452);
    return this;
  }
  
  public final gv uG(String paramString)
  {
    AppMethodBeat.i(194453);
    this.eLb = x("WorkEnterpriseDescId", paramString, true);
    AppMethodBeat.o(194453);
    return this;
  }
  
  public final gv uH(String paramString)
  {
    AppMethodBeat.i(194454);
    this.eLc = x("WorkEnterpriseName", paramString, true);
    AppMethodBeat.o(194454);
    return this;
  }
  
  public final gv uI(String paramString)
  {
    AppMethodBeat.i(194455);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(194455);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gv
 * JD-Core Version:    0.7.0.1
 */