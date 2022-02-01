package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mk
  extends a
{
  public long iLz;
  private String iQZ = "";
  public long ila;
  public long ips;
  public long jbD;
  private String jbE = "";
  private String jbF = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(184773);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iQZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ips);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ila);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbF);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(184773);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(184774);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomId:").append(this.iQZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.ips);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgType:").append(this.iLz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ila);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exit:").append(this.jbD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("todoid:").append(this.jbE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appusername:").append(this.jbF);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184774);
    return localObject;
  }
  
  public final int getId()
  {
    return 19444;
  }
  
  public final mk uR(String paramString)
  {
    AppMethodBeat.i(184771);
    this.iQZ = F("roomId", paramString, true);
    AppMethodBeat.o(184771);
    return this;
  }
  
  public final mk uS(String paramString)
  {
    AppMethodBeat.i(184772);
    this.jbE = F("todoid", paramString, true);
    AppMethodBeat.o(184772);
    return this;
  }
  
  public final mk uT(String paramString)
  {
    AppMethodBeat.i(368367);
    this.jbF = F("appusername", paramString, true);
    AppMethodBeat.o(368367);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.mk
 * JD-Core Version:    0.7.0.1
 */