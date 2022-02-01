package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class rb
  extends a
{
  public long iTb;
  private String ilL = "";
  private String ilM = "";
  public long juC;
  private String juD = "";
  private String juE = "";
  public long juF;
  public long juG;
  
  public final String aIE()
  {
    AppMethodBeat.i(369231);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ilM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.juC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.juD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iTb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.juE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.juF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.juG);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369231);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369245);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.ilM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Appid:").append(this.ilL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeStampInMs:").append(this.juC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventName:").append(this.juD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventType:").append(this.iTb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Parent:").append(this.juE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Category:").append(this.juF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Option:").append(this.juG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369245);
    return localObject;
  }
  
  public final int getId()
  {
    return 19175;
  }
  
  public final rb xZ(String paramString)
  {
    AppMethodBeat.i(369202);
    this.ilM = F("InstanceId", paramString, true);
    AppMethodBeat.o(369202);
    return this;
  }
  
  public final rb ya(String paramString)
  {
    AppMethodBeat.i(369207);
    this.ilL = F("Appid", paramString, true);
    AppMethodBeat.o(369207);
    return this;
  }
  
  public final rb yb(String paramString)
  {
    AppMethodBeat.i(369212);
    this.juD = F("EventName", paramString, true);
    AppMethodBeat.o(369212);
    return this;
  }
  
  public final rb yc(String paramString)
  {
    AppMethodBeat.i(369217);
    this.juE = F("Parent", paramString, true);
    AppMethodBeat.o(369217);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.rb
 * JD-Core Version:    0.7.0.1
 */