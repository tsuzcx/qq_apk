package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class di
  extends a
{
  private String izq = "";
  public long izr;
  public String izs = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368415);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.izq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izs);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368415);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368419);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InnerVersion:").append(this.izq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exceptionType:").append(this.izr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exceptionValue:").append(this.izs);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368419);
    return localObject;
  }
  
  public final int getId()
  {
    return 20889;
  }
  
  public final di nq(String paramString)
  {
    AppMethodBeat.i(368408);
    this.izq = F("InnerVersion", paramString, true);
    AppMethodBeat.o(368408);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.di
 * JD-Core Version:    0.7.0.1
 */