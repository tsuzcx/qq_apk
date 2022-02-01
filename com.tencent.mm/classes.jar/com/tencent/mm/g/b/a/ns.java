package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ns
  extends a
{
  public int eqm = 0;
  private String fir = "";
  private String fit = "";
  private String fiu = "";
  public int fiv;
  
  public final ns AQ(String paramString)
  {
    AppMethodBeat.i(184121);
    this.fir = x("oldaccountusername", paramString, true);
    AppMethodBeat.o(184121);
    return this;
  }
  
  public final ns AR(String paramString)
  {
    AppMethodBeat.i(184122);
    this.fit = x("newaccountusername", paramString, true);
    AppMethodBeat.o(184122);
    return this;
  }
  
  public final ns AS(String paramString)
  {
    AppMethodBeat.i(184123);
    this.fiu = x("friendusername", paramString, true);
    AppMethodBeat.o(184123);
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(184124);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fir);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fit);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fiu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fiv);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(184124);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(184125);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.eqm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("oldaccountusername:").append(this.fir);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("newaccountusername:").append(this.fit);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("friendusername:").append(this.fiu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errortype:").append(this.fiv);
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
 * Qualified Name:     com.tencent.mm.g.b.a.ns
 * JD-Core Version:    0.7.0.1
 */