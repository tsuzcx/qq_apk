package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class l
  extends a
{
  public int tPI = -2;
  public int tPJ = -2;
  
  public final String aIE()
  {
    AppMethodBeat.i(321482);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.tPI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.tPJ);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(321482);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(321485);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("requestedOrientation:").append(this.tPI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("currentOrientation:").append(this.tPJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(321485);
    return localObject;
  }
  
  public final int getId()
  {
    return 23792;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.l
 * JD-Core Version:    0.7.0.1
 */