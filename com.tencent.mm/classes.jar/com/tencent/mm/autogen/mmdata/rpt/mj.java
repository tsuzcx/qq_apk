package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mj
  extends a
{
  public long iLz;
  private String iQZ = "";
  public long ips;
  public long iuA;
  private long jbD;
  private String jbE = "";
  private String jbF = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(184769);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iQZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ips);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbF);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(184769);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(184770);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomId:").append(this.iQZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.ips);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgType:").append(this.iLz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.iuA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exit:").append(this.jbD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("todoid:").append(this.jbE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appusername:").append(this.jbF);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184770);
    return localObject;
  }
  
  public final mj aIS()
  {
    this.jbD = 2L;
    return this;
  }
  
  public final int getId()
  {
    return 19443;
  }
  
  public final mj uO(String paramString)
  {
    AppMethodBeat.i(184767);
    this.iQZ = F("roomId", paramString, true);
    AppMethodBeat.o(184767);
    return this;
  }
  
  public final mj uP(String paramString)
  {
    AppMethodBeat.i(184768);
    this.jbE = F("todoid", paramString, true);
    AppMethodBeat.o(184768);
    return this;
  }
  
  public final mj uQ(String paramString)
  {
    AppMethodBeat.i(368423);
    this.jbF = F("appusername", paramString, true);
    AppMethodBeat.o(368423);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.mj
 * JD-Core Version:    0.7.0.1
 */