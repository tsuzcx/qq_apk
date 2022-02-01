package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fh
  extends a
{
  public long iFe;
  public long iGT;
  private String iGU = "";
  public long iGV;
  private String iGW = "";
  private String iGX = "";
  private String inx = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368075);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.inx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGX);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368075);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368079);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.inx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pickerScene:").append(this.iGT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionType:").append(this.iFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("eventCode:").append(this.iGU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("tabType:").append(this.iGV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("udfKv:").append(this.iGW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timeStampInMs:").append(this.iGX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368079);
    return localObject;
  }
  
  public final int getId()
  {
    return 22878;
  }
  
  public final fh pO(String paramString)
  {
    AppMethodBeat.i(368053);
    this.inx = F("sessionid", paramString, true);
    AppMethodBeat.o(368053);
    return this;
  }
  
  public final fh pP(String paramString)
  {
    AppMethodBeat.i(368057);
    this.iGU = F("eventCode", paramString, true);
    AppMethodBeat.o(368057);
    return this;
  }
  
  public final fh pQ(String paramString)
  {
    AppMethodBeat.i(368063);
    this.iGW = F("udfKv", paramString, true);
    AppMethodBeat.o(368063);
    return this;
  }
  
  public final fh pR(String paramString)
  {
    AppMethodBeat.i(368070);
    this.iGX = F("timeStampInMs", paramString, true);
    AppMethodBeat.o(368070);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.fh
 * JD-Core Version:    0.7.0.1
 */