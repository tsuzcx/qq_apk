package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class uo
  extends a
{
  public int ipB = 0;
  private String jHD = "";
  private String jHE = "";
  private String jHF = "";
  public int jHG;
  
  public final uo Ar(String paramString)
  {
    AppMethodBeat.i(184121);
    this.jHD = F("oldaccountusername", paramString, true);
    AppMethodBeat.o(184121);
    return this;
  }
  
  public final uo As(String paramString)
  {
    AppMethodBeat.i(184122);
    this.jHE = F("newaccountusername", paramString, true);
    AppMethodBeat.o(184122);
    return this;
  }
  
  public final uo At(String paramString)
  {
    AppMethodBeat.i(184123);
    this.jHF = F("friendusername", paramString, true);
    AppMethodBeat.o(184123);
    return this;
  }
  
  public final String aIE()
  {
    AppMethodBeat.i(184124);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ipB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jHG);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(184124);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(184125);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.ipB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("oldaccountusername:").append(this.jHD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("newaccountusername:").append(this.jHE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("friendusername:").append(this.jHF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errortype:").append(this.jHG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184125);
    return localObject;
  }
  
  public final int getId()
  {
    return 19376;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.uo
 * JD-Core Version:    0.7.0.1
 */