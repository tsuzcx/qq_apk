package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qt
  extends a
{
  public int gly = 0;
  private String hlC = "";
  private String hlD = "";
  private String hlE = "";
  public int hlF;
  
  public final qt HJ(String paramString)
  {
    AppMethodBeat.i(184121);
    this.hlC = z("oldaccountusername", paramString, true);
    AppMethodBeat.o(184121);
    return this;
  }
  
  public final qt HK(String paramString)
  {
    AppMethodBeat.i(184122);
    this.hlD = z("newaccountusername", paramString, true);
    AppMethodBeat.o(184122);
    return this;
  }
  
  public final qt HL(String paramString)
  {
    AppMethodBeat.i(184123);
    this.hlE = z("friendusername", paramString, true);
    AppMethodBeat.o(184123);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(184124);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gly);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hlC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hlD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hlE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hlF);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(184124);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(184125);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.gly);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("oldaccountusername:").append(this.hlC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("newaccountusername:").append(this.hlD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("friendusername:").append(this.hlE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errortype:").append(this.hlF);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184125);
    return localObject;
  }
  
  public final int getId()
  {
    return 19376;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.b.a.qt
 * JD-Core Version:    0.7.0.1
 */