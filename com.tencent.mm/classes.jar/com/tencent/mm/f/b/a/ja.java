package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ja
  extends a
{
  private String gKD = "";
  private String gKE = "";
  private String gKF = "";
  private String gKG = "";
  private String gcU = "";
  public long gef = 0L;
  
  public final ja Ab(String paramString)
  {
    AppMethodBeat.i(212938);
    this.gKD = z("ResignationWorkUsername", paramString, true);
    AppMethodBeat.o(212938);
    return this;
  }
  
  public final ja Ac(String paramString)
  {
    AppMethodBeat.i(212940);
    this.gKE = z("TakeOverWorkUsername", paramString, true);
    AppMethodBeat.o(212940);
    return this;
  }
  
  public final ja Ad(String paramString)
  {
    AppMethodBeat.i(212941);
    this.gKF = z("WorkEnterpriseDescId", paramString, true);
    AppMethodBeat.o(212941);
    return this;
  }
  
  public final ja Ae(String paramString)
  {
    AppMethodBeat.i(212942);
    this.gKG = z("WorkEnterpriseName", paramString, true);
    AppMethodBeat.o(212942);
    return this;
  }
  
  public final ja Af(String paramString)
  {
    AppMethodBeat.i(212944);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(212944);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(212947);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gKD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gef);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(212947);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(212952);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ResignationWorkUsername:").append(this.gKD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TakeOverWorkUsername:").append(this.gKE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WorkEnterpriseDescId:").append(this.gKF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WorkEnterpriseName:").append(this.gKG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.gef);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(212952);
    return localObject;
  }
  
  public final int getId()
  {
    return 19942;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ja
 * JD-Core Version:    0.7.0.1
 */