package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ml
  extends a
{
  public long iLz;
  private String iNB = "";
  public long ila;
  public long ips;
  public long jbD;
  private String jbE = "";
  private String jbF = "";
  public long jbG;
  
  public final String aIE()
  {
    AppMethodBeat.i(184776);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iNB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ips);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ila);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbF);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(184776);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(184777);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.iNB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.ips);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exit:").append(this.jbD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("msgType:").append(this.iLz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ila);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openHelp:").append(this.jbG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("todoid:").append(this.jbE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appusername:").append(this.jbF);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184777);
    return localObject;
  }
  
  public final int getId()
  {
    return 19442;
  }
  
  public final ml uU(String paramString)
  {
    AppMethodBeat.i(184775);
    this.iNB = F("roomid", paramString, true);
    AppMethodBeat.o(184775);
    return this;
  }
  
  public final ml uV(String paramString)
  {
    AppMethodBeat.i(368369);
    this.jbE = F("todoid", paramString, true);
    AppMethodBeat.o(368369);
    return this;
  }
  
  public final ml uW(String paramString)
  {
    AppMethodBeat.i(368374);
    this.jbF = F("appusername", paramString, true);
    AppMethodBeat.o(368374);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ml
 * JD-Core Version:    0.7.0.1
 */