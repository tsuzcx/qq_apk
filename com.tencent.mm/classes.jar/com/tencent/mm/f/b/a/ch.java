package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ch
  extends a
{
  private String gpE = "";
  private long gpF;
  private String gpG = "";
  
  public final String agH()
  {
    AppMethodBeat.i(285269);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gpE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpG);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(285269);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(285270);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InnerVersion:").append(this.gpE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exceptionType:").append(this.gpF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exceptionValue:").append(this.gpG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(285270);
    return localObject;
  }
  
  public final ch fk(long paramLong)
  {
    this.gpF = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20889;
  }
  
  public final ch mh(String paramString)
  {
    AppMethodBeat.i(285267);
    this.gpE = z("InnerVersion", paramString, true);
    AppMethodBeat.o(285267);
    return this;
  }
  
  public final ch mi(String paramString)
  {
    AppMethodBeat.i(285268);
    this.gpG = z("exceptionValue", paramString, true);
    AppMethodBeat.o(285268);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ch
 * JD-Core Version:    0.7.0.1
 */